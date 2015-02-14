public class Driver{
    public static void main(String[]args){
	NQueens f;
	if(args.length < 1){
	    f = new NQueens(3);
	}else{
	    f = new NQueens(Integer.parseInt(args[0]));
	}
	f.clearTerminal();     
	if (f.solve()){
	    System.out.println("Yay!!!");
	}
	else{
	    System.out.println("No Solution");
	}
    }
}