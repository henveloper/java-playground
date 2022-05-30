package syntax;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class MapExamples {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        for (Entry<String, Integer> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
    }
}
