package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MacthTest {
    private Ligue ligue;
    private Combattant Rakoto;
    private Combattant Rasoa;
    private Combattant Ranaivo;
    private Combattant Rabe;
    private Match match1;
    private Match match2;
    private Match match3;
    @BeforeEach
    void setUp() {
        ligue = new Ligue("Ligue");
         Rakoto = new Combattant("123","Rakoto","Paul",
                "l'éléphant",100.0);
         Rabe = new Combattant("456","Rabe","Bob",
                "le singe",110.0);
         Rasoa = new Combattant("789", "Rasoa", "Marguerite",
                "Rose",85);
         Ranaivo = new Combattant("234","Ranaivo","Patric",
                "Tracteur",125.0);
         match1 = new MatchAmical("001", LocalDate.now(),"Ambonjatovo",Rasoa, Ranaivo);
         match2 = new MatchOfficiel("002",LocalDate.of(2024,12,12),
                "Analakely",Rakoto, Rabe);
         match3 = new MatchTitre("003",LocalDate.of(2025,2,15),
                 "Tanjombato", Rakoto, Rasoa, "champion du monde");
    }
    @Test
    void creerMatchDansLigueTest(){
        ligue.creerMatch(match1);//ajout d'un match amical
        ligue.creerMatch(match2);// ajout d'un match officiel
        ligue.creerMatch(match3);// ajout d'un match pour un titre
        List<Match> listeMatches = new ArrayList<>();
        listeMatches.add(match1);
        listeMatches.add(match2);
        listeMatches.add(match3);
        assertEquals(ligue.getMatches(),listeMatches);
    }

    @Test
    void testListerMatchCombattant(){
        ligue.creerMatch(match1);//match sans Rakoto
        ligue.creerMatch(match2);//match avec Rakoto
        ligue.creerMatch(match3);//match avec Rakoto
        List<Match> matchesDeRakoto = new ArrayList<>();
        matchesDeRakoto.add(match2);
        matchesDeRakoto.add(match3);
        assertEquals(matchesDeRakoto,ligue.listerMatchesCombattant(Rakoto));
    }

    @Test
    void ajouterPointsCombattant1Test(){
        match1.combattant1GagnerPoint();
        assertEquals(1, match1.getPointsCombattant1());

    }
    @Test
    void ajouterPointsCombattant2Test(){
        match2.combattant2GagnerPoint();
        match2.combattant2GagnerPoint();
        assertEquals(2, match2.getPointsCombattant2());
    }
    @Test
    void terminerMatchOfficielTest(){
        match2.combattant1GagnerPoint();
        assertEquals(match2.terminerMatch(), Rakoto);//retourne le vainqueur pour pouvoir tester
    }

    @Test
    void testPalmaresMatchAmical(){
        match1.combattant1GagnerPoint();
        match1.terminerMatch();
        //pas de changement de palmarès dans les matchs amicaux
        assertEquals(0, Rasoa.getPalmares().get(PalmaresTypes.victoires));
        assertEquals(0, Ranaivo.getPalmares().get(PalmaresTypes.victoires));
        assertEquals(0, Rasoa.getPalmares().get(PalmaresTypes.defaites));
        assertEquals(0, Ranaivo.getPalmares().get(PalmaresTypes.defaites));
        assertEquals(0, Ranaivo.getPalmares().get(PalmaresTypes.egalites));
        assertEquals(0, Rasoa.getPalmares().get(PalmaresTypes.egalites));
    }

    @Test
    void testPalmaresMatchOfficiel(){
        match2.combattant1GagnerPoint();
        match2.terminerMatch();
        //une victoire pour Rakoto 1 défaite pour Rabe
        assertEquals(1, Rakoto.getPalmares().get(PalmaresTypes.victoires));
        assertEquals(0, Rabe.getPalmares().get(PalmaresTypes.victoires));
        assertEquals(0, Rakoto.getPalmares().get(PalmaresTypes.defaites));
        assertEquals(1, Rabe.getPalmares().get(PalmaresTypes.defaites));
        assertEquals(0, Rakoto.getPalmares().get(PalmaresTypes.egalites));
        assertEquals(0, Rabe.getPalmares().get(PalmaresTypes.egalites));
    }

    @Test
    void testPalmaresEgalitesMatchAmical(){
        match2.combattant1GagnerPoint();
        match2.combattant2GagnerPoint();
        match2.terminerMatch();
        //équalité
        assertEquals(0, Rakoto.getPalmares().get(PalmaresTypes.victoires));
        assertEquals(0, Rabe.getPalmares().get(PalmaresTypes.victoires));
        assertEquals(0, Rakoto.getPalmares().get(PalmaresTypes.defaites));
        assertEquals(0, Rabe.getPalmares().get(PalmaresTypes.defaites));
        assertEquals(1, Rakoto.getPalmares().get(PalmaresTypes.egalites));
        assertEquals(1, Rabe.getPalmares().get(PalmaresTypes.egalites));
    }

    @Test
    void gagnerTitreTest(){
        match3.combattant2GagnerPoint();
        match3.terminerMatch();
        //Rasoa gagne le titre, Rakoto ne gagne rien
        assertEquals(1, Rasoa.getTitres().size());
        assertEquals("champion du monde", Rasoa.getTitres().getFirst());
        assertEquals(0, Rakoto.getTitres().size());
    }

    @Test
    void gagnerPlusieursTitreTest(){
        match3.combattant2GagnerPoint();
        match3.terminerMatch();
        match3.combattant2GagnerPoint();
        match3.terminerMatch();
        //Rasoa gagne deux fois le même titre, le même combat
        assertEquals(2, Rasoa.getTitres().size());
        assertEquals("champion du monde", Rasoa.getTitres().getFirst());
        assertEquals("champion du monde", Rasoa.getTitres().getLast());
    }
}