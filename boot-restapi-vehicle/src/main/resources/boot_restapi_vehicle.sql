create database vehicle_db;
use  vehicle_db;
show tables;

-- drop table tt_vehicle;
create table tt_vehicle (
vehicle_id int primary key not null unique auto_increment,
reg_no varchar(30)  unique NOT NULL,
eng_no varchar(30) unique NOT NULL,
chas_no  varchar(30) unique NOT NULL,
vehicle_model varchar(50),
wheel_type varchar(20)
);
SELECT * from tt_vehicle;
--- GRANT ALL PRIVILEGES ON * . * TO 'boot'@'localhost' ; 
--- FLUSH PRIVILEGES;

insert into tt_vehicle ( vehicle_id , reg_no, eng_no, chas_no, vehicle_model , wheel_type ) 
values (1001, 'MP19NA3378','52WVC10338' ,'2H2XA59BWDY987665' , 'TVS Jupitor' , 'Two Wheeler');