-- mysql table or database update
select table_schema,
       table_name,
	   table_rows,
       concat(truncate(data_length/1024/1024,2),'MB') as data_size,
	   create_time,
	   update_time
	   -- create_options,
	   -- table_comment
from information_schema.tables where table_schema='sta';

select table_schema,
       table_name,
	   table_rows,
       concat(truncate(data_length/1024/1024,2),'MB') as data_size,
	   create_time,
	   update_time
	   -- create_options,
	   -- table_comment
from information_schema.tables where table_schema='adm';

select table_schema,
       table_name,
	   table_rows,
       concat(truncate(data_length/1024/1024,2),'MB') as data_size,
	   create_time,
	   update_time
	   -- create_options,
	   -- table_comment
from information_schema.tables where table_schema='ods';