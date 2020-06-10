public class Variable extends Entree {
    
    private Variables variable;

    public Variable(Variables var){
        super(var.name());
        this.variable = var;
        super.setAction(var.getAction());
    }

    public Variables getVariable() {
        return variable;
    }

    public void setVariable(Variables variable) {
        this.variable = variable;
    }

    
}