show variables like '%version%';
show databases;
create database mydb;
use mydb;
show tables ;
 -- drop table tt_product ;
create table tt_product (
prod_id int auto_increment not null primary Key ,
prod_name varchar(50) ,
prod_desc varchar(100) ,
price int
);

select * from tt_product ;

mysql> SELECT user,authentication_string,plugin,host FROM mysql.user;
mysql> create database db_example; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

-- java.sql.SQLException: Access denied for user '=root'@'localhost' (using password: YES)

CREATE USER 'singraul'@'localhost' IDENTIFIED BY 'singraul';

GRANT ALL PRIVILEGES ON * . * TO 'singraul'@'localhost' ; 

FLUSH PRIVILEGES;

========https://www.yawintutor.com/error-5068-exception-during-pool-initialization/
CREATE USER 'root'@'192.168.1.3' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'192.168.1.3' WITH GRANT OPTION;
FLUSH PRIVILEGES;

========Rollback
revoke ALL PRIVILEGES ON *.* from 'root'@'192.168.1.3';
FLUSH PRIVILEGES;