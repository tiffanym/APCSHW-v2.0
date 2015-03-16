import java.util.*;
public class MyLinkedList{
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

    public boolean add(int value){
	if (size==0){
	    head=new LNode(value,null);
	    tail=head;
	    current=head;
	}else{
	    while (current.getNext()!=null){
		current=current.getNext();
	    }
	    current.setNext(new LNode(value,null));
	    tail=current.getNext();
	}
	size++;
	return true;
    }

    public void add(int index,int value){
	current=head;
	if (index<0 || index>=size){
	    throw new IndexOutOfBoundsException();
	}else{
	    int posn=0;
	    while(current.getNext()!=null && posn<index-1){
		current=current.getNext();
		posn++;
	    }
	    LNode<T> temp=new LNode(value,current.getNext());
	    current.setNext(temp);
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
	T out; //I don't need to initialize... right?
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
	T before; //initilize? (compile to see)
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
	current=new LNode(head.getValue(),head.getNext());
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

    public static void main(String[] args){
	//make test conditions

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