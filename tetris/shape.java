import java.util.*;
import java.lang.Math;
public class shape{
   ArrayList<block> myblocks;
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
       int col=(int)(Math.random()*5);
       int type=(int)(Math.random()*7);
       myblocks.add(new block(5,28,0));
       //0:050  1:50100 2:100150 3:150200 4:200250 5:2530 6:3035  7:3540 8:4045 9:4550
       //translates to (5*500/10,30*800/50
       //(250,480,50,16)
       myblocks.add(new block(6,28,0));
       myblocks.add(new block(5,29,0));
       myblocks.add(new block(6,29,0));
   }
   public void shift(int dir){
      if(block.canFall(myblocks) && block.canShift(myblocks,dir)){
        for(block b:myblocks){
            b.x+=dir;
         }
      }
   }
}