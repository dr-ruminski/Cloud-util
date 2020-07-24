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
 * machines. Fills up data of the main data model of GCP compute machines.
 * 
 * @author dr
 *
 */
public class VMManager extends Manager implements IVMManager {

	private static final Logger LOG = LogManager.getLogger();

	private List<GCPComputeVModel> vms = new ArrayList<>();
	private GCPComputeVModel currVM = null;

	public VMManager() {
		LOG.debug("Virtual Machine Manager has started. Retrieving GCE instances data.");

		try {
			Process process = Runtime.getRuntime().exec(GcloudCommands.LIST_INSTANCES);

			// reads I/O of the gcloud tool
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			// read the output from the command
			String in = null;
			StringBuilder input = new StringBuilder();
			while ((in = stdInput.readLine()) != null) {
				input.append(in).append('\n');
			}
			LOG.trace(input);

			Gson gson = new Gson();
			GCPComputeVModel[] model = gson.fromJson(input.toString(), GCPComputeVModel[].class);
			
			// rewriting into dynamic arraylist
			for (GCPComputeVModel vm : model) 
				vms.add(vm);
			

			StringBuilder errorInput = new StringBuilder();
			// read any errors from the attempted command
			while ((in = stdError.readLine()) != null) {
				errorInput.append(in);
			}

			if (errorInput.length() > 0) {
				LOG.error(errorInput.toString());
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
		
	}

	@Override
	public void stopInstance(String name) {
		if (name == null) {
			LOG.info("Cannot stop vm with a name: {}",name);
			return;
		}
		
		execute(LOG, GcloudCommands.STOP_INSTANCE + name + " --zone="+currVM.getZone());
		
		
	}

	@Override
	public void startAllInstance() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startRandomInstance() {
		if (vms.size() == 0)
			return;
		
		int numberOfVMs = vms.size()-1;
		Random rand = new Random();
		int id = rand.nextInt(numberOfVMs);
		
		GCPComputeVModel vm = vms.remove(id);
		
		LOG.info("Starting: {}", vms.get(id).getName());
		String json = execute(LOG, GcloudCommands.START_INSTANCE + vm.getName() +" --zone="+vm.getZone() +" --format=json");
		LOG.trace("Running machine json: {}", json);
		
		Gson gson = new Gson();
		GCPComputeVModel[] model = gson.fromJson(json, GCPComputeVModel[].class);
		
		this.currVM = model[0];
		
		
	}

	@Override
	public void stopRandomInstance() {

	}
	
	public GCPComputeVModel getCurrentVM() {
		return currVM;
	}
	


}
