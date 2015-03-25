public class MyDeque<T>{
    T[] data;
    int head,tail;

    public void addFirst(T value){
	
    }

    public void addLast(T value){
	if (t==data.length){
	    
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

    public T[] resize(){
	
    }
    
    public static void main(String[] args){
	
    }
}