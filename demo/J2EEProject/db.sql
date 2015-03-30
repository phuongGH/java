
create TABLE customers (
mobile number constraint customer_pk primary key,
name varchar2(50),
email varchar2(50),
offerID number
);

create TABLE offer (
id number constraint offer_pk primary key,
descr varchar2(50)
);

alter table customers add (constraint customer_offer_fk
foreign key (offerid) references offer(id)); 

insert into offer values (4,'value 4')
insert into offer values (5,'value 5')
insert into offer values (6,'value 6')
insert into offer values (7,'value 7');