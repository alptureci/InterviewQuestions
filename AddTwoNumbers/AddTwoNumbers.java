package AddTwoNumbers;

/******************************************************************************

*******************************************************************************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {

    public static void main(String[] args){
        addTwoNumbers();
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }

        @Override
        public String toString(){
            ListNode temp = this;
            String s = "";
            while (temp.next != null){
                s = s + " -> " + temp.val;
                temp = temp.next;
            }
            s = s + " -> " + temp.val;
            return s;
        }
    }

    public static void addTwoNumbers(){
        //(2 -> 4 -> 3) + (5 -> 6 -> 4)
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};

        ListNode l1 = makeList(arr1);
        ListNode l2 = makeList(arr2);

        ListNode result = addTwoNumbers(l1, l2);

        //result.toString();

        System.out.println(result.toString());
    }

    public static ListNode makeList(int[] arr){

        ListNode n = addNext(arr);

        return n;
    }

    public static ListNode addNext(int[] arr){

        if(arr.length < 1){
            return null;
        }

        int val = arr[0];
        int[] rem_arr = new int[arr.length -1];
        ListNode n = new ListNode(val);
        for(int i = 0; i < arr.length - 1; i++){
            rem_arr[i] = arr[i+1];
        }
        n.next = addNext(rem_arr);
        return n;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null){
            return null;
        }

        ListNode ln = null;

        int digitSum = l1.val + l2.val;

        if (digitSum <= 9){
            ln = new ListNode(digitSum);
            ln.next = addTwoNumbers(l1.next, l2.next);
        } else {
            int remainder = digitSum%10;
            ln = new ListNode(remainder);
            l1.next.val = l1.next.val + 1;
            ln.next = addTwoNumbers(l1.next, l2.next);
        }

        return ln;


    }


    /**public static ListNode recursive_node_traversal(ListNode node){
        int current_val = node.val;
        ListNode new_node = null;
        if (node.next != null){
            recursive_node_traversal(node.next);
        } else {
            new_node = new ListNode(current_val);
            return new_node;
        }
        new_node.next = new ListNode(current_val);
        return new_node;
    }*/
}
