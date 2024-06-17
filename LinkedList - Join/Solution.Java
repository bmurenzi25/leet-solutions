/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // initialize a dummy pointer to the head of the linked list
        ListNode p = l1, q = l2, head = dummyHead;
        int carry = 0;

        while(q != null || p != null) { // check if either of the linked list is not null
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;

            int sum = x + y + carry;
            carry = sum / 10; // get the carry value

            head.next = new ListNode(sum % 10);  // get the remainder of the sum and assign it to the next node of the dummyHead
            head = head.next;

            // update the pointers to the next node by checking if the current node is null
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return dummyHead.next; // return the next node of the dummyHead
    }
}


