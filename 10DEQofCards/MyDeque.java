public class MyDeque<T>{
    T[] data;
    int head,tail;

    public void addFirst(T value){
	
    }

    public void addLast(T value){
	if (tail==data.length){
	    

	}
    }
    
    public T removeFirst(){
	if (data.length==0){
	    throw new NoSuchElementException();
	}else{
	    data[0]==null;
	}
    }

    public T removeLast(){
	if (data.length==0){
	    throw new NoSuchElementException();
	}else{
	    data[data.length-1]==null;
	}
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
	MyDeque test=new MyDeque();
	
    }
}