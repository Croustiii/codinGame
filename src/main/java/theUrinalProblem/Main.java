package theUrinalProblem;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class Main {


    public static void main(String[] args) {

        String input = "!UUU!";

        //FindBestUrinoir(input);
        System.out.println(input.toCharArray());

        FindBestUrinoir(input);
    }

    public static void FindBestUrinoir(String input){

        char[] urinoirs = input.toCharArray();
        List<Integer> occupiedUrinoirs = new ArrayList();
        List<Integer> openUrinoirs = new ArrayList();
        HashMap<Integer, Integer> distances = new HashMap<>();

        for (int i = 0; i < urinoirs.length; i++) {
            if(urinoirs[i] == '!'){
                occupiedUrinoirs.add(i);
            } else if (urinoirs[i] == 'U') {
                openUrinoirs.add(i);
            }
        }

        // on calcule les distance min entre chaque urinoir libre et les urinoirs occupés
        for (int i = 0; i < openUrinoirs.size(); i++) {
            int distance = calculateMinDistance(urinoirs, openUrinoirs.get(i));
            distances.put(openUrinoirs.get(i), distance);
        }

        // on trouve la distance max
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println(maxEntry.getKey());
    }

    public static int calculateMinDistance(char[] urinoirs, int index){
        // trouve le premier urinoir inoccupé a droite ou a gauche

        int distance = 0;
        int left = index;
        int right = index;
        while(urinoirs[left] == 'U' || urinoirs[right] == 'U'){
            if(left -1 >=0) left--;
            if (right +1 < urinoirs.length) right++;
            distance++;

            if((left-1 < 0 && right +1 >= urinoirs.length) || (urinoirs[left] == '!' || urinoirs[right] == '!')) break;

        }
        return distance;
    }
}

