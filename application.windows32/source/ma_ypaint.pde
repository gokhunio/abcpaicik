
// tworze klase button, ktora jest moim obiktem,
//nad ktorym chce po kliknieciu na nim, zmienił się kolor.
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
  void narysuj(){
    
  rect(0+odZeradlu,0+odZerawys,dlugosc,wysokosc);
  }
  //funkcja sprawdzajaca czy klikamy w przycisk. Zwraca true lub false.
  boolean klikniety()
  {
   if(mouseX>(odZeradlu) && mouseX<(dlugosc+odZeradlu) && mouseY<(wysokosc+odZerawys) && mouseY>(odZerawys) && mousePressed)
   {
    return true;
   }
   else { return false; }
  
  };
  //funkcja wypelniajaca kolorem
  void zamaluj()
  {
  fill(0,50,200);
  };
}//tu sie konczy definiowanie klasy button

//tworze obiekt mojbutton klasy button
button mojbutton1;
button mojbutton2;
void setup() {
  background(255);
  size(350,500);
  mojbutton1 = new button(100,30,100,0);//konstruuje obiekt
  mojbutton2 = new button(100,30,0,0);
  
}
void draw(){
  stroke(0);
   String wyczysc = "Wyczyść";
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


   