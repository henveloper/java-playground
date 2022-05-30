import java.util.Iterator;
import java.util.LinkedList;

// Queue is only an intf
public class QueueExamples {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(4);
        ll.add(5);
        ll.add(2, 3);
        System.out.println(ll);

        System.out.println(ll.remove());
        System.out.println(ll.remove(1));
        System.out.println(ll.removeFirst());
        System.out.println(ll.removeLast());

        Iterator<Integer> it = ll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
