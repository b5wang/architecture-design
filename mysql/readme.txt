Take mysql 8 as example to simulate various scenarios in product.

- AA
http://www.884358.com/mysql8-gtid/

-- Validate the synchronisation process
CREATE TABLES IF NOT EXISTS key_value_pair(
    k VARCHAR(255),
    v VARCHAR(255),
    PRIMARY KEY (k)
);

insert into key_value_pair(k,v) values(UUID(),'1');
select * from key_value_pair;
