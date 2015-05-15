public class RunningMedian{
    MyHeap maxHeap; //holds everything less than the median
    MyHeap minHeap; //holds everything greater than the median
    
    public RunningMedian(){
	maxHeap=new MyHeap(true);
	minHeap=new MyHeap(false);
    }
    
}