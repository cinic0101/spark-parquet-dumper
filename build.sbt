name := "spark-parquet-dumper"

version := "0.1"

scalaVersion := "2.11.11"

val sparkVersion = "2.2.0"
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "com.typesafe" % "config" % "1.3.1"
)

mainClass := Some("Dumper")