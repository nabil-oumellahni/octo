package com.octoproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String username;

    @Column(length = 10, nullable = false)
    private String gender;

    @Column(length = 60, nullable = false)
    private String lastname;

    @Column(length = 60, nullable = false)
    private String firstname;

    @Temporal(TemporalType.DATE)
    private Date birthdate;
}
