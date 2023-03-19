#!/bin/bash

project_name=$1
instance_name=$2
zone=$3
key=$4

gcloud compute instances describe $instance_name --zone=$zone --project=$project_name --format "json(metadata.$key)"