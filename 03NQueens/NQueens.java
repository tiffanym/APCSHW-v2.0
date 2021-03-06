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
	boolean works=false;
	for (int i=0;i<board.length;i++){
	    works=works || solve(i);
	}
	return works;
    }

    public boolean solve(int x){
	if (x<0 || x>board.length){
	    return false;
	}else{
	    return solve(0,x);//starts on first column
	}
    }		

    //x=col;y=row
    public boolean safeSpot(int x,int y){
	for (int i=0;i<x;i++){//columns
	    //Any queens in same row?
	    if (queen[i]==y){
		return false;
	    }
	    //Any queens in diagonal?
	    if (Math.abs(i-x)==Math.abs(queen[i]-y)){
	    	return false;
	    }
	}
	return true;
    }

    public boolean solve(int col, int currentQueenNumber){
	if (debug){
	    System.out.println(this);
	    wait(500);
	}
	
	//for 1x1 board
	if (board.length==1){
	    return true;
	}
	
	//out of bounds
	if (col<0 || col>=board.length || currentQueenNumber<1 || currentQueenNumber>board.length){
	    return false;
	}
	
	if (board.length==3){
	    return false;
	}
	
	for (int row=0;row<board.length;row++){
	    if (safeSpot(col,row)){
		board[row][col]='Q';
		queen[col]=row;
		if (solve(col+1,currentQueenNumber+1) || currentQueenNumber==board.length){
		    return true;
		}
		else{
		    board[row][col]='.';
		}
		    //}
	    }else{
		queen[col]=(queen[col]+1)%board.length;
		board[row][col]='.';
	    }
	}
	return false;
    }
}
