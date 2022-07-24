drop table if exists liked_by;
drop table if exists offer;
drop table if exists employee;

create table Employee(
	id int primary key auto_increment,
    name varchar(50) not null,
    department varchar(50),
    gender varchar(6) not null,
    age int not null,
    contact_number bigint,
    email varchar(100) unique,
    password varchar(100),
    points_gained int default 0,
    check (gender in ('male','female')),
    check ( age > 0 )
    );
    
create table Offer(
	id int primary key auto_increment,
    name varchar(50) not null,
    description varchar(100),
    category varchar(50) not null,
    open_date timestamp default now(),
    closed_date timestamp,
    engaged_date timestamp,
    engaged_emp_id int,
    emp_id int not null,
    likes int default 0,
    foreign key(engaged_emp_id) references Employee(id) on delete cascade,
    foreign key(emp_id) references Employee(id) on delete cascade
    );

create table liked_by(
	emp_id int,
    offer_id int,
    liked_on timestamp default now(),
    primary key(emp_id,offer_id),
    foreign key(emp_id) references Employee(id) on delete cascade,
    foreign key(offer_id) references Offer(id) on delete cascade
    );
    
    
insert into Employee(id,name,department,gender,age,contact_number,email,password) values(1,'rohitsharma','Account','male',21,123456789,'rohit@gmail.com','rohitsharma');
insert into Employee(id,name,department,gender,age,contact_number,email,password) values(2,'kohli','Hr','male',31,123456746,'kohli@gmail.com','kohli');
insert into Employee(id,name,department,gender,age,contact_number,email,password) values(3,'smritimandhana','Hr','female',24,123456746,'smrithi@gmail.com','smritimandhana');

insert into Offer(id,name, description,category,emp_id) values(1,'offer 1','mobile','electronics',3);
insert into Offer(id,name, description,category,emp_id) values(2,'offer 2','table','furniture',3);
insert into Offer(id,name, description,category,emp_id) values(3,'offer 4','watch','accesscories',2);
insert into Offer(id,name, description,category,emp_id) values(4,'offer 5','chair','furniture',1);
insert into Offer(id,name, description,category,emp_id) values(5,'offer 6','ring','accessories',2);
insert into Offer(id,name, description,category,emp_id) values(6,'offer 3','laptop','electronics',1);

insert into liked_by(emp_id,offer_id) values(1,1);
insert into liked_by(emp_id,offer_id) values(1,2);
insert into liked_by(emp_id,offer_id) values(3,6);
insert into liked_by(emp_id,offer_id) values(2,4);



