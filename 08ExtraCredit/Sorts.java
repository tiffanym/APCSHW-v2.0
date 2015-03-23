import java.util.*;
import java.lang.*;

public class Sorts{
    //******MERGE SORT******//
    public static void mergeSort(int[] humanity){
	if (humanity.length>0){
	    mergeSortH(humanity);
	}
    }
    
    public static int[] mergeSortH(int[] humanity){
	int[] a=new int[humanity.length/2];
	int[] b=new int[humanity.length-a.length];
	
	if (humanity.length==1){
	    return humanity;
	}

	//putting elements in subarrays
	for (int i=0;i<a.length;i++){
	    a[i]=humanity[i];
	    b[i]=humanity[i+a.length];
	}
	if (b.length%2==1 || a.length%2==1){
	    b[b.length-1]=humanity[humanity.length-1];
	}
	
	return merge(mergeSortH(a),mergeSortH(b));
    }

    /**Merges the two given arrays into one sorted array
     *@param a One of the two arrays to be combined.
     *@param b The other of the two arrays to be combined.
     *@return An integer array with the contents of the two given arrays sorted
     */
    public static int[] merge(int[] a, int[] b){
	int[] sortAR=new int[a.length+b.length];
	//int posn=0;
	//int posnA=0;
	//int posnB=0;
	/*
	for (int i=0;posnA+posnB<sortAR.length && 
		 posnA<a.length && posnB<b.length;i++){
	    if (a[posnA]<b[posnB]){
		sortAR[posn]=a[posnA];
		posnA++;
	    }
	    else if (a[posnA]==b[posnB]){
		sortAR[posn]=a[posnA];
		posnA++;
		posn++;
		sortAR[posn]=b[posnB];
		posnB++;
	    }
	    else{ //b[i]<a[i]
		sortAR[posn]=b[posnB];
		posnB++;
	    }
	    posn++;
	}
	if (posnA<a.length){ //stuff left in a
	    for (int i=posnA;i<a.length;i++){
		sortAR[posn]=a[i];
		posn++;
	    }
	}
	else if (posnB<b.length){ //stuff left in b
	    for (int i=posnB;i<b.length;i++){
		sortAR[posn]=b[i];
		posn++;
	    }
	}
	*/
	ArrayList<Integer> a1= new ArrayList<Integer>(Arrays.asList(a));
	ArrayList<Integer> b1= new ArrayList<Integer>(Arrays.asList(b));
	ArrayList<Integer> temp= new ArrayList<Integer>(); //temp for sortAR;
	for (int posn=0;posn<a.length+b.length;posn++){
	    if (!a1.isEmpty() && !b1.isEmpty()){
		int n=a1.get(0)-b1.get(0);
		if (n<0){
		    temp.add(a1.remove(0));
		}else if (n==0){
		    temp.add(a1.remove(0));
		    temp.add(b1.remove(0));
		}else{
		    temp.add(b1.remove(0));
		}
	    }else if (!a1.isEmpty() && b1.isEmpty()){
		temp.add(a1);
		break;
	    }else if (a1.isEmpty() && !b1.isEmpty()){
		temp.add(b1);
		break;
	    }
	}
	
	for (int i=0;i<sortAR.length;i++){
	    //sortAR[i]=temp.remove(0).intValue();
	    int n=temp.remove(0);
	    sortAR[i]=n.intValue();
	}
	return sortAR;
    }
    
    //******QUICK SORT******// -->handle duplicates!!!!!
    /**Algorithm for an in-place Quick Select
     *@param ary Array you want to use
     *@param si Starting index
     *@param ei Ending index
     *@param index You want to find the (index)th smallest number
     *@return The element at ary[index] if array was sorted (so the (index)th smallest number of the given array)
     */
    public static int partition(int[]ary, int si, int ei, int index){ //looking for element at given index
	//System.out.println("Current Array: "+Arrays.toString(ary)); //
	//int[] d= Arrays.copyOf(ary,ary.length);
	int[] d=new int[ary.length];
	System.arraycopy(ary,0,d,0,ary.length);
	
	//System.out.println("Start: "+si+"\n"+"End: "+ei); //
	
	int ri=si+(int)(Math.random()*(ei-si+1));
	int pivot= ary[ri];
	//System.out.println("pivot: "+ pivot); //
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
	//System.out.println(Arrays.toString(d)); //

	int ans;
	if (start==index){
	    ans= d[start];
	}else{
	    //ary=Arrays.copyOf(d,d.length);
	    System.arraycopy(d,0,ary,0,d.length);
	    if (index<start){
		ans=partition(ary,si,start-1,index);
	    }else{
		ans=partition(ary,start+1,ei,index);       
	    }
	}
	return ans;
    }

    //******RADIX SORT******//     -->finish!!!!
    public static void radix(int[] data){
	//ArrayList() creates array list with initial capacity of 10
	//ArrayList<Integer> tempOld=new ArrayList<Integer>(10);
	int[][] tempOld=new int[10][];
	int place=1;
	for (int i : data){  //means "for each element i in data"
	    int digit= i%(int)Math.pow(10,place);
	    //arraylist add function: add (index, element)
	    //tempOld.add(digit,data[i]);
	    
	    //hm... how to add to temporary array thing
	    tempOld[digit][tempOld[digit].length]=data[i];
	    //not sure why above doesn't work....
	    place+=1;
	}
    }

    //add MyLinkedList into folder

    public static void main(String[] args){

    }
}
