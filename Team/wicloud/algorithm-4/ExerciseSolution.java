/**
 * 
 */
package com.alphago.algorithm;

import java.util.Stack;

/**
 *
 *
 * @author  wicloud
 * @date   2016-5-8
 */
public class ExerciseSolution {

	/**
	 * 
	 * 114.1.2.6
	 * @param s
	 * @param t        s+s 包含 t
	 * 
	 * 判断是否回环变wei  st
	 */
	public boolean isCircularRotation(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		return s.concat(s).indexOf(t) >= 0;
	}

	/**
	 * 适配括号
	 * p161 1.3.4
	 * @param parentheses
	 * @return
	 */
	public boolean isParenthesesFit(String parentheses) {
		char[] arr = parentheses.toCharArray();

		Stack<Character> st = new Stack<Character>();
		for (char c : arr) {
			if (st.isEmpty()) {
				st.push(c);
				continue;
			}
			if (isFit((char) st.peek(), c)) {
				st.pop();
			} else {
				st.push(c);
			}

		}
		if (st.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isFit(char a, char b) {
		if ("(".equals(a) && ")".equals(b)) {
			return true;
		}
		if ("[".equals(a) && "]".equals(b)) {
			return true;
		}
		if ("{".equals(a) && "}".equals(b)) {
			return true;
		}
		return false;
	}

	/**
	 * 前移编码 p169 1.3.40
	 * @param str
	 */
	public void moveToFront(String str) {

		char[] arrStr = str.toCharArray();
		CharListNode head = new CharListNode(arrStr[0]);
		CharListNode temp;
		for (int i = 0; i < arrStr.length; i++) {
			char c = arrStr[i];
			temp = head;
			boolean flag = false;
			while (temp.next != null) {
				if (temp.next.val == c) {
					CharListNode node = temp.next;
					temp.next = node.next;
					node.next = head;
					head = node;
					flag = true;//
				}
				temp = temp.next;
			}
			if (i > 0 && !flag) {//重复的
				temp.next = new CharListNode(c);
			}
		}

		StringBuffer sb = new StringBuffer();
		while (head != null) {
			sb.append(head.val);
			head = head.next;
		}
		System.out.println(sb.toString());

	}

	/**
	 *
	 *链表
	 * @author  wicloud
	 * @date   2016-5-8
	 */
	public class CharListNode {

		char val;
		CharListNode next;

		CharListNode(char x) {
			val = x;
		}
	}

}
