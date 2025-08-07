package org.example;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Match {
    private String id;
    private LocalDate date;
    private String lieu;
    protected Combattant combattant1;
    protected Combattant combattant2;
    protected Integer pointsCombattant1;
    protected Integer pointsCombattant2;

    public Match(String id, LocalDate date, String lieu, Combattant combattant1,
                 Combattant combattant2) {
        this.id = id;
        this.date = date;
        this.lieu = lieu;
        this.combattant1 = combattant1;
        this.combattant2 = combattant2;
        this.pointsCombattant1 = 0;
        this.pointsCombattant2 = 0;
    }
    public void combattant1GagnerPoint(){
        this.pointsCombattant1++;
    }
    public void combattant2GagnerPoint(){
        this.pointsCombattant2++;
    }

    public abstract void terminerMatch();
}
