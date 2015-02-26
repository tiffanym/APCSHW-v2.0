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
		//if (solve(col+1,currentQueenNumber+1)){
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

    /*
    public boolean solve(int x,int y,int currentQueenNumber){
	if (debug){
	    System.out.println(this);
	    wait(1000);
	}
	
	//out of bounds
	if (y<0 || y>=board.length || 
	    x<0 || x>=board.length || 
	    currentQueenNumber<0 || currentQueenNumber>board.length){
	 return false;
	}       
	//comment out start here
	for (int r=row;r<board.length;row++){
	    if (safeSpot(r,col)){
		if (solve (r,col,currentQueenNumber+1)){
		    queen[col]=r;
		    board[r][col]='Q';		
		}
		if (currentQueenNumber==board.length+1){
		    return true;
		}
	    }

	    //if (safeSpot(row,col)){
	    //	board[row][col]='Q';
	    //	queen[col]=row;
	    //	if (currentQueenNumber==board.length || solve(col+1,currentQueenNumber+1)){
	    //	    return true;
	    //	}
	    //}else{
	    //	board[row][col]='.';
	    //}
	}
	//stop here
    //comment out start here
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
	//stop here
	
	if(safeSpot(x,y,currentQueenNumber) && board[x][y]=='.'){
	//if (safe && board[x][y]=='.'){
	    queen[x]=y;
	    board[x][y]='Q';
	    //if (currentQueenNumber==board.length){
	    //	return true;
	    //}else{
	    if((solve(x+1,y+1,currentQueenNumber+1) || solve(x,y+1,currentQueenNumber+1) || solve(x+1,y,currentQueenNumber+1)) 
	    //if(solve(x+1,(y+1)%board.length,currentQueenNumber+1)
	    	&& currentQueenNumber==board.length){		
		return true;
	    }
		//}
	    //return true;
	}
	else{
	    queen[x]+=1;
	    solve(x,queen[x],currentQueenNumber);
	}
	board[x][y]='.';
	
	return false;
	}
*/
}
