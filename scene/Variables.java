enum Variables {
    
    P("P"),
    S("S"),
    R("R"),
    I("I"),
    E("E"),
    Eprime("E'"),
    T("T"),
    Tprime("T'"),
    F("F");

    // declaring private variable for getting values
    private String action;

    // enum constructor - cannot be public or protected
    private Variables(String action) 
    { 
        this.action = action; 
    }

    // getter method
    public String getAction() {
        return this.action;
    }

}