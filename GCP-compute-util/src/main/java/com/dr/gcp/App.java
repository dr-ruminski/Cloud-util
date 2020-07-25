package com.dr.gcp;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dr.gcp.compute.vm.manager.VMManager;

/**
 * Test app that demonstrates a small subset of the VM manager functionality.
 */
public class App {
	
	public static void main(String[] args) {

		// apache log4j for this demo
		Logger log = LogManager.getLogger();
		
		// initialize a VM Manager instance
		VMManager vmManager = new VMManager();
		
		// starts randomly selected GCE instance
		vmManager.startRandomInstance();
		
		// gets the IP address of randomly selected VM instance that runs on GCP
		String ip = vmManager.getCurrentVM().getNetworkInterfaces().get(0).getAccessConfigs().get(0).getNatIP();
		log.info("External IP of the GCE instance: {}", ip);
		
		
		// hit enter to shutdown randomly selected a VM instance
		Scanner s = new Scanner(System.in);
		s.nextLine();
		s.close();
		
		log.info("Stoping instance. Please wait for the response");
		
		// stops VM instance
		vmManager.stopInstance(vmManager.getCurrentVM().getName());
		
	}
}
