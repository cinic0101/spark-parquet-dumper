# spark-parquet-dumper

Store from RDBMS table data into a parquet file.

## Usage:
*--jars* = JDBC driver jars
```bash
spark-submit --jars "/tmp/data/mysql-connector-java-5.1.41-bin.jar,/tmp/data/sqljdbc42.jar" /tmp/data/spark-parquet-dumper-assembly-0.1.jar /tmp/data/db.conf
```

## db.conf
```apacheconf
// JDBC driver, for example:
// SQL Server -> com.microsoft.sqlserver.jdbc.SQLServerDriver
// MySQL      -> com.mysql.jdbc.Driver
// ...
driver=com.mysql.jdbc.Driver

// JDBC DB URL, for example:
// SQL Server -> jdbc:sqlserver://SERVER_ADDRESS:1433;databaseName=DB_NAME
// MySQL      -> jdbc:mysql://SERVER_ADDRESS:3306/DB_NAME
// ...
url="jdbc:mysql://SERVER_ADDRESS:3306/DB_NAME"

// DB user name and password
user="USER"
password="PASSWORD"

// Dump table info
dbTable=users
columns=[mobile,email,first_name,gender,birthday]

// Parquet path
saveAs=/tmp/data/users.parquet
```
