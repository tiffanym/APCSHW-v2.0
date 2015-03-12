public class MyLinkedList{
    LNode head;
    LNode current; //copy of head

    public MyLinkedList(LNode head){
	this.head=head;
	current=new LNode(head.getValue(),head.getNext());
    }
    public MyLinkedList(){
	head=new LNode();
	current=new LNode(head.getValue(),head.getNext());
    }

    public String toString(){ //no exceptions
	String L="[ ";
	while (current.getNext()!=null){
	    L+=current.getValue()+" ";
	    current=current.getNext();
	}
	L+=current.getValue()+" ]";
	return L;
    }

    public int get(int index){ //yes exceptions
	try{
	    int posn=0;
	    while (current.getNext()!=null){
		if(posn==index){
		    return current.getValue();
		}
		current=current.getNext();
		posn+=1;
	    }
	    if (posn==index){
		return current.getValue();
	    }
	}catch(IndexOutOfBoundsException e){
	    System.out.println("Index out of Bounds");
	}
	return 0;
    }

    //returns element previously at specified position
    public void set(int index, int value){ //yes exceptions
	
    }

    //check documentation for return types
    public boolean add(int value){ //something going on here that makes it not work...
	//int posn=0;
	//while (current.getNext()!=null){
	//    posn+=1;
	//    current=current.getNext();
	//}
	//current.setValue(value);	
	return true;
    }

    public void add(int index, int value){

    }

    public int remove(int index){
	return index;
    }

    public int size(){
	int size=0;
	while (current.getNext()!=null){
	    size+=1;
	    current=current.getNext();
	}
	size+=1;
	return size;
    }

    public int indexOf(int value){
	return value;
    }

    public static void main(String[] args){
	LNode help2=new LNode(9,null);
	LNode help1=new LNode(2,help2);	
	LNode head=new LNode(3,help1);
	MyLinkedList test=new MyLinkedList(head);
	//TOSTRING should print "[ 3 2 9 ]"
	//System.out.println(test.toString()); //works

	//SIZE should print 3
	//System.out.println(test.size()); //works
	
	//why so long to compile though? T.T 
	//(longer than i think it should take,anyway)	

	//GET
	//System.out.println(test.get(2)); //works (returns 9; get(1) returns 2)
	//System.out.println(test.get(5)); //works (returns 0)

	//ADD
	test.add(6);
	System.out.println(test.toString());
    }
}