package org.example;


import java.util.List;

public class Ligue {
    private String nom;
    private List<Combattant> combattants;
    private List<Match> matches;

    public Ligue(String nom, List<Combattant> combattants, List<Match> matches) {
        this.nom = nom;
        this.combattants = combattants;
        this.matches = matches;
    }
}