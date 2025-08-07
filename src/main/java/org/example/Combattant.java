package org.example;

import java.util.*;

public class Combattant {
    private String id;
    private String nom;
    private String prenom;
    private String surnom;
    private double poids;
    private Map<PalmaresTypes, Integer> palmares;
    private List<String> titres;

    public Combattant(String id, String nom, String prenom, String surnom, double poids) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.surnom = surnom;
        this.poids = poids;
        this.palmares = new HashMap<PalmaresTypes, Integer>(PalmaresTypes.class.getModifiers());
        this.palmares.put(PalmaresTypes.victoires,0);
        this.palmares.put(PalmaresTypes.defaites,0);
        this.palmares.put(PalmaresTypes.egalites,0);
        this.titres = new ArrayList<String>();
    }

    public void ajouterVictoire(){
        this.palmares.put(PalmaresTypes.victoires,this.palmares.get(PalmaresTypes.victoires) + 1);
    }
    public void ajouterDefaite(){
        this.palmares.put(PalmaresTypes.defaites,this.palmares.get(PalmaresTypes.defaites) + 1);
    }
    public void ajouterEgalite(){
        this.palmares.put(PalmaresTypes.egalites,this.palmares.get(PalmaresTypes.egalites) + 1);
    }

    public List<String> getTitres(){
        return this.titres;
    }

    public Map<PalmaresTypes, Integer> getPalmares(){
        return this.palmares;
    }

    public void gagnerTitre(String titre){
        this.titres.add(titre);
    }
}
