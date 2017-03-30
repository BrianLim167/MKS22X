//import java.util.*;
public class Merge{
    public static void mergesort(int[] ary){
	if (ary.length > 1){
	    int[] left = new int[ary.length/2];
	    for (int i=0 ; i<ary.length/2 ; i++){
		left[i] = ary[i];
	    }
	    int[] right = new int[ary.length-ary.length/2];
	    for (int i=0 ; i<ary.length-ary.length/2 ; i++){
		right[i] = ary[i+ary.length/2];
	    }
	    mergesort(left);
	    mergesort(right);
	    //System.out.println(Arrays.toString(left)+" | "+Arrays.toString(right));
	    int l=0,r=0;
	    while (l<left.length && r<right.length){
		if (left[l] < right[r]){
		    ary[l+r] = left[l];
		    l++;
		}else{
		    ary[l+r] = right[r];
		    r++;
		}
	    }
	    while (l<left.length){
		ary[l+r] = left[l];
		l++;
	    }
	    while (r<right.length){
		ary[l+r] = right[r];
		r++;
	    }
		
	}
	//System.out.println(Arrays.toString(ary));
    }
}
