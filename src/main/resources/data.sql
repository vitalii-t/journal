--  BEGIN/END OF A LESSON SCHEDULE

insert into Schedule values ( 1, '8:00', '9:20' );
insert into Schedule values ( 2, '9:40', '11:00' );
insert into Schedule values ( 3, '9:40', '11:00' );
insert into Schedule values ( 4, '11:25', '12:45' );
insert into Schedule values ( 5, '13:10', '14:30' );
insert into Schedule values ( 6, '14:50', '16:10' );
insert into Schedule values ( 7, '16:25', '17:45' );

-- odd week

insert into week values (1,'monday',0,'free day','odd');

insert into week values (2,'tuesday',1,'Modelling(lec)','odd');
insert into week values (3,'tuesday',2,'Embedded computer systems (lec)','odd');
insert into week values (4,'tuesday',3,'Digital signal processing (lec)','odd');

insert into week values (5,'wednesday',1,'WEB-technology (pr)','odd');
insert into week values (6,'wednesday',2,'Digital signal processing (pr)','odd');

insert into week values (7,'thursday',1,'Programming technology (pr)','odd');
insert into week values (8,'thursday',2,'Programming technology (lec)','odd');

insert into week values (9,'friday',2,'WEB-technology (lec)','odd');
insert into week values (10,'friday',3,'English','odd');

-- EVEN WEEK SCHEDULE
insert into week values (11,'monday',0,'free day','even');

insert into week values (12,'tuesday',2,'Modelling(lec)','even');
insert into week values (13,'tuesday',3,'Embedded computer systems (lec)','even');

insert into week values (14,'wednesday',1,'Programming technology (lec)','even');
insert into week values (15,'wednesday',2,'WEB-technology (lec)','even');

insert into week values (16,'thursday',1,'Modelling (pr)','even');
insert into week values (17,'thursday',2,'Digital signal processing (lec)','even');

insert into week values (18,'friday',2,'Embedded computer systems (pr)','even');
insert into week values (19,'friday',3,'Digital signal processing (pr)','even');

insert into user values (1,'Vitalii','Tasun','mind0wner');

insert into user values (2,'Andrey','Nechiporuk','VacIncom1ng');
insert into user values (3,'Andrey','Kolesnyk','trugaaa~');

insert into user values (4,'Dmitriy','Senchuk','sen4');
insert into user values (5,'Vasilii','Petrov','VasPet');

insert into user values (6,'Pavel','Gerashchenko','pashgun');

insert into user values (7,'James','Harden','beard');
insert into user values (8,'Damian','Lillard','time');
