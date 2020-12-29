# Cloud-util
Cloud-util is a lightweight java framework for managing GCP/AWS/Azure/Alibaba instances. It allows to:
<ul>
 <li>start/stop a specific VM instance,</li>
 <li>start/stop all VM instances,</li>
 <li>start/stop a randomly selected VM instance.</li>
</ul>


To run Cloud-util the cloud provider's sdk is needed. Use config.properties in order to point a particular sdk path: 
```
# path to google cloud sdk
google-cloud-sdk.path=/path/to/google-cloud-sdk/bin

# path to Amazon AWS cloud sdk
aws-cloud-sdk.path=

# path to azure cloud sdk
azure-cloud-sdk.path=

# path to alibaba cloud computing sdk
alibaba-cloud-sdk.path=
```

The current version supports managing GCE instances. 


## Virtual Machine Manager
To start working with Cloud-util an instance of VMManager is required. VMManager retrieves data of virtual
machines and fills up the main data model (in the following example the GCPComputeVModel class.
```
VMManager<GCPComputeVModel> vmManager = new GCEManager();
```
Under the hood the constructor exectues:
```
gcloud compute instance list
```
and transforms GCE json into the managable data model.

## Demo
The following example presents how to start of a randomly selected virtual machine running within Google Cloud Platfrom.
```
// initialize a VM Manager instance for GCE (in the following example an implementation of Google Cloud Engine Manager is used).
VMManager<GCPComputeVModel> vmManager = new GCEManager();
				
// starts a randomly selected GCE instance
vmManager.startRandomInstance();
```

You don't need randomization you can pass the name of virtual machine.
```
vmManager.startInstance("ubuntu-las-vegas-c");
```

To obtain the IP address of vm use the following snipet of code:
```
// gets the IP address of randomly selected VM instance that runs on GCP
String ip = vmManager.getCurrentVM().getNetworkInterfaces().get(0).getAccessConfigs().get(0).getNatIP();
log.info("External IP of the GCE instance: {}", ip);
```
Above-presented code produces the following Apache log4j log:
```
20:44:58.353 [main] DEBUG com.dr.gcp.compute.vm.manager.VMManager - Virtual Machine Manager has started. Retrieving GCE instances data.
20:45:12.129 [main] INFO  com.dr.gcp.compute.vm.manager.VMManager - Starting: ubuntu-las-vegas-c
20:45:12.129 [main] DEBUG com.dr.gcp.compute.vm.manager.VMManager - Executing: google-cloud-sdk/bin/gcloud compute instances start ubuntu-las-vegas-c --zone=https://www.googleapis.com/compute/v1/projects/GSP-compute-util-project/zones/us-west4-c --format=json
20:45:21.999 [main] INFO  com.dr.gcp.compute.vm.manager.VMManager - Starting instance(s) ubuntu-las-vegas-c...........done.
Updated [https://compute.googleapis.com/compute/v1/projects/GSP-compute-util-project/zones/us-west4-c/instances/ubuntu-las-vegas-c].
Instance internal IP is 10.182.0.6
Instance external IP is 32.125.85.16

20:45:22.007 [main] INFO  com.dr.gcp.App - External IP of the GCE instance: 32.125.85.16
```
You can check the result via GCP web console.
<p align="center">
    <img height="250" src="/Figures/gcp-console-example.png?raw=true">
    <br>Fig.1 - GCP web console view.
</p>  

## Where do I start?
Please see the following demo application: <br>
https://github.com/dr-ruminski/GCP-compute-util/blob/master/GCP-compute-util/src/main/java/com/dr/gcp/App.java

## Literature
[1] Compute Engine documentation - https://cloud.google.com/compute/docs/ <br/>
[2] gcloud compute console tool - https://cloud.google.com/compute/docs/gcloud-compute <br/>
[3] Compute Engine APIs - https://cloud.google.com/compute/docs/reference/rest/v1
