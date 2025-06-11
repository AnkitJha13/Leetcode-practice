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
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    private ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;


    }
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) return true;
        
        ListNode middle = findMiddle(head);

        ListNode temp = middle.next;
        middle.next = reverse(temp);

        ListNode head1 = head;
        ListNode head2 = middle.next;

        while(head2 != null){
            if(head1.val != head2.val){
                return false;
            }
            else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return true;
    }
}