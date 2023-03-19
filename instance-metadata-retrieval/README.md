# Retrieve a given key from VM's metadata

This is achieved using Google Cloud SDK via the gcloud command.
The script expects four arguments:
- project_name
- instance_name
- zone
- key

Please note that this script does not contain authentication logic, and it would depend on the CI/CD tool on which this script will be run.
Majorly, the pre-requisites would be the presence of "gcloud" tool on the system, and optionally some way to store the key of service account etc.

The Google service account that is used to create the VM instance could be utilized by creating its key and storing it in an encrypted store. This encrypted store could be GitHub Secrets, Jenkins Credentials or any cloud's secret manager.
In case of Jenkins, the key could be stored in Jenkins credentials as a "Secret file", and the pipeline script could fetch the key using withCredentials() block by passing in the secret file name.
This could be made use of in the 'gcloud auth activate-service-account' command to authenticate to GCP.

Alternately, the user could also be granted 'iam/serviceAccountTokenCreator' role to impersonate the service account, in case the developer needs to make API calls on the instance by acting as the service account which does have access.

Usage:
```
./metadata-key.sh <project-name> <instance-name> <zone> <key>
```