package Seance01;

import java.time.Year;

public class Livre {
    private final String isbn;
    private final String titre;
    private final String auteur;
    private final int anneePublication;
    private boolean disponible = true;      // un nouveau livre est disponible

    public Livre(String isbn, String titre, String auteur, int anneePublication) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
    }

    public String getIsbn()          { return isbn; }
    public String getTitre()         { return titre; }
    public String getAuteur()        { return auteur; }
    public int getAnneePublication() { return anneePublication; }
    public boolean estDisponible()   { return disponible; }

    public void emprunter() {
        if (!disponible) {
            throw new IllegalStateException("Le livre est déjà emprunté.");
        }
        disponible = false;
    }

    public void retourner() {
        disponible = true;
    }

    // Propriété calculée à partir de l'année courante
    public int getAge() {
        return Year.now().getValue() - anneePublication;
    }
}