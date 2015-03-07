public class QS1{
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
}