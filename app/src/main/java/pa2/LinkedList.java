package pa2;

/**
 * A sorted singly linked list of integers
 */
public class LinkedList {

    /**
     * A node in the linked list
     */
    public Node head;

    /**
     * Constructor
     * Initialize the linked list with a null head
     */
    public LinkedList() {
        this.head = null;
    }

    /** 
     * Add a new node to the linked list 
     * so that the list remains sorted
     * @param value The value to add
     * @return void
     */
    public void add(int value) {
        Node new_node = new Node(value);
        if(this.head == null){
            this.head = new_node;
        }
        else if (new_node.value < this.head.value){
            new_node.next = this.head;
            this.head = new_node;
        }
        else{
            Node current = this.head;
            while (current.next != null){
                if (new_node.value < current.next.value){
                    new_node.next = current.next;
                    current.next = new_node;
                    break;
                }
                current = current.next;
            }
            if(current.next == null){
                current.next = new_node;
            }
        }
        

        
    }

    /**
     * Remove the first node with the given value
     * If the value is not found, do nothing
     * @param value The value to remove
     * @return void
     */
    public void remove(int value) {
        Node current = this.head;
        if (current.value == value){
            this.head = current.next;
        }
        else{
            while (current.next != null){
                if (current.next.value == value){
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
        }
    }

    /**
     * Traverse the linked list RECURSIVELY and returns a string representation of the list
     * @param current
     * @return String
     */
    
    public String traverse_recur(Node current){
        if (current == null){
            return "";
        }
        return current.value + " " + traverse_recur(current.next);
    }

    /**
     * Traverse the linked list and returns a string representation of the list
     * @return String
     */
    public String traverse(){
        Node current = this.head;
        String result = "";
        while (current.next != null){
            result = result + current.value + " ";
            current = current.next;
        }
        result += current.value + " ";
        return result;
    }

    /**
     * Traverse the linked list RECURSIVELY and 
     * returns the reverse string representation of the list
     * e.g. the linked list 1 -> 2 -> 3 -> 4 will be printed as 4 3 2 1
     * @return String
     */
    public String reverse(Node current){
        if (current == null){
            return "";
        }
        return reverse(current.next) + current.value + " ";
    }


    /**
     * Merges two sorted linked list and returns the 
     * merged linked list that is also sorted
     * @param list1 The first sorted linked list
     * @param list2 The second sorted linked list 
     * @return LinkedLists
     */
    public static LinkedList merge(LinkedList list1, LinkedList list2){
        LinkedList mergedList = new LinkedList();
        Node curr1 = list1.head;
        Node curr2 = list2.head;
        // checks if list 1 or 2 is empty
        if (curr1 == null) {
            mergedList.head = curr2;
            return mergedList;
        }
        if (curr2 == null) {
            mergedList.head = curr1;
            return mergedList;
        }
        // checks which value is least and sets the head
        if (curr1.value <= curr2.value) {
            mergedList.head = curr1;
            curr1 = curr1.next;
        } 
        else {
            mergedList.head = curr2;
            curr2 = curr2.next;
        }
        // sets current to head and runs until one of the lists is empty
        Node current = mergedList.head;
        while (curr1 != null && curr2 != null) {
            if (curr1.value <= curr2.value) {
                current.next = curr1;
                curr1 = curr1.next;
            } else {
                current.next = curr2;
                curr2 = curr2.next;
            }
            current = current.next;
        }
        // adds the list that is not empty to the mergedlist
        if (curr1 != null) {
            current.next = curr1;
        }
        if (curr2 != null) {
            current.next = curr2;
        }
        return mergedList;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.traverse());
        list.remove(4);
        System.out.println(list.traverse());
    }
}