
public class AddTwoNumbers_Medium {

    /*
    https://leetcode.com/problems/add-two-numbers/

    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Ex1:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.

    Ex2:
    Input: l1 = [0], l2 = [0]
    Output: [0]

    Ex3:
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
    */

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

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        public void insertNode(int newVal){
            ListNode newNode = new ListNode(newVal);
            ListNode currentNode = this;
            while (currentNode.next != null){
                currentNode=currentNode.next;
            }
            currentNode.next = newNode;
        }

        public void print(){
            ListNode currentNode = this;
            while (currentNode != null){
                System.out.print("-->"+ currentNode.val);
                currentNode=currentNode.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        /*{
            // Test 1
            int[] a1 = {2,4,3};
            int[] a2 = {5,6,4};
            ListNode l1 = populateList(a1);
            ListNode l2 = populateList(a2);
            ListNode resultNode = addTwoNumbers(l1, l2);
            resultNode.print();
        }*/
        /*{
            // Test 2
            int[] a1 = {0};
            int[] a2 = {0};
            ListNode l1 = populateList(a1);
            ListNode l2 = populateList(a2);
            ListNode resultNode = addTwoNumbers(l1, l2);
            resultNode.print();
        }*/
        {
            // Test 3
            int[] a1 = {9,9,9,9,9,9,9};
            int[] a2 = {9,9,9,9};
            ListNode l1 = populateList(a1);
            ListNode l2 = populateList(a2);
            ListNode resultNode = addTwoNumbers(l1, l2);
            ListNode resultNode_alp = addTwoNumbers_alps_way(l1, l2);
            System.out.println("\nThe way questions wants:\n");
            resultNode.print();
            System.out.println("\nThe way Alp developed:\n");
            resultNode_alp.print();
        }
    }

    public static ListNode populateList(int[] arr){
        ListNode l = new ListNode(arr[0]);
        for(int i = 1; i<=arr.length -1; i++){
            l.insertNode(arr[i]);
        }
        return l;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode nextNode = null;
        int iteration_count = 0;
        int carry = 0;

        while (l1 != null || l2 != null){
            iteration_count++;
            int x;
            int y;
            if (l1 == null){
                x = 0;
                l1=null;
            } else {
                x = l1.val;
                l1 = l1.next;
            }

            if (l2 == null){
                y = 0;
                l2=null;
            } else {
                y = l2.val;
                l2 = l2.next;
            }

            int sum = x + y + carry;
            int ones_digit = sum%10;
            carry = sum/10;

            if (iteration_count == 1){
                nextNode = new ListNode(ones_digit);
                resultNode = nextNode;
            } else {
                ListNode tempNode = new ListNode(ones_digit);
                nextNode.next = tempNode;
                nextNode = tempNode;
                //tempNode = tempNode.next;
            }
        }

        if (carry > 0){
            ListNode tempNode = new ListNode(carry);
            nextNode.next = tempNode;
        }
        return resultNode;
    }

    // This solution uses my own ListNode.insertNode(int val) function.
    // However the question doesn't want me to use that.
    public static ListNode addTwoNumbers_alps_way(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        int carry = 0;

        while (l1 != null || l2 != null){
            int x;
            int y;
            if (l1 == null){
                x = 0;
                l1=null;
            } else {
                x = l1.val;
                l1 = l1.next;
            }

            if (l2 == null){
                y = 0;
                l2=null;
            } else {
                y = l2.val;
                l2 = l2.next;
            }

            int sum = x + y + carry;
            int ones_digit = sum%10;
            carry = sum/10;

            resultNode.insertNode(ones_digit);

        }

        if (carry > 0){
            resultNode.insertNode(carry);
        }
        if (resultNode.next != null){
            resultNode = resultNode.next;
        }
        return resultNode;
    }

}
