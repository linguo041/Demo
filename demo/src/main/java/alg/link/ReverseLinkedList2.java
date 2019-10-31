package alg.link;

import alg.AbstractLisitService;
import alg.ListNode;

public class ReverseLinkedList2 extends AbstractLisitService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3};
//		int a[] = {3, 5};
		ListNode head = build(a);
		ListNode newHead = cal(head, 1, 2);
		print(newHead);
	}
	
	public static ListNode cal (ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}
		
		ListNode curr = head;
		ListNode beforeM = null;
		ListNode nodeM = null;
		ListNode pre = head;
		int i = 0;
		
		while (curr != null && i++ <= n) {
			ListNode nextN = curr.next;
			
			if (i < m) {
				beforeM = curr;
			} else if ( i == m) {
				nodeM = curr;
			} else if (i < n) {
				curr.next = pre; 
			} else {
				if (beforeM != null) {
					beforeM.next = curr;
				} else {
					head = curr;
				}
				
				curr.next = pre;
				nodeM.next = nextN;
				
				break;
			}
			
			pre = curr;
			curr = nextN;
		}
		return head;
	}
}
