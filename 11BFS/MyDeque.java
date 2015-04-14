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



    /**PRIORITY QUEUE*/
    public void add(T object,int index){
	
    }
    
    public T removeSmallest(){	
	T min=(T)data[0];
	int indexOut=0;
	for (int i=0;i<size;i++){
	    //if (min.compareTo(data[i])>0){ //this.compareTo(arg)>0 => arg<this
	    if(min>data[i]){
		min=(T)data[i];
		indexOut=i;
	    }
	}
	data[indexOut]=0;
	return min;
    }

    //public void resize(){
    //}    
    /**PRIORITY QUEUE*/



    //EXTRA: For Maze.java (with BFS and DFS to work)
    public int size(){
	return size;
    }
    
    public boolean isEmpty(){
	return size==0;
    }
    /*
    public Iterator<T> iterator(){
	return new MyDequeIterator<T>();
    }
    //from http://codereview.stackexchange.com/questions/56361/generic-deque-implementation
    private class DequeIterator implements Iterator<T> {	
	private Node<T> curr = head;
	
	public boolean hasNext() {
	    return curr != null;
	}
	public void remove() {
	    throw new UnsupportedOperationException();
	}
	public T next() {
	    if (!hasNext()) { throw new NoSuchElementException(); }
	    T item = curr.item;
	    curr = curr.right;
	    return item;
	}
    }
    */

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