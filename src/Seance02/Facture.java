package Seance02;

public class Facture {
    private static final String PREFIXE = "FAC-2026";
    private static int compteur = 0;

    private final String numero;

    public Facture() {

        compteur++;
        this.numero = String.format("%s-%04d", PREFIXE, compteur);
    }

    public String getNumero() {
        return numero;
    }

    // Visible seulement dans le package seance02 (donc par les tests)
    static void reinitialiserCompteur() {
        compteur = 0;
    }
}