terraform {
  backend "gcs" {
    bucket = "tejas-backend-ice-bucket-challenge"
    prefix = "database/"
  }
}