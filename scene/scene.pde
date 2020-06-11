import java.util.*;
import java.lang.*;

Table table = new Table();
Grammaire[] grammaires;

float xPile = 380;
float yPile = 700 ;
float cote = 40;

String[] rows;
int indiceRow;
ArrayList<String> entreeCourante = new ArrayList<String>();
ArrayList sortie = new ArrayList();

ArrayList<Entree> pile = new ArrayList<Entree>();

boolean endOfFile;

void setup(){
  size(1300, 1000);

  endOfFile = false;

  rows = loadStrings("entrees.dat");

  if(rows.length > 0) {
    indiceRow = 0;
    chargerEntrees(indiceRow);
    
    grammaires = table.getTabGrammaire();

    // conditions initiales de la pile
    pile.add(table.getDollar());
    pile.add(table.getP());
  } else {
    endOfFile = true;
  }

}

void draw(){
  background(255);

  dessineGrammaire();
  dessineEntreeSortie();
  dessinePile(pile);
  
  if(endOfFile){
    dessineEndOfFile();
  }
}

void chargerEntrees(int indice){
  
  String[] str = rows[indice].split(" ");
  
  for(int i = str.length -1; i >= 0; i--){
    entreeCourante.add(str[i]);
  } 
}

void dessineGrammaire(){
  fill(0);
  for(int i = 0; i < grammaires.length; i++){
    text(grammaires[i].toString(), 3*(width/5), height/3 + (i*cote/2));
  }
}

void dessineEntreeSortie(){
  ArrayList<String> printEntree = new ArrayList<String>();
  for(int i = entreeCourante.size() -1; i >= 0; i--){
    printEntree.add(entreeCourante.get(i));
  } 
  
  textSize(15);
  fill(0);
  
  text("entrée: " + printEntree, 10, 50);
  text("sortie: " + sortie, 10, 100);
}

void dessinePile(List<Entree> liste){
 
  int sizeList = liste.size();

  for(int i = 0; i < sizeList; i++){
    fill(255);
    square(xPile, (yPile - (i * cote)), cote);
    fill(0);
    textSize(20);
    text(pile.get(i).getAction(), xPile + 10, (yPile - (i * cote)) + 27);
  }
}

void majPileSortieVariable(boolean found, Grammaire gram){

    if(found && gram != null){
      final List<Entree> regle = gram.getRegle();
      pile.remove(pile.size()-1);
      for(int j = 0; j < regle.size(); j++){
        if(!regle.get(j).getAction().equals("EPS")){
          pile.add(regle.get(j));
        }
      }
      sortie.add(gram.getNumber());
    } else if(!found){
      sortie.add("ERROR");
    }
}

void majPileSortieTerminal(){

  pile.remove(pile.size()-1);
  entreeCourante.remove(entreeCourante.size()-1);
  sortie.add("pop");
}

