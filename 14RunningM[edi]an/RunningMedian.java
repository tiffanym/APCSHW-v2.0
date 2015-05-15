public class RunningMedian{
    MyHeap maxHeap; //holds everything less than the median
    MyHeap minHeap; //holds everything greater than the median
    //int median;
    
    public RunningMedian(){
	maxHeap=new MyHeap(true);
	minHeap=new MyHeap(false);
    }
    
    public void add(int eger){
	if (maxHeap.size()==0 && minHeap.size()==0){
	    maxHeap.add(eger);
	}else{
	    resize();
	    if (eger<maxHeap.peek()){
		maxHeap.add(eger);
	    }else{
		minHeap.add(eger);
	    }
	}
    }

    public double getMedian(){
	double median;
	if (maxHeap.size()==minHeap.size()){
	    median = (double)(maxHeap.peek() + minHeap.size())/2.0;
	}else{
	    if (maxHeap.size()>minHeap.size()){
		median = (double)(maxHeap.peek());
	    }else{
		median = (double)(minHeap.peek());
	    }
	}
	return median;
    }

    public void resize(){
	if (Math.abs(maxHeap.size()-minHeap.size())>1){
	    if (maxHeap.size()>minHeap.size()){
		while (maxHeap.size()-1 != minHeap.size()){
		    minHeap.add(maxHeap.remove());
		}
	    }else if (minHeap.size()>maxHeap.size()){
		while (minHeap.size()-1 != maxHeap.size()){
		    maxHeap.add(minHeap.remove());
		}
	    }
	}
    }

}