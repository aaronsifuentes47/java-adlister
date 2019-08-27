use adlister_db;

drop table ads;
drop table users;

create table if not exists users (
        id int unsigned not null auto_increment primary key,
        user_name varchar(100) not null,
        email varchar(150) not null,
        password varchar(100) not null
);

create table if not exists ads (
        id int unsigned not null auto_increment primary key,
        user_id int unsigned not null,
        title varchar(100) not null,
        description text not null,
        foreign key(user_id) references users (id)
);

insert into users (user_name, email, password)
values ('joe', 'joe@email.com', 'joepass');

insert into ads (user_id, title, description)
values (1, 'joes stuff','buy my stuff');
