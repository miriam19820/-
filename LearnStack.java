/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learnstack;

import java.util.Scanner;

/**
 *
 * @author 
 */
public class LearnStack {

    /**
     * @param args the command line arguments
     */
    public static int count(Stack<String> s) {
        int mone = 0;
        Stack<String> s2 = new Stack<>();
        while (!s.isEmpty()) {
            mone++;
            s2.push(s.pop());
        }
        while (!s2.isEmpty()) {
            s.push(s2.pop());
        }
        return mone;
    }

    public static boolean sograim() {
        Scanner input = new Scanner(System.in);
        char c;
        Stack<Character> open = new Stack<>();
        Stack<Character> close = new Stack<>();
        do {
            System.out.println("insert the next char from the matematic expression");
            c = input.nextLine().charAt(0);
            if (c == '(' || c == '[' || c == '{') {
                open.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                close.push(c);
            }
        } while (c != '.');
        Stack<Character> help = new Stack<>();
        while (!open.isEmpty()) {
            help.push(open.pop());
        }
        while (!help.isEmpty() && !close.isEmpty()) {
            if ((help.top() == '(' && close.top() != ')') || (help.top() == '[' && close.top() != ']') || (help.top() == '{' && close.top() != '}')) {
                return false;
            }
            help.pop();
            close.pop();
        }
        return help.isEmpty() && close.isEmpty();

    }

    public static void delete(Stack<Integer> s, int num) {
        Stack<Integer> s2 = new Stack<>();
        while (!s.isEmpty()) {
            if (s.top() == num) {
                s.pop();
            } else {
                s2.push(s.pop());
            }
        }
        while (!s2.isEmpty()) {
            s.push(s2.pop());
        }
    }

    public static boolean func7(String str) {
        if (str.length() % 2 == 0 || str.charAt(str.length() / 2) != 'y') {
            return false;
        }
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < str.length() / 2; i++) {
            s1.push(str.charAt(i));
        }
        for (int i = str.length() / 2 + 1; i < str.length(); i++) {
            if (str.charAt(i) != s1.pop()) {
                return false;
            }
        }
        return true;

    }

    public static boolean isParityStack(Stack<Integer> st) {
        int countZ = 0, countEZ = 0, sumZ = 0, sumEZ = 0;
        Stack<Integer> st2 = new Stack<>();
        boolean flag = true;
        while (!st.isEmpty() && flag) {
            if (st.top() < 0) {
                flag = !flag;
            }
            if (st.top() % 2 == 0) {
                countZ++;
                sumZ += st.top();
            } else {
                countEZ++;
                sumEZ += st.top();
            }
            st2.push(st.pop());
        }
        while (!st2.isEmpty()) {
            st.push(st2.pop());
        }
        return sumZ == sumEZ && countZ == countEZ && flag;
    }
       public static int Getsumofstack(Stack<Integer> st){
   int sum=0;
   while(!st.isEmpty()){
   sum+=st.pop();
}
return sum;
   }
 public static int Getstacklestvalue(Stack<Integer> st){
int end=0;
 while(!st.isEmpty()){
 end=st.pop();}
return end;}
 public static Stack<Integer> Doit(Node<Stack<Integer>> chain){
    Stack<Integer> newStack = new Stack<>();
    Node<Stack<Integer>> current = chain; 

    while (current != null) {
        Stack<Integer> st = current.getValue();
      Stack<Integer> stCopy = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int count = 0;

        while (!st.isEmpty()) {
            int val = st.pop();
            stCopy.push(val);
            temp.push(val);
            count++;  
        }

       
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }

        
        Stack<Integer> copyForSum = new Stack<>();
        Stack<Integer> copyForEnd = new Stack<>();
        Stack<Integer> stCopyTemp = new Stack<>();
        while (!stCopy.isEmpty()) {
            int val = stCopy.pop();
            copyForSum.push(val);
            copyForEnd.push(val);
            stCopyTemp.push(val);
        }
        while (!stCopyTemp.isEmpty()) {
            stCopy.push(stCopyTemp.pop());
        }

        int sum = Getsumofstack(copyForSum);
        int end = Getstacklestvalue(copyForEnd);

        if (count % 2 == 0)
            newStack.push(sum);
        else
            newStack.push(end);

        current = current.getNext();
    }

    return newStack;
}


  

    public static boolean ExistSum(Stack<Integer> s, int num) {
        Stack<Integer> s2 = new Stack<>(), trash = new Stack<>();
        int n;
        boolean flag = false;
        while (!s.isEmpty() && !flag) {
            n = s.pop();
            if (n > num) {
                trash.push(n);
            } else {
                while (!s.isEmpty()) {
                    if (n + s.top() == num) {
                        flag = true;
                    }
                    s2.push(s.pop());
                }
                s = s2;
                s2 = new Stack<>();
                trash.push(n);
            }

        }
        while (!trash.isEmpty()) {
            s.push(trash.pop());
        }
        return flag;
    }

   

    public static void main(String[] args) {
//        Stack<Integer> s1 = new Stack<>();
//        s1.push(1);
//        s1.push(2);
//        s1.push(3);
//        System.out.println(s1);
//        System.out.println(s1.pop());
//        System.out.println(s1);
//        Stack<String> s2 = new Stack<>();
//        s2.push("Miryami");
//        s2.push("Chaya");
//        s2.push("Sari");
//        s2.push("Sara");
//        s2.push("Miryam");
//        System.out.println(s2);
//        System.out.println(count(s2));
//        System.out.println(sograim());
//        System.out.println("-------------");
//        System.out.println(func7("ABCyCBA"));
//        System.out.println(func7("ABCyyyCBa"));
//        Stack<Integer> st = new Stack<>();
//        st.push(1);
//        st.push(5);
//        st.push(2);
//        st.push(8);
//        st.push(11);
//        st.push(4);
//        st.push(3);
//        System.out.println(Getsumofstack(st));
 //  Stack<Integer> st = new Stack<>();
 //      st.push(1);
  //     st.push(5);
 //      st.push(2);
 //      st.push(8);
 //      st.push(11);
 //      st.push(4);
 //      st.push(3);
 //        System.out.println(Getstacklestvalue(st));
 //   }
  Stack<Integer> st1 = new Stack<>();
    st1.push(1);
    st1.push(2);
    st1.push(3);

    Stack<Integer> st2 = new Stack<>();
    st2.push(4);
    st2.push(5);

    Stack<Integer> st3 = new Stack<>();
    st3.push(6);
    st3.push(7);
    st3.push(8);
    st3.push(9);
    
    Node<Stack<Integer>> n1 = new Node<>(st1);
    Node<Stack<Integer>> n2 = new Node<>(st2);
    Node<Stack<Integer>> n3 = new Node<>(st3);
   n1.setNext(n2);
   n2.setNext(n3);

    
    Stack<Integer> resultStack = Doit(n1);
      while (!resultStack.isEmpty()) {
        System.out.println(resultStack.pop());
    }}
}
