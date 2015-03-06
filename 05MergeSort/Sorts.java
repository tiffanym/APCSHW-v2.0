import java.util.*;

public class Sorts{

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
	if (humanity.length==2){
	    a[0]=humanity[0];
	    b[0]=humanity[1];
	    return merge(a,b);
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
	int posn=0;
	int posnA=0;
	int posnB=0;
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
	return sortAR;
    }
    
    public static void main(String[] args){
	//testing merge method functionality
	/*
	int[] a={5,12,14,21,25,34};
	int[] b={2,3,5,6,29};
	//int[] b={};
	
	//int[] a=new int[1000000];
	//int[] b=new int[8535456];
	
	for (int i=0;i<a.length;i++){
	    a[i]=i;
	}
	for (int i=0;i<b.length;i++){
	    b[i]=i;
	}
	
	int[] fin=merge(a,b);
	System.out.println(Arrays.toString(fin));
	*/

	//testing mergeSort (recursive) functionality
	/*
	Random r=new Random();
	int[][] test={{1,5,4,2,3},
		      {1,2,3},
		      {3,2,1},
		      {26,4,13,-12,0,15}}; //works for all these 9.9
	//int[] test1=new int[999]; //works 6.6
	//for (int i=0;i<test1.length;i++){
	//    test1[i]=r.nextInt(test1.length)-r.nextInt(42);
	//}
	int[] testNums={999,100000,1000000}; //*v* It all works Kyaaqhahasbkdjsaewrnfgudvizsjlsknjbfiosregjaksldjhfiljekaniwqjolefgopsv
	////testNums[3]=10000000 took a while to print, but it worked;
	int[] test2=new int[testNums[2]];
	for (int i=0;i<test2.length;i++){
	    test2[i]=r.nextInt(test2.length)-r.nextInt(test2.length);
	}

	System.out.println(Arrays.toString(test2)); //original array (unsorted/ pre-mergeSort)
	//For testing purposes,using helper function;  mergeSort can't return anything, so not helpful when trying to debug code
	int[] pleasegodletthiswork=mergeSortH(test2); 
	System.out.println(Arrays.toString(pleasegodletthiswork));
	*/
	
	//if(args.length==0){
	//    System.out.println("java Filename [sort] [size]");
	//    System.out.println("sort:0=merge; otherwise, arrays.sort");
	//}
	Random r=new Random();
	int[] test = new int[4000000];
	for (int i=0;i<test.length;i++){
	    test[i]=r.nextInt(test.length);
	}
	//mergeSort(test);
	Arrays.sort(test);
    }
}
