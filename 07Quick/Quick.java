public class Quick{
    public int part(int[] data,int start,int end){
        int v = 0;////
	swap(data,start,v);
	int i = start + 1;
	int j = end - 1;
	while (i <= j){
	    if (data[i] < data[j]){
		i++;
	    }
	    else {
		swap(i,j);
		j--;
	    }
	}
	
    }
    public void swap(int[] data,int a, int b){
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }
}
