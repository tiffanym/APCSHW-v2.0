import java.util.*;
public class MyDeque<T>{
    T[] data;
    int head,tail;

    public void addFirst(T value){
	
    }

    public void addLast(T value){
	if (tail==data.length){
	    resize(data.length+1);
	}
	data[tail]=value;
	tail++;	
    }
    
    public T removeFirst(){
	if (data.length==0){
	    throw new NoSuchElementException();
	}
	T temp=data[0];
	data[head]=null;
	head++;
	return temp;
    }

    public T removeLast(){
	if (data.length==0){
	    throw new NoSuchElementException();
	}	
	T temp=data[tail];
	data[tail]=null;
	tail--;	
	return temp;
    }

    public T getFirst(){
	return data[0];
    }

    public T getLast(){
	return data[data.length-1];
    }

    public void resize(int size){
	T[] out=new T[size];
	if (size==data.length){
	    out=data;
	}else if (size<data.length){
	    for (int i=0;i<size;i++){
		out[i]=data[i];
	    }
	}else{ //size>data.length
	    for (int i=0;i<data.length;i++){
		out[i]=data[i];
	    }
	}
	data=out;
    }
    
    public static void main(String[] args){
	MyDeque<Integer> test=new MyDeque<Integer>();
	test.addLast(0);
    }
}