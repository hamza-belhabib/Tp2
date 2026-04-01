package partie1;

public class CompteBancaire {

    private int numero;
    private String titulaire;
    private double solde;
    private double decouvertAutorise;

    public static int nbComptes = 0;
    public static double tauxInteretAnnuel = 0.03;

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
            solde += m;
        } else {
            System.out.println("Montant invalide");
        }
    }

    public void retirer(double m) {
        if (m > 0 && solde + decouvertAutorise >= m) {
            solde -= m;
        } else {
            System.out.println("Retrait refuse");
        }
    }

    public void virementVers(CompteBancaire c, double m) {
        if (m > 0 && solde + decouvertAutorise >= m) {
            this.solde -= m;
            c.solde += m;
        } else {
            System.out.println("Virement impossible");
        }
    }

    public double calculerSoldeAvecInterets() {
        solde += solde * tauxInteretAnnuel;
        return solde;
    }

    public double calculerSoldeAvecInterets(double bonus) {
        double t = tauxInteretAnnuel + bonus;
        solde += solde * t;
        return solde;
    }
}