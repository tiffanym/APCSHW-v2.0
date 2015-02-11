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
    
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	return hide + go(0,0) + ans + "\n" + show;
    }
    
    public KnightsTour(int size){
	board=new int[size][size];
	startx=0;
	starty=0;
	board[startx][starty]=1; //just going to let top left be start for now
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		if (i!=0 && j!=0){
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
	    solve(startx,starty);
	}
    }

    public void solve(int startx, int starty){
	
    }
		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	
	if (x+2,y+1){// hopefully...
	    return true;
	}

	return false;
    }
}