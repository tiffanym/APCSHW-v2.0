import java.util.*;
public class MyHeap{
    int[] heap;
    boolean isMaxHeap;

    public MyHeap(){ //creates a max heap
	isMaxHeap=true;
	heap=new int[10];
    }

    public MyHeap(boolean isMax){ //-> creates a max-heap when boolean is true, min-heap when the boolean is false
	isMaxHeap=isMax;
	heap=new int[10];
    }

    public String toString(){
	//print array first
	//Worry about later: based on height of tree and which level you're on, can make printing shape of tree; when is full
	//use boolean later to print simple array vs tree-looking array
	System.out.print("Index: ");
	for (int i=0;i<heap.length;i++){
	    System.out.printf("%-4d",i);
	}
	System.out.println();
	System.out.print("Value: ");
	for(int i : heap){
	    System.out.printf("%-4d",i);
	}
	return "";
    }

    public int remove(){ //remove the root and return the value  O(logn)
	int root=heap[1];
	if (root==0){
	    throw new NoSuchElementException("Add something first!!!");
	}
	//switch root with last element;
	heap[1]=heap[heap[0]];
	heap[heap[0]]=0;	
	heap[0]--;
	
	//then swap till everything is back in place
	int eliIndex=1;
	int li=eliIndex*2; //left index
	int ri=eliIndex*2+1; //right index		
	if (isMaxHeap){
	    int max=Math.max(heap[li],heap[ri]);
	    int maxIndex;	
	    while(eliIndex<heap[0] && max>heap[eliIndex] && (li<heap[0] || ri<heap[0])){
		if (heap[li]==max){
		    maxIndex=li;
		}else{
		    maxIndex=ri;
		}
		swap(maxIndex,eliIndex);
		eliIndex=maxIndex;			
		li=eliIndex*2;
		ri=eliIndex*2+1;
		max=Math.max(heap[li],heap[ri]);
	    }
	}else{ //minHeap
	    int min=Math.min(heap[li],heap[ri]);
	    int minIndex;	
	    while(eliIndex<heap[0] && min<heap[eliIndex] && (li<heap[0] || ri<heap[0])){
		if (heap[li]==min){
		    minIndex=li;
		}else{
		    minIndex=ri;
		}
		swap(minIndex,eliIndex);
		eliIndex=minIndex;			
		li=eliIndex*2;
		ri=eliIndex*2+1;
		min=Math.min(heap[li],heap[ri]);
	    }
	}
	return root;
    }

    public void add(int elligence){ //add the int to the heap  O(logn)
	//int si=1; //start index //si < data.length?
	if (heap[0]+1>=heap.length){
	    resize();
	}
	heap[heap[0]+1] = elligence;
	heap[0]++;
	int eliIndex=heap[0];
	if (isMaxHeap){
	    while (eliIndex>1 && heap[eliIndex]>heap[eliIndex/2]){ //will assume no duplicates for now
		swap(eliIndex,eliIndex/2);
		eliIndex=eliIndex/2;
	    }
	}else{ //minHeap	    
	    while (eliIndex>1 && heap[eliIndex]<heap[eliIndex/2]){ //will assume no duplicates for now
		swap(eliIndex,eliIndex/2);
		eliIndex=eliIndex/2;
	    }
	}
    }

    public int peek(){ // return the value of the root but do not remove it.  O(1)
	return heap[1];
    }

    public void resize(){
	//for maxHeap
	int[] temp = new int[heap.length*2];
	for (int i=0;i<heap.length;i++){
	    temp[i]=heap[i];
	}
	heap=temp;
    }

    public void swap(int i , int j){
	int temp=heap[j];
	heap[j]=heap[i];
	heap[i]=temp;
    }

    //Index: 0   1   2   3   4   5   6   7   8   9
    //Value: 6   9   10  32  16  50  40  0   0   0  -> 0= no element there
    //NOTE: index 0 is the COUNTER
    public static void main(String[] args){
	MyHeap test=new MyHeap();
	//test.remove();
	test.add(2);
	//System.out.println(test.toString());
	test.add(5);
	//System.out.println(test.toString());
	test.add(3);
	//System.out.println(test.toString());
	test.add(1);
	//System.out.println(test.toString());
	for (int i=14;i<25;i++){
	    test.add(i);
	    //System.out.println("Adding: "+i);
	    //System.out.println(test.toString());
	}
	System.out.println(test.toString());
	System.out.println("Remove root: "+test.remove());
	System.out.println(test.toString());
    }
}