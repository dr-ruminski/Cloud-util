package com.dr.gcp.compute.vm.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.Logger;

import com.dr.gcp.compute.vm.model.GCPComputeVModel;

public abstract class Manager<T> implements IVMManager {

	// maps vm name to its model
	protected Map<String, List<T>> vmsMap = new HashMap<String, List<T>>();
	
	// current virtual machine that is managed by a VMManager instance
	protected GCPComputeVModel currVM = null;

	// 
	protected String execute(Logger log, String command) throws IOException {
		Process process = Runtime.getRuntime().exec(command);
		// reads I/O of the gcloud tool
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

		// read the output from the command
		String in = null;
		StringBuilder input = new StringBuilder();
		while ((in = stdInput.readLine()) != null) {
			input.append(in).append('\n');
		}
		if (input.length() > 0)
			log.trace(input);

		StringBuilder errorInput = new StringBuilder();
		// read any errors from the attempted command
		while ((in = stdError.readLine()) != null) {
			errorInput.append(in).append('\n');
		}

		if (errorInput.length() > 0)
			log.error(errorInput.toString());

		// cleaning resources and killing the process 
		stdInput.close();
		stdError.close();
		process.destroy();
		
		return input.toString();
	}
}
