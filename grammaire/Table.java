package grammaire;

public class Table<T extends Entree> {

    public Table() {
        this.init();
    }

    public void init(){

        Terminaux terminaux = new Terminaux();

        int i[] = new int[10];

        Variables s = new Variables({i, r});
        Variables p = new Variables(terminaux.getDEBUT(), s, terminaux.getFIN());


    }
}
