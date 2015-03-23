import java.util.*;
import java.lang.*;
public class MyLinkedList<T> implements Iterable<T>{
    LNode<T> head, current, tail;
    int size;
    
    public MyLinkedList(){	
	head=null;
	tail=head;
	size=0;
    }

    public String name(){
	return "ming.tiffany";
    }

    public boolean add(T value){
	if (size==0){
	    head=new LNode<T>(value);
	    tail=head;
	    current=head;
	}else{
	    LNode<T> temp=new LNode<T>(value);
	    tail.setNext(temp);
	    tail=tail.getNext();
	}
	size++;
	return true;
    }

    public void add(int index,T value){
	current=head;
	if (index<0 || index>=size){
	    throw new IndexOutOfBoundsException();
	}else{
	    int posn=0;
	    while(current.getNext()!=null && posn<index-1){
		current=current.getNext();
		posn++;
	    }
	    T temp=current.getValue();
	    current.setValue(value);
	    current.setNext(new LNode<T>(temp,current.getNext()));
	    size++;
	}
    }

    public T get (int index){
	if (index<0 || index>=size){
	    throw new IndexOutOfBoundsException("Index "+index+" out of Bounds!");
	}else{
	    current=head;
	    int posn=0;
	    while (current.getNext()!=null && posn<index){
		current=current.getNext();
		posn++;
	    }
	    return current.getValue();
	}
    }

    public int indexOf(T value){
	for (int posn=0;current.getNext()!=null;posn++){
	    if (current.getValue()==value){
		return posn;
	    }
	    current=current.getNext();
	}
	throw new NoSuchElementException(value+" not in linked list");
    }

    public T remove(int index){
	T out; 
	if (index<0 || index>=size){
	    throw new IndexOutOfBoundsException("Index "+index+" out of Bounds!");
	}
	if (index==0){
	    out=head.getValue();
	    head=head.getNext();	 
	}
	else{
	    int posn=0;
	    current=head;
	    while (current.getNext()!=null && posn<index-1){
		current=current.getNext();
		posn++;
	    }
	    if (index==size-1){
		tail=current;
	    }
	    out=current.getNext().getValue();
	    current.setNext(current.getNext().getNext());	    
	    size--;;
	}
	return out;
    }

    public T set(int index,T value){
	T before;
	if (index<0 || index>=size){
	    throw new IndexOutOfBoundsException("Index "+index+" out of Bounds!");
	}
	else{
	    current=head;
	    int posn=0;
	    while (current.getNext()!=null && posn<index){
		current=current.getNext();
		posn++;
	    }
	    before=current.getValue();
	    if (index==size-1){
		tail.setValue(value);
	    }	    
	    current.setValue(value);
	}
	return before;
    }

    public String toString(){
	String L="[ ";
	current=head;
	while (current.getNext()!=null){
	    L+=current.getValue()+" ";
	    current=current.getNext();
	}
	L+=tail.getValue()+" ]";
	return L;
    }

    public int size(){
	return size;
    }

    //for Iterable interface
    public Iterator<T> iterator(){
	return new  MyLinkedListIterator<T>(head);
    }

    private class MyLinkedListIterator<T> implements Iterator<T>{
	LNode<T> current;

	public MyLinkedListIterator(LNode<T> current){
	    this.current=current;
	}

	public T next(){
	    current=current.getNext();
	    if (hasNext()){
		return current.getValue();
	    }else{
		throw new NoSuchElementException();
	    }
	}

	public boolean hasNext(){
	    if(current.getNext()!=null){
		return true;
	    }
	    return false;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }

    public static void main(String[] args){
	//

	/*
	//make test conditions
	MyLinkedList<Integer> testL=new MyLinkedList<Integer>();
	ArrayList<Integer> testA=new ArrayList<Integer>();
	
	int num=5;
	for (int i=0;i<num;i++){
	    testL.add(i);
	    testA.add(i);
	    System.out.println("Linked List: "+testL.toString());
	    System.out.println("Array List "+testA.toString());
	}

	//testL.add(2,6); //Mine adds before instead of after given index
	//testA.add(2,6);
	testL.add(0,6);
	testA.add(0,6);
	System.out.println("Linked List: "+testL.toString());
	System.out.println("Array List "+testA.toString());

	//testL.add(15,8);
	//testA.add(15,8);
	//System.out.println("Linked List: "+testL.toString());
	//System.out.println("Array List "+testA.toString());
	
	testL.remove(4);
	testA.remove(4);
	System.out.println("Linked List: "+testL.toString());
	System.out.println("Array List "+testA.toString());

	//testL.remove(15);
	//testA.remove(15);
	//System.out.println("Linked List: "+testL.toString());
	//System.out.println("Array List "+testA.toString());

	testL.set(2,8);
	testA.set(2,8);
	System.out.println("Linked List: "+testL.toString());
	System.out.println("Array List "+testA.toString());

	//testL.set(15,8);
	//testA.set(15,8);
	//System.out.println("Linked List: "+testL.toString());
	//System.out.println("Array List "+testA.toString());

	testL.get(4);
	testA.get(4);
	System.out.println("Linked List: "+testL.toString());
	System.out.println("Array List "+testA.toString());

	//testL.get(15);
	//testA.get(15);
	//System.out.println("Linked List: "+testL.toString());
	//System.out.println("Array List "+testA.toString());

	//testL.indexOf(8);
	//testA.indexOf(8);
	//System.out.println("Linked List: "+testL.toString());
	//System.out.println("Array List "+testA.toString());

	testL.size();
	testA.size();
	System.out.println("Linked List: "+testL.toString());
	System.out.println("Array List "+testA.toString());
	*/

	/*
	MyLinkedList test=new MyLinkedList();
	//ADD(value)
	test.add(1);
	test.add(2);
	test.add(3);
	test.add(-1);
	test.add(14);
	test.add(5);

	//TOSTRING()
	System.out.println(test.toString());

	//ADD(index,value)
	test.add(2,4);
	//test.add(16,6);

	System.out.println(test.toString());       
	//SIZE()
	System.out.println(test.size());
	
	//GET(index)
	System.out.println(test.get(2));
	//System.out.println(test.get(15));

	//INDEXOF(value)
	System.out.println(test.indexOf(14));
	//System.out.println(test.indexOf(200));

	//REMOVE(index)
	System.out.println("removed "+test.remove(4));
	System.out.println("removed "+test.remove(2));
	//System.out.println("removed "+test.remove(15));
	System.out.println(test.toString());       

	//SET(index,value)
	//System.out.println("Size:"+test.size());
	System.out.println("before set change: "+test.set(3,4));
	System.out.println("before set change: "+test.set(4,16));
	System.out.println(test.toString());
	*/
    }
}