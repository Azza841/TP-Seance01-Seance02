package Seance01;

public class Rectangle {
    private double largeur;
    private double hauteur;

    public Rectangle(double largeur, double hauteur) {
        this.largeur = valider(largeur, "La largeur");
        this.hauteur = valider(hauteur, "La hauteur");
    }

    public double getLargeur() { return largeur; }
    public double getHauteur() { return hauteur; }

    public void setLargeur(double largeur) {
        this.largeur = valider(largeur, "La largeur");
    }

    public void setHauteur(double hauteur) {
        this.hauteur = valider(hauteur, "La hauteur");
    }

    public double calculerAire() {
        return largeur * hauteur;
    }

    public double calculerPerimetre() {
        return 2 * (largeur + hauteur);
    }

    // Propriété calculée : pas de champ, on calcule à chaque appel
    public boolean estCarre() {
        return largeur == hauteur;
    }

    // Écrit une seule fois : utilisé par le constructeur ET les setters
    private static double valider(double valeur, String nom) {
        if (valeur <= 0) {
            throw new IllegalArgumentException(nom + " doit être supérieure à 0.");
        }
        return valeur;
    }
}