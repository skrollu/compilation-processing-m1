public class Entree {
    
    private String action;

    public Entree() {
   
    }

    public Entree(String str) {
        this.action = str;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String toString(){
        return this.action;
    }
}