import java.util.*;
public class MyDeque<T>{
    T[] data;
    int head,tail;
    int size;

    public MyDeque(){
	data=new T[10];
	head=0;
	tail=0;
	size=0;
    }
    //h--,insert
    public void addFirst(T value){
	resize();
	if (head<0){
	    head+=data.length;
	}
	data[head]=value;
	head--;
	size++;
    }
    //t++,insert
    public void addLast(T value){
	resize();
	if (tail==data.length){
	    tail=tail%data.length;
	}
	data[tail]=value;
	tail++;	
	size++;
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
	}
	T out=new T[temp];
	if (head<=tail){
	    for (int i=head;i<tail+1;i++){
		out[i]=data[i];
	    }
	}else{ //tail<head
	    for (int i=0;i<tail;i++){
		out[i]=data[i];
	    }
	    for (int i=head;head<data.length;i++){
		out[i]=data[i];
	    }
	}
	data=out;
	head=0;
	if (size>0){
	    tail=size-1;
	}
    }
    
    public static void main(String[] args){
	MyDeque<Integer> test=new MyDeque<Integer>();
	test.addLast(0);
    }
}