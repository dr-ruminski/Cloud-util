package com.dr.gcp;

import java.util.Scanner;

import com.dr.gcp.compute.vm.manager.VMManager;

/**
 * Test app that demonstrates a small susbset of the VM manager functionality.
 */
public class App {
	public static void main(String[] args) {

		// initialize a VM Manager instance
		VMManager vmManager = new VMManager();
		
		// starts randomly selected GCE instance
		vmManager.startRandomInstance();
		
		// gets the IP address of randomly selected VM instance that runs on GCP
		String ip = vmManager.getCurrentVM().getNetworkInterfaces().get(0).getAccessConfigs().get(0).getNatIP();
		
		// hit enter to shutdown randomly selected a VM instance
		Scanner s = new Scanner(System.in);
		s.nextLine();
		s.close();
		
		// stops VM instance
		vmManager.stopInstance(vmManager.getCurrentVM().getName());
		
	}
}
