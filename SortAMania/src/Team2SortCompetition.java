/**
* Katherin Solis and Dana Ravvin
* SortAMania Team 2
* 12/7/17
*/
import java.util.Random;

public class challenges {

	//added merge, mergesort, create2Darray

	public static void main(String[] args)
	{
		//checks challengeOne
		int[] arr1 = createArray(10000);
		double median = challengeOne(arr1);
		System.out.println("median: " + median);

		//checks challengeTwo
			//stack overflow error
		String[] arr2 = {"hey", "hi", "bye"};
		int index = challengeTwo(arr2, "bye");
		System.out.println("index of string: " + index);

	}

	
	/**
	* This function sorts the array and returns the median
	* @param arr - holds the median value 
	* @return The integer value of the median of the array
	*/
	public static int challengeOne(int[] arr)
	{
		printIntArray(arr);
		quickSort(arr, 0, arr.length-1);
		printIntArray(arr);
		return findMedian(arr);
	}

	/**
	* This function sorts the list and if it finds the string, return the index of the string
	* @param arr - holds the array that is being looped through
	* @param query - the string that is looked for in the arrays
	* @return the position of the search word
	*/
	public static int challengeTwo(String[] arr, String query)
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

	/** 
	* this function sorts a mostly sorted list and returns the median
	* @param arr - the array to be sorted
	* @return the median of the array 
	*/

	public static int challengeThree(int[] arr)
	{
		return challengeOne(arr);
	}

	/**
	* Sorts the sub arrays first, then the arrays by the median value, returns index of the median
	* @param arr - the two dimensional array to be sorted 
	* @return the median of the medians in the two dimensional array
	*/
	public static int challengeFour(int[][] arr)
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

	/** 
		* Sorts an array of any objects and sees if it contains the element given. returns position or -1
		* @param arr - the array that is sorted through  
		* @param query - the key that searched for in the object in the array
		* @return the position of the query in the array
	*/

	public static int challengeFive(Comparable[]arr, Comparable query)
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

	/**
	* creates a random array of integers
	*/
	
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

	/**
	* creates a random 5 character string
	*/
	
	public static String createRandomString()
	{
		return "hello";
	}

	/** 
	* prints each number in the array
	* @param arr - array to be sorted
	* @return prints individual integers
	*/
	
	public static void printIntArray(int[] arr)
	{
		for (int num : arr)
		{
			System.out.print(num + " ");
		}
		System.out.println();
	}

	/**
	* prints each string in the array
	* @param arr - array to be sorted
	* @return prints individual strings
	*/
	public static void printStringArray(String[] arr)
	{
		for (String str : arr)
		{
			System.out.print(str + " ");
		}
		System.out.println();
	}

	/**
	* @param list1 - list that should be sorted
	* @param front - index that is used to compare to 
	* @param back - placeholder for the back
	* @return partition sort
	
	*/
	
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

	
	/**
	* working integer using quickSort
	* @param list1- array to be sorted
	* @param front- to be compared with
	* @param back - for use of comparison 
	* @return swapped string array
	*/
	public static void quickSort(int[] list1, int front, int back)
	{
		if (front < back)
		{
			int pivPosition = partition(list1, front, back);
			quickSort(list1,front,pivPosition-1);
			quickSort(list1,pivPosition+1,back);
		}
	}

	/**
	* @param arr - array to be sorted
	* @param i - to be swapped
	* @param j - swapped with
	* @return swapped string array
	*/
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

	/**
	* @param arr - array to be sorted
	* @param i - to be swapped
	* @param j - swapped with
	* @return swapped string array
	*/
	public static void swapS(String[] arr, int i, int j)
	{
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
