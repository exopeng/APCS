// **** YOUR NAME HERE: Ethan Peng
import java.util.Arrays;

public class SortLibrary {

	
	
	  public static void main(String[] args) { // Test arrays you can use to checkyour sorts. // They represent common arrangements: random, alread  sorted,reversed, mostly sorted 
	  int[] random = new
	  int[]{33,94,9,40,77,82,47,15,51,64,76,28,2,85,11}; int[] alreadySorted = new
	  int[]{2,9,11,15,28,33,40,47,51,64,76,77,82,85,94}; int[] reversed = new
	  int[]{94,85,82,77,76,64,51,47,40,33,28,15,11,9,2}; int[] mostlySorted = new
	  int[]{2,85,11,15,28,33,47,40,51,64,76,77,82,9,94}; int[] longerArray =
	  ArrayImporter.readArrayFile("smallArray.txt"); int[] myCustomTest = new
	  int[]{15, 23, 42, 4}; int[] custom1 = new int[] {1,5,3, 2, 7, 2}; // ***Enter your array to sort here 
	  int[] arrayToSort = longerArray; // arrayToSort will  point to the array you choose 
	  int[] copyOfArrayToSort =
	  Arrays.copyOf(arrayToSort, arrayToSort.length);
	  
	  // ***Enter which sort you want to test 
	  mergeSort(arrayToSort); // Call yoursort method -- Remember array is modified in the method, not returned!
	  Arrays.sort(copyOfArrayToSort); // call java.util.Array's sort method forcomparison
	  
	  if(arrayToSort.length < 50) { System.out.println("Result after sort: " +
	  Arrays.toString(arrayToSort)); System.out.println("Result should be: " +
	  Arrays.toString(copyOfArrayToSort)); }
	  
	  System.out.println("Sorts match? " + Arrays.equals(arrayToSort,
	  copyOfArrayToSort));
	  
	  }
	 
	 
	
	public static void mergeSort(int[] nums) {
		int partition = 2;
		boolean power2 = false;
		while (partition <= nums.length) {
			power2 = false;
			int leftOff = 0;
			int[] arr1 = Arrays.copyOf(nums, nums.length);
			for (int i = 0; i < nums.length; i += partition) {
				int lh = i;
				int rh = i + (partition / 2);
				if (i + partition > nums.length) {
					power2 = true;
					leftOff = i;
					break;
				}
				for (int j = i; j < i + partition && j < nums.length; j++) {	
					if (rh == i + partition || (lh < i + (partition / 2) && arr1[lh] <= arr1[rh]  ) ) {
						nums[j] = arr1[lh];
						lh++;
					} else {
						nums[j] = arr1[rh];
						rh++;
					}
				}
			}
			  if (power2) { 
				  int lh = leftOff; 
				  int rh = leftOff + partition / 2; 
				  for (int i = lh; i < nums.length; i++) { 
					  if (rh >= nums.length || (lh < leftOff + partition / 2 && arr1[lh] <= arr1[rh])) {
						  nums[i] = arr1[lh]; lh++; 
						} else { 
							nums[i] = arr1[rh]; rh++; 
						} 
				  }
			  }
			 
			partition*=2;
			if (partition > nums.length && ((double)partition / 2) != nums.length) {
				arr1 = Arrays.copyOf(nums, nums.length);
				int lh = 0;
				int rh = (int)(Math.pow(2, (int)(Math.log10(nums.length) / Math.log10(2))));
				for (int i = lh; i < nums.length; i++) {
					if (rh == nums.length || (lh < (int)(Math.pow(2, (int)(Math.log10(nums.length) / Math.log10(2)))) && arr1[lh] <= arr1[rh])) {
						nums[i] = arr1[lh];
						lh++;
					} else {
						nums[i] = arr1[rh];
						rh++;
					}
				}
			}
			//handle remainder, if arr length isn't a power of 2
		}
	}
	// void normally would be OK.  Don't need to return int[] or anything.
	// However, I want you to keep track of and return the number of swaps.
	public static int bubbleSort(int[] nums) {
		int swaps = 0;
		for (int i = 0; i < nums.length; i++) {
			int localSwaps = 0;
			for (int j = 0; j + 1 < nums.length; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j + 1];
					int temp1 = nums[j];
					nums[j + 1] = temp1;
					nums[j] = temp;
					localSwaps++;
				}
			}
			if (localSwaps == 0) {
				return swaps;
			}
			swaps += localSwaps;
		}
		return swaps;
	}
	
	// void is OK.  'unsorted' simply receives a copy of reference to the unsorted
	// array 'arrayToSort' when method is called.  When your method finishes, 
	// 'arrayToSort' will point to the sorted array
	public static void insertionSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				for (int j = i; j > 0; j--) {
					if (nums[j] < nums[j - 1]) {
						int temp = nums[j - 1];
						int temp1 = nums[j];
						nums[j - 1] = temp1;
						nums[j] = temp;
					} else {
						break;
					}
				}
			}
		}
	}
	
	public static void selectionSort(int[] nums) {
		for (int i = 0; i < nums.length; i++ ) {
			int min = Integer.MAX_VALUE;
			int index = 0;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] < min) {
					min = nums[j];
					index = j;
				}
			}
			int temp = nums[index];
			int temp1 = nums[i];
			nums[i] = temp;
			nums[index] = temp1;
		}
	}

	
	
}
