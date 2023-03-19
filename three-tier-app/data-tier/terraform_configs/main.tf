resource "google_sql_database_instance" "database-instance" {
  region           = "us-central1"
  database_version = "POSTGRES_14"
  settings {
    tier = "db-f1-micro"
  }
}

resource "google_sql_database" "database" {
  name     = "tejas-database"
  instance = google_sql_database_instance.database-instance.name
}

resource google_sql_user "user" {
  name     = "tejas-user"
  instance = google_sql_database_instance.database-instance.name
  password = "AsIfThisWorks"
}