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
 <li>start randomly selected a GCE instance,</li>
 <li>stop randomly selected a GCE instance.</li>
</ul>

A list of functions will be continuously extended. 

To start working with GCP-compute-util an instance of the VMManager class is required. VMManager retrieves data of virtual
machines and fills up the main data model of GCE compute machines i.e., transforms GCE json into managable API - GCPComputeVModel.
