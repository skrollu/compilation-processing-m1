import java.util.*;
import org.apache.commons.lang3.StringUtils;

Table table = new Table();
Grammaire[] grammaires;

float xPile = 380;
float yPile = 700 ;
float cote = 40;

String[] rows;
ArrayList<String> entreeCourante = new ArrayList<String>();
ArrayList sortie = new ArrayList();

ArrayList<Entree> pile = new ArrayList<Entree>();

void setup(){
  size(800, 800);

  pile.add(table.getDollar());
  pile.add(table.getP());

  chargerEntrees();
}

void draw(){
  background(255);

  dessineEntreeSortie();
  dessinePile(pile);
  
  grammaires = table.getTabGrammaire();

  //print("|| x: " + mouseX + " y: " + mouseY);
}

void chargerEntrees(){
  rows = loadStrings("entrees.txt");
  
  String[] str = rows[0].split(" ");
  
  for(int i = str.length -1; i >= 0; i--){
    entreeCourante.add(str[i]);
  }
  
}

void dessineEntreeSortie(){
  textSize(25);
  fill(0);
  text("entrée: " + rows[0], width/4, 50);
  text("sortie: " + sortie, width/4, 100);
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

void majPileSortie(boolean found, Grammaire gram){

    if(found && gram != null){
      final List<Entree> regle = gram.getRegle();
      pile.remove(pile.size()-1);
      for(int j = 0; j < regle.size(); j++){
        pile.add(regle.get(j));
      }
      sortie.add(gram.getNumber());
    } else if(!found){
      sortie.add("ERROR");
    }
}

void mousePressed(){
  boolean grammaireTrouvee = false;

  if( pile.get(pile.size()-1) != null && pile.get(pile.size()-1) instanceof Variable){

    for (int i = 0; i < grammaires.length; i++){
      
      //Si haut de pile == variable d'une grammaire disponible et si haut de regle de la variable est le même terminal que celui de l'entrée.
      if(grammaires[i].getVariable().getAction().equals(pile.get(pile.size()-1).getAction()) 
        && grammaires[i].getRegle().get(grammaires[i].getRegle().size()-1).getAction().equals(entreeCourante.get(entreeCourante.size()-1)) && !grammaireTrouvee){

        grammaireTrouvee = true;
       
        majPileSortie(grammaireTrouvee, grammaires[i]);
      }
    }

    if(!grammaireTrouvee){
      for (int i = 0; i < grammaires.length; i++){
        //Si haut de pile == variable d'une grammaire disponible et si haut de regle de la variable est le même terminal que celui de l'entrée.
        if(grammaires[i].getVariable().getAction().equals(pile.get(pile.size()-1).getAction()) && !grammaireTrouvee){
          grammaireTrouvee = true;
          majPileSortie(grammaireTrouvee, grammaires[i]);
        }
      }
    }

    if(!grammaireTrouvee){
      majPileSortie(grammaireTrouvee, null);
      println("ERROR GRAMMAIRE NOT FOUND");
    }
       
  } else if(pile.get(pile.size()-1) != null && pile.get(pile.size()-1) instanceof Terminal){

    println(pile.get(pile.size()-1).getAction());
    println((entreeCourante.get(entreeCourante.size()-1)));
    
    //haut de pile == mot de l'entrée !
    if( pile.get(pile.size()-1).getAction().equals(entreeCourante.get(entreeCourante.size()-1))  ){
      pile.remove(pile.size()-1);
      entreeCourante.remove(entreeCourante.size()-1);
      sortie.add("pop");

    } else if (pile.get(pile.size()-1).getAction().equals("id") 
      || pile.get(pile.size()-1).getAction().equals("nb")) {

     //println( entreeCourante.get(entreeCourante.size()-1).length());

     if(entreeCourante.get(entreeCourante.size()-1).length() == 1){

        if(StringUtils.isNumeric(entreeCourante.get(entreeCourante.size()-1))) { // si l'entrée est un nombre
          println("l'entrée est nombre");
        } else if(Character.isLetter(entreeCourante.get(entreeCourante.size()-1).charAt(0))){ //si l'entrée est un id
          println("l'entrée est une lettre");
        }
      }
    }
  }
}
