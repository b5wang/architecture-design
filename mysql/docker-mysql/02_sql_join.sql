-- ======================================================================
-- https://wxb.github.io/2016/12/15/MySQL%E4%B8%AD%E7%9A%84%E5%90%84%E7%A7%8Djoin.html
-- 

-- ======================================================================
-- Simple case t1 t2
CREATE TABLE t1 (
    id INT PRIMARY KEY,
    person VARCHAR(55) NOT NULL
);
 
CREATE TABLE t2 (
    id VARCHAR(55) PRIMARY KEY,
    person VARCHAR(55) NOT NULL
);

INSERT INTO t1(id, person)
VALUES(1,'小明'),
      (2,'小红'),
      (3,'小强');
 
INSERT INTO t2(id, person)
VALUES('A','小明'),
      ('B','小红'),
      ('C','小刚');
      
select * from t1;
select * from t2;

select * from t1 cross join t2 order by t1.id;-- Cartesion product
select * from t1 full join t2;

select * from t1 cross join t2 on t1.person=t2.person order by t1.id; -- as same as inner join
select * from t1 inner join t2 on t1.person=t2.person order by t1.id;

select * from t1 left join t2 on t1.person=t2.person order by t1.id;
select * from t1 left join t2 on t1.person=t2.person where t2.id is null order by t1.id;

select * from t1 right join t2 on t1.person=t2.person order by t2.id;
select * from t1 right join t2 on t1.person=t2.person where t1.id is null order by t2.id;


select * from t1 left join t2 on t1.person=t2.person where t2.id is null
union
select * from t1 right join t2 on t1.person=t2.person where t1.id is null;
-- ======================================================================
-- Complex case: products, stores, and sales
-- https://cloud.tencent.com/developer/article/1532193
-- 
CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100),
    price DECIMAL(13,2 )
);
 
CREATE TABLE stores (
    id INT PRIMARY KEY AUTO_INCREMENT,
    store_name VARCHAR(100)
);
 
CREATE TABLE sales (
    product_id INT,
    store_id INT,
    quantity DECIMAL(13 , 2 ) NOT NULL,
    sales_date DATE NOT NULL,
    PRIMARY KEY (product_id , store_id),
    FOREIGN KEY (product_id)
        REFERENCES products (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (store_id)
        REFERENCES stores (id)
        ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO products(product_name, price)
VALUES('iPhone', 699),
      ('iPad',599),
      ('Macbook Pro',1299);
 
INSERT INTO stores(store_name)
VALUES('North'),
      ('South');
 
INSERT INTO sales(store_id,product_id,quantity,sales_date)
VALUES(1,1,20,'2017-01-02'),
      (1,2,15,'2017-01-05'),
      (1,3,25,'2017-01-05'),
      (2,1,30,'2017-01-02'),
      (2,2,35,'2017-01-05');

-- Question: 
-- 统计每个商店每种商品总共营业额是多少钱？
select st.store_name,pr.product_name,format(sa.quantity*pr.price,2) as total_money
from sales sa inner join stores st on sa.store_id=st.id inner join products pr on sa.product_id=pr.id;

select st.store_name,pr.product_name,ifnull(null,0.00) from stores st cross join products pr;


select st.store_name,pr.product_name,ifnull(t2.total_money,0.00) as total_money from stores st cross join products pr
left join 
(select st.store_name,pr.product_name,format(sa.quantity*pr.price,2) as total_money 
from sales sa inner join stores st on sa.store_id=st.id inner join products pr on sa.product_id=pr.id) t2 
on st.store_name=t2.store_name and pr.product_name=t2.product_name
order by st.store_name,pr.product_name;