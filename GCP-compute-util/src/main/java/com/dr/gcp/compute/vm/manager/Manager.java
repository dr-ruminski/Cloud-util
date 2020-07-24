package com.dr.gcp.compute.vm.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.Logger;

public abstract class Manager {

	protected String execute(Logger log, String command) {
		try {
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

			if (errorInput.length() > 0) {
				log.error(errorInput.toString());
			}
			
			return input.toString();

		} catch (IOException e) {
			log.error(e);
		}
		
		return null;
	}
}
