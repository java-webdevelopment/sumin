SELECT owner, table_name FROM all_tables where OWNER = 'WEEK7';


CREATE TABLE student (
	name VARCHAR2(15) PRIMARY KEY,
	password VARCHAR2(15),
	subject VARCHAR2(15)
)

CREATE TABLE subject (
	subject VARCHAR2(15) PRIMARY KEY,
	name VARCHAR2(15)
)

Select * from student;

Select * from subject;


ALTER TABLE student DROP COLUMN subject;