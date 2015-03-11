public class MyLinkedList{
    LNode head;
    //while (current.getNext()!=null){
    //	current=current.getNext();
    //}
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
	for (int posn=0;current.getNext()!=null && (posn< );posn++){ //finish this

	}
	return index;
    }
    public void set(int index, int value){ //yes exceptions

    }
    //check documentation for return types
    public void add(int value){

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

	//SIZE shoudl print 3
	System.out.println(test.size());
	
	//why so long to compile though? T.T 
	//(longer than i think it should take,anyway)	
    }
}