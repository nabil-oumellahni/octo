package com.octoproject;

import com.octoproject.domain.Compte;
import com.octoproject.domain.TransactionTransfer;
import com.octoproject.domain.Utilisateur;
import com.octoproject.repository.CompteRepository;
import com.octoproject.repository.TransactionTransferRepository;
import com.octoproject.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
@EnableJpaAuditing
public class OctoProjectApplication implements CommandLineRunner {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private TransactionTransferRepository transferRepository;

    public static void main(String[] args) {
        SpringApplication.run(OctoProjectApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
//        Utilisateur utilisateur1 = new Utilisateur();
//        utilisateur1.setUsername("user1");
//        utilisateur1.setLastname("last1");
//        utilisateur1.setFirstname("first1");
//        utilisateur1.setGender("Male");
//
//        utilisateurRepository.save(utilisateur1);
//
//
//        Utilisateur utilisateur2 = new Utilisateur();
//        utilisateur2.setUsername("user2");
//        utilisateur2.setLastname("last2");
//        utilisateur2.setFirstname("first2");
//        utilisateur2.setGender("Female");
//
//        utilisateurRepository.save(utilisateur2);
//
//        Compte compte1 = new Compte();
//        compte1.setNrCompte("010000A000001000");
//        compte1.setRib("RIB1");
//        compte1.setSolde(BigDecimal.valueOf(200000L));
//        compte1.setUtilisateur(utilisateur1);
//
//        compteRepository.save(compte1);
//
//        Compte compte2 = new Compte();
//        compte2.setNrCompte("010000B025001000");
//        compte2.setRib("RIB2");
//        compte2.setSolde(BigDecimal.valueOf(140000L));
//        compte2.setUtilisateur(utilisateur2);
//
//        compteRepository.save(compte2);
//
//        TransactionTransfer v = new TransactionTransfer();
//        v.setMontant(BigDecimal.TEN);
//        v.setCompteBeneficiaire(compte2);
//        v.setCompteEmetteur(compte1);
//        v.setDateExecution(new Date());
//        v.setMotif("Assignment 2021");
//
//        transferRepository.save(v);
    }

}
