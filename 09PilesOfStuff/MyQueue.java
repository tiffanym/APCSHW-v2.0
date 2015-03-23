public class MyQueue<T>{
    MyLinkedList<T> queue;

    public MyQueue(){
	queue=new MyLinkedList<T>();
    }

    public T enqueue(T n){
	queue.add(n);
	return n;
    }

    public T dequeue(){
	T temp=queue.remove(queue.size()-1);
	return temp;
    }

    public static void main(String[] args){
	MyQueue<Integer> test=new MyQueue<Integer>();
	//System.out.println(test.enqueue(0));
	//System.out.println(test.enqueue(1));
	for (int i=0;i<20;i++){
	    System.out.println(test.enqueue(i));
	}
	//System.out.println(test.enqueue("hola"));
	//System.out.println(test.enqueue(2));
	System.out.println(test.dequeue());
	System.out.println(test.dequeue()); //returns error... (when you're dequeueing an empty array)

    }
}