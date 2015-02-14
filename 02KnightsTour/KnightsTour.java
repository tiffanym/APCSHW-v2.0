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
    boolean debug=false;
    
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

    public String name(){
	return "ming.tiffany";
    }

    public String toString(){
	String ans = "\n";
	String boardAR=go(0,0)+"";
	for (int i=0;i<board.length;i++){
	    for (int j=0;j<board[0].length;j++){
		boardAR+=String.format("%-"+board.length+"s",board[i][j]);    
	    }
	    boardAR+=ans;
	}
	boardAR+=ans+show;
	return boardAR;
    }
    
    public KnightsTour(int size){
	board=new int[size][size];
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		board[i][j]=0;
	    }
	}
    }
        
    public boolean solve(){
	return solve(0,0);
    }

    public boolean solve(int startx, int starty){
	if (startx<0 || starty<0 || 
	    startx>=board.length || starty>=board[0].length){
	    return false;
	}else{
	    return solve(startx,starty,1);
	}
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	if (debug){
	    System.out.println(this);
	    wait(10);
	}
	//out of bounds
	if (x<0 || y<0 || x>=board.length || y>=board[0].length && board[x][y]!=0){
	    return false;
	}
	//covered all squares
	if (currentMoveNumber==board.length*board[0].length && board[x][y]==0){
	    //board[x][y]=board.length*board[0].length;
	    return true;
	}
					       
	if (board[x][y]==0){ //0=no number 
	    board[x][y]=currentMoveNumber;
	    
	    if(solve(x+2,y+1,currentMoveNumber+1) ||
	       solve(x+2,y-1,currentMoveNumber+1) ||
	       solve(x-2,y+1,currentMoveNumber+1) ||
	       solve(x-2,y-1,currentMoveNumber+1) ||
	       solve(x+1,y+2,currentMoveNumber+1) ||
	       solve(x-1,y+2,currentMoveNumber+1) ||	    
	       solve(x+1,y-2,currentMoveNumber+1) ||
	       solve(x-1,y-2,currentMoveNumber+1)
	       ){ 
		board[x][y]=currentMoveNumber;
		return true;
	    }
	    board[x][y]=0;
	    return false;
	}
	return false;
    }
}