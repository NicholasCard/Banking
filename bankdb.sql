DROP SCHEMA IF EXISTS bank CASCADE;

CREATE SCHEMA bank AUTHORIZATION postgres;


 
create table bank.users (
	id serial not null,
	role varchar(15),
	f_name varchar(40),
	l_name varchar(40),
	user_name varchar(40),
	password varchar(40),
	primary key(id)

);

create table bank.accounts (
	id serial not null ,
	user_id int,
	total int,
	acc_name varchar(40),
	primary key(id),
	approved boolean,
	constraint fk_user
		foreign key(user_id)
			references bank.users(id)
	
);

create table bank.transactions (
	id serial not null primary key,
	user_id int,
	acc_id int,
	transaction_type varchar(15),
	amount int,
	transaction_date timestamp,
	constraint fk_user
		foreign key(user_id)
			references bank.users(id),
	constraint fk_acc_id
		foreign key(acc_id)
			references bank.accounts(id)
			on delete cascade

);

create table bank.transfers (
id serial not null primary key,
recieverAccount int,
senderAccount int,
amount int
);

INSERT INTO bank.users (f_name,l_name, role, user_name, password) VALUES ('nick','card', 'customer', 'nickcard@email.com', 'nickcard');
INSERT INTO bank.users (f_name,l_name, role, user_name, password) VALUES ('travis','hammonds', 'employee', 'travishammonds@email.com', 'travishammonds');
INSERT INTO bank.users (f_name,l_name, role, user_name, password) VALUES ('test','1', 'customer', 'test1@email.com', 'test1');
INSERT INTO bank.users (f_name,l_name, role, user_name, password) VALUES ('test','2', 'employee', 'test2@email.com', 'test2');

INSERT INTO bank.accounts (user_id, total, acc_name, approved) VALUES (1, 50, 'nicks checking', true);
INSERT INTO bank.accounts (user_id, total, acc_name, approved) VALUES (3, 58484, 'Test1 savings', true);
INSERT INTO bank.accounts (user_id, total, acc_name, approved) VALUES (3, 54, 'Test1 checking', false);

insert into bank.transactions (user_id, acc_id, transaction_type, amount, transaction_date) values (3, 2, 'deposit', 60, '2021-06-06');

