import java.util.ArrayList;
import java.util.HashMap;

public class HW10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temp = new int[] {2, 2, 2, 2, 2};
		int[] temp1 = new int[] {2,2};
		System.out.println(maxMirror1(temp));
 		//System.out.println(linearIn(temp, temp1));
	}
	
	public static boolean linearIn(int[] outer, int[] inner) {
		int counter = 0;
		for (int i = 0; i < outer.length; i++) {
			if (counter == inner.length) {
		      break;
			}
			while (outer[i] < inner[counter]) {
				i++;
				if (i == outer.length) {
					return false;
				}
			} 
	    if (outer[i] != inner[counter]) {
	        return false;
	    }
    	counter++;
    	if (i == outer.length - 1 && counter != inner.length) {
	    	return false;
	    }
	  }
		
	  return true;
	}
	public int maxMirror(int[] nums) {
		  for (int i = nums.length; i > 1; i--) {
		    int len = i;
		    for (int j = 0; j + len <= nums.length; j++) {
		      int start = j;
		      int end = j + len - 1;
		      for (int e = nums.length - 1; e - len + 1 >= 0; e--) {
		        int counter = 0;
		        boolean good = false;
		        for (int f = start; f <= end; f++) {
		          if (nums[f] != nums[e - counter]) {
		            good = false;
		            break;
		          }
		          counter++;
		          if (counter == len) {
		            good = true;
		          }
		        }
		        if (good) {
		          return len;
		        }
		      }
		    }
		  }
		  if (nums.length == 0) {
		    return 0;
		  }
		  return 1;
		}
	
	//runs in O(N^2), if something is checked, can skip over
		public static int maxMirror1(int[] nums) {
		  int max = 0;
		  for (int i = 0; i < nums.length; i++) {
		    for (int j = nums.length - 1; j >= i; j--) {
		      if (nums[i] == nums[j]) {
		        int counter = 0;
		        while (nums[j] == nums[i + counter]) {
		          counter++;
		          max = Math.max(counter, max);
		          j--;
		          if (j == i - 1) {
		            break;
		          }
		        }
		      }
		    }
		  }
		  return max;
		}







}