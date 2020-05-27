package grammaire;

public class Terminaux extends Entree {
    
    private final String DEBUT = "début";
    private final String FIN = "fin";
    private final String POINT_VIRGULE = ";";
    private final String ID = "id";
    private final String EGAL = ":=";
    private final String PLUS = "+";
    private final String ETOILE = "*";
    private final String PAR_OUVRANTE = "(";
    private final String PAR_FERMANTE = ")";
    private final String NOMBRE = "nb";
    private final String EPSILON = "eps";

    public String getDEBUT() {
        return DEBUT;
    }

    public String getFIN() {
        return FIN;
    }

    public String getPOINT_VIRGULE() {
        return POINT_VIRGULE;
    }

    public String getID() {
        return ID;
    }

    public String getEGAL() {
        return EGAL;
    }

    public String getPLUS() {
        return PLUS;
    }

    public String getETOILE() {
        return ETOILE;
    }

    public String getPAR_OUVRANTE() {
        return PAR_OUVRANTE;
    }

    public String getPAR_FERMANTE() {
        return PAR_FERMANTE;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getEPSILON() {
        return EPSILON;
    }

}