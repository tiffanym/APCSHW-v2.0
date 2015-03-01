//For Question 7 "Cow Travelling" from http://tjsct.wikidot.com/usaco-mar08-silver
public class CowsTravel{
    String[][] pasture;
    int N,M,T; //N=row(2<=N<=100) //M=col(2<=M<=100) //T=time(0<T<=15)
    int R1,C1,R2,C2; //(R1,C1)=start (R2,C2)=end
    int S=0; //number of ways cows can travel with given info
    ArrayList<String> pathsR=new ArrayList<String>();
    ArrayList<String> pathsC=new ArrayList<String>();

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
    }

    public void FJneedstoKnow(){
	//startR,startC= (R1-1,C1-1); endR,endC=(R2-1,C2-1);
	travel(R1-1,C1-1,1);
    }

    public boolean travel(int row,int col,int time){
	if (row==R2-1 && col==C2-1 && time==T){
	    pathsR.get(S).set(T-1,row);
	    pathsC.get(S).set(T-1,col);
	    return true;
	}
	if (pasture[row][col]!='.'){ //is a *(tree) or some labeled number
	    return false;
	}
	//then do something here
    }
    
    public static void main(String[] args){
	String input="4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	CowsTravel test=new CowsTravel(input);
    }
}