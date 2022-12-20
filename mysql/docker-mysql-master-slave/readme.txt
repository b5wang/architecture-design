Usercase:
- 1 master
- 1 slave
-------------------------------------------
1) using default_authentication_plugin=mysql_native_password
By default default_authentication_plugin=caching_sha2_password, need configure SSL certificat.
Otherwise,
error connecting to master 'mydb_slave_user@mysql_master:3306' - retry-time: 60 retries: 1 message: Authentication plugin 'caching_sha2_password' reported error: Authentication requires secure connection.



2) configuration items relevant to directory
[client]
#socket=/var/lib/mysql/mysql.sock

[mysqld]
#socket=/var/lib/mysql/mysql.sock
#pid-file=/var/lib/mysql/mysql.pid
log-error=/var/lib/mysql/error.log
#datadir=/var/lib/mysql/data
slow_query_log_file=/var/lib/mysql/slow.log



3) A debug for replication error

# mysql -uroot -p111
mysql: [Warning] Using a password on the command line interface can be insecure.
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 20
Server version: 8.0.23 MySQL Community Server - GPL

Copyright (c) 2000, 2021, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> show slave status \G;
*************************** 1. row ***************************
               Slave_IO_State: Waiting for master to send event
                  Master_Host: mysql_master
                  Master_User: mydb_slave_user
                  Master_Port: 3306
                Connect_Retry: 60
              Master_Log_File: mysql-bin.000004
          Read_Master_Log_Pos: 1026
               Relay_Log_File: mysql-relay.000005
                Relay_Log_Pos: 901
        Relay_Master_Log_File: mysql-bin.000004
             Slave_IO_Running: Yes
            Slave_SQL_Running: No
              Replicate_Do_DB: 
          Replicate_Ignore_DB: 
           Replicate_Do_Table: 
       Replicate_Ignore_Table: 
      Replicate_Wild_Do_Table: 
  Replicate_Wild_Ignore_Table: 
                   Last_Errno: 1032
                   Last_Error: Coordinator stopped because there were error(s) in the worker(s). The most recent failure being: Worker 1 failed executing transaction 'a1057a87-74ab-11ed-82dd-0242ac130002:14' at master log mysql-bin.000004, end_log_pos 995. See error log and/or performance_schema.replication_applier_status_by_worker table for more details about this failure or others, if any.
                 Skip_Counter: 0
          Exec_Master_Log_Pos: 726
              Relay_Log_Space: 1574
              Until_Condition: None
               Until_Log_File: 
                Until_Log_Pos: 0
           Master_SSL_Allowed: No
           Master_SSL_CA_File: 
           Master_SSL_CA_Path: 
              Master_SSL_Cert: 
            Master_SSL_Cipher: 
               Master_SSL_Key: 
        Seconds_Behind_Master: NULL
Master_SSL_Verify_Server_Cert: No
                Last_IO_Errno: 0
                Last_IO_Error: 
               Last_SQL_Errno: 1032
               Last_SQL_Error: Coordinator stopped because there were error(s) in the worker(s). The most recent failure being: Worker 1 failed executing transaction 'a1057a87-74ab-11ed-82dd-0242ac130002:14' at master log mysql-bin.000004, end_log_pos 995. See error log and/or performance_schema.replication_applier_status_by_worker table for more details about this failure or others, if any.
  Replicate_Ignore_Server_Ids: 
             Master_Server_Id: 1
                  Master_UUID: a1057a87-74ab-11ed-82dd-0242ac130002
             Master_Info_File: mysql.slave_master_info
                    SQL_Delay: 0
          SQL_Remaining_Delay: NULL
      Slave_SQL_Running_State: 
           Master_Retry_Count: 86400
                  Master_Bind: 
      Last_IO_Error_Timestamp: 
     Last_SQL_Error_Timestamp: 221206 01:49:10
               Master_SSL_Crl: 
           Master_SSL_Crlpath: 
           Retrieved_Gtid_Set: a1057a87-74ab-11ed-82dd-0242ac130002:12-14
            Executed_Gtid_Set: a1057a87-74ab-11ed-82dd-0242ac130002:12-13,
a147b116-74ab-11ed-892e-0242ac130003:1-8
                Auto_Position: 0
         Replicate_Rewrite_DB: 
                 Channel_Name: 
           Master_TLS_Version: 
       Master_public_key_path: 
        Get_master_public_key: 0
            Network_Namespace: 
1 row in set, 1 warning (0.00 sec)

ERROR: 
No query specified

mysql>

