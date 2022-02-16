// QueueTest.java
// Allocation of Queue objects in main()

/*
TASK AT HAND:

Compile and run QueueTest.java.  
Then implement deQueue() and test it.  
Also implement the operation boolean isMember(int x) which returns true if x in the queue. 
Does it give the correct answer?
*/

//libraries
import java.util.Scanner;  // Import the Scanner class

class Queue {
    int intArray[]; // this is an array that will be with ints
    int lenArray = 0;

    private class Node {
        int data;
        Node next;
        public Node getNextNode(){
            return next;
        }
        public int getData(){
            return data;
        }
    }

    Node z, head, tail;

    public Queue() {
        z = new Node(); z.next = z;
        head = z;  tail = null;
    }

    public void enQueue( int x) {
        Node t;

        t = new Node();
        t.data = x;
        t.next = z;

        if(head == z)       // case of empty list
            head = t;
        else                // case of list not empty
            tail.next = t;
            
        tail = t;           // new node is now at the tail
        lenArray += 1;
    }

  // assume the queue is non-empty when this method is called
    public int deQueue(int x) {
        Node node = head;
        head = head.getNextNode();
        lenArray -= 1;
        System.out.println("The length of the queue is: " + lenArray);
        return node.getData();

    }
    
    public boolean isEmpty() {
        return head == head.next;
    }

    public boolean isMember(int x) {
        Node t = head;
        while( t != t.next) {
            if (t.data == x) {
                return true;
            } else if (t.next != null) {
                t = t.next;
            } else {
                return false;
            }
        }
        return false;
    }
    
    public void display() {
        System.out.println("\nThe queue values are:\n");

        Node t = head;
        while( t != t.next) {
            System.out.print( t.data + "  ");
            t = t.next;
        }
        System.out.println("\n");
        System.out.println("The length of the queue is: " + lenArray);
    } 

} // end of Queue class



class QueueTest {

  public static void main(String[] arg) {

                    try (Scanner myObj = new Scanner(System.in)) 
                    {
                        Queue q = new Queue();
                        int option = 0;

                        do 
                        {
                            System.out.println("1. Enqueue ");
                            System.out.println("2. Dequeue ");
                            System.out.println("3. Check if in queue? ");
                            System.out.println("4. Display queue ");
                            System.out.println("5. Exit ");
                            System.out.println("Please enter in an option: \n");                        
                            option = myObj.nextInt();  // Read user input

                            switch (option)
                            {
                                case 1:
                                {
                                    System.out.println("What number would you like to enqueue? ");
                                    int numEnqueue = myObj.nextInt();
                                    q.enQueue(numEnqueue);
                                    q.display();
                                    // System.out.println("Inserting ints from 9 to 1 into queue gives:\n");
                                    // for (int i = 9; i > 0; --i) {
                                    //     q.enQueue(i);
                                    break;
                                    
                                } //end of option 1

                                case 2:
                                {
                                    if(!q.isEmpty())
                                    System.out.println("Deleting value from queue " + q.deQueue(9) + "\n");
                                    break;
                                }

                                case 3:
                                {      
                                    System.out.println("Input a number to see if it is in the queue ");
                                    int num = myObj.nextInt(); // getting user input
                                    if (q.isMember(num) == true)
                                    {
                                        System.out.println("The number " + num + " is in the queue\n");
                                    }
                                    if (q.isMember(num) == false)
                                    {
                                        System.out.println("The number " + num + " is not in the queue\n");
                                    }
                                    break;
                                }

                                case 4:
                                {   
                                    q.display();
                                }

                                case 5:
                                {
                                    break;
                                }

                                default:
                                {
                                    System.out.println("Choice must be a value between 1 and 4.");
                                }
                            } // end of switch

                        }while (option != 5); // end of do..while loop
                            
                    } // end of try

                    } // end of main

} //end of QueueTest

