/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learnlinkedlist;

/**
 *
 * @author 
 */
public class learnCircleList {

    public static void insertHead(Node<Integer> tail, int val) {
        Node<Integer> newNode = new Node<>(val);
        newNode.setNext(tail.getNext());
        tail.setNext(newNode);
    }

    public static Node<Integer> insertAfter(Node<Integer> tail, int val) {
        Node<Integer> newNode = new Node<>(val);
        newNode.setNext(tail.getNext());
        tail.setNext(newNode);
        return newNode;
    }

    public static void DeleteHead(Node<Integer> tail) {
        tail.setNext(tail.getNext().getNext());
    }

    public static Node<Integer> deletAfter(Node<Integer> tail) {
        Node<Integer> curr = tail.getNext(); // = head
        while (curr.getNext() != tail) {
            curr = curr.getNext();
        }
        curr.setNext(tail.getNext());
        return curr;
    }

    public static void printCircleList(Node<Integer> tail) {
        Node<Integer> curr = tail.getNext(); // = head
        String s = "";
        while (curr != tail) {
            s = s + " " + curr.getValue();
            curr = curr.getNext();
        }
        s = s + " " + curr.getValue();
        System.out.println(s);
    }
        public static void printList(Node<Integer> tail) {
        if (tail == null) return;

        Node<Integer> head = tail.getNext();
        Node<Integer> curr = head;

        do {
            System.out.print(curr.getValue() + " ");
            curr = curr.getNext();
        } while (curr != head);

        System.out.println();
    }

  

//שאלה 3
    public static int hefresh(Node<Integer> tail) {
        int countZ = 0, countEZ = 0;
        Node<Integer> curr = tail.getNext(); // = head
        while (curr != tail) {
            if (curr.getValue() % 2 == 0) {
                countZ += curr.getValue();
            } else {
                countEZ += curr.getValue();
            }
            curr = curr.getNext();
        }
        if (curr.getValue() % 2 == 0) {
            countZ += curr.getValue();
        } else {
            countEZ += curr.getValue();
        }
        return countZ - countEZ;
//        return Math.abs(countZ)
    }
    //שאלה 10
    public static Node<Integer> chitooch(Node<Integer> tail1, Node<Integer> tail2) {
        Node<Integer> tail3 = null, curr1 = tail1.getNext(), curr2;
        while (curr1 != tail1) {
            curr2 = tail2.getNext();
            while (curr2 != tail2 && curr1.getValue() != curr2.getValue()) {
                curr2 = curr2.getNext();
            }
            if (curr2.getValue() == curr1.getValue()) {
                if (tail3 == null) {
                    tail3 = new Node<Integer>(curr2.getValue());
                } else {
                    insertHead(tail3, curr2.getValue());
                }
            }
            curr1 = curr1.getNext();
        }
        return tail3;
    }
//    public static Node<Integer> AllLists(Node<Integer> tail1, Node<Integer> tail2) {
//        Node<Integer> curr = tail1.getNext();
//        Node<Integer> curr1 = tail1.getNext();
//        Node<Integer> curr2 = tail2.getNext();
//        if (tail1 == null) {
//            return tail2;
//        }
//        if (tail2 == null) {
//            return tail1;
//        }
//        tail1.setNext(curr2);
//        tail2.setNext(curr1);
//        return tail2;
//
//    }
    //שאלה 11
public static Node<Integer> echoodlist(Node<Integer> tail1, Node<Integer> tail2) {
    Node<Integer> tail3 = null; 
    Node<Integer> curr3 = null; 

 
    Node<Integer> curr1 = tail1.getNext();
    while (curr1 != tail1) {
        Node<Integer> newNode = new Node<>(curr1.getValue());
        if (tail3 == null) {
            tail3 = newNode;
            curr3 = tail3;
        } else {
            curr3.setNext(newNode);
            curr3 = newNode;
        }
        curr1 = curr1.getNext();
    }
   
    Node<Integer> newNode = new Node<>(tail1.getValue());
    if (tail3 == null) {
        tail3 = newNode;
        curr3 = tail3;
    } else {
        curr3.setNext(newNode);
        curr3 = newNode;
    }

  
    Node<Integer> curr2 = tail2.getNext();
    while (curr2 != tail2) {
      
        boolean exists = false;
        Node<Integer> check = tail3;
        while (check != null) {
            if (check.getValue().equals(curr2.getValue())) {
                exists = true;
                break;
            }
            check = check.getNext();
        }

       
        if (!exists) {
            Node<Integer> newNode2 = new Node<>(curr2.getValue());
            curr3.setNext(newNode2);
            curr3 = newNode2; 
        }

        curr2 = curr2.getNext();
    }

 
    curr3.setNext(tail3);

    return tail3;
}
//שאלה 4
 public static Node<Integer> avgInList(Node<Integer> tail) {
    if (tail == null) {
        return null;
    }

    Node<Integer> head = tail.getNext();
    Node<Integer> curr = head.getNext(); 

    int count = 1; 
    int sum = head.getValue();

    while (curr != head) {  
        count++;
        sum += curr.getValue();
        curr = curr.getNext();
    }

    int avg = sum / count;
    Node<Integer> newNode = new Node<>(avg);

    // מחברים את הצומת החדש אחרי ה-tail
    newNode.setNext(head);
    tail.setNext(newNode);

    return newNode; // tail החדש
}
// // שאלה 7
// public static void deleatemeninlist(Node<Integer> tail){
// Node<Integer> curr=tail.getNext();//
// while(curr.getNext()!=tail){//כל עוד האיבר הציפיציפי הוא לא הזנב האיבר האחרון
// curr=curr.getNext().getNext();
// 
// }
 //שאלה 8
public static Node<Integer> addxinlist(Node<Integer> tail, int x) {
    Node<Integer> newNode = new Node<>(x);

    // רשימה ריקה
    if (tail == null) {
        newNode.setNext(newNode);
        return newNode;
    }

    Node<Integer> curr = tail.getNext(); // head
    Node<Integer> prev = tail;

  
    do {
        if (curr.getValue() < x) {
            prev = curr;
            curr = curr.getNext();
        } else {
            break;
        }
    } while (curr != tail.getNext());

    prev.setNext(newNode);
    newNode.setNext(curr);

  
    if (x > tail.getValue()) {
        return newNode;
    } else {
        return tail;
    }
}
 public static Node<Integer> DeleteEveryThird(Node<Integer> tail) {
        Node<Integer> curr = tail.getNext();
        int count = 1;
        while (curr != tail) {
            count++;
            curr = curr.getNext();

        }
        curr = tail;

        while (count > 1) {
            curr = curr.getNext();
            curr = curr.getNext();
            System.out.println(curr.getNext().getValue());
            curr.setNext(curr.getNext().getNext());
            count--;

        }
        System.out.println("last one: " + curr.getValue());
        return curr;
    }
 //שאלה 9
 public static Node<Integer> func9(Node<Integer> tail1, Node<Integer> tail2) {
        Node<Integer> head1 = tail1.getNext();
        Node<Integer> head2 = tail2.getNext();
        tail1.setNext(head2);
        tail2.setNext(head1);
        return tail2;
    }

public static void main(String[] args) {
 
 //   Node<Integer> n1 = new Node<>(1);
  //  Node<Integer> n2 = new Node<>(2);
//    Node<Integer> n3 = new Node<>(3);
//    Node<Integer> n4 = new Node<>(4);
//    n1.setNext(n2);
//    n2.setNext(n3);
//    n3.setNext(n4);
//    n4.setNext(n1); 
//    Node<Integer> tail1 = n4;

  
 ///   Node<Integer> m1 = new Node<>(3);
 //   Node<Integer> m2 = new Node<>(4);
 //   Node<Integer> m3 = new Node<>(5);
 //   Node<Integer> m4 = new Node<>(6);
//    m1.setNext(m2);
 //   m2.setNext(m3);
 //   m3.setNext(m4);
 //   m4.setNext(m1); 
 //   Node<Integer> tail2 = m4;

  
 //   Node<Integer> tail3 = echoodlist(tail1, tail2);

 //   Node<Integer> curr = tail3;
 //   if (curr != null) {
  //      do {
  ///          System.out.print(curr.getValue() + " -> ");
  //          curr = curr.getNext();
  //      } while (curr != tail3);
  //      System.out.println("(חזרה לראש)");
  //  }
//}}
        //func9 הרצה
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n3 = new Node<>(3, n4);
        Node<Integer> n2 = new Node<>(2, n3);
        Node<Integer> n1 = new Node<>(1, n2);
        n4.setNext(n1);
        Node<Integer> tail1 = n4;
        Node<Integer> n8 = new Node<>(8);
        Node<Integer> n7 = new Node<>(7, n8);
        Node<Integer> n6 = new Node<>(6, n7);
        Node<Integer> n5 = new Node<>(5, n6);
        n8.setNext(n5);
        Node<Integer> tail2 = n8;
        func9(tail1, tail2);
        printCircleList(tail2);
    }
}

      //  printCircleList(tail);
       // insertHead(tail, 0);
       // printCircleList(tail);
      //  tail = insertAfter(tail, 5);
      //  printCircleList(tail);
      //  DeleteHead(tail);
      //  printCircleList(tail);
       // tail = deletAfter(tail);
        //printCircleList(tail);


    // יצירת צמתים
