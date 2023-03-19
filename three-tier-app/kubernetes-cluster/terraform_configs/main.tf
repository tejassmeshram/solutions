resource "google_container_cluster" "my-cluster" {
  name     = "tejas-cluster"
  location = "us-central1"

  remove_default_node_pool = true
  initial_node_count       = 1

  node_config {
    preemptible  = true
    machine_type = "e2-micro"
    disk_type    = "pd-standard"
    disk_size_gb = 10
  }
}

resource "google_container_node_pool" "my-node-pool" {
  name       = "tejas-node-pool"
  cluster    = google_container_cluster.my-cluster.name
  location   = "us-central1"
  node_count = 2
  node_config {
    preemptible  = true
    machine_type = "e2-micro"
    disk_type    = "pd-standard"
    disk_size_gb = 10
  }
}