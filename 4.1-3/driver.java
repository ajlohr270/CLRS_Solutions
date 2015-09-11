package maxsubarr;
import java.util.Random;
public class driver {
//gives runtime for the bruteforce and fast solution on random arrays of lengths of array <100
static Random r = new Random();
public static void main(String[] args)
{
	long[] bruteruntimes = new long[100];
	long[] fastruntimes = new long[100];
	for(int i=1;i<100;i++)
	{
		int[] arr = randomarray(i);
		long entertime = System.nanoTime();
		long ret = bruteforce.maxsubarr(arr);
		bruteruntimes[i] = System.nanoTime()-entertime;
		entertime = System.nanoTime();
		System.out.print(ret+" ");
		ret = fast.maxsubarr(arr,0,i-1).val;
		fastruntimes[i] = System.nanoTime()-entertime;
		System.out.println(ret);
	}
	System.out.println("Fast Runtimes");
	for(int i=0;i<100;i++)
	{
		System.out.println(fastruntimes[i]);
	}
	System.out.println("Brute Force Runtimes");
	for(int i=0;i<100;i++)
	{
		System.out.println(bruteruntimes[i]);
	}
	
}
public static int[] randomarray(int n)
{
	int[] ret = new int[n];
	for(int i=0;i<n;i++)
	{
		ret[i] = r.nextInt();
	}
	return ret;
}
}
