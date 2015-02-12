import java.util.*;
import java.io.*;

public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private int[][]board;
    private int startx, starty;
    
    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    
    public void clearTerminal(){
	System.out.println(clear);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	//return hide + go(startx,starty) + ans + "\n" + show;
	String boardAR=go(0,0)+"";
	for (int i=0;i<board.length;i++){
	    boardAR+="[ ";
	    for (int j=0;j<board[0].length;j++){
		if (board[i][j]==-1){
		    boardAR+=color(38,47)+board[i][j]+" ";    
		}else{
		    boardAR+=color(32,40)+board[i][j]+" ";    
		}
		
	    }
	    boardAR+="]"+ans;
	}
	boardAR+=ans+show +color(37,40);
	return boardAR; //HMMM.... IS THIS RIGHT?!?!?!?!?!?!?!?!?!?!
    }
    
    public KnightsTour(int size){
	board=new int[size][size];
	startx=0;
	starty=0;
	board[startx][starty]=1; //just going to let top left be start for now
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		if (i!=0 || j!=0){
		    board[i][j]=-1;
		}
	    }
	}
    }
        
    public void solve(){
	if (board.length<2){
	    System.out.println("Doesn't work.");
	    System.out.println(board);
	}else{
	    solve(0,0,1);
	}
    }

    public void solve(int x, int y){
	
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(500);
	if (currentMoveNumber==board.length*board[0].length){
	    return true;
	}
	if (x<0 || y<0 || x>=board.length || y>=board[0].length){
	    return false;
	}

	if (Math.abs(board[x][y])==1){ //-1=nothing done yet; 1=start;
	    board[x][y]=currentMoveNumber;
	    /*
	    if(solve(x+2,y+1,currentMoveNumber+1) ||
	       solve(x+2,y-1,currentMoveNumber+1) ||
	       solve(x-2,y+1,currentMoveNumber+1) ||
	       solve(x-2,y-1,currentMoveNumber+1) ||
	       solve(x+1,y+2,currentMoveNumber+1) ||
	       solve(x+1,y+2,currentMoveNumber+1) ||
	       solve(x-1,y-2,currentMoveNumber+1) ||
	       solve(x-1,y-2,currentMoveNumber+1)
	       ){ 
		return true;
	    }
	    */
	    if (solve(x+2,y+1,currentMoveNumber+1)){ //WHY DOES IT STOP AT 7?!?!?!?!
		return true;
	    }
	    if (solve(x+2,y-1,currentMoveNumber+1)){
		return true;
	    }
	    if (solve(x-2,y+1,currentMoveNumber+1)){
		return true;
	    }
	    if (solve(x-2,y-1,currentMoveNumber+1)){
		return true;
	    }
	    if(solve(x+1,y+2,currentMoveNumber+1)){
		return true;
	    }
	    if(solve(x+1,y+2,currentMoveNumber+1)){
		return true;
	    }
	    if(solve(x-1,y-2,currentMoveNumber+1)){
		return true;
	    }
	    if (solve(x-1,y-2,currentMoveNumber+1)){
		return true;
	    }

	    board[x][y]=-1;
	    solve(x,y,currentMoveNumber);
	}

	return false;
    }
}