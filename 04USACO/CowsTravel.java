//For Question 7 "Cow Travelling" from http://tjsct.wikidot.com/usaco-mar08-silver
import java.util.*;

public class CowsTravel{
    String[][] pasture;
    int N,M,T; //N=row(2<=N<=100) //M=col(2<=M<=100) //T=time(0<T<=15)
    int R1,C1,R2,C2; //(R1,C1)=start (R2,C2)=end
    int S=0; //number of ways cows can travel with given info
    ArrayList<String> paths=new ArrayList<String>();

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
	pathsR.add(new int[T]);//*** ISSUE
	pathsC.add(new int[T]);//*** ISSUE
    }

    public int FJneedstoKnow(){
	//startR,startC= (R1-1,C1-1); endR,endC=(R2-1,C2-1);
	if (travel(R1-1,C1-1,1)){
	    return S;
	}else{
	    return 0;
	}
    }

    public boolean travel(int row,int col,int time){
	if (row<0 || row>=N || col<0 || col>=M || time<0 || time>T) { //out of bounds
	    return false;
	}
	if (row==R2-1 && col==C2-1 && time==T){ //finished / at end position
	    //pathsR.get(S).set(time-1,""+row);
	    //pathsC.get(S).set(time-1,""+col);
	    pathsR.get(S).add(""+row);      //*** ISSUE
	    pathsC.get(S).add(""+col);	    //*** ISSUE
	    S+=1;
	    //pathsR.add(new ArrayList<String>());
	    //pathsC.add(new ArrayList<String>());
	    pathsR.add(new int[T]);         //*** ISSUE
	    pathsC.add(new int[T]);         //*** ISSUE
	    return true;
	}
	if (pasture[row][col]!=""+'.'){ //is a '*'(tree) or some labeled number
	    return false;
	}
	//Can a path be made from the current position with the given amount of steps/ time?
	if (travel(row+1,col,time+1) || travel(row,col+1,time+1) ||
	    travel(row-1,col,time+1)|| travel(row,col-1,time+1)){
	    if(!(Integer.parseInt(pathsR.get(S).get(time-1))>0) &&
	       !(Integer.parseInt(pathsC.get(S).get(time-1))>0)){
		//pathsR.get(S).set(time-1,""+row);
		//pathsC.get(S).set(time-1,""+col);
		pathsR.get(S).add(""+row);
		pathsC.get(S).add(""+col);
		return true;
	    }
	}
    }
    
    public static void main(String[] args){
	String input="4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	CowsTravel test=new CowsTravel(input);
    }
}