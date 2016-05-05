import java.util.Arrays;

/**
 *
 * LeetCode Solution对象 ，提供所有solution 方法
 * @author  wicloud
 * @date   2016-4-24
 */
public class Solution {

	/**
	* 
	* 2. Add Two Numbers   Total Accepted: 138344 Total Submissions: 602371 Difficulty: Medium
	* 
	* You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	* Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	* Output: 7 -> 0 -> 8
	* 
	* @param l1
	* @param l2
	* @return
	*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int up = 0;
		ListNode res = l1;
		int val = 0;
		while (null != l1) {
			val = (l1.val + l2.val + up) % 10;
			up = (l1.val + l2.val + up) / 10;
			l1.val = val;
			if (null == l1.next) { //指向l2
				l1.next = l2.next;
				if (l1.next == null && up > 0) {
					l1.next = new ListNode(up);
					break;
				}
				l1 = l1.next;
				l2.next = null;
				l2.val = 0;
				continue;
			}
			if (null == l2.next) {
				l1 = l1.next;
				l2.val = 0;
			} else {
				l1 = l1.next;
				l2 = l2.next;
			}
		}
		return res;
	}

	//	  Definition for singly-linked list.
	public class ListNode {

		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 *
	 * 1. Two Sum    O(n*n)  O(1)          -.>建议使用hashMap
	 * 
	 *  Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 *	You may assume that each input would have exactly one solution.
	 * @author  wicloud
	 * @date   2016-4-24
	 */
	public int[] twoSum(int[] nums, int target) {

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

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
		//超时 算法有问题
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
