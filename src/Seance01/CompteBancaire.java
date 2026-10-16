package Seance01;

import java.math.BigDecimal;

public class CompteBancaire {
    private final String numero;        // final = fixé une fois, jamais changé
    private String titulaire;
    private BigDecimal solde = BigDecimal.ZERO;

    public CompteBancaire(String numero, String titulaire) {
        this.numero = numero;
        this.titulaire = validerTitulaire(titulaire);
    }

    public String getNumero()      { return numero; }
    public String getTitulaire()   { return titulaire; }
    public BigDecimal getSolde()   { return solde; }

    public void setTitulaire(String titulaire) {
        this.titulaire = validerTitulaire(titulaire);
    }

    // PAS de setSolde : le solde ne change que par deposer() et retirer()

    public void deposer(BigDecimal montant) {
        if (montant.signum() <= 0) {
            throw new IllegalArgumentException("Le montant doit être supérieur à 0.");
        }
        solde = solde.add(montant);
    }

    public boolean retirer(BigDecimal montant) {
        if (montant.compareTo(solde) > 0) {
            return false;               // solde insuffisant : rien n'est modifié
        }
        solde = solde.subtract(montant);
        return true;
    }

    private static String validerTitulaire(String titulaire) {
        if (titulaire == null || titulaire.isBlank()) {
            throw new IllegalArgumentException("Le titulaire ne peut pas être vide.");
        }
        return titulaire;
    }
}