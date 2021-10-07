import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    Node head;

    public void DoublyLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginging(int data) {
        Node newnode = new Node(data);
        if (isEmpty()) {
            head = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }

    }

    public void insertAtLast(int data) {
        Node newnode = new Node(data);
        if (isEmpty())
            head = newnode;
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
            newnode.prev = temp;
        }
    }

    public void deleteFromBegining() {
        if (!isEmpty()) {
            if (head.next != null)
                head = head.next;
        } else
            System.out.println("Empty List");
    }

    public void displayFromStart() {
        if (!isEmpty()) {
            Node temp = head;
            int counter = 0;
            while (temp != null) {
                System.out.println("Data at " + counter + " index is " + temp.data);
                temp = temp.next;
                counter++;
            }
        } else
            System.out.println("Empty List");
    }
}

class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList obj = new DoublyLinkedList();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(
                    "Enter Choice:\n1. Enter data at begining\n2. Display from start\n3. Enter data at last:\n4. delete from begining\n5. Exit");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("Enter value:");
                    obj.insertAtBeginging(sc.nextInt());
                    break;
                case 2:
                    obj.displayFromStart();
                    break;
                case 3:
                    System.out.println("Enter value:");
                    obj.insertAtLast(sc.nextInt());
                    break;
                case 4:
                    obj.deleteFromBegining();
                    break;
                case 5:
                    System.out.println("Thank You");
                    return;
            }
        }
    }
}
