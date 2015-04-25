import java.util.*;
public class MyDeque<T>{
    Object[] data;
    int head,tail;
    int size;
    int[] weights;

    public MyDeque(){
	data=new Object[10];
	head=0;
	tail=size-1;
	size=0;
	weights=new int[10];
    }
    //h--,insert
    public void addFirst(T value){
	resize();
	head--;
	if (head<0){
	    head+=data.length;
	}
	data[head]=value;
	size++;
    }
    //t++,insert
    public void addLast(T value){
	resize();
	tail++;	
	if (tail==data.length){
	    tail=tail%data.length;
	}
	data[tail]=value;
	size++;
    }
    
    public T removeFirst(){
	if (size==0 || data.length==0){
	    throw new NoSuchElementException();
	}
	resize();
	System.out.println("Array: "+toString(DATA));
	Object temp=data[0];
	data[head]=null;
	head++;
	size--;
	return (T)temp;
    }

    public T removeLast(){
       	if (size==0 || data.length==0){
	    throw new NoSuchElementException();
	}	
	Object temp=data[tail];
	data[tail]=null;
	tail--;
	size--;
	return (T)temp;
    }

    public T getFirst(){
	return (T)data[head];
    }

    public T getLast(){
	return (T)data[tail];
    }

    public void resize(){
	int temp=data.length;
	if (size==data.length){
	    temp=2*data.length;
	}
	Object[] out=new Object[temp];
	int[] newWeights=new int[temp];
	if (head<=tail){
	    for (int i=head;i<tail+1;i++){
		out[i]=data[i];
		newWeights[i]=weights[i];
	    }
	}else{ //tail<head
	    for (int i=0;i<tail;i++){
		out[i]=data[i];
		newWeights[i]=weights[i];
	    }
	    for (int i=head;i<data.length;i++){
		out[i]=data[i];
		newWeights[i]=weights[i];
	    }
	}
	data=out;
	weights=newWeights;
	head=0;
	if (size>0){
	    tail=size-1;
	}
    }



    /**PRIORITY QUEUE*/
    public void add(T value,int weight){
	//resize();
	addLast(value);
	weights[tail]=weight;
	//tail++;
	//resize();
	
    }
    
    public T removeSmallest(){
	if (size==1){
	    size--;
	    return (T)data[head];
	}
	resize();
	int indexOut=head;
	int weight=weights[head];
	if (size>1){
	    int i=head;
	    int end;
	    if (head<tail){
		end=tail;
	    }else{
		end=weights.length+tail;
	    }
	    while (i<=end){
		int index=i%weights.length;
		if (weights[index]<weight){
		    weight=weights[index];
		    indexOut=index;
		}
		i++;
	    }
	}

	T min=(T)data[indexOut];
	System.out.println("Replaced "+data[indexOut]+" with "+data[head]);
	data[indexOut]=data[head];
	System.out.println("Replaced "+weights[indexOut]+" with "+weights[head]);
	weights[indexOut]=weights[head];
	System.out.println("Replaced "+data[indexOut]+" with null");
	data[head]=null;	
	System.out.println("Replaced "+weights[indexOut]+" with -1");
	weights[head]=-1;
	head=(head+1)%data.length;
	System.out.println("Head now equals: "+head);
	size--;
	System.out.println("Size is now: "+size);
	return min;
    }

    /**PRIORITY QUEUE*/



    //EXTRA: For Maze.java (with BFS and DFS to work)
    public int size(){
	return size;
    }
    
    public boolean isEmpty(){
	return size==0;
    }

    
    //for toString:
    private static final int DATA=0;
    private static final int WEIGHT=1;
    public String toString(int mode){
	resize();
	String ans="[";
	if (mode==DATA){
	    for (int i=head;i<=tail;i++){
		ans+=data[i]+",";
		/* //I think this part was to print out stuff in Frontier class
		if (i%2==0){
		    ans+="("+data[i]+",";
		}else{
		    ans+=data[i]+")";
		    //if (i!=tail-1){
		    //	ans+=",";
		    //}
		}
		*/
	    }
	}else if (mode==WEIGHT){
	    //for (int i : weights){
	    for (int i=head;i<=tail;i++){
		//ans+=""+i+",";
		ans+=weights[i]+",";
	    }
	}
	return ans.substring(0,ans.length()-1)+"]";
    }
    

    //EXTRA: For Maze.java (with BFS and DFS to work)


    public static void main(String[] args){
	MyDeque<Integer> test=new MyDeque<Integer>();
	/*
	//ADDLAST
	test.addLast(new Integer(0));
	System.out.println("last: "+test.getLast()); //addLast seems to work when adding first element to an empty array
	for (int i=0;i<5;i++){
	    test.addLast(new Integer(i+10));
	    System.out.println("last: "+test.getLast());
	} //yay!!! addLast seems to work even when pushed past boundaries of array (meaning resize also works...!)
	
	//ADDFIRST
	test.addFirst(new Integer(5));
	System.out.println("first: "+test.getFirst()); //addFirst works with adding one element
	for (int i=0;i<5;i++){
	    test.addFirst(new Integer(i+20));
	    System.out.println("first: "+test.getFirst());
	}

	//REMOVEFIRST
	test.addFirst(new Integer(-2));
	System.out.println("removed: "+test.removeFirst());

	//REMOVELAST
	*/

	//For PRIORITY QUEUE
	test.add(12,2);
	System.out.println("Data: "+test.toString(0));
	System.out.println("Priority: "+test.toString(1));

	test.add(3,4);
	System.out.println("Data: "+test.toString(0));
	System.out.println("Priority: "+test.toString(1));

	test.add(2,8);
	System.out.println("Data: "+test.toString(0));
	System.out.println("Priority: "+test.toString(1));

	System.out.println(test.removeSmallest());
	System.out.println("Data: "+test.toString(0));
	System.out.println("Priority: "+test.toString(1));
    }
}
