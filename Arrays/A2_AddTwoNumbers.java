public class A2_AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {} //constructors
        ListNode(int val) { this.val = val; } 
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //Chatgpt solution
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            /*
            * use dummyHead so that no need to check is l1 l2 empty
            * curr is current index
            * carry is the value bring to next position
            */

            ListNode dummyHead = new ListNode(0);
            ListNode curr = dummyHead;
            int carry = 0;
            
            /*
             * unless l1 l2 both empty and carry is put in
             * the program keep processing
             */
            while (l1 != null || l2 != null || carry != 0) {
                int x = (l1 != null) ? l1.val : 0;  //check null & assign value at same time
                int y = (l2 != null) ? l2.val : 0;
                //compute value at this digit,  carry from last calc
                int sum = x + y + carry;
                //check is there a carry, value less than 10 will return 0
                carry = sum / 10;


                //save the current bit to next node
                curr.next = new ListNode(sum % 10);
                //move to next node
                curr = curr.next;

                //after computation, move to next bit
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            //return the actual value not the head, computation starts from head.next which is curr.next
            return dummyHead.next;
        }
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // l1 = [2, 4, 3]
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));

        // l2 = [5, 6, 4]
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));


        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        //result suppose to be 7 -> 0 -> 8
        System.out.print("Result: ");
        printList(result);
    }
}
