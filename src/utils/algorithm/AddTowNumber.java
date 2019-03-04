package utils.algorithm;
/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。 你可以假设除了数字 0
 * 之外，这两个数字都不会以零开头。 示例： 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 +
 * 465 = 807
 *
 */
public class AddTowNumber {
	ListNode result = new ListNode(0);	//定义计算结果的node
	ListNode head = result;				//头节点
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		add(l1, l2, 0);
		return head.next;
	}

	public void add(ListNode l1, ListNode l2, int addNumber) {
		if (l1 != null || l2 != null) {
			int val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + addNumber;
			addNumber = val/10;
			val = val%10;
			ListNode node = new ListNode(val);
			result.next = node;
			result = node;
			add((l1 == null ? null : l1.next) ,(l2 == null ? null : l2.next), addNumber);
		}else if (addNumber !=0) {
			result.next = new ListNode(addNumber);
		}
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}