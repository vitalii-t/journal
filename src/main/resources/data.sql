--  BEGIN/END OF A LESSON SCHEDULE

insert into Schedule values ( 1, '8:00', '9:20' );
insert into Schedule values ( 2, '9:40', '11:00' );
insert into Schedule values ( 3, '9:40', '11:00' );
insert into Schedule values ( 4, '11:25', '12:45' );
insert into Schedule values ( 5, '13:10', '14:30' );
insert into Schedule values ( 6, '14:50', '16:10' );
insert into Schedule values ( 7, '16:25', '17:45' );

-- odd week

insert into odd_week values (1,'monday',0,'free day');

insert into odd_week values (2,'tuesday',1,'Modelling(lec)');
insert into odd_week values (3,'tuesday',2,'Embedded computer systems (lec)');
insert into odd_week values (4,'tuesday',3,'Digital signal processing (lec)');

insert into odd_week values (5,'wednesday',1,'WEB-technology (pr)');
insert into odd_week values (6,'wednesday',2,'Digital signal processing (pr)');

insert into odd_week values (7,'thursday',1,'Programming technology (pr)');
insert into odd_week values (8,'thursday',2,'Programming technology (lec)');

insert into odd_week values (9,'friday',2,'WEB-technology (lec)');
insert into odd_week values (10,'friday',3,'English');

-- EVEN WEEK SCHEDULE
insert into even_week values (1,'monday',0,'free day');

insert into even_week values (2,'tuesday',2,'Modelling(lec)');
insert into even_week values (3,'tuesday',3,'Embedded computer systems (lec)');

insert into even_week values (4,'wednesday',1,'Programming technology (lec)');
insert into even_week values (5,'wednesday',2,'WEB-technology (lec)');

insert into even_week values (6,'thursday',1,'Modelling (pr)');
insert into even_week values (7,'thursday',2,'Digital signal processing (lec)');

insert into even_week values (8,'friday',2,'Embedded computer systems (pr)');
insert into even_week values (9,'friday',3,'Digital signal processing (pr)')