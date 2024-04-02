package phoneNumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberNode {

    public Integer value;

    public List<NumberNode> childNodes;

    public NumberNode() {
        this.childNodes = new ArrayList<NumberNode>();
    }

    public NumberNode(Integer value) {
        this.childNodes = new ArrayList<NumberNode>();
        this.value = value;
    }

    public NumberNode hasChild(Integer num){

        if(num != null && !childNodes.isEmpty()){
            for(NumberNode node : childNodes){
                if(node.value == num) return node;
            }
            return null;
        }
        return null;
    }

    public Queue<Integer> toQueue(String numbers){
        Queue<Integer> queueNumbers = new LinkedList<>();
        for(String s : numbers.split("")){
            queueNumbers.offer(Integer.parseInt(s));
        }
        return queueNumbers;
    }

    public void process(Queue<Integer> numbers, NumberNode node){

        Integer next = numbers.poll();
        // cas 1 il reste des numéros a évaluer et le noeud contient un enfant qui à ce numéro
        if(next != null && node.hasChild(next) != null){

            process(numbers, node.hasChild(next));
        }
        // cas 2 il reste des numéros a évaluer et aucun enfant n'a la valeur recherchée actuellee
        if(next != null && node.hasChild(next) == null){
            // ajouter le noeud enfant avec la valeur actuelle
            node.childNodes.add(new NumberNode(next));
            // Continuer le process avec le noeud suivant
            NumberNode nextNode = node.hasChild(next);
            process(numbers, nextNode);
        }

    }







}
