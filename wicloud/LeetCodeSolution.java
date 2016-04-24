import java.util.Arrays;

/**
 *
 * LeetCode Solution对象 ，提供所有solution 方法
 * @author  wicloud
 * @date   2016-4-24
 */
public class Solution {

	/**
	 * 16.  3Sum Closest 
	 * 
	 * Closest Given an array S of n integers, find three integers in S such that the sum is closest to a given
	 * number, target. Return the sum of the three integers. You may assume that each input would have exactly one
	 * solution.
	 * 
	 * @param nums
	 * @param target
	 * @return 
	 * 
	 * */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);

		int len = nums.length;
		int sumClosest = nums[0] + nums[1] + nums[2];
		int i = 0, j, k;
		for (; i < len - 2; i++) { // 第一个数  越加越大了。
			for (j = i + 1; j < len - 1; j++) {// 第二个数
				for (k = j + 1; k < len; k++) {// 第三个数
					int sum = nums[i] + nums[j] + nums[k];
					if (Math.abs(sumClosest - target) > Math.abs(sum - target)) {
						sumClosest = sum;
					}

					if (sum - target >= 0) {
						break;
					}

				}
			}
		}
		return sumClosest;

	}

	/**
	 *  344	Reverse String  	59.9%		Easy
	 * @param s
	 * @return
	 */
	public String reverseString(String s) {
		return new StringBuffer(s).reverse().toString();
	}

	/**
	 *
	 * 345	Reverse Vowels of a String   37.5%		Easy
	 * @param s
	 * @return
	 */
	public String reverseVowels(String s) {
		char[] sArr = s.toCharArray();
		int i = 0;
		int j = sArr.length - 1;
		for (; i < j; i++) {
			if (isVowel(sArr[i])) {
				int pos = decreaseJ(i, sArr, j);
				if (pos > i) {
					char temp = sArr[i];
					sArr[i] = sArr[pos];
					sArr[pos] = temp;
					j = pos - 1;
				}
			}
		}
		return new String(sArr);
	}

	public int decreaseJ(int i, char[] chars, int j) {

		for (; j > i; j--) {
			if (isVowel(chars[j])) {
				return j;
			}
		}
		return i;
	}

	public boolean isVowel(char c) {
		return c == 'A' || c == 'a' || c == 'E' || c == 'e' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
				|| c == 'U';
	}

}
