package com.societe.gestionsjoueurs.repository;

import com.societe.gestionsjoueurs.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur,Long> {
}
