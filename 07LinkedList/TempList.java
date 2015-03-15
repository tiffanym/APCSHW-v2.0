import java.util.*;
public class TempList{
    LNode head, current, tail;
    int size;

    public TempList(){
	head=null;
	tail=head;
	size=0;
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
	if (index<0){
	    throw new IndexOutOfBoundsException();
	}
	else if (index>=size){
	    add(value);
	}else{
	    int posn=0;
	    while(current.getNext()!=null && posn<index-1){
		current=current.getNext();
		posn++;
	    }
	    LNode temp=new LNode(value,current.getNext());
	    current.setNext(temp);
	    size++;
	}
    }

    public int get (int index){
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

    public int indexOf(int value){
	for (int posn=0;current.getNext()!=null;posn++){
	    if (current.getValue()==value){
		return posn;
	    }
	    current=current.getNext();
	}
	throw new NoSuchElementException(value+" not in linked list");
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
	TempList test=new TempList();
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
	System.out.println(test.get(15));

	//INDEXOF(value)
	System.out.println(test.indexOf(14));
	System.out.println(test.indexOf(200));
    }
}