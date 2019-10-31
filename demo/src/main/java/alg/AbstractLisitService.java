package alg;

public class AbstractLisitService {

	public static ListNode build (int[] a) {
		ListNode head = new ListNode(a[0]);
		ListNode before = head;
		
		for (int i = 1; i < a.length; i++) {
			ListNode node = new ListNode(a[i]);
			before.next = node;
			before = node;
		}
		
		return head;
	}
	
	public static void print (ListNode head) {
		ListNode node = head;
		
		while (node != null) {
			System.out.print(node.val + ", ");
			node = node.next;
		}
	}
	
	public static ListNode findMedian (ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static ListNode reverse (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode prev = head, curr = head.next;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head.next = null;
		
		return prev;
	}
}
