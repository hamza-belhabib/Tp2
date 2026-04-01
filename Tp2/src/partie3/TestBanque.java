package partie3;

import partie1.CompteBancaire;
import partie2.Banque;

public class TestBanque {

    public static void main(String[] args) {

        Banque b = new Banque("MarocBank", 1500);

        CompteBancaire c1 = new CompteBancaire("mizo", 1000, 500);
        CompteBancaire c2 = new CompteBancaire("ali", 800, 300);
        CompteBancaire c3 = new CompteBancaire("med", 600, 200);

        b.ajouterCompte(c1);
        b.ajouterCompte(c2);
        b.ajouterCompte(c3);

        c1.deposer(200);
        c1.retirer(300);

        c2.virementVers(c3, 100);

        b.afficherTous();

        c2.calculerSoldeAvecInterets();
        c2.calculerSoldeAvecInterets(0.015);

        System.out.println(CompteBancaire.nbComptes);
        System.out.println(CompteBancaire.tauxInteretAnnuel);
    }
}