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
    boolean debug=true;
    
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
	//return hide + go(startx,starty) + ans + "\n" + show;
	String boardAR=go(0,0)+"";
	for (int i=0;i<board.length;i++){
	    for (int j=0;j<board[0].length;j++){
		    boardAR+=board[i][j]+" ";    
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
	if (board.length<2){
	    //System.out.println("Doesn't work.");
	    //System.out.println(board);
	    return false;
	}else{
	    return solve(0,0);
	}
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
	    wait(50);
	}					       
	//covered all squares
	if (currentMoveNumber==board.length*board[0].length){
	    return true;
	}
	//out of bounds
	if (x<0 || y<0 || x>=board.length || y>=board[0].length){
	    return false;
	}

	if (board[x][y]==0){ //0=no number 
	    board[x][y]=currentMoveNumber;
	    
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
	    }else{	    
		board[x][y]=0;
		return false;
	    }
	}

	return false;
    }
}