import java.util.*;

public class MergeSort{
    
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
	if (posnA<b.length){ //stuff left in b
	    for (int i=posnA;i<b.length;i++){
		sortAR[posn]=b[i];
		posn++;
	    }
	}
	else if (posnB<a.length){ //stuff left in a
	    for (int i=posnB;i<a.length;i++){
		sortAR[posn]=a[i];
		posn++;
	    }
	}
	return sortAR;
    }
    
    public static void main(String[] args){
	//int[] a={5,12,14,21,25,34};
	//int[] b={2,3,5,6,29};
	//int[] b={};
	int[] a=new int[1000000];
	int[] b=new int[8535456];
	for (int i=0;i<a.length;i++){
	    a[i]=i;
	}
	for (int i=0;i<b.length;i++){
	    b[i]=i;
	}
	int[] fin=merge(a,b);
	System.out.println(Arrays.toString(fin));
    }
}