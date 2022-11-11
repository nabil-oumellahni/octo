package com.octoproject.service;

import com.octoproject.domain.Utilisateur;

import java.util.List;

public interface IUtilisateurService {

    Utilisateur save(Utilisateur utilisateur);

    Utilisateur getByUsername(String username);

    List<Utilisateur> getAll();

}
