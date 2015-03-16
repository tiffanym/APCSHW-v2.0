public class LNode<T>{
    private int value;
    private LNode<T> next;

    //constructors
    public LNode(int value, LNode<T> next){
	setValue(value);
	setNext(next);
    }
    public LNode(int value){
	setValue(value);
	setNext(null);
    }

    public LNode(){
	setValue(0);
	setNext(null);
    }

    //get/set methods
    public int getValue(){
	return value;
    }
    public void setValue(int value){
	this.value=value;
    }
    public LNode getNext(){
	return next;
    }
    public void setNext(LNode<T> next){
	this.next=next;
    }
    
    //toString method
    public String toString(){
	return ""+value+next;
    }

    //main method
    public static void main(String[] args){

    }
}