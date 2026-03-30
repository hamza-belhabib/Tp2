package partie01;

//    PARTIE 1 * Classe CompteBancaire

public class Exercicep01 {

    static class CompteBancaire {

        private int numero;
        private String titulaire;
        private double solde;
        private double decouvertAutorise;

        static int nbComptes = 0;
        static double tauxInteretAnnuel = 0.03;

        public CompteBancaire(String titulaire, double solde, double decouvertAutorise) {
            nbComptes++;
            numero = nbComptes;
            this.titulaire = titulaire;
            this.solde = solde;
            this.decouvertAutorise = decouvertAutorise;
        }

        public void afficher() {
            System.out.println("Numero: " + numero);
            System.out.println("Nom: " + titulaire);
            System.out.println("Solde: " + solde);
            System.out.println("Decouvert: " + decouvertAutorise);
        }

        public void deposer(double m) {
            if (m > 0) {
                solde = solde + m;
            } else {
                System.out.println("Montant de depot invalide.");
            }
        }

        public void retirer(double m) {
            if (m > 0 && solde + decouvertAutorise >= m) {
                solde = solde - m;
            } else {
                System.out.println("Retrait refuse.");
            }
        }

        public void virementVers(CompteBancaire c, double m) {
            if (m > 0 && solde + decouvertAutorise >= m) {
                solde = solde - m;
                c.solde = c.solde + m;
            } else {
                System.out.println("Virement impossible.");
            }
        }

        public double calculerSoldeAvecInterets() {
            solde = solde + (solde * tauxInteretAnnuel);
            return solde;
        }

        public double calculerSoldeAvecInterets(double bonus) {
            double t = tauxInteretAnnuel + bonus;
            solde = solde + (solde * t);
            return solde;
        }
    }
//                 PARTIE 2 ** Classe Banque
    static class Banque {

        private String nom;
        private CompteBancaire[] comptes;
        private int nbActuels;

        public Banque(String nom, int capacite) {
            this.nom = nom;
            comptes = new CompteBancaire[capacite];
            nbActuels = 0;
        }

        public void ajouterCompte(CompteBancaire c) {
            if (nbActuels < comptes.length) {
                comptes[nbActuels] = c;
                nbActuels++;
            } else {
                System.out.println("Banque pleine");
            }
        }

        public void afficherTous() {
            for (int i = 0; i < nbActuels; i++) {
                comptes[i].afficher();
                System.out.println("-----");
            }
        }
    }
//            PARTIE 3 ***  Classe TestBanque
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