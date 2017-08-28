# spark-parquet-dumper

Store from RDBMS table data into a parquet file.

## Usage:
*--jars* = JDBC driver jars
```
spark-submit --jars "/tmp/data/mysql-connector-java-5.1.41-bin.jar,/tmp/data/sqljdbc42.jar" /tmp/data/spark-parquet-dumper-assembly-0.1.jar /tmp/data/db.conf
```

