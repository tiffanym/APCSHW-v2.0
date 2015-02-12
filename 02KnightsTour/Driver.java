public class Driver{
    public static void main(String[]args){
	KnightsTour f;
	if(args.length < 1){
	    f = new KnightsTour(6);
	}else{
	    f = new KnightsTour(Integer.parseInt(args[0]));
	}
	f.clearTerminal();
	f.solve();	
    }
}