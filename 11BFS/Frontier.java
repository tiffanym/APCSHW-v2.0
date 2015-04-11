/**FRONTIER class*/
private class Frontier{//is a deque
    int mode;
    MyDeque<Coordinate> pile = new MyDeque<Coordinate>();
    
    //queue-->BFS =0
    //stack-->DFS =1
    public Frontier (int mode){
	this.mode=mode;
    }
    
    public void add(Coordinate next){
	if (mode==1){ //DFS=stack
	    pile.addFirst(next);
	}else if (mode==0){ //BFS=queue
	    pile.addLast(next);
	}	    
    }
    
    public Coordinate remove(){
	Coordinate out=null; //returns nothing if empty
	if (mode==1){ //DFS=stack
	    out=pile.removeFirst();
	}else if (mode==0){ //BFS=queue
	    out=pile.removeLast();
	}
	return out;
    }
    
    public int size(){
	return pile.size();
    }
}