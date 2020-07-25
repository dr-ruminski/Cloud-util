# GCP-compute-util
Google Cloud Patform Compute utility is a lightweight java framework for managing Google Cloud Engine instances. Simply, it wraps basic functionality of 
```
gcloud compute instance *
```
where * can means further parameters such as: start, stop, list, name of vm, --zone, --format etc.


With the use of GCP-compute-util you can:
<ul>
 <li>start a GCE instance by providing a name of vm,</li>
 <li>stop a GCE instance by providing a name of vm,</li>
 <li>start all GCE instances,</li>
 <li>stop all GCE instances,</li> 
 <li>start randomly selected a GCE instance,</li>
 <li>stop randomly selected a GCE instance.</li>
</ul>

A list of functions will be continuously extended. 

## Virtual Machine Manager
To start working with GCP-compute-util an instance of the VMManager class is required. VMManager retrieves data of virtual
machines and fills up the main data model of GCE compute machines.
```
VMManager vmManager = new VMManager();
```
Under the hood the constructor exectues:
```
gcloud compute instance list
```
and transforms GCE json into managable data model - a map of GCPComputeVModel.

## Demo
The following example presents starting randomly selected virtual machine running within Google Cloud Platfrom.
```
// initialize a VM Manager instance
VMManager vmManager = new VMManager();
		
// starts randomly selected GCE instance
vmManager.startRandomInstance();
		
// gets the IP address of randomly selected VM instance that runs on GCP
String ip = vmManager.getCurrentVM().getNetworkInterfaces().get(0).getAccessConfigs().get(0).getNatIP();
log.info("External IP of the GCE instance: {}", ip);
```
Above-presented code produces the following 



