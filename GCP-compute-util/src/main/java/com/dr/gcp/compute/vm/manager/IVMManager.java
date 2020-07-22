package com.dr.gcp.compute.vm.manager;

public interface IVMManager {


	
	/**
	 * Starts virtual machine.
	 * @param name - Google Cloud Engine instance name
	 */
	void startInstance(String name);
	
	/**
	 * Stops virtual machine.
	 * @param name - Google Cloud Engine instance name
	 */
	void stopInstance(String name);
	
	/**
	 * Starts all GCE instances one by one.
	 */
	void startAllInstance();
	
	/**
	 * Selects randomly a GCE instance and starts it.
	 */
	void startRandomInstance();
	
	/**
	 * Stops randomly selected GCE instance.
	 */
	void stopRandomInstance();
	
}
