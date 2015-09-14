import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class ma_ypaint extends PApplet {


// tworze klase button, ktora jest moim obiktem,
//nad ktorym chce po kliknieciu na nim, zmieni\u0142 si\u0119 kolor.
class button{
  int wysokosc;//wymiary przycisku
  int dlugosc;
  int odZerawys;
  int odZeradlu;
  //konstruktor 
  button( int dlu,int wys,int odlu, int owys){
   wysokosc = wys;
   dlugosc = dlu;
   odZerawys = owys;
   odZeradlu = odlu;
  }
  //funkcja rysujaca przycisk
  public void narysuj(){
    
  rect(0+odZeradlu,0+odZerawys,dlugosc,wysokosc);
  }
  //funkcja sprawdzajaca czy klikamy w przycisk. Zwraca true lub false.
  public boolean klikniety()
  {
   if(mouseX>(odZeradlu) && mouseX<(dlugosc+odZeradlu) && mouseY<(wysokosc+odZerawys) && mouseY>(odZerawys) && mousePressed)
   {
    return true;
   }
   else { return false; }
  
  };
  //funkcja wypelniajaca kolorem
  public void zamaluj()
  {
  fill(0,50,200);
  };
}//tu sie konczy definiowanie klasy button

//tworze obiekt mojbutton klasy button
button mojbutton1;
button mojbutton2;
public void setup() {
  background(255);
  
  mojbutton1 = new button(100,30,100,0);//konstruuje obiekt
  mojbutton2 = new button(100,30,0,0);
  
}
public void draw(){
  stroke(0);
   String wyczysc = "Wyczy\u015b\u0107";
  String zapisz = "Zapisz";
  noFill();
  mojbutton1.narysuj();
  mojbutton2.narysuj();
  fill(0);
  text(wyczysc,30,20);
  text(zapisz, 130,20);
  


if(mojbutton1.klikniety() == true){
  fill(255);
  stroke(255);
    mojbutton1.narysuj();
  mojbutton2.narysuj();
  
  text(wyczysc,30,20);
  text(zapisz, 130,20);
  //save("rysunek.jpg");
  saveFrame("rysunek-#####.jpg");

  //fill(200);
}
//else { }
if(mousePressed && mouseButton == LEFT) {

 point(mouseX,mouseY); 
}
 // else if(mouseButton == RIGHT && mojbutton2.klikniety()==true) {mojbutton2.narysuj(); }
  if(mouseButton == LEFT && mojbutton2.klikniety()==true){ background(255) ;}
  if(mouseButton == RIGHT && mojbutton2.klikniety()==false){ fill(255);stroke(255); ellipse(mouseX-3,mouseY-3,6,6);}
}


   
  public void settings() {  size(350,500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ma_ypaint" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
