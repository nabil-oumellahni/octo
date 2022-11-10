package com.octoproject.mapper;

import com.octoproject.domain.Compte;
import com.octoproject.dto.CompteDto;

public class CompteMapper {

    public static CompteDto fromEntity(Compte compte) {
        CompteDto dto = new CompteDto();

        dto.setId(compte.getId());
        dto.setRib(compte.getRib());
        dto.setSolde(compte.getSolde());
        dto.setNrCompte(compte.getNrCompte());

        return dto;

    }

    public static Compte toEntity(CompteDto dto) {
        Compte compte = new Compte();

        compte.setId(dto.getId());
        compte.setRib(dto.getRib());
        compte.setSolde(dto.getSolde());
        compte.setNrCompte(dto.getNrCompte());

        return compte;

    }
}
