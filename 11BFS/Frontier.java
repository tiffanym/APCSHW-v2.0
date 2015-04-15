/**FRONTIER class*/
import java.util.*;
public class Frontier{//is a deque
    int mode;
    MyDeque<Point> pile;
    
    //queue-->BFS =0
    //stack-->DFS =1
    public Frontier (int mode){	
	this.mode=mode;
	pile=new MyDeque<Point>();
    }
    
    public void add(Point next){
	//if (mode==1){ //DFS=stack
	//    pile.addFirst(next);
	//}else if (mode==0){ //BFS=queue
	//    pile.addLast(next);
	//}
	//pile.addLast(next);
	pile.addLast(next);
    }
    
    public Point remove(){
	Point out=null; //returns nothing if empty
	if (size()>0){
	    if (mode==1){ //DFS=stack
		out=pile.removeLast();
	    }else if (mode==0){ //BFS=queue
		out=pile.removeFirst();
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
}