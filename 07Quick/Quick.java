import java.util.Random;
public class Quick{
    public static int part(int[] data,int start,int end){
        Random rand = new Random();
	int v = start + rand.nextInt(end-start);
	System.out.println(data[v]);
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
    public static void swap(int[] data,int a, int b){
	int temp = data[a];
	data[a] = data[b];
	data[b] = temp;
    }
}
