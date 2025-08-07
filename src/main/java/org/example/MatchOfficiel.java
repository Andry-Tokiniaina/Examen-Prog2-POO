package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class MatchOfficiel extends Match{
    public MatchOfficiel(String id, LocalDate date, String lieu, Combattant combattant1,
                         Combattant combattant2){
        super(id,date,lieu,combattant1,combattant2);
    }

    @Override
    public void terminerMatch() {
        if (Objects.equals(pointsCombattant1, pointsCombattant2)){
            combattant1.ajouterEgalite();
            combattant2.ajouterEgalite();
        }
        else if (pointsCombattant1<pointsCombattant2){
            combattant1.ajouterDefaite();
            combattant2.ajouterVictoire();
        }
        else {
            combattant2.ajouterDefaite();
            combattant1.ajouterVictoire();
        }
    }
}
