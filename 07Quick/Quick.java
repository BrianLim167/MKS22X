import java.util.Random;
public class Quick{
    public static int partMeh(int[] data,int start,int end){
        Random rand = new Random();
	int v = start + rand.nextInt(end-start);
	//System.out.println(data[v]);
	swap(data,start,v);
	int i = start + 1;
	int j = end - 1;
	while (i <= j){
	    if (data[i] < data[start]){
		i++;
	    }
	    else {
		swap(data,i,j);
		j--;
	    }
	}
	swap(data,start,j);
	return j;
    }
    public static int[] part(int[] data,int start,int end){
        Random rand = new Random();
	int v = start + rand.nextInt(end-start);
	//System.out.println(data[v]);
	swap(data,start,v);
	int red = start;
	int whi = start + 1;
	int blu = end - 1;
	while (whi <= blu){
	    if (data[whi] == data[red]){
		whi++;
	    }else if (data[whi] < data[red]){
		swap(data,whi,red);
		red++;
		whi++;
	    }else{
		swap(data,whi,blu);
		blu--;
	    }
	}
	int[] ans = new int[2];
	ans[0] = red;
	ans[1] = blu;
	return ans;
    }
    public static void swap(int[] data,int a, int b){
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }

    public static int quickselect(int[] data,int k){
	return quickselect(data,k,0,data.length);
    }
    public static int quickselect(int[] data,int k,int start,int end){
	int[] inds = part(data,start,end);
	if (k>=inds[0] && k<=inds[1]){
	    return data[k];
	}else if (k<inds[0]){
	    return quickselect(data,k,start,inds[0]);
	}
	return quickselect(data,k,inds[1]+1,end);
    }
    
    public static void quicksort(int[] data){
	quicksort(data,0,data.length);
    }
    public static void quicksort(int[] data,int start,int end){
	if (data.length>1){
	    int[] inds = part(data,start,end);
	    //for (int i=0 ; i<data.length ; i++){
	    //    System.out.print(data[i]+" ");
	    //}
	    //System.out.println();
	    if (start!=inds[0]){
		quicksort(data,start,inds[0]);
	    }
	    if (inds[1]+1!=end){
		quicksort(data,inds[1]+1,end);
	    }
	}
    }
}
