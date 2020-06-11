enum Terminaux {
    
    DEBUT("début"), 
    FIN("fin"),
    POINT_VIRGULE(";"),
    ID("id"),
    EGAL(":="), 
    PLUS("+"),
    ETOILE("*"),
    PAR_OUVRANTE("("),
    PAR_FERMANTE(")"), 
    NOMBRE("nb"),
    EPSILON("EPS"),
    DOLLAR("$");

      // declaring private variable for getting values 
    private String action; 
  
    // getter method 
    public String getAction() 
    { 
        return this.action; 
    } 

    // enum constructor - cannot be public or protected
    private Terminaux(String action) 
    { 
        this.action = action; 
    }
}