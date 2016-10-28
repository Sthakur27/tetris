//tetris
// 10 x 50
shape Corran=new shape();
int[]red={66,255,0,255,128,0};
int[]green={134,51,205,165,0,215};
int[]blue={244,0,0,0,128,215};
void setup(){
  size(400,700);
  frameRate(5);
  surface.setResizable(true);
  scale(-1,1);
  for (int i=0;i<15;i++){ Corran.fall();  }
}

void draw(){
   scale(1,-1);
   translate(0,-height);
   background(256,256,256);
   fill(0,0,0);
   textSize(60);
   stroke(#ff3399);
   fill(#ff3300);
   Corran.fall();
   line(100,50,100,650);
   line(300,50,300,650);
   line(100,50,300,50);
   line(100,650,300,650);
   stroke(0,0,0);
   for(block b: block.allblocks){
      fill(red[b.col],green[b.col],blue[b.col]);
      rect(100+b.x*20,50+b.y*20,20,20);
      //rect(100+b.x*60,100+b.y*8,30,30);
   }
   for(block b: Corran.myblocks){
       fill(red[b.col],green[b.col],blue[b.col]);
       rect(100+b.x*20,50+b.y*20,20,20);
       //rect(b.x*width/10,b.y*height/50,width/10,height/10);
       //rect(100+b.x*60,100+b.y*8,30,30);
   }
   block.deleteRow();
   block.gameOver();
}

void keyPressed(){
   if(key=='a'||key=='A'){
       Corran.shift(-1);
   }
   if(key=='d'||key=='D'){
       Corran.shift(1);
   }
   if(key=='s'||key=='S'){
       Corran.fall();
   }
   if(key=='w'||key=='W'){
       Corran.rotate();
   }
   if(key=='r'||key=='R'){
      Corran.reset(); block.reset();
   }
}