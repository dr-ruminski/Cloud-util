package com.dr.gcp.compute.manager;

public class GcloudCommands {
	
	public static final String LIST_INSTANCES = "gcloud compute instances list --format json";
	public static final String START_INSTANCE = "gcloud compute instances start ";
	public static final String STOP_INSTANCE = "gcloud compute instances stop ";
	public static final String DELETE_INSTANCE = "gcloud compute instances delete ";
	
	// Prevents instantiation
	private GcloudCommands() {}
}
