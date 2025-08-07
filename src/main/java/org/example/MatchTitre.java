package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class MatchTitre extends Match{
    private String titre;
    public MatchTitre(String id, LocalDate date, String lieu, Combattant combattant1,
                      Combattant combattant2, String titre) {
        super(id,date,lieu,combattant1,combattant2);
        this.titre=titre;
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
            combattant2.gagnerTitre(this.titre);
        }
        else {
            combattant2.ajouterDefaite();
            combattant1.ajouterVictoire();
            combattant1.gagnerTitre(this.titre);
        }
    }
}
