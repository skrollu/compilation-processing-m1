package grammaire;

java.util.List;

public class Grammaire<T>{

    private List<T[]> regle;

    public Grammaire(T regle){
        this.regle = regle;
    }


}