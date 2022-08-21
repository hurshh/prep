package leetcode;

public class _19_RemoveNth {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head = head.createList(new int[]{1,2,3,4,5});
        head.printList(head);
        head = removeNthFromEnd(head,2);
        head.printList(head);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null || head.next==null)
            return null;

        ListNode temp = head;
        int length =1;

        while (temp.next != null){
            length++;
            temp = temp.next;
        }

        temp = head;
        length -= n;
        length--;

        if(length == 0){
            return head.next;
        }
        while (length-- >0){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}
