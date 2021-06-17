package com.dr.gcp.compute.manager;

public class GcloudCommands {
	
	public static final String LIST_INSTANCES = "gcloud compute instances list --format json";
	public static final String START_INSTANCE = "gcloud compute instances start ";
	public static final String STOP_INSTANCE = "gcloud compute instances stop ";
	public static final String DELETE_INSTANCE = "gcloud compute instances delete ";
	public static final String RESET_INSTANCE = "gcloud compute instances reset ";
	public static final String CREATE_INSTANCE = "gcloud beta compute instances create ";
	
//	 us-central1-f-1006-1 --source-machine-image ubuntu-ch --zone us-central1-f --machine-type f1-micro --tags proxy8080&

	// Prevents instantiation
	private GcloudCommands() {}
}
