package com.dr.gcp.compute.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dr.cloud.manager.Manager;
import com.dr.gcp.compute.model.GCPComputeVModel;
import com.google.gson.Gson;
import static com.dr.gcp.compute.manager.GcloudCommands.*;


/**
 * The manager for Google Compute Engine instances. Retrieves info about virtual
 * machines. Fills up data of the main data model of GCP compute machines. It
 * provides the following functions that support managing vms:
 * <ul>
 * <li>start a GCE instance by providing a name of vm,</li>
 * <li>stop a GCE instance by providing a name of vm,</li>
 * <li>start all GCE instances,</li>
 * <li>stop all GCE instances,</li>
 * <li>start randomly selected a GCE instance,</li>
 * <li>stop randomly selected a GCE instance.</li>
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
			Gson gson = new Gson();
			GCPComputeVModel[] model = gson.fromJson(jsonStr.toString(), GCPComputeVModel[].class);
			List<GCPComputeVModel> list = Arrays.asList(model);
			vmsMap = list.stream().collect(Collectors.groupingBy(GCPComputeVModel::getName));

		} catch (IOException e) {
			LOG.error(e);
			LOG.info("Closing VMManager");
			System.exit(-1);
		}
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
		cmd.append(START_INSTANCE).append(name).append(" --zone=").append(vm.getZone())
				.append(" --format=json");

		String jsonResponse = execute(cmd.toString());

		LOG.trace("Running machine json: {}", jsonResponse);
		Gson gson = new Gson();
		GCPComputeVModel[] model = gson.fromJson(jsonResponse, GCPComputeVModel[].class);

		currentVM = model[0];
	}

	@Override
	public void stopInstance(String name) throws IOException {
		if (name == null || name.isEmpty() || !vmsMap.keySet().contains(name)) {
			LOG.error("There is a problem with the VM called {}. Cannot stop vm with the following name: {}", name, name);
			return;
		}
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
		Collections.shuffle( listOfVms );
		
		GCPComputeVModel vm = listOfVms.get(0).get(0);

		LOG.info("Starting: {}", vm.getName());

		StringBuilder cmd = new StringBuilder();
		cmd.append(START_INSTANCE).append(vm.getName()).append(" --zone=").append(vm.getZone())
				.append(" --format=json");

		String jsonResponse = execute(cmd.toString());

		LOG.trace("Running machine json: {}", jsonResponse);
		Gson gson = new Gson();
		GCPComputeVModel[] model = gson.fromJson(jsonResponse, GCPComputeVModel[].class);

		currentVM = model[0];
		
		// updates map with new data
		vmsMap.remove(currentVM.getName());
		vmsMap.put(currentVM.getName(), Arrays.asList(currentVM));

	}

	@Override
	public void stopRandomInstance() throws IOException {
		stopInstance(currentVM.getName());
	}



}
