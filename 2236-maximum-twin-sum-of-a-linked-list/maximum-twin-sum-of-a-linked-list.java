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
    ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!= null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondhalf = reverseList(slow);
        ListNode firsthalf = head;
        int maxtwin = 0;

        while(secondhalf!= null){
            int twinsum = firsthalf.val + secondhalf.val;
            if(twinsum > maxtwin) maxtwin = twinsum;
            firsthalf = firsthalf.next;
            secondhalf = secondhalf.next;
        }
        return maxtwin;
    }
}