package com.dr.gcp.compute.vm.manager;

import java.io.IOException;

/**
 * An interface for the Virtual Machine Manager. The idea of use
 * {@link IVMManager} is to support e.g. Amazon, Alibaba, Azure clouds managers.
 * Currently is used by {@link VMManager} in context of Google Cloud.
 * 
 * @author Dariusz Rumiński
 *
 */
public interface IVMManager {

	/**
	 * Starts virtual machine.
	 * 
	 * @param name - Google Cloud Engine instance name
	 */
	void startInstance(String name) throws IOException;

	/**
	 * Stops virtual machine.
	 * 
	 * @param name - Google Cloud Engine instance name
	 */
	void stopInstance(String name) throws IOException;

	/**
	 * Starts all GCE instances one by one.
	 */
	void startAllInstance() throws IOException;

	/**
	 * Stops all GCE instances one by one.
	 */
	void stopAllInstance() throws IOException;

	/**
	 * Selects randomly a GCE instance and starts it.
	 */
	void startRandomInstance() throws IOException;

	/**
	 * Stops randomly selected GCE instance.
	 */
	void stopRandomInstance() throws IOException;

}
