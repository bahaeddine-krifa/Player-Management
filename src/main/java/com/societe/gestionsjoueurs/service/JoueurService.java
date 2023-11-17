package com.societe.gestionsjoueurs.service;

import com.societe.gestionsjoueurs.entity.Joueur;
import com.societe.gestionsjoueurs.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoueurService {
    @Autowired
    private JoueurRepository joueurRepository;

    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    public Joueur saveJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public Joueur getJoueurById(Long id) {
        return joueurRepository.findById(id).get();
    }

    public Joueur updateJoueur(Joueur joueur) {
        return joueurRepository.save(joueur);
    }

    public void deleteJoueurById(Long id) {
        joueurRepository.deleteById(id);
    }
}
