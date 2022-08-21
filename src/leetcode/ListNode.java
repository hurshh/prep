package leetcode;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x){
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode createList(int[] values){
        ListNode head = new ListNode(values[0]);
        ListNode temp = head;
        for(int i =1 ; i< values.length;i++){
            temp.next = new ListNode(values[i]);
            temp = temp.next;
        }
        return head;
    }

    public void printList(ListNode node){
        do{
            System.out.print(node.val+ " ");
            node = node.next;
        }
        while (node.next != null);
        System.out.println();
    }

}
