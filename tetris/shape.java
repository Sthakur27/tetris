import java.util.*;
import java.lang.Math;
public class shape{
   ArrayList<block> myblocks;
   int x,y;
   int matrix;
   public shape(){
      //random number to determine shape, random number to determine color
      myblocks=new ArrayList<block>();
      reset();
   }  
   public void fall(){
      if(block.canFall(myblocks)){
         for(block b:myblocks){
            b.y-=1;
         }
         y-=1;
      }
      else{
         for (int i=0;i<myblocks.size();i++){
            block.allblocks.add(myblocks.get(i));
         }
         myblocks.clear();
         reset();
      }
   }
   public void reset(){
       //System.out.println("reseted");
       myblocks.clear();
       //4 matrix  x=4;y=29;
       x=5; y=30;
       //int col=(int)(Math.random()*6);
       int type=(int)(Math.random()*6);
       //System.out.println(type);
       switch (type){
          case 0:
          //System.out.println("0");
            x=4; y=29;
            matrix=2;
            myblocks.add(new block(5,30,type));
            myblocks.add(new block(6,31,type));
            myblocks.add(new block(5,31,type));
            myblocks.add(new block(6,30,type));
            break;
          case 1:
          //System.out.println("1");
           x=4;y=29;
           matrix=4;
           myblocks.add(new block(4,30,type));
           myblocks.add(new block(7,30,type));
           myblocks.add(new block(5,30,type));
           myblocks.add(new block(6,30,type));
            break;
          case 2:
          //System.out.println("2");
             x=5;y=30;
             matrix=3;
             myblocks.add(new block(5,30,type));
             myblocks.add(new block(6,30,type));
             myblocks.add(new block(7,30,type));
             myblocks.add(new block(6,31,type));
              break;
          case 3:
             //System.out.println("3");
             x=5;y=30;
             matrix=3;
             myblocks.add(new block(5,30,type));
             myblocks.add(new block(6,30,type));
             myblocks.add(new block(7,30,type));
             myblocks.add(new block(5,31,type));
              break;
          case 4:
             //System.out.println("4");
             x=5;y=30;
             matrix=3;
             myblocks.add(new block(5,30,type));
             myblocks.add(new block(6,30,type));
             myblocks.add(new block(7,30,type));
             myblocks.add(new block(7,31,type));
              break;
          case 5:
             //System.out.println("5");
             x=5;y=30;
             matrix=3;
             myblocks.add(new block(5,30,type));
             myblocks.add(new block(6,30,type));
             myblocks.add(new block(6,31,type));
             myblocks.add(new block(7,31,type));
            break;
         
       }
   }
   public void shift(int dir){
      if(block.canFall(myblocks) && block.canShift(myblocks,dir)){
        for(block b:myblocks){
            b.x+=dir;
         }
         x+=dir;
      }
   }
   public void rotate(){
       ArrayList<block>test=new ArrayList<block>(this.myblocks.size());
       for(block b:myblocks){
          test.add(new block(b.x,b.y,0));
       }
       boolean error=false;
       for (block b:test){
          int tempx=b.x+1-x;
          int tempy=b.y+1-y;
          /*System.out.print(tempx);System.out.print("  ");
          System.out.println(tempy);
          System.out.print(tempy);System.out.print("  ");
          System.out.println(5-tempx);
          System.out.println("  ");*/
          if(matrix==3){
              b.x=x-1+tempy;
              b.y=y-1+(4-tempx);
          }
          if(matrix==4){
              b.x=x-1+tempy;
              b.y=y-1+(5-tempx);
          }
          //System.out.println(b.x);
          if(b.x<1 || b.x>9 || b.y<1){ error=true;}
          for(block a:block.allblocks){
             if(b.x==a.x && b.y==a.y){
                error=true;
             }
          }
       }
       if(!error){
          for(int i=0;i<myblocks.size();i++){
             myblocks.get(i).x=test.get(i).x;
             myblocks.get(i).y=test.get(i).y;
          }
       }
   }
}

//(1,2)==>(2(y),4-0(x))    

//(a,b)  => (1,2)=>(2,4)     (3,2)=>(2,2)   (3,1)=>(1,2)
//(an,bn)=(b,5-a)
// 0 0 0 0           0 1 0 0    0 0 0 0
// 0 0 0 0           0 1 0 0    1 1 1 1
// 1 1 1 1           0 1 0 0    0 0 0 0
// 0 0 0 0           0 1 0 0    0 0 0 0