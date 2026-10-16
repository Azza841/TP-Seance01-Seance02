package Seance02;

public final class OutilsTableau {

    private OutilsTableau() { }   // nobody can create an object: a static toolbox

    public static void echanger(int[] tab, int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }

    // Retourne null si le tableau est null ou vide
    public static Stats calculerStats(int[] valeurs) {
        if (valeurs == null || valeurs.length == 0) {
            return null;
        }

        int min = valeurs[0];
        int max = valeurs[0];
        double somme = 0;

        for (int v : valeurs) {
            if (v > max) max = v;
            if (v < min) min = v;
            somme += v;
        }

        return new Stats(min, max, somme / valeurs.length);
    }
}