package org.perscholas.springboot.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    //must ALWAYS use java.util.Date, NEVER java.sql.Date
    //when working with dates, ALWAYS use a timestamp column in database
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    public Date createDate;

}