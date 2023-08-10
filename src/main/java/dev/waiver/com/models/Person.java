package dev.waiver.com.models;

import dev.waiver.com.models.common.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person extends AbstractEntity {

//    person_id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY ,
//    name varchar(255) NOT NULL CHECK ( length(name)>3 ),
//    username varchar(255) NOT NULL UNIQUE CHECK ( length(username)>3 ),
//    password varchar(255) NOT NULL CHECK ( length(password)>3 ),
//    age int CHECK ( age>1 AND age<125),
//    role varchar(255) NOT NULL CHECK ( length(role)>3 )
//    created_at timestamp NOT NULL,
//    updated_at timestamp NOT NULL

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "role")
    private String role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}