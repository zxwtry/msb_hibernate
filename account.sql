
    drop table if exists acc_tab 

    create table acc_tab (
        id integer not null auto_increment,
        name varchar(255),
        age integer,
        score double precision,
        birthday date,
        primary key (id)
    ) ENGINE=InnoDB 
