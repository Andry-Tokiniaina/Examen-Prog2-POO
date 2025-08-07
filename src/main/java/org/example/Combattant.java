package org.example;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Combattant {
    private String id;
    private String nom;
    private String prenom;
    private String surnom;
    private double poids;
    private Map<PalmaresTypes, Integer> palmares;

    public Combattant(String id, String nom, String prenom, String surnom, double poids) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.surnom = surnom;
        this.poids = poids;
        this.palmares = new HashMap<PalmaresTypes, Integer>(PalmaresTypes.class.getModifiers());
    }

    public Combattant(String id, String nom, String prenom, double poids) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poids = poids;
        this.palmares = new HashMap<PalmaresTypes, Integer>(PalmaresTypes.class.getModifiers());
    }
}
