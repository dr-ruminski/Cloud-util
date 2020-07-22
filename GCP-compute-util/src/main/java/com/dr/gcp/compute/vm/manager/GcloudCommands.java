package com.dr.gcp.compute.vm.manager;

public class GcloudCommands {
	
	public static final String GCLOUD_PATH = "google-cloud-sdk/bin/";
	public static final String LIST_INSTANCES = GCLOUD_PATH+"gcloud compute instances list --format json";
	public static final String START_INSTANCE = GCLOUD_PATH+"gcloud compute instances start ";
	public static final String STOP_INSTANCE = GCLOUD_PATH+"gcloud compute instances stop ";
}
