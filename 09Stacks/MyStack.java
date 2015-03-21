public class MyStack<T>{
    int size;
    LNode<T> head;

    public MyStack(){
	size=0;
	head=null;
    }

    public T push(T item){
	if (size==0){
	    head=new LNode<T>(item,null);
	}else{
	    LNode<T> temp=new LNode<T>(item,null);
	    temp.setNext(head);
	    head=temp;
	}
	return item;
    }

    public static void main(String[] args){
	
    }
}