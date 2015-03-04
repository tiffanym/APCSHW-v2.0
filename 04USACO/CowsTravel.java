//For Question 7 "Cow Travelling" from http://tjsct.wikidot.com/usaco-mar08-silver
import java.util.*;
import java.io.*;

public class CowsTravel{
    String[][] pasture;
    int N,M,T; //N=row(2<=N<=100) //M=col(2<=M<=100) //T=time(0<T<=15)
    int R1,C1,R2,C2; //(R1,C1)=start (R2,C2)=end
    int ways=0;
    /*
    public CowsTravel(String input){
	String[] info=input.split("\n");
	for (int line=0;line<info.length;line++){
	    //sets variables
	    if (line==0){
		String[] para=info[line].split(" ");
		N=Integer.parseInt(para[0]);
		M=Integer.parseInt(para[1]);
		T=Integer.parseInt(para[2]);
		pasture= new String[N][M];
	    }
	    //sets pasture
	    if (line>0 && line<N+1){
		String[] pastureRow=info[line].split("");
		for (int col=0;col<M;col++){
		    pasture[line-1][col]=pastureRow[col];
		}
	    }
	    //sets start and stop coordinates
	    if (line==N+1){
		String[] startEnd=info[line].split(" ");
		R1=Integer.parseInt(startEnd[0]);
		C1=Integer.parseInt(startEnd[1]);
		R2=Integer.parseInt(startEnd[2]);
		C2=Integer.parseInt(startEnd[3]);
	    }
	}
	//paths.add();
    }
    */
    public CowsTravel(){
	File info=new File("ctravel.in");
	try{
	    Scanner scan= new Scanner(info);
	    int line=0;
	    while (scan.hasNextLine()){
		String text=scan.nextLine();
		//sets variables
		if (line==0){
		    String[] para=text.split(" ");
		    N=Integer.parseInt(para[0]);
		    M=Integer.parseInt(para[1]);
		    T=Integer.parseInt(para[2]);
		    pasture= new String[N][M];
		}
		//sets pasture
		if (line>0 && line<N+1){
		    String[] pastureRow=text.split("");
		    for (int col=0;col<M;col++){
			pasture[line-1][col]=pastureRow[col];
		    }
		}
		//sets start and stop coordinates
		if (line==N+1){
		    String[] startEnd=text.split(" ");
		    R1=Integer.parseInt(startEnd[0]);
		    C1=Integer.parseInt(startEnd[1]);
		    R2=Integer.parseInt(startEnd[2]);
		    C2=Integer.parseInt(startEnd[3]);
		}
		line++;
	    }
	}catch (FileNotFoundException e){

	}
    }

    public int FJneedstoKnow(){
	//startR,startC= (R1-1,C1-1); endR,endC=(R2-1,C2-1);
	return travel(R1-1,C1-1,1);
    }

    public int travel(int row,int col,int time){
	if (row<0 || row>=N || col<0 || col>=M || time<0 || time>T) { //out of bounds
	    return 0;
	}
	if (time==T && row==R2-1 && col==C2-1){ //finished / at end position
	    return 1;
	}
	if (pasture[row][col]==""+'*'){ //is a '*'(tree)
	    return 0;
	}
	//Can a path be made from the current position with the given amount of steps/ time?
	return travel(row+1,col,time+1) + travel(row,col+1,time+1) +
		travel(row-1,col,time+1) + travel(row,col-1,time+1);
    }
    
    public static void main(String[] args){
	//String input="4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	//CowsTravel test=new CowsTravel(input);
	CowsTravel test=new CowsTravel();
	System.out.println(test.FJneedstoKnow());
    }
}