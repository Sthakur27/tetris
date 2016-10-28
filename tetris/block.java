import java.util.*;
public class block{
  static ArrayList<block> allblocks=new ArrayList<block>(3);
  int x,y,col;
  public block(int a, int b, int c){
     x=a; y=b; col=c;
  }
  public static boolean canFall(ArrayList<block> figureblocks){
     for (int b=0;b<figureblocks.size();b++){
         if(figureblocks.get(b).y==0){return (false);}
         for(int a=0;a<allblocks.size();a++){
            //can't fall if there is a different block under or if at bottom already
            if(figureblocks.get(b).x==allblocks.get(a).x && 
            figureblocks.get(b).y-1==allblocks.get(a).y){
                return (false);
            }
         }
     }
     return (true);
  }
  public static boolean canShift(ArrayList<block> figureblocks, int dir){
     for (int b=0;b<figureblocks.size();b++){
         if(figureblocks.get(b).y==0){return (false);}
         if((figureblocks.get(b).x==0 && dir==-1)||(figureblocks.get(b).x==9 && dir==1)){
             return(false);
         }
         for(int a=0;a<allblocks.size();a++){
            //can't fall if there is a different block under or if at bottom already
            if(figureblocks.get(b).y==allblocks.get(a).y && 
            figureblocks.get(b).x+dir==allblocks.get(a).x){
                return (false);
            }
         }
     }
     return (true);
  }
  public static void deleteRow(){
     for (int row=50;row>=0;row--){
        //*add* check if a row should be deleted
        if(shouldDeleteRow(row)){
            //deleting a row
            for(int i=0;i<allblocks.size();i++){
               if(allblocks.get(i).y==row){
                 allblocks.remove(i);
                 i--;
               }
               //shifts all blocks above deleted row down one
               else if(allblocks.get(i).y>row){
                  allblocks.get(i).y-=1;
               }
            }
        }
     }
  }
  public static boolean shouldDeleteRow(int n){
     int[] test={0,0,0,0,0,0,0,0,0,0};
     for(int b=0;b<allblocks.size();b++){
       if(allblocks.get(b).y==n){
          test[allblocks.get(b).x]=1;
       }
     }
     for(int i:test){
        if(i==0){return (false);}
     }
     return(true);
  }
  public static void reset(){
     allblocks.clear();
    
  }
}