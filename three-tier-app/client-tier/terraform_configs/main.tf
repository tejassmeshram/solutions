resource "google_compute_instance_group_manager" "mig" {
  base_instance_name = "tejas"
  name               = "my-mig"
  target_size        = 2
  zone               = "us-central1-a"
  version {
    instance_template = google_compute_instance_template.template.id
  }
}

resource "google_compute_instance_template" "template" {
  disk {
    source_image = "debian-cloud/debian-11"
    auto_delete  = true
    disk_type    = "pd-standard"
    disk_size_gb = 10
  }
  name         = "tejas-template"
  machine_type = "e2-micro"
  network_interface {
    network = "default"
  }
  region = "us-central1"
}