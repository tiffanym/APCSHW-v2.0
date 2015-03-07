import java.util.*;

public class QuickSelect{
    /**Partitions an array about a randomly chosen pivot element
     *@param ary the array being partitioned
     *@param si the start index
     *@param ei the end index
     *@return the elements in ary between indices si and ei are partitions
     */
    public static void partition(int[]ary, int si, int ei){
	int[] d= new int[ary.length]; //new empty array of same size as ary
	for (int i=0;i<ary.length;i++){
	    if (i<si || i>ei){
		d[i]=ary[i]; //copy all elements not in range si to ei to the new array
	    }
	}
	int ri=si+(int)(Math.random()*(ei-si+1));
	int pivot= ary[ri]; //select a random pivot element and pull it out of the array
	for (int n=si;si!=ei;n++){
	    if (ary[n]<pivot){
		d[si]=ary[n];
		si+=1;
	    }
	    if(ary[n]>pivot){
		d[ei]=ary[n];
		ei-=1;
	    }
	}
	d[ei]=pivot;
    }

    public static int partitionMain(int[]ary, int si, int ei, int index){
	QuickSelect.partitionIP(ary,si,ei,index);
	System.out.println("Index: "+index);
	return ary[index];
    }

    //in place quickselect
    public static int[] partitionIP(int[]ary, int si, int ei, int index){ //looking for element at given index
	System.out.println("Current Array: "+Arrays.toString(ary)); //
	if ((si==index && ei==index+1) || (si==index-1 && ei==index)){
	    return ary;
	}
	//if ((si==0 && ei==0) || (si==ary.length && ei==ary.length)){
	//    return ary;
	//}
	if (ary.length>1 && ei-si>0){ //or 1?
	    int[] d= new int[ary.length];	    
	    for (int i=0;i<ary.length;i++){
		if (i<si || i>ei){
		    d[i]=ary[i];
		}
	    }
	    System.out.println("Copied Array: "+Arrays.toString(d)+"\n"+"Start: "+si+"\n"+"End: "+ei); //
	    
	    int ri=si+(int)(Math.random()*(ei-si+1));
	    int pivot= ary[ri];
	    System.out.println("pivot: "+ pivot); //
	    int origEnd=ei;
	    for (int n=si;n<ary.length ;n++){
		if (n<=origEnd && si<=ei){
		    //if (si<=ei){
		    if (ary[n]<pivot){
			System.out.println("Start: "+si); //
			d[si]=ary[n];
			si+=1;			
		    }
		    if(ary[n]>pivot){
			System.out.println("End: "+ei); //
			d[ei]=ary[n];
			ei-=1;
		    }
		    System.out.println(Arrays.toString(d)); //
		}
	    }
	    d[ei]=pivot;
	    if (index<si){
		partitionIP(d,0,si-1,index);
	    }
	    if (index>ei){
		partitionIP(d,ei+1,d.length-1,index);
	    }
	    return d;
	}
	return ary;
    }

    public static void main(String[] args){
	Random r= new Random();
	//int[] ary={15,12,16,2,4,9,85,21,36};
	//partition(ary,2,5);  
	int[] test={2,5,6,1,8,0,9,7,4,3};
	System.out.println(partitionMain(test,0,test.length-1,r.nextInt(test.length)));
    }
}