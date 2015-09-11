package maxsubarr;

public class fast {
	public static Triple maxsubarr(int[] arr,int low,int high)
	{
		if(high==low)
			return new Triple(low,high,arr[low]);
		int mid = (low+high)/2;//automatically takes floor
		Triple one = maxsubarr(arr,low,mid);
		Triple two = maxsubarr(arr,mid+1,high);
		Triple three = crossingsubarr(arr,low,mid,high);
		if((one.val >=two.val)&&(one.val>=three.val))
		{
			return one;
		}else
		{
			if((two.val >= one.val)&&(two.val>=three.val))
				return two;
			return three;
		}
	}
	public static Triple crossingsubarr(int[] arr, int low, int mid,int high)
	{
		long leftsum = Long.MIN_VALUE;
		int maxleft = 0;
		long sum = 0;
		for(int i=mid;i>=low;i--)
		{
			sum +=arr[i];
			if(sum>leftsum)
			{
				leftsum = sum;
				maxleft = i;
			}
		}
		long rightsum = Long.MIN_VALUE; 
		int maxright = mid+1;
		sum =0;
		for(int i=mid+1;i<=high;i++)
		{
			sum +=arr[i];
			if(sum>rightsum)
			{
			  rightsum = sum;
				maxright = i;
			}
		}
		return new Triple(maxleft,maxright,leftsum+rightsum);
	}
	public static class Triple
	{
		public Triple(int low,int high, long val)
		{
			this.low = low;
			this.high = high;
			this.val = val;
		}
		int low;
		int high;
		long val;
	}
}
