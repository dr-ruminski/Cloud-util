package com.dr.gcp.compute.vm.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dr.gcp.compute.vm.model.GCPComputeVModel;
import com.google.gson.Gson;

/**
 * The manager for Google Compute Engine instances. Retrieves info about virtual
 * machines. Fills up data of the main data model of GCP compute machines. It
 * provides the following functions that support managing vms:
 * <ul>
 * <li>start a GCE instance by providing a name of vm,</li>
 * <li>stop a GCE instance by providing a name of vm,</li>
 * <li>start all GCE instances,</li>
 * <li>start randomly selected a GCE instance,</li>
 * <li>start randomly selected a GCE instance.</li>
 * </ul>
 * 
 * @author Dariusz Rumiński
 *
 */
public class VMManager extends Manager implements IVMManager {

	// apache log4j logger
	private static final Logger LOG = LogManager.getLogger();

	// a list of GCE virtual machines
	private List<GCPComputeVModel> vms = new ArrayList<>();
	
	// current virtual machine that is managed by a VMManager instance
	private GCPComputeVModel currVM = null;

	// main constructor
	public VMManager() {
		LOG.debug("Virtual Machine Manager has started. Retrieving GCE instances data.");

		try {
			Process process = Runtime.getRuntime().exec(GcloudCommands.LIST_INSTANCES);

			// reads I/O of the gcloud tool
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			// read the output from the command
			String out = null;
			StringBuilder output = new StringBuilder();
			while ((out = stdInput.readLine()) != null) {
				output.append(out).append('\n');
			}
			LOG.trace(output);

			Gson gson = new Gson();
			GCPComputeVModel[] model = gson.fromJson(output.toString(), GCPComputeVModel[].class);

			// rewriting into dynamic arraylist
			for (GCPComputeVModel vm : model)
				vms.add(vm);

			StringBuilder errorInput = new StringBuilder();
			// read any errors from the attempted command
			while ((out = stdError.readLine()) != null) {
				errorInput.append(out);
			}

			if (errorInput.length() > 0) {
				LOG.info(errorInput.toString());
				System.exit(-1);
			}

		} catch (IOException e) {
			LOG.error(e);
			LOG.info("Closing VMManager");
			System.exit(-1);
		}
	}

	@Override
	public void startInstance(String name) {
		if (name == null)
			return;
		// @todo
	}

	@Override
	public void stopInstance(String name) {
		if (name == null) {
			LOG.info("Cannot stop vm with a name: {}", name);
			return;
		}

		execute(LOG, GcloudCommands.STOP_INSTANCE + name + " --zone=" + currVM.getZone());

	}

	@Override
	public void startAllInstance() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startRandomInstance() {
		if (vms.size() == 0)
			return;

		int numberOfVMs = vms.size() - 1;
		Random rand = new Random();
		int id = rand.nextInt(numberOfVMs);

		GCPComputeVModel vm = vms.remove(id);

		LOG.info("Starting: {}", vms.get(id).getName());

		StringBuilder cmd = new StringBuilder();
		cmd.append(GcloudCommands.START_INSTANCE).append(vm.getName()).append(" --zone=").append(vm.getZone())
				.append(" --format=json");

		LOG.debug("Executing: {}", cmd);
		String jsonResponse = execute(LOG, cmd.toString());
		
		LOG.trace("Running machine json: {}", jsonResponse);
		Gson gson = new Gson();
		GCPComputeVModel[] model = gson.fromJson(jsonResponse, GCPComputeVModel[].class);

		this.currVM = model[0];

	}

	@Override
	public void stopRandomInstance() {
		stopInstance(currVM.getName());
	}

	public GCPComputeVModel getCurrentVM() {
		return currVM;
	}

}
