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
    private int[] queen;//tells what row each queen is in //queen[col]=row queen is in;
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
	queen=new int[size];
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		board[i][j]='.';
	    }
	}
    }
        
    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int x){
	if (x<0 || x>board.length){
	    return false;
	}else{
	    return solve(0,x,1); //starts on first column
	}
    }		

    public boolean safeSpot(int row, int col){
	for (int i=0;i<board.length;i++){//columns
	    if (i!=col){
		//Any queens in same row?
		if (queen[i]==row){
		    return false;
		}
		//Any queens in diagonal?
		if (Math.abs(i-col)==Math.abs(queen[i]-row)){
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean solve(int row,int col,int currentQueenNumber){
	if (debug){
	    System.out.println(this);
	    wait(1000);
	}
	//out of bounds
	if (row<0 || row>=board.length ||
	    col<0 || col>=board.length || 
	    currentQueenNumber<0 || currentQueenNumber>board.length){
	 return false;
	}
	//covered all squares
	if (currentQueenNumber==board.length ||
	   (board.length==1 && currentQueenNumber==1)){
	    return true;
	}
       
	board[row][col]='Q';
	for (int r=row;r<board.length;r++){
	    //if (safeSpot(row,col) && solve(row+1,col,currentQueenNumber+1)){
	    //queen[col]=row;
	    //board[row][col]='Q';
	    //return true;
	    //}
	    if (safeSpot(r,col)){
		queen[col]=r;
		if (solve(0,col+1,currentQueenNumber+1)){
		    return true;
		}
	    }
	}
	board[row][col]='.';

	return false;
    }
}