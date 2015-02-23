public class MakeLake{
    int[][] pasture;
    int R,C,E; //R=row;C=col
                 //E=desired elevation (only <=E works in final pasture)
    int N;//N=number of stomp digging instructions
    int[][] instructions=new int[N][3];
    int volume;

    public MakeLake(){
	//just some constructor for now; create one that reads file
    }

    public void command(){
	for (int i=0;i<N;i++){
	    cowsDig(instructions[i]); //instructions[i]={row,col,depth};
	}
    }

    public void cowsDig(int[] instruction){
	int row=instruction[0];
	int col=instruction[1];
	int depth=instruction[2];
	int max=pasture[row][col];
	for (int r=row;r<pasture.length || r<row+3;r++){
	    for (int c=col;c<pasture[0].length || c<col+3;c++){
		if (pasture[row][col]>max){
		    max=pasture[row][col];
		}
	    }
	}
    }

    public static void main(String[] args){

    }
}