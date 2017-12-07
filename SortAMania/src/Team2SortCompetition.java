import java.util.Random;

public class Team2SortCompetition extends SortCompetition {

	public static void main(String[] args)
	{	
		//checks challengeOne
		int[] arr1 = createArray(10000);
		challengeOne(arr1);
		
		//checks challengeTwo
		String[] arr2 = {"hey", "hi", "bye"};
		challengeTwo(arr2, "bye");
		
		//checks challengeThree
		challengeThree(arr1);
		
		//checks challengeFour
		int[][] arr3 = create2DArray(1000);
		challengeFour(arr3);
	}

	public String greeting() 
	{
		return "This is Team 2, created by Katherin & Dana.";
	}
	
	//this method sorts the array and returns the median
	public int challengeOne(int[] arr)
	{
		printIntArray(arr);
		quickSort(arr, 0, arr.length-1);
		printIntArray(arr);
		return findMedian(arr);
	}
	
	//this method sorts the list and if it finds the string, return the index of the string 
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
	
	//this method sorts a mostly sorted list and returns the median 
	public int challengeThree(int[] arr)
	{
		return challengeOne(arr);
	}
	
	//this method sorts the sub arrays first, then the arrays by the median value, returns index of the median
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
	
	//this method sort an array of any objects and sees if it contains the element given. returns position or -1
	public int challengeFive(Comparable[]arr, Comparable query)
	{
		mergeSort(arr);
		for (int i = 0; i<arr.length; i++)
		{
			if (arr[i].equals(query))
			{
				return i;
			}
		}
		return -1;
	}
	
	//this method finds the median of the array
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
	
	public static int[][] create2DArray(int n)
	{
		Random rnd = new Random();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				arr[i][j] = rnd.nextInt(10000);
			}
		}
		return arr;
	}
	
	//creates a random 5 character string
	public static String createRandomString()
	{
		String charsList = "abcdefghijklmnopqrstuvwxyz";
		Random rnd2 = new Random();
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
	
	//int partition
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
	
	//int quickSort
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
	
	//string swap
	public static void swapS(String[] arr, int i, int j)
	{
		String temp = arr[i];
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
	
	public static String[] merge(String[] list1, String[] list2)
	{
		String[] mergedList = new String[list1.length+list2.length];
		
		int listIndex = 0;
		int i = 0;
		int x = 0;
		
		String check1 = list1[i];
		String check2 = list2[x];
		
		while(i < list1.length && x < list2.length-1)
		{
			//System.out.println("i: " + i + " x: " + x + " listIndex: " + listIndex + " check1: " + check1 + " check2: " + check2);
			
			if (check1.compareTo(check2) <= 0)
			{
				//check1 is closer to a than check2
				mergedList[listIndex] = check1;
				listIndex++;
				i++;
				check1 = list1[i];
			}
			else
			{
				//check2 is closer to a than check1
				mergedList[listIndex] = check2;
				listIndex++;
				x++;
				check2 = list2[x];
			}
		}
		
		while (i < list1.length)
		{
			mergedList[listIndex] = list1[i];
			i++;
			listIndex++;
		}
		
		while (x < list2.length)
		{
			mergedList[listIndex] = list2[x];
			x++;
			listIndex++;
		}
		
		return mergedList;
	}
	
	public static String[] mergeSort(Comparable[] arr)
	{
		//initializes the two halves
		String[] list1 = new String[arr.length/2];
		String[] list2 = new String[arr.length/2];
		
		//sets the values into the new arrays
		for (int i = 0; i < arr.length/2; i++)
		{
			list1[i] = (String) arr[i];
		}
		for (int i = arr.length/2; i < arr.length; i++)
		{
			list2[i] = (String) arr[i];
		}
		
		//completes the recursive separation
		while (list1.length > 1 || list2.length > 1)
		{
			mergeSort(list1);
			mergeSort(list2);
		}
		
		
		return merge(list1, list2);		
		
	}
}
