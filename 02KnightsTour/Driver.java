public class Driver{
    public static void main(String[]args){
	KnightsTour f;
	if(args.length < 1){
	    f = new KnightsTour(4);
	}else{
	    f = new KnightsTour(Integer.parseInt(args[0]));
	}
	f.clearTerminal();     
	if (f.solve()){
	    System.out.println("Yay!!!");
	}
	else{
	    System.out.println("No Solution");
	}
	//f.solve();
    }
}