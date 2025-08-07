package org.example;

import java.time.LocalDate;

public class MatchAmical extends Match{
    public MatchAmical(String id, LocalDate date, String lieu, Combattant combattant1,
                       Combattant combattant2){
        super(id,date,lieu,combattant1,combattant2);
    }

    @Override
    public void terminerMatch(){
    }
}
