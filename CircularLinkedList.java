package circularlinkedlist;
public class CircularLinkedList{
    class Node{
        int data;
        Node next;
    }

    Node addToEmpty(Node last, int data){
        if (last != null)
            return last;

        Node temp = new Node();
        temp.data = data;
        last = temp;
        last.next = last;

        return last;
    }

     Node addBegin(Node last, int data){
        if(last == null)
            return addToEmpty(last, data);

        Node temp = new Node();

        temp.data = data;
        temp.next = last.next;
        last.next = temp;

        return last;
    }

    Node addEnd(Node last, int data){
        if (last == null)
            return addToEmpty(last, data);

        Node temp = new Node();

        temp.data = data;
        temp.next = last.next;
        last.next = temp;
        last = temp;

        return last;
    }

     Node addAfter(Node last, int data, int item){
        if (last == null)
            return null;

        Node temp, p;
        p = last.next;

        do{
            if(p.data == item){
                temp = new Node();
                temp.data = data;
                temp.next = p.next;
                p.next = temp;

                if(p == last)
                    last = temp;
                return last;
            }
            p = p.next;
        }
        while(p != last.next);

        System.out.println(item + " not present in the list.");
        return last;
    }

     void traverse(Node last){
        Node p;

        if (last == null){
            System.out.println("List is Empty.");
            return;
        }

        p = last.next;

        do{
            System.out.print(p.data + " ");
            p = p.next;
        }
        while (p != last.next);
    }

    public static void main(String[] args){
        Node last = null;

        CircularLinkedList obj=new CircularLinkedList();

        last = obj.addToEmpty(last,5);
        last = obj.addBegin(last, 3);
        last = obj.addBegin(last, 2);
        last = obj.addEnd(last, 7);
        last = addEnd(last, 11);
        last = addEnd(last, 17);
        last = addEnd(last, 19);
        last = addAfter(last, 13, 11);

        traverse(last);
    }
}