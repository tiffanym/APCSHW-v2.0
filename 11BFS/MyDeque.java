import java.util.*;
public class MyDeque<T>{
    Object[] data;
    int head,tail;
    int size;

    public MyDeque(){
	data=new Object[10];
	head=0;
	tail=size-1;
	size=0;
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
	Object temp=data[0];
	data[head]=null;
	head++;
	return (T)temp;
    }

    public T removeLast(){
       	if (size==0 || data.length==0){
	    throw new NoSuchElementException();
	}	
	Object temp=data[tail];
	data[tail]=null;
	tail--;	
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
	if (head<=tail){
	    for (int i=head;i<tail+1;i++){
		out[i]=data[i];
	    }
	}else{ //tail<head
	    for (int i=0;i<tail;i++){
		out[i]=data[i];
	    }
	    for (int i=head;i<data.length;i++){
		out[i]=data[i];
	    }
	}
	data=out;
	head=0;
	if (size>0){
	    tail=size-1;
	}
    }

    //EXTRA: For Maze.java (with BFS and DFS to work)
    public int size(){
	return size;
    }
    //EXTRA: For Maze.java (with BFS and DFS to work)

    public static void main(String[] args){
	MyDeque<Integer> test=new MyDeque<Integer>();
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
	
    }
}