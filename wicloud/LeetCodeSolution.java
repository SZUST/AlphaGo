import java.util.Arrays;

/**
 *
 * LeetCode Solution对象 ，提供所有solution 方法
 * @author  wicloud
 * @date   2016-4-24
 * 
 * Runtime: 4 ms   1047 / 1047 test cases passed
 * Your runtime beats 35.97% of javasubmissions
 */
public class Solution {

	/**
	 * 8. String to Integer (atoi)
	 * Implement atoi to convert a string to an integer.
	 * @param str
	 * @return
	 */
	public int myAtoi(String str) {
		if (null == str) {
			return 0;
		}
		str = str.trim();
		boolean isPosivit = true;
		if (str.startsWith("-")) {
			str = str.substring(1);
			isPosivit = false;
		} else if (str.startsWith("+")) {
			str = str.substring(1);
		}
		if ("".equals(str)) {
			return 0;
		}
		short i = 0;
		char c = '0';
		long l = 0;
		while (i < str.length()) {
			c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				if (isPosivit) {
					l = l * 10 + (c - '0'); //正数
				} else {
					l = l * 10 + (c - '0') * (-1);//负数
				}
				if (l > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				} else if (l < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
				i++;
			} else {
				break;
			}
		}
		return (int) l;

	}

	/**
	 * 7. Reverse Integer
	 * @param x
	 * @return
	 *  * Your runtime beats 45.49% of javasubmissions
	 * Runtime: 2 ms
	 */
	public int reverse(int x) {
		long res = 0;

		for (; x != 0; x /= 10) {
			res = res * 10 + x % 10;
		}
		return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
	}

	/**
	 * 6. ZigZag Conversion
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given 
	 * number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
	 * 写 w
	 * @param s
	 * @param numRows
	 * @return
	 * 1158 / 1158 test cases passed.  Runtime: 14 ms  Your runtime beats 40.21% of javasubmissions
	 */
	public String convert(String s, int numRows) {
		if (1 == numRows) {
			return s;
		}
		int len = s.length();
		StringBuffer[] arrsBuffers = new StringBuffer[numRows];
		int pos = 0, row = 0;
		boolean add = true;
		while (pos < len) {
			//			System.out.println("row= " + row + "  pos = " + pos);

			if (arrsBuffers[row] == null) {
				arrsBuffers[row] = new StringBuffer();
			}
			arrsBuffers[row].append(s.charAt(pos));
			pos++;
			if (add) {
				if (row == numRows - 1) {
					row--;
					add = false;
					continue;
				}
				row++;
			} else {
				if (row == 0) {
					row++;
					add = true;
					continue;
				}
				row--;
			}
		}
		StringBuffer rs = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			if (arrsBuffers[i] == null) {
				break;
			}
			rs.append(arrsBuffers[i]);
		}
		return rs.toString();
	}

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
