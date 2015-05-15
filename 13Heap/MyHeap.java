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
	//code for straight out printing array with indexes aligned
	/*
	System.out.print("Index: ");
	for (int i=0;i<heap.length;i++){
	    System.out.printf("%-4d",i);
	}
	System.out.println();
	System.out.print("Value: ");
	for(int i : heap){
	    System.out.printf("%-4d",i);
	}
	*/
	int totalLevels=getHeight();
	for (int i=1 ; i<heap[0]+1 ; i++){
	    //current level
	    int level= (int)( (Math.log(i)) / (Math.log(2)) );
	    //spaces needed
	    //int spaces=totalLevels - level;
	    int spaces;
	    if (((int)(Math.pow(2,level))==i)){
		    System.out.println();
		    //System.out.print(addSpaces(spaces));
		    spaces = (int)(Math.pow(2,totalLevels-level)) - 1;
	    }else{
		//System.out.print(" ");
		spaces = (int)(Math.pow(2,totalLevels-level+1)) - 1;
	    }
	    System.out.print(addSpaces(spaces));
	    System.out.print(heap[i]);		    
	}
	return "";
    }

    public String addSpaces(int levels){
	return spacesHelp(levels, "");
    }

    public String spacesHelp(int levels, String ans){
	if (levels==0){
	    return ans;
	}else{
	    return " "+spacesHelp(levels-1,ans);
	}
    }

    public int getHeight(){
	return getHeightHelp(heap[0],0);
    }
    public int getHeightHelp(int curr,int count){ //curr=heap[0] //count starts at 0
	if (curr==0){
	    return count;
	}else{
	    return getHeightHelp(curr/2,count+1);
	}
    }
    
    public int getMaxRowSize(){
	return heap[0] + 1 - (int) Math.pow( 2.0 , (double) (getHeight() - 1));
    }

    public int remove(){ //remove the root and return the value  O(logn)
	int root=heap[1];
	if (heap[0]==0){ //size=0 means no elements inside
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
	    while(//(li<heap[0] && ri<heap[0]) && 
		  eliIndex<heap[0] && max>heap[eliIndex]){
		if (heap[li]==max){
		    maxIndex=li;
		}else{
		    maxIndex=ri;
		}
		swap(maxIndex,eliIndex);
		eliIndex=maxIndex;			
		li=eliIndex*2;
		//System.out.println("Left index: "+li);
		ri=eliIndex*2+1;
		//System.out.println("Right index: "+ri);
		//System.out.println("Getting max of li and ri");
		if (li>=heap[0] || ri>=heap[0]){
		    break;
		}
		max=Math.max(heap[li],heap[ri]);
	    }
	}else{ //minHeap
	    int min=Math.min(heap[li],heap[ri]);
	    int minIndex;	
	    while(//(li<heap[0] && ri<heap[0]) && 
		  eliIndex<heap[0] && min<heap[eliIndex] ){
		if (heap[li]==min){
		    minIndex=li;
		}else{
		    minIndex=ri;
		}
		swap(minIndex,eliIndex);
		eliIndex=minIndex;		
		li=eliIndex*2;
		//System.out.println("Left index: "+li);
		ri=eliIndex*2+1;
		//System.out.println("Right index: "+ri);
		//System.out.println("Getting max of li and ri");
		if (li>=heap[0] || ri>=heap[0]){
		    break;
		}
		min=Math.min(heap[li],heap[ri]);
	    }
	}
	//System.out.println("Successfully removed: "+ root);
	return root;
    }

    public void add(int elligence){ //add the int to the heap  O(logn)
	if (heap[0]+1>=heap.length){
	    resize();
	}
	heap[heap[0]+1] = elligence;
	heap[0]++;
	int eliIndex=heap[0];
	if (isMaxHeap){
	    while (eliIndex>1 && heap[eliIndex]>heap[eliIndex/2]){ //will assume no duplicates
		swap(eliIndex,eliIndex/2);
		eliIndex=eliIndex/2;
	    }
	}else{ //minHeap	    
	    while (eliIndex>1 && heap[eliIndex]<heap[eliIndex/2]){ //will assume no duplicates
		swap(eliIndex,eliIndex/2);
		eliIndex=eliIndex/2;
	    }
	}
    }

    public int peek(){ // return the value of the root but do not remove it.  O(1)
	if (heap[0]<1){
	    throw new NoSuchElementException("Add something first!!!");
	}else{
	    return heap[1];
	}
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

    //for RunningMedian
    public int size(){
	return heap[0];
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
	//System.out.println("Remove root: "+test.remove());
	//System.out.println(test.toString());
	
	//System.out.println(test.getHeight());
	//System.out.println(test.getMaxRowSize());
    }
}