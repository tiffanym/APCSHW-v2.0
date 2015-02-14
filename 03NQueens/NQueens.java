import java.util.*;
import java.io.*;

public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private char[][]board;
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

    public String name(){
	return "ming.tiffany";
    }

    public String toString(){
	String ans = "\n";
	String boardAR=go(0,0)+"";
	for (int i=0;i<board.length;i++){
	    for (int j=0;j<board[0].length;j++){
		boardAR+=String.format("%-2s",board[i][j]);    
	    }
	    boardAR+=ans;
	}
	boardAR+=ans+show;
	return boardAR;
    }
    
    public NQueens(int size){
	board=new char[size][size];
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		board[i][j]='.';
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

    public boolean solve(int x,int y,int currentQueenNumber){
	if (debug){
	    System.out.println(this);
	    wait(20);
	}
	//out of bounds
	if (x<0 || y<0 || x>=board.length || y>=board[0].length){
	    return false;
	}
	//covered all squares
	if (currentQueenNumber==board.length && board[x][y]=='.'){
	    return true;
	}
	//no blockage
	//if (board[x][y]==0){
	//    return false;
	//}
	
	if (board[x][y]=='Q'){
	    return false;
	}

	if (board[x][y]==0){ //0=no number 
	    board[x][y]='Q';
	    	    
	    if(solve(x-1,y-1,currentQueenNumber+1) || //NW
	       solve(x,y-1,currentQueenNumber+1) || //N
	       solve(x+1,y-1,currentQueenNumber+1) || //NE
	       solve(x+1,y,currentQueenNumber+1) || //E
	       solve(x+1,y+1,currentQueenNumber+1) || //SE
	       solve(x,y+1,currentQueenNumber+1) ||  //S
	       solve(x-1,y+1,currentQueenNumber+1) || //SW
	       solve(x-1,y,currentQueenNumber+1)    //W
	       
	       ){ 
		return true;
	    }
	    board[x][y]='.';
	    return false;
	}
	
	return false;
    }
}