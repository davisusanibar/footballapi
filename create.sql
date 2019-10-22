
    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team (id)

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition (id)

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team (id)

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition (id)

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team (id)

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition (id)

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team (id)

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition (id)

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team (id)

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition (id)

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    )

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    )

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    )

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    )

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    )

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    )

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    )

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    )

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    )

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    )

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    )

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    )

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team (id)

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition (id)

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team (id)

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition (id)

    create table competition (
       id varchar(255) not null,
        area_name varchar(255),
        code varchar(255),
        name varchar(255),
        primary key (id)
    )

    create table player (
       id varchar(255) not null,
        country_of_birth varchar(255),
        date_of_birth varchar(255),
        name varchar(255),
        nationality varchar(255),
        position varchar(255),
        team_id varchar(255),
        primary key (id)
    )

    create table team (
       id varchar(255) not null,
        area_name varchar(255),
        email varchar(255),
        name varchar(255),
        short_name varchar(255),
        tla varchar(255),
        competition_id varchar(255),
        primary key (id)
    )

    alter table player 
       add constraint FKdvd6ljes11r44igawmpm1mc5s 
       foreign key (team_id) 
       references team

    alter table team 
       add constraint FKqhhapgh63c9yjo4tc0uf6ynt1 
       foreign key (competition_id) 
       references competition
