public class LNode<T>{
    private T value;
    private LNode<T> next;

    //constructors
    public LNode(T value, LNode<T> next){
	setValue(value);
	setNext(next);
    }
    public LNode(T value){
	setValue(value);
	setNext(null);
    }

    public LNode(){
	//T temp= new T();
	setValue(null);
	setNext(null);
    }

    //get/set methods
    public T getValue(){
	return value;
    }
    public void setValue(T value){
	this.value=value;
    }
    public LNode<T> getNext(){
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