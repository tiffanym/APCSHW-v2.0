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
	int ri=si+(Math.random()*(ei-si+1));
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

    //in place quickselect
    public static int[] partitionIP(int[]ary, int si, int ei){
	System.out.println("Current Array: "+ary); //
	if (ary.length==1){
	    return ary;
	}
	if (ary.length>1){
	    int[] d= new int[ary.length];
	    for (int i=0;i<ary.length;i++){
		if (i<si || i>ei){
		    d[i]=ary[i];
		}
	    }
	    
	    int ri=si+(int)(Math.random()*(ei-si+1));
	    int pivot= ary[ri];
	    System.out.println("pivot: "+ pivot); //
	    for (int n=si;si<=ei;n++){
		if (ary[n]<pivot){
		    d[si]=ary[n];
		    si+=1;
		}
		if(ary[n]>pivot){
		    d[ei]=ary[n];
		    ei-=1;
		}
		System.out.println(d); //
	    }
	    d[ei]=pivot;
	    partitionIP(d,si/2,si);
	    partitionIP(d,ei,(d.length-ei)/2);
	    return d;
	}
    }

    public static void main(String[] args){
	//int[] ary={15,12,16,2,4,9,85,21,36};
	//partition(ary,2,5);  
	int[] test={2,5,6,1,8,0,9,7,4,3};
	System.out.println(test.partitionIP(test,0,test.length-1));
    }
}