package org.example;

import java.time.LocalDate;

public class MatchAmical extends Match{
    public MatchAmical(String id, LocalDate date, String lieu, Combattant combattant1,
                       Combattant combattant2){
        super(id,date,lieu,combattant1,combattant2);
    }

    @Override
    public Combattant terminerMatch(){
        if (this.pointsCombattant1<this.pointsCombattant2){
            return this.combattant2;
        }
        else  if (this.pointsCombattant1>this.pointsCombattant2){
            return this.combattant1;
        }
        else {
            return null;
        }
    }
}
