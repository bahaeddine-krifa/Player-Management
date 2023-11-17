package com.societe.gestionsjoueurs.controller;

import com.societe.gestionsjoueurs.entity.Joueur;
import com.societe.gestionsjoueurs.service.JoueurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoueurController {
    @Autowired
    private JoueurService joueurService;

    @GetMapping("/joueurList")
    public String listJoueur(Model model) {
        model.addAttribute("joueurs", joueurService.getAllJoueurs());
        return "list";
    }

    @GetMapping("/ajouterJoueur")
    public String createJoueurForm(Model model) {
        Joueur joueur = new Joueur();
        model.addAttribute("joueur", joueur);
        return "ajout";
    }

    @PostMapping("/joueurList")
    public String saveJoueur(@ModelAttribute("joueur") Joueur joueur) {
        joueurService.saveJoueur(joueur);
        return "redirect:/joueurList";
    }

    @GetMapping("/joueurList/edit/{id}")
    public String editjoueurForm(@PathVariable Long id, Model model) {
        model.addAttribute("joueur",joueurService.getJoueurById(id));
        return "edit";
    }

    @PostMapping("/joueurList/{id}")
    public String updateJoueur(@PathVariable Long id, @ModelAttribute("joueur") Joueur joueur, Model model) {
        //get joueur from database by id
        Joueur existJouur = joueurService.getJoueurById(id);
        existJouur.setId(id);
        existJouur.setFirstName(joueur.getFirstName());
        existJouur.setLastName(joueur.getLastName());
        existJouur.setEmail(joueur.getEmail());

        //save updated joueur object
        joueurService.updateJoueur(existJouur);
        return "redirect:/joueurList";
    }

    @GetMapping("/joueurList/{id}")
    public String deleteJoueur(@PathVariable Long id) {
        joueurService.deleteJoueurById(id);
        return "redirect:/joueurList";
    }
}
