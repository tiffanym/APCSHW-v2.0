import java.util.*;
public class Sorts{
    int[] ary;
    MyHeap maxHeap;
    
    public Sorts(int[] ary){
	this.ary=ary;
	maxHeap = new MyHeap(true);
    }

    public void heapsort(int[] ary){
	heapify(ary);
	//loop
	////remove and place at end
	int count = ary.length-1;
	while (maxHeap.size()>0){
	    ary[count] = maxHeap.remove();
	    System.out.println("Adding "+ary[count]+
			       " from maxHeap to position "+count
			       +" in array");
	    count--;
	}
    }

    public void heapify(int[] ary){
	//MyHeap maxHeap = new MyHeap(true);
	for (int i : ary){
	    System.out.println("Adding "+i+" to maxHeap");
	    maxHeap.add(i);
	}
	System.out.println("Setting ary equal to maxHeap");
	System.out.println("MaxHeap:");
	System.out.print(maxHeap.toString());
	ary=maxHeap.whatsMyHeap();
    }

    public String toString(){
	System.out.println("MaxHeap:");
	System.out.print(maxHeap.toString());
	System.out.println("Array: "+Arrays.toString(ary));	
	return "";
    }

    public static void main(String[] args){
	int[] ary = {0,9,3,1,6,4,2,7};
	Sorts test = new Sorts(ary);	
	test.heapsort(ary);
	test.toString();
    }
}