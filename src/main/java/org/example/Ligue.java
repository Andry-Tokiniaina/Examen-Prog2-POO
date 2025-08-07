package org.example;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ligue {
    private String nom;
    private List<Combattant> combattants;
    private List<Match> matches;

    public Ligue(String nom) {
        this.nom = nom;
        this.combattants = new ArrayList<Combattant>();
        this.matches = new ArrayList<>();
    }

    public void ajouterCombattant(Combattant combattant){
        this.combattants.add(combattant);
    }

    public void creerMatch(Match match){
        this.matches.add(match);
    }

    public List<Match> listerMatchesCombattant(Combattant combattant){
        return this.matches.stream()
                .filter(m -> m.combattant1.equals(combattant) || m.combattant2.equals(combattant))
                .collect(Collectors.toList());
    }

    public List<Match> getMatches(){
        return this.matches;
    }

    public List<Combattant> getCombattants(){
        return this.combattants;
    }
}