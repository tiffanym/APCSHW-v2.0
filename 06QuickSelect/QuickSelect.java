import java.util.*;

public class QuickSelect{

    //in place quickselect
    public static int partitionIP(int[]ary, int si, int ei, int index){ //looking for element at given index
	System.out.println("Current Array: "+Arrays.toString(ary)); //
	int[] d= Arrays.copyOf(ary,ary.length);
	System.out.println("Start: "+si+"\n"+"End: "+ei); //
	
	int ri=si+(int)(Math.random()*(ei-si+1));
	int pivot= ary[ri];
	System.out.println("pivot: "+ pivot); //
	int start=si;
	int end=ei;
	for (int n=si;n<=ei ;n++){
	    if (ary[n]<pivot){
		d[start]=ary[n];
		start++;			
	    }
	    if(ary[n]>pivot){		    
		d[end]=ary[n];
		end--;
	    }
	}
	d[start]=pivot;
	System.out.println(Arrays.toString(d)); //
	int ans;
	if (start==index){
	    ans= d[start];
	}else{

	    ary=Arrays.copyOf(d,d.length);
	    
	    if (index<start){
		ans=partitionIP(ary,si,start-1,index);
	    }else{
		ans=partitionIP(ary,start+1,ei,index);       
	    }
	}
	return ans;
    }

    public static void main(String[] args){
	Random r= new Random();
	//int[] ary={15,12,16,2,4,9,85,21,36};
	//partition(ary,2,5);  
	int[] test={2,5,6,1,8,0,9,7,4,3};
	//int[] test={2,0,4,1,3};
	int num=r.nextInt(test.length);
	System.out.println("Index: "+num);
	int fin= partitionIP(test,0,test.length-1,num);
	System.out.println(fin);
	//System.out.println(partitionIP(test,0,test.length-1,r.nextInt(test.length)));
	//System.out.println(Arrays.toString(fin));
    }
}