--Get the information from binlog
--master
$ mysqlbinlog --no-defaults -vv mysql-bin.000004 | grep -A 100 995
--slave
$ mysqlbinlog --no-defaults -vv mysql-relay.000005 | grep -A 100 995
mysql> show binlog events in 'mysql-bin.000004';
mysql> show relaylog events in 'mysql-relay.000005';



-- set gtid_mode=on, it doesn't work
set global sql_slave_skip_counter=1;
start slave sql_thread;



-- using gtid
Retrieved_Gtid_Set: a1057a87-74ab-11ed-82dd-0242ac130002:12-14
Executed_Gtid_Set: a1057a87-74ab-11ed-82dd-0242ac130002:12-13,
mysql> stop slave;
mysql> set GTID_NEXT='a1057a87-74ab-11ed-82dd-0242ac130002:14';
mysql> begin;commit;
mysql> set GTID_NEXT='AUTOMATIC';
mysql> start slave;



-- continue running, read binlog
#221206  2:26:53 server id 1  end_log_pos 1277 CRC32 0x6d10119d 	Write_rows: table id 97 flags: STMT_END_F

BINLOG '
baiOYxMBAAAANgAAANIEAAAAAGEAAAAAAAEABG15ZGIAAmt2AAIDDwL8AwIBAQACAeDJQ79P
baiOYx4BAAAAKwAAAP0EAAAAAGEAAAAAAAEAAgAC/wADAAAAAQAznREQbQ==
'/*!*/;
### INSERT INTO `mydb`.`kv`
### SET
###   @1=3 /* INT meta=0 nullable=0 is_null=0 */
###   @2='3' /* VARSTRING(1020) meta=1020 nullable=1 is_null=0 */
# at 1277
#221206  2:26:53 server id 1  end_log_pos 1308 CRC32 0x1d0567e1 	Xid = 200
COMMIT/*!*/;
# at 1308
#221206  2:44:19 server id 1  end_log_pos 1387 CRC32 0x611fdacc 	GTID	last_committed=4	sequence_number=5	rbr_only=yes	original_committed_timestamp=1670294659123082	immediate_commit_timestamp=1670294659123082	transaction_length=282
/*!50718 SET TRANSACTION ISOLATION LEVEL READ COMMITTED*//*!*/;
# original_commit_timestamp=1670294659123082 (2022-12-06 02:44:19.123082 UTC)
# immediate_commit_timestamp=1670294659123082 (2022-12-06 02:44:19.123082 UTC)
/*!80001 SET @@session.original_commit_timestamp=1670294659123082*//*!*/;
/*!80014 SET @@session.original_server_version=80023*//*!*/;
/*!80014 SET @@session.immediate_server_version=80023*//*!*/;
SET @@SESSION.GTID_NEXT= 'a1057a87-74ab-11ed-82dd-0242ac130002:16'/*!*/;
# at 1387
#221206  2:44:19 server id 1  end_log_pos 1462 CRC32 0x4982ebd4 	Query	thread_id=10	exec_time=0	error_code=0
SET TIMESTAMP=1670294659/*!*/;
BEGIN
/*!*/;
# at 1462
#221206  2:44:19 server id 1  end_log_pos 1516 CRC32 0x5e09ac67 	Table_map: `mydb`.`kv` mapped to number 97
# at 1516
#221206  2:44:19 server id 1  end_log_pos 1559 CRC32 0x2e43ec59 	Write_rows: table id 97 flags: STMT_END_F

BINLOG '
g6yOYxMBAAAANgAAAOwFAAAAAGEAAAAAAAEABG15ZGIAAmt2AAIDDwL8AwIBAQACAeBnrAle
g6yOYx4BAAAAKwAAABcGAAAAAGEAAAAAAAEAAgAC/wAEAAAAAQA0WexDLg==
'/*!*/;
### INSERT INTO `mydb`.`kv`
### SET
###   @1=4 /* INT meta=0 nullable=0 is_null=0 */
###   @2='4' /* VARSTRING(1020) meta=1020 nullable=1 is_null=0 */
# at 1559
#221206  2:44:19 server id 1  end_log_pos 1590 CRC32 0x7bd45536 	Xid = 265
COMMIT/*!*/;
SET @@SESSION.GTID_NEXT= 'AUTOMATIC' /* added by mysqlbinlog */ /*!*/;
DELIMITER ;
# End of log file
/*!50003 SET COMPLETION_TYPE=@OLD_COMPLETION_TYPE*/;
/*!50530 SET @@SESSION.PSEUDO_SLAVE_MODE=0*/;
# 



--- ignore update table
REPLICATE_IGNORE_TABLE = ('mydb.kv1')