import java.util.*;

public class MyStack<T>{
    int size;
    LNode<T> head;

    public MyStack(){
	size=0;
	head=null;
    }

    public boolean isEmpty(){	
	return size==0;
    }

    public T push(T item){	
	if (isEmpty()){
	    head=new LNode<T>(item,null);
	}else{
	    LNode<T> temp=new LNode<T>(item,null);
	    temp.setNext(head);
	    head=temp;
	}
	size++;
	return item;
    }

    public T pop(){
	if (isEmpty()){
	    throw new EmptyStackException();
	}
	T out=head.getValue();
	head=head.getNext();
	size--;	
	return out;
    }

    public T peek(){
	if (isEmpty()){
	    throw new EmptyStackException();
	}
	T out=head.getValue();
	return out;
    }

    //for testing purposes
    public String toString(){
	String ans="[ ";
	LNode<T> current=head;
	while (current!=null){
	    ans+=current.getValue()+" ";
	    current=current.getNext();
	}
	ans+="]";
	return ans;	
    }

    public static void main(String[] args){
	MyStack<Integer> test=new MyStack<Integer>();
	System.out.println(test.push(0));
	System.out.println(test.push(-5));
	System.out.println(test.toString());
	//System.out.println(test.push(3));
	//System.out.println(test.push(4));
	//System.out.println(test.pop());
	//System.out.println(test.pop());
	//System.out.println(test.pop());
	System.out.println(test.peek());
	//System.out.println(test.toString());
	System.out.println(test.push(3));
	//System.out.println(test.toString());
	System.out.println(test.peek());
	
	
    }
}