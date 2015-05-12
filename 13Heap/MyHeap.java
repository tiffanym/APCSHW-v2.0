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
	return ""; //dummy
    }

    public int remove(){ //remove the root and return the value  O(logn)
	int root=heap[1];
	heap[0]--;
	return 0;//dummy
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
	    while (heap[eliIndex]>heap[eliIndex/2]){ //will assume no duplicates for now
		swap(eliIndex,eliIndex/2);
	    }
	}else{ //minHeap	    
	    while (heap[eliIndex]<heap[eliIndex/2]){ //will assume no duplicates for now
		swap(eliIndex,eliIndex/2);
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
	
    }
}