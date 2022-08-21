package leetcode;

public class _876_MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head = head.createList(new int[]{1,2,3,4,5});
        System.out.println(middleNode(head).val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode temp = head,temp1 = head;
        int count =0;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        count++;
        count /= 2;
        while(count --> 0){
            temp1 = temp1.next;
        }

        return temp1;
    }
}