//    Node<Integer> n1 = new Node<>(10);
//    Node<Integer> n2 = new Node<>(20);
//    Node<Integer> n3 = new Node<>(30);
//    Node<Integer> n4 = new Node<>(40);
//    Node<Integer> n5 = new Node<>(60);
//    Node<Integer> n6 = new Node<>(70);
//    Node<Integer> n7 = new Node<>(80);

    // חיבור צמתים ליצירת רשימה מעגלית
//    n1.setNext(n2);
//    n2.setNext(n3);
//    n3.setNext(n4);
//    n4.setNext(n5);
//    n5.setNext(n6);
//    n6.setNext(n7);
//    n7.setNext(n1); // חזרה ל-head

    // tail מתחיל בצומת האחרון
//    Node<Integer> tail = n7;

    // הדפסה לפני הוספה
//    System.out.println("לפני הוספה:");
//    printList(tail);
//
//    // הוספת איבר חדש (למשל X = 25)
//    tail = addxinlist(tail, 25);
//
//    // הדפסה אחרי הוספה
//    System.out.println("אחרי הוספה:");
//    printList(tail);
//}}

//        // לפני הוספת הממוצע
//        System.out.println("לפני:");
//        printList(tail);
//
//        // מוסיפים את הממוצע
//        tail = avgInList(tail);
//
//        // אחרי הוספת הממוצע
//        System.out.println("אחרי:");
//        printList(tail);
//    }
//
//    // פונקציה להדפסת רשימה מעגלית
//    public static void printList(Node<Integer> tail) {
//        if (tail == null) return;
//
//        Node<Integer> head = tail.getNext();
//        Node<Integer> curr = head;
//
//        do {
//            System.out.print(curr.getValue() + " ");
//            curr = curr.getNext();
//        } while (curr != head);
//
//        System.out.println();
//    }
//


