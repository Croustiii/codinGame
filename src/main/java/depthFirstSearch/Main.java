package depthFirstSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        InputReader inputReader = new InputReader(5, 4, 2);

        inputReader.addRelation("0 1");
        inputReader.addRelation("0 2");
        inputReader.addRelation("1 3");
        inputReader.displayMatrix();

    }



}

// Classe  responsable de la lecture des inputs et de la construction de la matrice d'adjacence à partir des inputs de l'exercice Coding Game
class InputReader{

    // Nombre de sommets N
    public int nodeCountN;
    // Nobmre de liens L
    public int edgesCount;
    //Nombre de passerelles de sortie E
    public int exitCount;

    // hashmap Matrice d'adjacency
    public HashMap<String, HashSet<String>> adjacencyMatrix = new HashMap<>();

    public InputReader(int nodeCountN, int edgesCount, int exitCount) {
        this.nodeCountN = nodeCountN;
        this.edgesCount = edgesCount;
        this.exitCount = exitCount;
    }

    public void addRelation(String input){
        String[] inputArray = input.split(" ");
        String node1 = inputArray[0];
        String node2 = inputArray[1];

        if(!adjacencyMatrix.containsKey(node1)){
            adjacencyMatrix.put(node1, new HashSet<>(List.of(node2)));
        } else if (adjacencyMatrix.containsKey(node1)) {
            if(!adjacencyMatrix.get(node1).contains(node2)){
                adjacencyMatrix.get(node1).add(node2);
            }
        }

        if(!adjacencyMatrix.containsKey(node2)){
            adjacencyMatrix.put(node2, new HashSet<>(List.of(node1)));
        }else if (adjacencyMatrix.containsKey(node2)){
            if(!adjacencyMatrix.get(node2).contains(node1)){
                adjacencyMatrix.get(node2).add(node1);
            }
        }

    }
    public void displayMatrix(){
        System.out.println(adjacencyMatrix);
    }

    public Node buildBinaryTree(HashMap<String, String[]> AdjacencyList, Node rootNode){
        // Create a map to store the nodes
        HashMap<String, Node> nodes = new HashMap<>();

        // Create a node for each key in the adjacency list
        for(String key : AdjacencyList.keySet()){
            nodes.put(key, new Node(key));
        }

        // Assign children to each node
        for(Map.Entry<String, String[]> entry : AdjacencyList.entrySet()){
            Node node = nodes.get(entry.getKey());
            String[] children = entry.getValue();

            // Assign the left and right children, if they exist
            if(children.length > 0){
                node.left = nodes.get(children[0]);
            }
            if(children.length > 1){
                node.right = nodes.get(children[1]);
            }
        }

        // Return the root node
        return nodes.get(rootNode.key);
    }

}
