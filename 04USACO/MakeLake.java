public class MakeLake{
    int[][] pasture;
    int R,C,E; //R=row;C=col
               //E=desired elevation (only <=E works in final pasture)
    int N;//N=number of stomp digging instructions
    int[][] instructions;

    public MakeLake(String input){
	//just some constructor for now; create one that reads file
	String[] info=input.split("\n");
	for (int line=0;line<info.length;line++){
	    //sets variables
	    if (line==0){
		String[] para=info[line].split(" ");
		R=Integer.parseInt(para[0]);
		C=Integer.parseInt(para[1]);
		E=Integer.parseInt(para[2]);
		N=Integer.parseInt(para[3]);
		pasture= new int[R][C];
		instructions= new int[N][3];
	    }
	    //sets pasture
	    if (line>0 && line<R+1){
		String[] pastureRow=info[line].split(" ");
		for (int col=0;col<C;col++){
		    pasture[line-1][col]=Integer.parseInt(pastureRow[col]);
		}
	    }
	    //sets instructions
	    if (line>R && line<R+N+1){
		String[] tempInstruct=info[line].split(" ");
		for (int col=0;col<3;col++){
		    instructions[line-R-1][col]=Integer.parseInt(tempInstruct[col]);
		}
	    }
	}
    }

    public int command(){
	for (int i=0;i<N;i++){
	    cowsDig(instructions[i]); //instructions[i]={row,col,depth};
	}	
	return calcVolume();
    }

    public void cowsDig(int[] instruction){
	int row=instruction[0]-1;
	int col=instruction[1]-1;
	int depth=instruction[2];
	//finds highest elevation
	int max=pasture[row][col]; //took away -depth
	for (int r=row;r<pasture.length && r<row+3;r++){
	    for (int c=col;c<pasture[0].length && c<col+3;c++){
		if (pasture[r][c]>max){
		    max=pasture[r][c];
		}
	    }
	}
	max=max-depth;
	//tells cows that should stomp (because on an elevation above desired max) to stomp
	for (int r=row;r<pasture.length && r<row+3;r++){
	    for (int c=col;c<pasture[0].length && c<col+3;c++){
		if (pasture[r][c]>max){
		    pasture[r][c]=max;
		}
	    }
	}
    }

    public int sumFinalDepths(){
	int sum=0;
	for (int row=0;row<pasture.length;row++){
	    for (int col=0;col<pasture[0].length;col++){
		if (pasture[row][col]<=E){
		    pasture[row][col]=E-pasture[row][col];
		    sum+=pasture[row][col];
		}else{
		    pasture[row][col]=0;
		}
	    }
	}
	return sum;
    }

    //Final Volume is 6 ft*6 ft* (sum of finalDepths()) inches = 72*72*(sum finalDepths)
    public int calcVolume(){
	return sumFinalDepths()*72*72;
    }

    public static void main(String[] args){
	String input="4 6 22 2\n28 25 20 32 34 36\n27 25 20 20 30 34\n24 20 20 20 20 30\n20 20 14 14 20 20\n1 4 4\n1 1 10";
	MakeLake test= new MakeLake(input);
	System.out.println(test.command());
    }
}