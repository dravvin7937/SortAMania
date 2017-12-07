import java.util.Random;

public class Team2SortCompetition extends SortCompetition {

	public static void main(String[] args)
	{	
//		//checks challengeOne
//		int[] arr1 = createArray(10000);
//		double median = challengeOne(arr1);
//		System.out.println("median: " + median);
//		
//		//checks challengeTwo
//			//stack overflow error
//		String[] arr2 = {"hey", "hi", "bye"};
//		int index = challengeTwo(arr2, "bye");
//		System.out.println("index of string: " + index);
	}

	public String greeting() 
	{
		return "This is Team 2, created by Katherin & Dana";
	}
	
	//this function sorts the array and returns the median
	public int challengeOne(int[] arr)
	{
		printIntArray(arr);
		quickSort(arr, 0, arr.length-1);
		printIntArray(arr);
		return findMedian(arr);
	}
	
	//this function sorts the list and if it finds the string, return the index of the string 
	public int challengeTwo(String[] arr, String query)
	{
		printStringArray(arr);
		bubbleSort(arr);
		printStringArray(arr);
		
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i].equals(query))
			{
				return i;
			}
		}
		return -1;
	}
	
	//this function sorts a mostly sorted list and returns the median 
	public int challengeThree(int[] arr)
	{
		return challengeOne(arr);
	}
	
	//this function sorts the sub arrays first, then the arrays by the median value, returns index of the median
	public int challengeFour(int[][] arr)
	{
		int[] arr2 = new int[arr.length];
		for (int i = 0; i<arr.length; i++)
		{
			quickSort(arr[i], 0, arr[i].length);
			
			arr2[i] = (int) findMedian(arr[i]);
		}
		quickSort(arr2, 0, arr2.length);
		
		return findMedian(arr2);
	}
	
	//this function sort an array of any objects and sees if it contains the element given. returns position or -1
	public int challengeFive(Comparable[]arr, Comparable query)
	{
		return -1;
	}
	
	//this function finds the median of the array
	public static int findMedian(int[] arr)
	{
		int middle = 0;
		if (arr.length%2 == 0)
		{
			middle = (int)(arr[arr.length/2] + arr[(arr.length/2) - 1])/2;
		}
		else
		{
			middle = (int)arr[arr.length/2-1];
		}
		return middle;
	}
	
	//creates a random array of integers
	public static int[] createArray(int n)
	{
		Random rnd = new Random();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = rnd.nextInt(10000);
		}
		return arr;
	}
	
	//creates a random 5 character string
	public static String createRandomString()
	{
		return "hello";
	}
	
	//prints each number in the array
	public static void printIntArray(int[] arr)
	{
		for (int num : arr)
		{
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	//prints each string in the array
	public static void printStringArray(String[] arr)
	{
		for (String str : arr)
		{
			System.out.print(str + " ");
		}
		System.out.println();
	}
	
	//working int partition
	public static int partition(int[] list1, int front, int back)
	{
		//returns position of the pivot 
		int pivot = list1[front];
		int pivPosition = front;
		
		for (int i = front+1; i <= back; i++)
		{
			if (list1[i]<=pivot)
			{
				for (int j = 0; j<i-pivPosition; j++)
				{
					swap(list1,i-j,i-j-1);
				}
				pivPosition++;
			}
		}
		return pivPosition;
	}
	
	//working int quickSort
	public static void quickSort(int[] list1, int front, int back)
	{
		if (front < back)
		{
			int pivPosition = partition(list1, front, back);
			quickSort(list1,front,pivPosition-1);
			quickSort(list1,pivPosition+1,back);
		}
	}
	
	//int swap
	public static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//string sort
	public static void bubbleSort(String[] list1)
	{
		for(int i = 0; i<list1.length-1; i++) 
		{
			if(list1[i+1].compareTo(list1[i]) <= 0)
			{
				swapS(list1,i,i+1);
				bubbleSort(list1);
			}
		}
	}
	
	//string swap
	public static void swapS(String[] arr, int i, int j)
	{
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
