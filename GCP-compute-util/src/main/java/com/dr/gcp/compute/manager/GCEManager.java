package com.dr.gcp.compute.manager;

import static com.dr.gcp.compute.manager.GcloudCommands.LIST_INSTANCES;
import static com.dr.gcp.compute.manager.GcloudCommands.START_INSTANCE;
import static com.dr.gcp.compute.manager.GcloudCommands.STOP_INSTANCE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dr.cloud.manager.Manager;
import com.dr.gcp.compute.model.GCPComputeVModel;
import com.google.gson.Gson;

/**
 * The manager for Google Compute Engine instances. Retrieves info about virtual
 * machines. Fills up data of the main data model of GCP compute machines. It
 * provides the following operations that support managing vms:
 * <ul>
 * <li>create a GCE instance</li>
 * <li>delete a GCE instance</li>
 * <li>start a GCE instance by providing a name of vm,</li>
 * <li>stop a GCE instance by providing a name of vm,</li>
 * <li>start all GCE instances,</li>
 * <li>stop all GCE instances,</li>
 * <li>start randomly selected a GCE instance,</li>
 * <li>stop a GCE instance that was randomly started.</li>
 * </ul>
 * 
 * @author Dariusz Rumiński
 *
 */
public class GCEManager extends Manager<GCPComputeVModel> {

	private static final Logger LOG = LogManager.getLogger(GCEManager.class);

	public GCEManager() {
		LOG.debug("Virtual Machine Manager has started. Retrieving GCE instances data.");

		try {
			String jsonStr = execute(LIST_INSTANCES);
			json2model(jsonStr);

		} catch (IOException e) {
			LOG.error(e);
			LOG.info("Closing VMManager");
			System.exit(-1);
		}
	}
	
	@Override
	public void createInstance(String name, Map<String, String> params) throws IOException {

		if (params == null)
			params = new HashMap<String, String>();
		
		// always force a result to be returned as a json type
		params.put("--format", "json");
		
		StringBuilder cmd = new StringBuilder();
		cmd.append(GcloudCommands.CREATE_INSTANCE).append(name);
		params.forEach((k, v) -> cmd.append(' ').append(k).append(' ').append(v));
		
		String jsonResponse = execute(cmd.toString());
		LOG.trace("Returned json: \n{}", jsonResponse);

		currentVM = json2model(jsonResponse).get();
		LOG.info("Created the {} instance; zone = {}", name, params.get("--zone"));
	}	
	
	@Override
	public void deleteInstance(String name) throws IOException {
		evaluateInstanceName(name);
		GCPComputeVModel vm = currentVM;
		StringBuilder cmd = new StringBuilder();
		cmd.append(GcloudCommands.DELETE_INSTANCE).append(name).append(" --zone ").append(vm.getZone());//.append('&');
		execute(cmd.toString(), "printf y\\n");
		LOG.info("Deleted the {} instance", name);
	}	

	@Override
	public void startInstance(String name) throws IOException {
		if (name == null || name.isEmpty()) {
			LOG.error("A name of vm cannot be null or empty. Cannot start vm with the following name: {}", name);
			return;
		}

		if (!vmsMap.containsKey(name)) {
			LOG.error("Wrong vm name {}. Double check spelling etc.", name);
			return;
		}

		GCPComputeVModel vm = vmsMap.get(name).get(0);

		LOG.info("Starting: {}", name);

		StringBuilder cmd = new StringBuilder();
		cmd.append(START_INSTANCE).append(name).append(" --zone=").append(vm.getZone()).append(" --format=json");

		String jsonResponse = execute(cmd.toString());

		LOG.trace("Returned json: \n{}", jsonResponse);

		currentVM = json2model(jsonResponse).get();
	}

	@Override
	public void stopInstance(String name) throws IOException {
		evaluateInstanceName(name);
		GCPComputeVModel vm = vmsMap.get(name).get(0); 
		StringBuilder cmd = new StringBuilder();
		cmd.append(STOP_INSTANCE).append(name).append(" --zone=").append(vm.getZone());

		execute(cmd.toString());

	}

	@Override
	public void startAllInstance() throws IOException {
		for (String vmName : vmsMap.keySet())
			startInstance(vmName);
	}

	@Override
	public void stopAllInstance() throws IOException {
		for (String vmName : vmsMap.keySet())
			stopInstance(vmName);
	}

	@Override
	public void startRandomInstance() throws IOException {
		if (vmsMap.size() == 0)
			return;

		List<List<GCPComputeVModel>> listOfVms = new ArrayList<>(vmsMap.values());
		Collections.shuffle(listOfVms);

		GCPComputeVModel vm = listOfVms.get(0).get(0);

		LOG.info("Starting: {}", vm.getName());

		StringBuilder cmd = new StringBuilder();
		cmd.append(START_INSTANCE).append(vm.getName()).append(" --zone=").append(vm.getZone())
				.append(" --format=json");

		String jsonResponse = execute(cmd.toString());

		LOG.trace("Returned json: \n{}", jsonResponse);

		currentVM = json2model(jsonResponse).get();

		// updates map with new data
		vmsMap.remove(currentVM.getName());
		vmsMap.put(currentVM.getName(), Arrays.asList(currentVM));

	}

	@Override
	public void stopRandomInstance() throws IOException {
		stopInstance(currentVM.getName());
	}
	
	@Override
	public void resetInstance(String name) throws IOException {
		// TODO Auto-generated method stub

	}	

	private void evaluateInstanceName(String name) {
		if (name == null || name.isEmpty() || !vmsMap.keySet().contains(name)) {
			LOG.error("There is a problem with the VM called {}. Cannot stop vm with the following name: {}", name,
					name);
			return;
		}
	}

	private Optional<GCPComputeVModel> json2model(String jsonStr) {
		Gson gson = new Gson();
		GCPComputeVModel[] model = gson.fromJson(jsonStr.toString(), GCPComputeVModel[].class);
		List<GCPComputeVModel> list = Arrays.asList(model);
		Map<String, List<GCPComputeVModel>> map = list.stream().collect(Collectors.groupingBy(GCPComputeVModel::getName));
		
		// always add map of gcp model independently when using startInstance or createInstance
		vmsMap.putAll(map);
		
		// when there are no vms an array of GCPComputeVModel is empty
		return Optional.ofNullable(model.length == 0 ? null : model[0]);
	}
}
