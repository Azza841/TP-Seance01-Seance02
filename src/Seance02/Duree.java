package Seance02;

public class Duree {
    private int secondes;

    public Duree(int secondes) {
        if (secondes < 0) {
            throw new IllegalArgumentException("Les secondes ne peuvent pas être négatives.");
        }
        this.secondes = secondes;
    }

    public Duree() {
        this(0);
    }

    public Duree(int heures, int minutes, int secondes) {
        this(heures * 3600 + minutes * 60 + secondes);
    }

    // Constructeur de recopie
    public Duree(Duree autre) {
        this(autre.secondes);
    }

    public int getTotalSecondes() { return secondes; }
    public int getHeures()        { return secondes / 3600; }
    public int getMinutes()       { return (secondes % 3600) / 60; }
    public int getSecondes()      { return secondes % 60; }

    public void ajouter(int secondes) {
        if (secondes < 0) {
            throw new IllegalArgumentException("Les secondes ne peuvent pas être négatives.");
        }
        this.secondes += secondes;
    }

    public void ajouter(Duree autre) {
        ajouter(autre.secondes);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", getHeures(), getMinutes(), getSecondes());
    }

    public static Duree parse(String texte) {
        String[] morceaux = texte.split(":");
        int h = Integer.parseInt(morceaux[0]);
        int m = Integer.parseInt(morceaux[1]);
        int s = Integer.parseInt(morceaux[2]);
        return new Duree(h, m, s);
    }
}