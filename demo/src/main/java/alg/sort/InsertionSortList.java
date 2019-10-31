package alg.sort;

import alg.AbstractLisitService;
import alg.ListNode;

public class InsertionSortList extends AbstractLisitService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {4,2,1,3};
		ListNode head = build(a);
		ListNode newHead = cal(head);
		print(newHead);
	}
	
	public static ListNode cal (ListNode head) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		
		ListNode curr = head;
		while (curr != null) {
			ListNode tmp = curr.next;
			
			ListNode pos = findPosition(dummy, curr.val);
			curr.next = pos.next;
			pos.next = curr;
			
			curr = tmp;
		}
		
		return dummy.next;
	}
	
	public static ListNode findPosition (ListNode head, int val) {
		ListNode curr = head;
		ListNode pre = head;
		
		while (curr != null) {
			if (curr.val > val) {
				break;
			}
			
			pre = curr;
			curr = curr.next;
		}
		
		return pre;
	}

}
