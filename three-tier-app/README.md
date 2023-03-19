<h3>Flow: </h3>

First, a kubernetes cluster should get created.

Next, data-tier could be executed to provision Cloud SQL.

Then, middle-tier could be executed to deploy application and kubernetes service, in the cluster. This application is assumed to have the logic to connect and interact with database.

Finally, client-tier can be executed to provision the Ingress in the cluster, which creates an External Load Balancer in GCE, and forwards the request to middle-tier's kubernetes service (which should also get created as a GCP backend service)

<h4>Note: </h4>
All resources are created in default network, wherever applicable, to keep the application simple.
Kubernetes resources are created in default namespace