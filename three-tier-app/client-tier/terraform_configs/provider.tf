provider "google" {
  # this value changes because I am using a playground
  project = "clgcporg8-093"
}

terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}