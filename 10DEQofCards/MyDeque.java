import java.util.*;
public class MyDeque<T>{
    T[] data;
    int head,tail;
    int size;

    public MyDeque(){
	head=0;
	tail=0;
	size=0;
    }

    public void addFirst(T value){
	if (head==data.length){
	    resize(data.length+1); //change so that everything moves forward and can add to front?
	}
	data[head]==value;
	head++;
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

    public void resize(){
	int temp=data.length;
	if (size==data.length){
	    temp=2*data.length;
	}else if (size<(int)(0.25*data.length)){
	    temp=(int)(0.5*data.length);
	}
	T out=new T[temp];
	for (int i=0;i<data.length && i<temp;i++){
	    out[i]=data[i];
	}
	data=out;
    }
    
    public static void main(String[] args){
	MyDeque<Integer> test=new MyDeque<Integer>();
	test.addLast(0);
    }
}