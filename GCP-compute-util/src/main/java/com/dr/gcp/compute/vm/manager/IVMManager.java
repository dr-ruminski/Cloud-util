package com.dr.gcp.compute.vm.manager;

/**
 * An interface for the Virtual Machine Manager. The idea of use
 * {@link IVMManager} is to support e.g. Amazon, Alibaba, Azure clouds managers.
 * Currently is used by GCP {@link VMManager}.
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
	void startInstance(String name);

	/**
	 * Stops virtual machine.
	 * 
	 * @param name - Google Cloud Engine instance name
	 */
	void stopInstance(String name);

	/**
	 * Starts all GCE instances one by one.
	 */
	void startAllInstance();

	/**
	 * Stops all GCE instances one by one.
	 */
	void stopAllInstance();

	/**
	 * Selects randomly a GCE instance and starts it.
	 */
	void startRandomInstance();

	/**
	 * Stops randomly selected GCE instance.
	 */
	void stopRandomInstance();

}
