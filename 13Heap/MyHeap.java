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

    public String toString(boolean isPrettyTree){
	//print array first
	//Worry about later: based on height of tree and which level you're on, can make printing shape of tree; when is full
	//use boolean later to print simple array vs tree-looking array
	if (isPrettyTree){
	}else{
	    System.out.print("Index: ");
	    for (int i=0;i<heap.length;i++){
		System.out.printf("%-4d",i);
	    }
	    System.out.println();
	    System.out.print("Value: ");
	    for(int i : heap){
		System.out.printf("%-4d",i);
	    }
	}
	return "";
    }

    public int remove(){ //remove the root and return the value  O(logn)
	int root=heap[1];
	//switch root with last element;
	heap[1]=heap[heap[0]];
	heap[heap[0]]=0;	
	heap[0]--;
	
	//then swap till everything is back in place (according to notes)
	if (isMaxHeap){

	}else{ //minHeap
	    //while(heap){

	    //}
	}
	return root;//dummy
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
	test.add(2);
	System.out.println(test.toString(false));
	test.add(5);
	System.out.println(test.toString(false));
	test.add(3);
	System.out.println(test.toString(false));
	test.add(1);
	System.out.println(test.toString(false));
	for (int i=14;i<25;i++){
	    test.add(i);
	    System.out.println("Adding: "+i);
	    System.out.println(test.toString(false));
	}
	
    }
}