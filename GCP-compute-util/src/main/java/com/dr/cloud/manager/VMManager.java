package com.dr.cloud.manager;

import java.io.IOException;
import java.util.Map;

import com.dr.gcp.compute.manager.GCEManager;

/**
 * An interface for the Virtual Machine Manager. The idea of use
 * {@link VMManager} is to support e.g. Amazon, Alibaba, Azure clouds managers.
 * Currently is used by {@link GCEManager} in context of Google Cloud.
 * 
 * @author Dariusz Rumiński
 * @param <T> - class representing general model of a virtual machine.
 *
 */
public interface VMManager<T> {

	/**
	 * 
	 * TODO: add comment
	 * 
	 * @param name
	 * @param params
	 * @throws IOException
	 */
	void createInstance(String name, Map<String, String> params) throws IOException;
	
	/**
	 * 
	 * @param name
	 * @throws IOException
	 */
	void deleteInstance(String name) throws IOException;
	
		
	
	/*
	 * Gets current (lastly selected) virtual machine.
	 */
	T getCurrentVM();

	/**
	 * Starts virtual machine.
	 * 
	 * @param name - a virtual machine's instance name
	 * @throws IOException - thrown in case when a problem with a virtual machine exists on the cloud side
	 */
	void startInstance(String name) throws IOException;

	/**
	 * Stops virtual machine.
	 * 
	 * @param name - Google Cloud Engine instance name
	 * @throws IOException - thrown in case when a problem with a virtual machine exists on the cloud side
	 */
	void stopInstance(String name) throws IOException;

	/**
	 * Starts all GCE instances one by one.
	 * @throws IOException - thrown in case when a problem with some virtual machine exists on the cloud side
	 */
	void startAllInstance() throws IOException;

	/**
	 * Stops all GCE instances one by one.
	 * @throws IOException - thrown in case when a problem with some virtual machine exists on the cloud side
	 */
	void stopAllInstance() throws IOException;

	/**
	 * Selects randomly selected virtual machine instance in order to start it.
	 * @throws IOException - thrown in case when a problem with a virtual machine exists on the cloud side
	 */
	void startRandomInstance() throws IOException;

	/**
	 * Stops the randomly selected virtual machine instance.
	 * @throws IOException - thrown in case when a problem with a virtual machine exists on the cloud side
	 */
	void stopRandomInstance() throws IOException;
	
	void resetInstance(String name) throws IOException;


}
