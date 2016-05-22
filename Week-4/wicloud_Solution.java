/**
 * @(#)Solution3.java   2016-5-11
 * Copyright 2016  wicloud.com, Inc. All rights reserved.
 */

package com.wicloud.alphago;

/**
 * Week-4 LeetCode 习题
 *
	19 Remove Nth Node From End of List 29.7% Easy
	20 Valid Parentheses 29.6% Easy
	17 Letter Combinations of a Phone Number 28.9% Medium
	18 4Sum 23.8% Medium
 *
 * @author  wicloud
 * @date   2016-5-21
 */

public class Solution4 {

	/**
	 * 19. Remove Nth Node From End of List
	 * Given a linked list, remove the nth node from the end of list and return its head.
		For example,
		Given linked list: 1->2->3->4->5, and n = 2.
		After removing the second node from the end, the linked list becomes 1->2->3->5.
		Note:
		Given n will always be valid.
		Try to do this in one pass.
	 */

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int len = 1;
		ListNode headTmp = head;
		while (null != head.next) {
			head = head.next;
			len++;
		}
		int skip = len - n;
		ListNode headRes = headTmp;
		if (n == len) {
			headRes = headTmp.next;
			return headRes;
		}
		len = 1;
		while (null != headTmp.next) {
			if (skip == len) {
				if (null != headTmp.next) {
					headTmp.next = headTmp.next.next;
				} else {
					headTmp.next = null;
				}
				break;
			}
			headTmp = headTmp.next;
			len++;
		}
		return headRes;
	}

	/**
	 *  Definition for singly-linked list.
	 * @author wicloud  
	 * @date 2016-5-21
	 */

	public class ListNode {

		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
