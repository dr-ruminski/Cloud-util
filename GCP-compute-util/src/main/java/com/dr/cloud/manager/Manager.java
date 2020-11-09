package com.dr.cloud.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// TODO: document class and the execute method
public abstract class Manager<T> implements VMManager<T> {

	// maps vm name to its model
	protected Map<String, List<T>> vmsMap = new HashMap<String, List<T>>();

	// current virtual machine that is managed by a VMManager instance
	protected T currentVM;

	// logger
	private static final Logger LOG = LogManager.getLogger(Manager.class);

	protected String execute(String command) throws IOException {

		String fullCmd = buildCloudCommand(command);
		LOG.info("Executing: {}", fullCmd);

		// here we attempt to run gcloud command using os shell
		Process gcloudProcess = Runtime.getRuntime().exec(fullCmd);

		// I/O of the gcloud * command
		BufferedReader stdOutput = new BufferedReader(new InputStreamReader(gcloudProcess.getInputStream()));
		BufferedReader stdErrorOutput = new BufferedReader(new InputStreamReader(gcloudProcess.getErrorStream()));

		StringBuilder processOutMsg = readProcessIOStream(stdOutput);
		if (processOutMsg.length() > 0)
			LOG.trace(processOutMsg);

		StringBuilder processErrOutMsg = readProcessIOStream(stdErrorOutput);
		if (processErrOutMsg.length() > 0)
			LOG.error(processErrOutMsg);

		// cleaning resources and killing the process
		stdOutput.close();
		stdErrorOutput.close();
		gcloudProcess.destroy();

		return processOutMsg.toString();
	}

	private String buildCloudCommand(String command) {
		StringBuilder cloudCmd = new StringBuilder();
		cloudCmd
			.append(PropertiesUtil.getInstance().getGceSdkPath())
			.append(File.separatorChar)
			.append(command);
		return cloudCmd.toString();
	}

	private StringBuilder readProcessIOStream(BufferedReader stdOut) throws IOException {
		String output;
		StringBuilder outputMessage = new StringBuilder();
		while ((output = stdOut.readLine()) != null)
			outputMessage.append(output).append('\n');

		return outputMessage;
	}

	@Override
	public T getCurrentVM() {
		return currentVM;
	}
}
