/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learnqueue;

/**
 *
 * @author 
 */
public class LearnQueue {

    /**
     * @param args the command line arguments
     */
    public static void reverseQueue(Queue<String> q) {
        Stack<String> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.insert(s.pop());
        }
    }

    public static void func3(Queue<Integer> q) {
        int sum = 0;
        boolean isBreak = false;
        q.insert(null);
        while (q.head() != null) {
            q.insert(sum);
            sum = 0;
            for (int i = 0; i < 3; i++) {
                if (q.head() == null) {
                    isBreak = true;
                    break;
                }
                sum += q.head();
                q.insert(q.remove());
            }
        }
        q.remove();//null
        q.remove();//sum=0
        if (!isBreak) {
            q.insert(sum);
        }

    }

    public static boolean isExist(Queue<Integer> bigQ, Queue<Integer> smallQ) {
        bigQ.insert(null);
        smallQ.insert(null);
        boolean flag = false;
        while (bigQ.head() != null && !flag) {
            if (bigQ.head() == smallQ.head()) {
                smallQ.insert(smallQ.remove());
                bigQ.insert(bigQ.remove());
                while (smallQ.head() != null && bigQ.head() != null) {
                    flag = true;
                    if (bigQ.head() != smallQ.head()) {
                        flag = false;
                    } else {
                        bigQ.insert(bigQ.remove());
                    }
                    smallQ.insert(smallQ.remove());
                }
            } else {
                bigQ.insert(bigQ.remove());
            }
        }
        if (smallQ.head() != null) {
            while (smallQ.head() != null) {
                smallQ.insert(smallQ.remove());
            }
        }
        if (flag) {
            while (bigQ.head() != null) {
                bigQ.insert(bigQ.remove());
            }
        }

        bigQ.remove();
        smallQ.remove();
        return flag;
    }



public static boolean isPermutationQueue(Queue<Integer> q, int N) {
    int[] counters = new int[N + 1];
    
    while (!q.isEmpty()) {
        int current = q.remove();
        if (current < 1 || current > N) return false; 
        if (counters[current] == 1) return false;    
        counters[current] = 1;
    }
    
 
    for (int i = 1; i <= N; i++) {
        if (counters[i] != 1) return false;
    }
    
    return true;
}


        
    public static void main(String[] args) {
     Queue<Integer> q = new Queue<>();
       
        int N = 5;
        q.insert(3);
        q.insert(1);
        q.insert(5);
        q.insert(7);
        q.insert(2);

       System.out.println(isPermutationQueue(q, N));
        
     
  

    }
}
