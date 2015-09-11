package maxsubarr;

public class bruteforce {

public static long maxsubarr(int[] arr)
{
	long bestsum = Long.MIN_VALUE;
	for(int i=0;i<arr.length;i++)
	{
		for(int j=i;j<arr.length;j++)
		{
			long cursum = 0;
			for(int k=i;k <= j;k++)
			{
				cursum+=arr[k];
			}
			if(cursum >bestsum)
				bestsum=cursum;
		}
	}
	return bestsum;
}
}
