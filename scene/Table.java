import java.util.*;

public class Table {
    
    private final Variable P = new Variable(Variables.P);
    private final Variable S = new Variable(Variables.S);
    private final Variable R = new Variable(Variables.R);
    private final Variable I = new Variable(Variables.I);
    private final Variable E = new Variable(Variables.E);
    private final Variable Eprime = new Variable(Variables.Eprime);
    private final Variable T = new Variable(Variables.T);
    private final Variable Tprime = new Variable(Variables.Tprime);
    private final Variable F = new Variable(Variables.F);
    
    private final Terminal DEBUT = new Terminal(Terminaux.DEBUT);
    private final Terminal FIN = new Terminal(Terminaux.FIN);
    private final Terminal POINT_VIRGULE = new Terminal(Terminaux.POINT_VIRGULE);
    private final Terminal ID = new Terminal(Terminaux.ID);
    private final Terminal EGAL = new Terminal(Terminaux.EGAL);
    private final Terminal PLUS = new Terminal(Terminaux.PLUS);
    private final Terminal ETOILE = new Terminal(Terminaux.ETOILE);
    private final Terminal PAR_OUVRANTE = new Terminal(Terminaux.PAR_OUVRANTE);
    private final Terminal PAR_FERMANTE = new Terminal(Terminaux.PAR_FERMANTE);
    private final Terminal NOMBRE = new Terminal(Terminaux.NOMBRE);
    private final Terminal EPSILON = new Terminal(Terminaux.EPSILON);
    private final Terminal Dollar = new Terminal(Terminaux.DOLLAR);
    
    private final ArrayList<Entree> regle1 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle2 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle3 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle4 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle5 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle6 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle7 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle8 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle9 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle10 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle11 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle12 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle13 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle14 = new ArrayList<Entree>();
    private final ArrayList<Entree> regle15 = new ArrayList<Entree>();
    
    private Grammaire G1;
    private Grammaire G2;
    private Grammaire G3;
    private Grammaire G4;
    private Grammaire G5;
    private Grammaire G6;
    private Grammaire G7;
    private Grammaire G8;
    private Grammaire G9;
    private Grammaire G10;
    private Grammaire G11;
    private Grammaire G12;
    private Grammaire G13;
    private Grammaire G14;
    private Grammaire G15;
    
    private Grammaire[] tabGrammaire;
    
    public Table(){
        init();
    }
    
    public void init (){
        regle1.add(FIN);
        regle1.add(S);
        regle1.add(DEBUT);
        
        this.G1 = new Grammaire(1, P, regle1);
        
        regle2.add(R);
        regle2.add(I);
        
        this.G2 = new Grammaire(2, S, regle2);
        
        regle3.add(R);
        regle3.add(I);
        regle3.add(POINT_VIRGULE);
        
        this.G3 = new Grammaire(3, R, regle3);
        
        regle4.add(EPSILON);
        
        this.G4 = new Grammaire(4, R, regle4);
        
        regle5.add(E);
        regle5.add(EGAL);
        regle5.add(ID);
        
        this.G5 = new Grammaire(5, I, regle5);
        
        regle6.add(EPSILON);
        
        this.G6 = new Grammaire(6, I, regle6);
        
        regle7.add(Eprime);
        regle7.add(T);
        
        this.G7 = new Grammaire(7, E, regle7);
        
        regle8.add(Eprime);
        regle8.add(T);
        regle8.add(PLUS);
        
        this.G8 = new Grammaire(8, Eprime, regle8);
        
        regle9.add(EPSILON);
        
        this.G9 = new Grammaire(9, Eprime, regle9);
        
        regle10.add(Tprime);
        regle10.add(F);
        
        this.G10 = new Grammaire(10, T, regle10);
        
        regle11.add(Tprime);
        regle11.add(F);
        regle11.add(ETOILE);
        
        this.G11 = new Grammaire(11, Tprime, regle11);
        
        regle12.add(EPSILON);
        
        this.G12 = new Grammaire(12, Tprime, regle12);
        
        regle13.add(PAR_FERMANTE);
        regle13.add(E);
        regle13.add(PAR_OUVRANTE);
        
        this.G13 = new Grammaire(13, F, regle13);
        
        regle14.add(ID);
        
        this.G14 = new Grammaire(14, F, regle14);
        
        regle15.add(NOMBRE);
        
        this.G15 = new Grammaire(15, F, regle15);
        
        this.tabGrammaire = new Grammaire[15];
        this.tabGrammaire[0] = G1;
        this.tabGrammaire[1] = G2;
        this.tabGrammaire[2] = G3;
        this.tabGrammaire[3] = G4;
        this.tabGrammaire[4] = G5;
        this.tabGrammaire[5] = G6;
        this.tabGrammaire[6] = G7;
        this.tabGrammaire[7] = G8;
        this.tabGrammaire[8] = G9;
        this.tabGrammaire[9] = G10;
        this.tabGrammaire[10] = G11;
        this.tabGrammaire[11] = G12;
        this.tabGrammaire[12] = G13;
        this.tabGrammaire[13] = G14;
        this.tabGrammaire[14] = G15;
    }
    
