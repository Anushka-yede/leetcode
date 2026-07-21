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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            boolean isfound = false;
            while(curr!= null && set.contains(curr.val)){
                isfound = true;
                curr = curr.next;
            }
            if(isfound){
                count++;
            }

            if(curr != null){
                curr = curr.next;
            }
        }
        return count;
    }
}