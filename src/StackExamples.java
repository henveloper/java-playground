import java.util.Iterator;
import java.util.Stack;

public class StackExamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.search(3)); 
        System.out.println(stack.pop());
        stack.sort(null);

        Iterator<Integer> it = stack.iterator(); // vector
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();
    }
}
