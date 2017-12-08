/**
* Katherin Solis and Dana Ravvin
* SortAMania Team 2
* 12/7/17
*/
import java.util.Arrays;
import java.util.Random;

public class Team2SortCompetition extends SortCompetition{

	//added merge, mergesort, create2Darray
	
	public static void main(String[] args)
	{
//		//checks challengeOne
 		//int[] arr1 = createArray(10000);
 		//System.out.println(challengeOne(arr1));
// 		// WORKS
// 		
// 		//checks challengeTwo
// 		String[] arr2 = {"hey", "hi", "bye"};
// 		System.out.println(challengeTwo(arr2, "hi"));
// 		// WORKS
// 		
 		//checks challengeThree
 		//System.out.println(challengeThree(arr1));
// 		// WORKS
// 		
// 		//checks challengeFour
// 		int[][] arr3 = create2DArray(1000);
// 		System.out.println(challengeFour(arr3));
// 		// WORKS
 		
// 		//checks challengeFive
// 		String[] arr2 = {"hey", "hi", "bye"};
// 		System.out.println(challengeFive(arr2, "hi"));
// 		//	WORKS
 		
	}
	
	public String greeting()
	{
		return "This is Katherin and Dana's sort entry.";
	}

	
	/**
	* This function sorts the array and returns the median
	* @param arr - holds the median value 
	* @return The integer value of the median of the array
	*/
	public int challengeOne(int[] arr)
	{
		//printIntArray(arr);
		quickSort(arr, 0, arr.length-1);
		//printIntArray(arr);
		return (int) findMedian(arr);
	}

	/**
	* This function sorts the list and if it finds the string, return the index of the string
	* @param arr - holds the array that is being looped through
	* @param query - the string that is looked for in the arrays
	* @return the position of the search word
	*/
	public int challengeTwo(String[] arr, String query)
	{
		//printStringArray(arr);
		mergeSort(arr);
		//printStringArray(arr);

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

	public int challengeThree(int[] arr)
	{
		return challengeOne(arr);
	}

	/**
	* Sorts the sub arrays first, then the arrays by the median value, returns index of the median
	* @param arr - the two dimensional array to be sorted 
	* @return the median of the medians in the two dimensional array
	*/
	public int challengeFour(int[][] arr)
	{
		int[] arr2 = new int[arr.length];
		for (int i = 0; i<arr.length; i++)
		{
			challengeOne(arr[i]);

			arr2[i] = (int) findMedian(arr[i]);
		}
		quickSort(arr2, 0, arr2.length);

		return (int)findMedian(arr2);
	}

	/** 
		* Sorts an array of any objects and sees if it contains the element given. returns position or -1
		* @param arr - the array that is sorted through  
		* @param query - the key that searched for in the object in the array
		* @return the position of the query in the array
	*/

	public int challengeFive(Comparable[]arr, Comparable query)
	{
		mergeSort2(arr);
		 for (int i = 0; i<arr.length; i++)
		 {
			 if (arr[i].equals(query))
		 	 {
			 	return i;
		 	 }
		 }
		 return 1;
	}

	//this function finds the median of the array
	public static double findMedian(int[] arr)
	{
		int middle = 0;
		if (arr.length%2 == 0)
		{
			middle = (arr[arr.length/2] + arr[(arr.length/2) - 1])/2;
		}
		else
		{
			middle = arr[arr.length/2-1];
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

		for (int i = front+1; i < back; i++)
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
		for(int i = 0; i<list1.length; i++) 
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
	
	public static String[] merge(String[] list1, String[] list2)
 	{
 		String[] mergedList = new String[list1.length+list2.length];
 		
 		int listIndex = 0;
 		int i = 0;
 		int x = 0;
 		
// 		String check1 = list1[i];
// 		String check2 = list2[x];
 		
		while(i < list1.length && x < list2.length)
 		{
 			//System.out.println("i: " + i + " x: " + x + " listIndex: " + listIndex + " check1: " + check1 + " check2: " + check2);
 			
 			if (list1[i].compareTo(list2[x]) <= 0)
 			{
 				//check1 is closer to a than check2
 				mergedList[listIndex] = list1[i];
 				listIndex++;
 				i++;
 			}
 			else
 			{
 				//check2 is closer to a than check1
 				mergedList[listIndex] = list2[x];
 				listIndex++;
 				x++;
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
	
	public static String[] mergeSort(String[] arr)
 	{
 		//initializes the two halves
// 		String[] list1 = new String[arr.length/2];
// 		String[] list2 = new String[arr.length/2];
 		
 		//sets the values into the new arrays
// 		for (int i = 0; i < arr.length/2; i++)
// 		{
// 			list1[i] = (String) arr[i];
// 		}
// 		for (int i = arr.length/2; i < arr.length; i++)
// 		{
// 			list2[i] = (String) arr[i];
// 		}
		
		//incorporate Arrays.copyOfRange instead
 		
 		//completes the recursive separation
		if (arr.length == 1)
		{
			return arr;
		}
		else
		{
	 		String[] list1 = Arrays.copyOfRange(arr, 0, arr.length/2);
	 		String[] list2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
	 		
	 		return merge(mergeSort(list1), mergeSort(list2));		
		}	
 	}
	
	public static Comparable[] merge2(Comparable[] list1, Comparable[] list2)
 	{
		Comparable[] mergedList = new Comparable[list1.length+list2.length];
 		
 		int listIndex = 0;
 		int i = 0;
 		int x = 0;
 		
// 		Comparable check1 = list1[i];
// 		Comparable check2 = list2[x];
 		
 		while(i < list1.length && x < list2.length)
 		{
 			//System.out.println("i: " + i + " x: " + x + " listIndex: " + listIndex + " check1: " + check1 + " check2: " + check2);
 			
 			if (list1[i].compareTo(list2[x]) <= 0)
 			{
 				//check1 is closer to a than check2
 				mergedList[listIndex] = list1[i];
 				listIndex++;
 				i++;
 			}
 			else
 			{
 				//check2 is closer to a than check1
 				mergedList[listIndex] = list2[x];
 				listIndex++;
 				x++;
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
	
	public static Comparable[] mergeSort2(Comparable[] arr)
 	{
		if (arr.length == 1)
		{
			return arr;
		}
		else
		{
	 		Comparable[] list1 = Arrays.copyOfRange(arr, 0, arr.length/2);
	 		Comparable[] list2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
	 		
	 		return merge2(mergeSort2(list1), mergeSort2(list2));		
		}	
 	}
}
