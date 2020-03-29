//utility class
import java.util.Arrays;

public class Statistics {
	/**
	 * Calculates the arithmetic mean of two numbers
	 * @param x the first input
	 * @param 
	 * @return the average of 2 numbers
	 */
	public static double calculateAverage(int[] nums ) {
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		
		return sum/nums.length;
	}
	public static double calculateAverage(double[] nums ) {
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		
		return sum/nums.length;
	}
	public static double calculateAverage(String[] nums ) {
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += Integer.parseInt(nums[i]);
		}
		
		return sum/nums.length;
	}
	public static double calculateAverage(int x, int y ) {
		return (double)(x + y) / 2;
	}
	public static double calculateAverage(String x, String y ) {
		return (double)(Integer.parseInt(x) + Integer.parseInt(y)) / 2;
	}

	public static double calculateMedian(int[] nums) {
		Arrays.sort(nums);
		if (nums.length % 2 == 0) {
			return (double)(nums[(nums.length - 1)/2] + nums[nums.length / 2]) / 2;
		} else {
			return nums[(nums.length - 1) / 2];
		}
	}

	public static double calculateMedian(String[] nums) {
		int [] nums1 = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			nums1[i] = Integer.parseInt(nums[i]);
		}
		Arrays.sort(nums1);
		if (nums.length % 2 == 0) {
			return (double)(nums1[(nums.length - 1)/2] + nums1[nums.length / 2]) / 2;
		} else {
			return nums1[(nums.length - 1) / 2];
		}
	}
	public static double calculateMedian(double[] nums) {
		Arrays.sort(nums);
		if (nums.length % 2 == 0) {
			return (double)(nums[(nums.length - 1)/2] + nums[nums.length / 2]) / 2;
		} else {
			return nums[(nums.length - 1) / 2];
		}
	}
	/**
	 * Calculates standard deviation for a list of numbers(population)
	 * @param nums the list of numbers
	 * @return the standard deviation for the list
	 */
	public static double calculateStdDev(int[] nums) {
		double mean = calculateAverage(nums);
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += (nums[i] - mean) * (nums[i] - mean);
		}
		return Math.sqrt(sum / nums.length);
	}

	public static double calculateStdDev(String[] nums) {
		double mean = calculateAverage(nums);
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += (Integer.parseInt(nums[i]) - mean) * (Integer.parseInt(nums[i]) - mean);
		}
		return Math.sqrt(sum / nums.length);
	}
	public static double calculateStdDev(double[] nums) {
		double mean = calculateAverage(nums);
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += (nums[i] - mean) * (nums[i] - mean);
		}
		return Math.sqrt(sum / nums.length);
	}
}