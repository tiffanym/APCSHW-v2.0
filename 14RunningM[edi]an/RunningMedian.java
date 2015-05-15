import java.util.*;
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
	    //System.out.println("MaxHeap size: "+maxHeap.size());
	    //System.out.println("MinHeap size: "+minHeap.size());
	    if (maxHeap.size()==0 || eger<maxHeap.peek()){
		//System.out.println("Adding to maxHeap");
		maxHeap.add(eger);
	    }else if ( minHeap.size()==0 || eger>=minHeap.peek()){
		//System.out.println("Adding to minHeap");
		minHeap.add(eger);
	    }
	}
    }

    public double getMedian(){
	resize();
	double median;
	if (maxHeap.size()==minHeap.size()){
	    //System.out.println("Median is avg of "+maxHeap.peek()+" and "+minHeap.peek());
	    median = (double)(maxHeap.peek() + minHeap.peek())/2.0;
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
		while (maxHeap.size()-1 > minHeap.size()){
		    minHeap.add(maxHeap.remove());
		}
	    }else if (minHeap.size()>maxHeap.size()){
		while (minHeap.size()-1 > maxHeap.size()){
		    maxHeap.add(minHeap.remove());
		}
	    }
	}
    }


    //for testing purposes
    public String toString(){
	resize();
	System.out.print("Max heap: ");
	System.out.println(maxHeap.toString());
	System.out.println();
	System.out.print("Min heap: ");
	System.out.println(minHeap.toString());
	System.out.println();
	System.out.println("Median: "+getMedian());
	return "";
    }
    public static void main(String[] args){
	RunningMedian test=new RunningMedian();
	Random r = new Random();
	test.add(4);
	//for (int i=0;i<1;i++){
	//    test.add(r.nextInt(500));
	//}
	test.add(42);
	test.add(2);
	test.toString();
    }

}