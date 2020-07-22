package com.dr.gcp.compute.vm.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class VMManager implements IVMManager {

	private static final Logger LOG = LogManager.getLogger();

	private GCPComputeVModel[] model;

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
				input.append(in);
			}

			Gson gson = new Gson();
			model = gson.fromJson(input.toString(), GCPComputeVModel[].class);

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
		// TODO Auto-generated method stub

	}

	@Override
	public void startAllInstance() {
		// TODO Auto-generated method stub

	}

	@Override
	public void startRandomInstance() {
		if (model == null || model.length == 0)
			return;
		
		int numberOfVMs = model.length;
		Random rand = new Random();
		int id = rand.nextInt(numberOfVMs);
		
		LOG.info("Starting: {}", model[id].getName());
		execute(GcloudCommands.START_INSTANCE + model[id].getName() +" --zone="+model[id].getZone());
		
		
	}

	@Override
	public void stopRandomInstance() {
		// TODO Auto-generated method stub

	}
	
	private void execute(String command) {
		try {
			Process process = Runtime.getRuntime().exec(command);

			// reads I/O of the gcloud tool
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			// read the output from the command
			String in = null;
			StringBuilder input = new StringBuilder();
			while ((in = stdInput.readLine()) != null) {
				input.append(in);
			}
			LOG.debug(input);
			
			StringBuilder errorInput = new StringBuilder();
			// read any errors from the attempted command
			while ((in = stdError.readLine()) != null) {
				errorInput.append(in);
			}

			if (errorInput.length() > 0) {
				LOG.error(errorInput.toString());
			}

		} catch (IOException e) {
			LOG.error(e);
		}
	}

}
