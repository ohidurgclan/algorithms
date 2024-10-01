import java.io.*;
import java.util.*;

public class adjacencyList {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
  
    public static void main(String[] args) {
        String filePath = "src\\graph.txt"; 
        readGraphFromFile(filePath);
        printAdjacencyList();
    }
    private static void readGraphFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int node = Integer.parseInt(parts[0]);
                List<Integer> neighbors = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    neighbors.add(Integer.parseInt(parts[i]));
                }
                graph.put(node, neighbors); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printAdjacencyList() {
        System.out.println("Adjacency List Representation:");
        for (int node : graph.keySet()) {
            System.out.print(node + ": ");
            for (int neighbor : graph.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
