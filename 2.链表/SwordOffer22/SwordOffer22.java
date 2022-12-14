package SwordOffer22;

/**
 * @author :lujianbin
 * @create :2020-07-17 20:16:00
 * @description :输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 */
public class SwordOffer22 {

public static void main(String[] args) {
	ListNode ln1 = new ListNode ();
	ListNode ln2 = new ListNode ();
	ListNode ln3 = new ListNode ();
	ListNode ln4 = new ListNode ();
	ListNode ln5 = new ListNode ();
	ln1.next = ln2;
	ln2.next = ln3;
	ln3.next = ln4;
	ln4.next = ln5;
	ln5.next = null;
	ln1.data = 1;
	ln2.data = 2;
	ln3.data = 3;
	ln4.data = 4;
	ln5.data = 5;
	
	SwordOffer22 swordOffer22 = new SwordOffer22 ();
	ListNode kthFromEnd = swordOffer22.getKthFromEnd (ln1, 2);
	System.out.println (kthFromEnd.data);
}

//查找链表中第k个节点
public ListNode getKthFromEnd(ListNode head, int k) {
	//判断链表是否为空以及k是否为小于0的数
	if (head == null || k < 0) {
		return null;
	}
	//将两个指针初始位置都指向头结点
	ListNode fast = head;
	ListNode slow = head;
	
	//将fast节点向右移k位
	for (int i = 0; i < k - 1; i++) {
		if (fast.next != null) {
			fast = fast.next;
		} else {
			return null;    //链表过短，不够k个节点
		}
	}
	//当右指针移动k个位置后，再同时移动两个指针，当右指针为空时左指针刚好在第倒数k位置上
	while (fast.next != null) {
		slow = slow.next;
		fast = fast.next;
	}
	return slow;
}
}
