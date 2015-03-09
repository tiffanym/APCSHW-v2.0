import java.util.*;

public class Sorts{
    //remember to return void!!!

    //Assuming no duplicates for now...
    public static int[] quicksort(int[] ary){
	//System.out.println("Original: "+Arrays.toString(ary)); //
	int[] d=new int[ary.length];
	for (int i=0;i<ary.length;i++){
	    d[i]=QuickSelect.partition(ary,0,ary.length-1,i);
	    //System.out.println("Element "+i+": "+d[i]); //
	}
	return d;
	//System.out.println("Sorted: "+Arrays.toString(d)); //
    }

    public static void main(String[] args){
	int[] test={15,12,16,2,4,9,85,21,36}; 
	int[] test1={2,51,1,55,-3,25,-999,42};
	int[] testSizes={2,5,10,1000,15201,545464,9999999};
	int[] test2=new int[testSizes[2]];
	//**All highlighted stuff below means I tried using ArrayList to add elements in order one by one (no duplicates) and 
	//create final array with those elements shuffled
	if (test2.length>0){
	    Random r=new Random();
	    //ArrayList<Integer> temp = new ArrayList<Integer>();
	    for (int i=0;i<test2.length;i++){
		test2[i]=r.nextInt(test2.length);
		//temp.add(test2[i]);
	    }
	}
	//Array -> ArrayList conversion from: http://www.programcreek.com/2013/04/how-to-convert-array-to-arraylist-in-java/
	//ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(test2));
	//System.out.println(Collections.shuffle(temp));
	//test2=temp.toArray();
	System.out.println(Arrays.toString(test2));
	System.out.println(Arrays.toString(quicksort(test2)));
    }
}