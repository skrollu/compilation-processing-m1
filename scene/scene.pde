import java.util.*;

Table table = new Table();
Grammaire[] grammaires;

float xPile = 380;
float yPile = 700 ;
float cote = 40;

String[] sortie ={"xdcdvb","fghjk"};
String[] rows;
ArrayList entreeCourante = new ArrayList();

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
  text("sortie: " + sortie[0], width/4, 100);
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

void mousePressed(){
  
  if( pile.get(pile.size()-1) != null && pile.get(pile.size()-1) instanceof Variable){


    for (int i = 0; i < grammaires.length; i++){
      println("var de grammaire: " + grammaires[i].getVariable().getAction());
      println("haut de pile:     " + pile.get(pile.size()-1).getAction());
      
      println(grammaires[i].getRegle().get(grammaires[i].getRegle().size()-1).getAction());
      println(entreeCourante.get(entreeCourante.size()-1));
    
      if(grammaires[i].getVariable().getAction().equals(pile.get(pile.size()-1).getAction()) 
        && grammaires[i].getRegle().get(grammaires[i].getRegle().size()-1).getAction().equals(entreeCourante.get(entreeCourante.size()-1))){
        print("même terminale qu'en entrée");
      }
    }
    
  } else if(pile.get(pile.size()-1) instanceof Terminal){
     print("terminal");
  }
}
