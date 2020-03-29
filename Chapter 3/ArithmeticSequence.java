public class ArithmeticSequence {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,7};
		
	}
	public static int highestSequence(int[] array) {
		int tempHigh = 0;
		int high;
		int index = 0;
		int commonDiff;
		while (index < array.length) {
			high = 0;
			commonDiff = array[index + 1] - array[index];
			while (array[index + 1] - array[index] == commonDiff) {
				tempHigh++;
				index++;
			}
			if (tempHigh > high) {
				high = tempHigh;
			}
		}
		return high;
	}
	public static int[] bubbleSorter(int[] array) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j+1]) {
					temp = array[j + 1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

}