import java.util.List;

public class Grammaire{

    // Une règle de grammaire s'écrit de la forme suivante: number: Variable -> regle
    private int number;
    private Variable variable;
    private List<Entree> regle; // regle est composé de symbole terminaux et parfois de varibales.

    public Grammaire(int number, Variable var, List<Entree> regle){
        this.number = number;
        this.variable = var;
        this.regle = regle;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public List<Entree> getRegle() {
        return regle;
    }

    public void setRegle(List<Entree> regle) {
        this.regle = regle;
    }


}