package alg.link;

import alg.AbstractLisitService;
import alg.ListNode;

public class RemoveDuplicates extends AbstractLisitService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int a[] = {1,2,3,3,4,4,5,5,5};
		int a[] = {1,1,1,2,3};
		ListNode head = build(a);
		ListNode newHead = cal(head);
		print(newHead);
	}
	
	public static ListNode cal (ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode pre = null;
		ListNode curr = head;
		boolean duplicate = false;
		
		while (curr.next != null) {
			if (curr.val == curr.next.val) {
				duplicate = true;
			}

			if (curr.val != curr.next.val) {
				if (duplicate) {
					if (pre != null) {
						pre.next = curr.next;
					} else {
						head = curr.next;
					}
					duplicate = false;
				} else {
					pre = curr;
				}
			}
			
			curr = curr.next;
		}
		
		if (pre == null) {
			if (duplicate) {
				return null;
			} else {
				return curr;
			}
		}
		
		if (duplicate) {
			pre.next = null;
		}
		
		return head;
	}

}
