drop table if exists log;

create table if not exists log(
    id bigint not null auto_increment primary key,
	message varchar(255) not null,
    created_date datetime not null
);

create table if not exists log_bak(
    id bigint not null auto_increment primary key,
	message varchar(255) not null,
    created_date datetime not null
);

insert into log(message,created_date) values('test log','2023-03-13 16:30:00');
select * from log;
select count(*) from log;
-- 
drop procedure if exists demo.make_date;

DELIMITER $$
create procedure demo.make_date()
begin
declare i int;
set i=0;
while i<=1000000 do
	insert into log(message,created_date) values(CONCAT('test log - ',i),'2023-03-15 11:30:00');
    set i=i+1;
end while;
select CONCAT('i=',i);
end $$

call make_date();

select * from performance_schema.events_statements_history;

-- 
DELIMITER $$
create procedure demo.backup_data()
begin

end $$

drop procedure if exists backup_data;

delimiter $$
CREATE procedure backup_data(in str_date varchar(55))
begin
declare done int default false;
declare offset_val int default 0;
declare counter_val int default 0;
repeat
    insert into log_bak(id,message,created_date) select id,message,created_date from log where created_date>=str_to_date(str_date,'%Y-%m-%d') and created_date<date_sub(str_to_date(str_date,'%Y-%m-%d'),interval -1 day) limit 10000 offset offset_val;
	set offset_val = offset_val + 10000;
	set done = row_count() = 0;
    set counter_val = counter_val + row_count();
until done
end repeat;
select counter_val;
end$$
delimiter ;
-- call backup_data('2023-03-14');

select date(date_sub(now(), interval 1 day));
select date(date_sub(now(), interval 0 day));
select * from log_bak limit 100;
select count(*) from log where created_date>=date_sub(str_to_date('2023-03-15','%Y-%m-%d'), INTERVAL 1 DAY ) and created_date<=str_to_date('2023-03-16','%Y-%m-%d');