    public Variable getP() {
        return P;
    }
    
    public Variable getS() {
        return S;
    }
    
    public Variable getR() {
        return R;
    }
    
    public Variable getI() {
        return I;
    }
    
    public Variable getE() {
        return E;
    }
    
    public Variable getEprime() {
        return Eprime;
    }
    
    public Variable getT() {
        return T;
    }
    
    public Variable getTprime() {
        return Tprime;
    }
    
    public Variable getF() {
        return F;
    }
    
    public Terminal getDEBUT() {
        return DEBUT;
    }
    
    public Terminal getFIN() {
        return FIN;
    }
    
    public Terminal getPOINT_VIRGULE() {
        return POINT_VIRGULE;
    }
    
    public Terminal getID() {
        return ID;
    }
    
    public Terminal getEGAL() {
        return EGAL;
    }
    
    public Terminal getPLUS() {
        return PLUS;
    }
    
    public Terminal getETOILE() {
        return ETOILE;
    }
    
    public Terminal getPAR_OUVRANTE() {
        return PAR_OUVRANTE;
    }
    
    public Terminal getPAR_FERMANTE() {
        return PAR_FERMANTE;
    }
    
    public Terminal getNOMBRE() {
        return NOMBRE;
    }
    
    public Terminal getEPSILON() {
        return EPSILON;
    }
    
    public ArrayList<Entree> getRegle1() {
        return regle1;
    }
    
    public ArrayList<Entree> getRegle2() {
        return regle2;
    }
    
    public ArrayList<Entree> getRegle3() {
        return regle3;
    }
    
    public ArrayList<Entree> getRegle4() {
        return regle4;
    }
    
    public ArrayList<Entree> getRegle5() {
        return regle5;
    }
    
    public ArrayList<Entree> getRegle6() {
        return regle6;
    }
    
    public ArrayList<Entree> getRegle7() {
        return regle7;
    }
    
    public ArrayList<Entree> getRegle8() {
        return regle8;
    }
    
    public ArrayList<Entree> getRegle9() {
        return regle9;
    }
    
    public ArrayList<Entree> getRegle10() {
        return regle10;
    }
    
    public ArrayList<Entree> getRegle11() {
        return regle11;
    }
    
    public ArrayList<Entree> getRegle12() {
        return regle12;
    }
    
    public ArrayList<Entree> getRegle13() {
        return regle13;
    }
    
    public ArrayList<Entree> getRegle14() {
        return regle14;
    }
    
    public ArrayList<Entree> getRegle15() {
        return regle15;
    }
    
    public Grammaire getG1() {
        return G1;
    }
    
    public Grammaire getG2() {
        return G2;
    }
    
    public Grammaire getG3() {
        return G3;
    }
    
    public Grammaire getG4() {
        return G4;
    }
    
    public Grammaire getG5() {
        return G5;
    }
    
    public Grammaire getG6() {
        return G6;
    }
    
    public Grammaire getG7() {
        return G7;
    }
    
    public Grammaire getG8() {
        return G8;
    }
    
    public Grammaire getG9() {
        return G9;
    }
    
    public Grammaire getG10() {
        return G10;
    }
    
    public Grammaire getG11() {
        return G11;
    }
    
    public Grammaire getG12() {
        return G12;
    }
    
    public Grammaire getG13() {
        return G13;
    }
    
    public Grammaire getG14() {
        return G14;
    }
    
    public Grammaire getG15() {
        return G15;
    }
    
    public void setG1(Grammaire g1) {
        G1 = g1;
    }
    
    public void setG2(Grammaire g2) {
        G2 = g2;
    }
    
    public void setG3(Grammaire g3) {
        G3 = g3;
    }
    
    public void setG4(Grammaire g4) {
        G4 = g4;
    }
    
    public void setG5(Grammaire g5) {
        G5 = g5;
    }
    
    public void setG6(Grammaire g6) {
        G6 = g6;
    }
    
    public void setG7(Grammaire g7) {
        G7 = g7;
    }
    
    public void setG8(Grammaire g8) {
        G8 = g8;
    }
    
    public void setG9(Grammaire g9) {
        G9 = g9;
    }
    
    public void setG10(Grammaire g10) {
        G10 = g10;
    }
    
    public void setG11(Grammaire g11) {
        G11 = g11;
    }
    
    public void setG12(Grammaire g12) {
        G12 = g12;
    }
    
    public void setG13(Grammaire g13) {
        G13 = g13;
    }
    
    public void setG14(Grammaire g14) {
        G14 = g14;
    }
    
    public void setG15(Grammaire g15) {
        G15 = g15;
    }
    
    public Terminal getDollar() {
        return Dollar;
    }
    
    public Grammaire[] getTabGrammaire() {
        return tabGrammaire;
    }
    
    public void setTabGrammaire(Grammaire[] tabGrammaire) {
        this.tabGrammaire = tabGrammaire;
    }
    
}
