public class MyLinkedList{
    LNode head;
    LNode current; //copy of head
    LNode tail; //keeps track of last node
    int size=0;

    public MyLinkedList(LNode head){
	this.head=head;
	current=new LNode(head.getValue(),head.getNext());
	tail=new LNode(current.getValue(),current.getNext());
	while (tail.getNext()!=null){
	    tail=tail.getNext();
	}
	size();
    }
    public MyLinkedList(){
	head=new LNode();
	current=new LNode(head.getValue(),head.getNext());
	tail=head;
	size();
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
    public int set(int index, int value){ //yes exceptions
	if(index>=0 && index<=size){
	    for (int posn=0;current.getNext()!=null && posn<index;posn++){
		current=current.getNext();
	    }
	    int out=current.getValue();
	    current.setValue(value);
	    return out;
	}else{
	    System.out.println("Index out of Bounds!");
	    return -1;
	}	
    }

    public boolean add(int value){
	if (size==0){
	    head=new LNode(value,null);
	}else{
	    for (int i=0;i<size;i++){
		current=current.getNext();
	    }
	    current.setNext(new LNode(value));	    
	}
	return true;
    }

    public void add(int index, int value){
	if (index==0){
	    LNode temp=new LNode(value,head);
	    head=temp;
	}
	else if (index==size){
	    add(value);
	}
	else if(index>0 && index<size){
	    LNode temp=new LNode(value);
	    for (int posn=0;current.getNext()!=null && posn<index;posn++){
		current=current.getNext();
	    }
	    temp.setNext(current);
	    current.setNext(temp);    
	}
	else{
	    System.out.println("Index out of Bounds!");
	}
    }

    public int remove(int index){
	if(index>=0 && index<=size){
	    for (int posn=0;current.getNext()!=null && posn<index;posn++){
		current=current.getNext();
	    }
	    int out=current.getValue();
	    current=current.getNext();
	    return out;
	}else{
	    System.out.println("Index out of Bounds!");
	    return -1;
	}
    }

    //public int size(){
    public void size(){
	while (current.getNext()!=null){
	    size+=1;
	    current=current.getNext();
	}
	size+=1;
    }

    public int indexOf(int value){
	for (int posn=0;current.getNext()!=null;posn++){
	    if (current.getValue()==value){
		return posn;
	    }
	    current=current.getNext();
	}
	return -1; //value not in linked list
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

	//ADD to end
	//System.out.println(test.add(6));

	//ADD to specific index
	//test.add(1,5); //It works!... I think.
	//test.add(5,4); //It prints out the message... so.... works?

	//INDEX-finds where a certain value is
	//System.out.println(test.indexOf(2)); //works
	//System.out.println(test.indexOf(5)); //works

	//REMOVE
	//System.out.println(test.remove(2)); //works 
	//System.out.println(test.remove(5)); //OMG... it works so far \(OoO)/
	
	//SET
	//System.out.println(test.set(2,12)); //OH.
	//System.out.println(test.set(-1,4)); //MY.
	//System.out.println(test.set(14,1)); //GAWD.

    }
}