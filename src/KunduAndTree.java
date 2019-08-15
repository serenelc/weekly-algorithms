import java.io.*;
import java.util.*;

public class KunduAndTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numNodes = Integer.parseInt(scanner.next());
        List<List> edges = new ArrayList<>();
        HashMap<Integer, List> nodes = new HashMap<>();
        for (int i = 1; i <= numNodes; i++) {
            nodes.put(i, new ArrayList<Integer>());
        }
        int numTriples = 0;

        while (scanner.hasNext()) {
            List<Integer> edge = new ArrayList<>();
            
            int node1 = Integer.parseInt(scanner.next());
            int node2 = Integer.parseInt(scanner.next());
            String color = scanner.next();
            if (color.equals("b")) {
                List<Integer> cannotPair1 = nodes.get(node1);
                List<Integer> cannotPair2 = nodes.get(node2);
                cannotPair1.add(node2);
                cannotPair2.add(node1);
                nodes.put(node1, cannotPair1);
                nodes.put(node2, cannotPair2);
            }

            edge.add(0, node1);
            edge.add(1, node2);
            edges.add(edge);
        }
        System.out.println(nodes.values());
    }
}