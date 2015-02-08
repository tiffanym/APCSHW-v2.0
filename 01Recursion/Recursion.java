public class Recursion{
    public String name(){
	return "Ming,Tiffany";
    }

    public int fact(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if(n==0){
	    return 1;
	}if (n>1){
	    return n*fact(n-1); 
	}else{
	    return n;
	}
    }

    public int fib(int n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (n>2){
	    return fib(n-1)+fib(n-2); 
	}if (n==2){
	    return 1;
	}else{
	    return n;
	}	
    }

    public double sqrt(double n){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	if (n==0){
	    return 0;
	}
	double guess=n/2;
	if (n>0){
	    return sqrt2(n,guess);
	}else{
	    return n;
	}
    }

    public double sqrt2(double n, double guess){
	if (n<0){
	    throw new IllegalArgumentException();
	}
	double temp=(n/guess+guess)/2;
	if (temp!=guess){
	    guess=temp;
	    return sqrt2(n,guess);
	}else{
	    return guess;
	}
    }

    public static void main(String[] args){
	Recursion test=new Recursion();
	//System.out.println(test.fact(5));
	//System.out.println(test.fact(10));
	//System.out.println(test.fact(14253566)); //prints out error message

	//f 0 1 2 3 4 5 6  7  8  9 10
	//  0 1 1 2 3 5 8 13 21 34
	//System.out.println(test.fib(3));
	//System.out.println(test.fib(10));
	
	//System.out.println(test.sqrt(9));
	//System.out.println(test.sqrt(100));
	//System.out.println(test.sqrt(81*81));
	//System.out.println(test.sqrt(5100000000)); //hehe //works with this too *v*
    }
}