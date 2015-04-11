import java.util.*;

public class MyStack<T> extends MyLinkedList<T>{
    //int size;
    //LNode<T> head;

    public MyStack(){
	//size=0;
	//head=null;
    }

    public boolean isEmpty(){	
	return size()==0;
    }

    public T push(T item){	
	/*
	if (isEmpty()){
	    head=new LNode<T>(item,null);
	}else{
	    LNode<T> temp=new LNode<T>(item,null);
	    temp.setNext(head);
	    head=temp;
	}
	size++;
	return item;
	*/
	add(0,item);
	return item;
    }

    public T pop(){
	/*
	if (isEmpty()){
	    throw new EmptyStackException();
	}
	T out=head.getValue();
	head=head.getNext();
	size--;	
	return out;
	*/
	return remove(0);
    }

    public T peek(){
	/*
	if (isEmpty()){
	    throw new EmptyStackException();
	}
	T out=head.getValue();
	return out;
	*/
	return get(0);
    }

    public static void main(String[] args){
	MyStack<Integer> test=new MyStack<Integer>();
	System.out.println(test.push(0));
	System.out.println(test.push(-5));
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