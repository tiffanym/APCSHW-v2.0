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
	//current=new LNode(head.getValue(),head.getNext());
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
	    //if (current.getNext()!=null){
	    //	LNode temp=new LNode(value,current.getNext());
	    //	current.setNext(temp);
	    //	//current.setNext(new LNode(value,current.getNext()));
	    //}else{
	    //	current.setNext(new LNode(value,null));
	    //}
	    LNode temp=new LNode(value,current.getNext());
	    current.setNext(temp);
	    size++;
	}
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
	test.add(2,4); //Doesn't add 

	//test.add(16,6);
	System.out.println(test.toString());
	System.out.println(test.size());
    }
}