void mousePressed(){
  boolean grammaireTrouvee = false;

  if(!sortie.isEmpty() && sortie.get(sortie.size()-1).equals("ERROR")){  //On a print une ERROR en sortie sur l'action d'avant donc on a une erreur de compilation pour ce mot
    
    initWord();
  } else if(!pile.isEmpty() && pile.get(pile.size()-1) != null && pile.get(pile.size()-1) instanceof Variable){
    //println("Variable");
    for (int i = 0; i < grammaires.length; i++){
      
      //Si haut de pile == variable d'une grammaire disponible et si haut de regle de la variable est le même terminal que celui de l'entrée.
      if(grammaires[i].getVariable().getAction().equals(pile.get(pile.size()-1).getAction()) && !grammaireTrouvee){
        if (grammaires[i].getRegle().get(grammaires[i].getRegle().size()-1).getAction().equals(entreeCourante.get(entreeCourante.size()-1))){
          grammaireTrouvee = true;        
          majPileSortieVariable(grammaireTrouvee, grammaires[i]);
        } else if (grammaires[i].getRegle().get(grammaires[i].getRegle().size()-1).getAction().equals("nb")){//si le haut d ela regle est nb
        
         if(entreeCourante.get(entreeCourante.size()-1).length() == 1){
              if(isDigit(entreeCourante.get(entreeCourante.size()-1).charAt(0))) { // si l'entrée est un nombre
              
            //  println("Variable l'entrée est un nombre");
                grammaireTrouvee = true;    
                majPileSortieVariable(grammaireTrouvee, grammaires[i]);
              }
         }
          
        } else if (grammaires[i].getRegle().get(grammaires[i].getRegle().size()-1).getAction().equals("id")){ //si le haut d ela regle est id 
          
          if(entreeCourante.get(entreeCourante.size()-1).length() == 1){
            if (isLetter(entreeCourante.get(entreeCourante.size()-1).charAt(0))){ //si l'entrée est un id
              
              //println("Variable l'entrée est une lettre");
                grammaireTrouvee = true;
                majPileSortieVariable(grammaireTrouvee, grammaires[i]);
             }
           }
        }
      }
    }

    if(!grammaireTrouvee){
      //println("eps");
      for (int i = 0; i < grammaires.length; i++){
        //Si haut de pile == variable d'une grammaire disponible && si haut de règle est EPS
        if(grammaires[i].getVariable().getAction().equals(pile.get(pile.size()-1).getAction()) 
        && grammaires[i].getRegle().get(grammaires[i].getRegle().size()-1).getAction().equals("EPS") && !grammaireTrouvee){
          grammaireTrouvee = true;
          majPileSortieVariable(grammaireTrouvee, grammaires[i]);
        }
      }
    }
    
      if(!grammaireTrouvee){
       //println("haut de regle != mot");
      for (int i = 0; i < grammaires.length; i++){
        //Si haut de pile == variable d'une grammaire disponible && si haut de règle est EPS
        if(grammaires[i].getVariable().getAction().equals(pile.get(pile.size()-1).getAction()) && !grammaireTrouvee){
          grammaireTrouvee = true;
          majPileSortieVariable(grammaireTrouvee, grammaires[i]);
        }
      }
    }

    if(!grammaireTrouvee){
      majPileSortieVariable(grammaireTrouvee, null);
      println("ERROR GRAMMAIRE NOT FOUND");
    }
       
  } else if(!pile.isEmpty() && pile.get(pile.size()-1) != null && pile.get(pile.size()-1) instanceof Terminal){
  
    //println("terminal");
    
    if(!pile.get(pile.size()-1).getAction().equals("$")){
        //haut de pile == mot de l'entrée !
        if( pile.get(pile.size()-1).getAction().equals(entreeCourante.get(entreeCourante.size()-1)) ){
          
          majPileSortieTerminal();
    
        } else if (pile.get(pile.size()-1).getAction().equals("id") 
          || pile.get(pile.size()-1).getAction().equals("nb")) {
    
         if(entreeCourante.get(entreeCourante.size()-1).length() == 1){
  
          if(isDigit(entreeCourante.get(entreeCourante.size()-1).charAt(0))) { // si l'entrée est un nombre
            //println("Terminal l'entrée est nombre");
            majPileSortieTerminal();
          } else if (isLetter(entreeCourante.get(entreeCourante.size()-1).charAt(0))){ //si l'entrée est un id
            //println("Terminal l'entrée est une lettre");
            majPileSortieTerminal();
          }
        }
      } else { // il n'y a pas match entre deux terminaux => erreur
        println("terminal en entrée et terminal en haut de pile ne match pas => Error");
        sortie.add("ERROR");
      }
    } else { // on a un dollar donc on a finit avec ce mot on passe au suivant
    
      initWord();
    }
  }
}

void initWord(){
  pile.clear();
  sortie.clear();
  entreeCourante.clear();
    if(indiceRow < rows.length - 1){
    indiceRow++;
    chargerEntrees(indiceRow);
    pile.add(table.getDollar());
    pile.add(table.getP());
  } else {  
    endOfFile = true;
  }
}

void dessineEndOfFile(){
    String s = "Il n'y a pas d'autre mot dans le fichier data/entrees.txt, ajoutez-en !";
    textSize(25);
    fill(255, 0, 0);
    text(s, width/4, height/2);
}

boolean isLetter(char c){
  if(Character.isLetter(c)){
    return true;
  } else {
    return false;
  }
}

boolean isDigit(char c){
  if(Character.isDigit(c)){
    return true;
  } else {
    return false;
  }
}
