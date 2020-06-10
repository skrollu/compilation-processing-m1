public class Terminal extends Entree {
    
    private Terminaux terminal;

    public Terminal(Terminaux term){
        super(term.name());
        this.terminal = term;
        super.setAction(term.getAction());
    }

    public Terminaux getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminaux terminal) {
        this.terminal = terminal;
    }
}