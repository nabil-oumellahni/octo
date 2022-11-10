package com.octoproject.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Setter
@Getter
public class UtilisateurDto {

    private Long id;

    private String username;

    private String gender;

    private String lastname;

    private String firstname;

    private Date birthdate;
}
