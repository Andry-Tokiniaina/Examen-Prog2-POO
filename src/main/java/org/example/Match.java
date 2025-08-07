package org.example;

import java.time.LocalDate;

public class Match {
    private String id;
    private LocalDate date;
    private String lieu;
    private Combattant combattant1;
    private Combattant combattant2;
    private Integer pointsCombattant1;
    private Integer pointsCombattant2;

    public Match(String id,LocalDate date, String lieu, Combattant combattant1, Combattant combattant2 ) {
        this.id = id;
        this.date = date;
        this.lieu = lieu;
        this.combattant1 = combattant1;
        this.combattant2 = combattant2;
        this.pointsCombattant1 = 0;
        this.pointsCombattant2 = 0;
    }
}
