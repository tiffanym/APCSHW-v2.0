/**FRONTIER class*/
import java.util.*;
public class Frontier{//is a deque
    int mode;
    MyDeque<Point> pile;
    private static final int BFS=0;
    private static final int DFS=1;
    private static final int BEST=2;
    private static final int ASTAR=3;

    //queue-->BFS =0
    //stack-->DFS =1
    public Frontier (int mode){	
	this.mode=mode;
	pile=new MyDeque<Point>();
    }
    
    public void add(Point next, int weight){
	pil.add(next,weight);
    }
    public void add(Point next){
	pile.addLast(next);
    }
    
    public Point remove(){
	Point out=null; //returns nothing if empty
	if (size()>0){
	    if (mode==1){ //DFS=stack
		out=pile.removeLast();
	    }else if (mode==0){ //BFS=queue
		System.out.println("Stuff will be removed");//added
		out=pile.removeFirst();
		System.out.println("Stuff removed: "+out);//added
	    }else{
		out=pile.removeSmallest();
	    }
	}else{
	    throw new NoSuchElementException();
	}
	return out;
    }
    
    public int size(){
	return pile.size();
    }
    
    public boolean hasNext(){
	return size()>0;
    }
    
    public String toString(){
	return pile.toString();
    }

    /*
    public Iterator<Point> iterator(){
	return new MyFrontierIterator<Point>(pile);
    }


    private class MyFrontierIterator<Point> implements Iterator<T>{
	MyDeque<Point> current;
	public MyLinkedListIterator(MyDeque<Point> current){
	    this.current=current;
	}
	public Point next(){
	    if (mode==1){ //DFS=stack
		current=current.removeLast();
	    }else if (mode==0){ //BFS=queue
		current=current.removeFirst();
	    }
	    if (hasNext()){
		Point out;
		if(mode==1){
		    out=current.getLast();
		}else if (mode==0){
		    out=current.getFirst();
		}
		return out;
	    }else{
		throw new NoSuchElementException();
	    }
	}
	public boolean hasNext(){
	    if(current.size()>0){
		return true;
	    }
	    return false;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    */
}
