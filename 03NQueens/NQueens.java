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
    private int[] queen;//tells what row each queen is in
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
	    queen[i]=i;
	}
    }
        
    public boolean solve(){
	return solve(0);
    }

    public boolean solve(int x){
	if (x<0 || x>board.length){
	    return false;
	}else{
	    return solve(x,0,1); //starts on first column
	}
    }		

    //x=col;y=row
    //x,y are currentQueen's current position (testing to see if will work)
    public boolean safeSpot(int x,int y,int currentQueenNumber){
	//Any queens in same row?
	for (int i=0;i<currentQueenNumber;i++){//columns
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

    //x=col;y=row;
    public boolean solve(int x,int y,int currentQueenNumber){
	if (debug){
	    System.out.println(this);
	    wait(50);
	}
	//out of bounds
	if (x<0 || y<0 || x>=board.length || y>=board.length){
	    return false;
	}
	//covered all squares
	if (currentQueenNumber==board.length+1){
	    return true;
	} 
	//if (board[x][y]=='Q'){
	//    return false;
	//}
	/*
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
	*/
	//for (int i=0;i<board.length;i++){ //start on first column; go right
	    boolean safe=true;
	    if (currentQueenNumber>1){
		for (int i=0;i<currentQueenNumber;i++){//columns
		    if (queen[i]==y){
			safe=false;
		    }
		    //Any queens in diagonal?
		    if (Math.abs(i-x)==Math.abs(queen[i]-y)){
			safe=false;
		    }
		}
	    }
		
	    ///if(safeSpot(x+i,y,currentQueenNumber)){
	    if (safe && board[x][y]=='.'){
		board[x][y]='Q';
		solve(x+1,y+1,currentQueenNumber+1);
		return true;
	    }
	    else{
		solve(x,y+1,currentQueenNumber);
	    }
	    board[x][y]='.';
	    //}
	
	return false;
    }
}