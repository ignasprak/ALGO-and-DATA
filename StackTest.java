// This is a very primitive version of me making a stack (push and pop) program with ssome sample code from my lecture
// StackTest.java
// Linked list implementation of Stack


class Stack {

    int length = 0;
    
    class Node {
        int data;
        Node next;
        public Node getNextNode() {
            return next;
        }
        public int getData() {
            return data;
        }  
    }
    private Node top;
      
    public Stack()
    { 
        top = null;
    }
        
    public void push(int x) {
        Node  t = new Node();
        t.data = x;
        t.next = top;
        top = t;
    }

    // pop() method here
    // only to be called if list is non-empty.
    // Otherwise an exception should be thrown.
    public int pop(int i){
        Node node = top; // we do this because we are selecting the first node in the stack
        top = top.getNextNode(); // this is saying that top is now equal to the next node in the stack
        length--; // i do not know what this does, I assume it takes 1 away from the length of the stack
        return node.getData();
    }

    public void display() {
        Node t = top;     
        System.out.println("\nStack contents are:  ");
        
        while (t != null) {
            System.out.print(t.data + " ");
            t = t.next;
        }        
        System.out.println("\n");
    }

}


public class StackTest
{
    public static void main( String[] arg){
        Stack s = new Stack();
        //Console.Write("Stack is created\n");
        System.out.println("Stack is created\n");
        
        //multiple pushes to insert data into stack
        s.push(10); 
        s.push(3); 
        s.push(11); 
        s.push(7);

        s.display();

        //this is the integer that will be popped
        int i = 7;

        //a pop to show it works
        s.pop(i);
        
        System.out.println("Just popped " + i);
        s.display();
    }
}
