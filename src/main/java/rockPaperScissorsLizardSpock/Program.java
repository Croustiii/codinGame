package rockPaperScissorsLizardSpock;

import java.util.*;

public class Program {


    public static void main(String[] args) {
        // https://www.codingame.com/ide/puzzle/rock-paper-scissors-lizard-spock
        // Jeu de données
        // [4, 1, 8, 3, 7, 5, 6, 2]
        // ["R", "P", "P", "R", "C", "S", "L", "L"]

        String[] choices = {"R", "P", "P", "R", "C", "S", "L", "L"};
        Integer[] players = {4, 1, 8, 3, 7, 5, 6, 2};


        List<Player> playersToAdd = new ArrayList<>();
        HashMap<Integer, Player> playerHashMap = new HashMap<Integer, Player>();

        for (int i = 0; i < choices.length; i++) {
            Player player = new Player(players[i], Sign.valueOf(choices[i]));

            playerHashMap.put(players[i], player);
            playersToAdd.add(player);
        }


        GameProcessor gameProcessor = new GameProcessor(playersToAdd);
        gameProcessor.playerHashMap = playerHashMap;

        //gameProcessor.opposePlayers(gameProcessor.players.get(0), gameProcessor.players.get(1));

        gameProcessor.RunCompetition();



    }
}
class Player{

    public int number;
    public Sign sign;

    public List<Integer> winPath = new ArrayList<>();

    public Player(int number, Sign choice) {
        this.number = number;
        this.sign = choice;
    }

    @Override
    public String toString() {
        return String.format("Joueur n°%s (%s)", this.number, this.sign);
    }
}
class GameProcessor{

    List<Player> players = new ArrayList<>();
    HashMap<Integer, Player> playerHashMap = new HashMap<Integer, Player>();
    List<Player> currentRound = new ArrayList<>();


    public GameProcessor(List<Player> players) {
        this.players = players;
        this.currentRound = players.stream().toList();
    }

    public void displayWinner(){
        if(currentRound.size() == 1){
            Optional<Player> winner = currentRound.stream().findFirst();
            System.out.println(winner.get().number);
            StringBuilder path = new StringBuilder();
            for(int i : winner.get().winPath){
                path.append(" " + i);
            }
            System.out.println(path.toString().trim());
        }
    }

    public void RunCompetition(){
        while(currentRound.size() > 1) ProcessRound();
        displayWinner();
    }

    public void ProcessRound(){
        List<Player> resultPlayers = new ArrayList<>();
        for (int i = 0; i < currentRound.size(); i+=2) {
            //System.out.println(String.format("\n\nDébut du round %s", i));

            int winnerNumber = opposePlayers(this.currentRound.get(i), this.currentRound.get(i+1));
            Player winner = playerHashMap.get(winnerNumber);

            if(winnerNumber != -1) resultPlayers.add(winner);
        }
        currentRound = resultPlayers.stream().toList();
        //System.out.println("Résultat du round : " + Arrays.toString(resultPlayers.toArray()));
    }

    public int opposePlayers(Player p1,  Player p2){
        Sign signPlayer1 = p1.sign;
        Sign signPlayer2 = p2.sign;
        //System.out.println(String.format("\tOpposition de : joueur n°%s (%s) contre joueur n°%s (%s)", p1.number, p1.sign, p2.number, p2.sign));

        if(p1.sign == p2.sign){
            Player winner;
            Player looser;
            if(p1.number < p2.number){
                winner = p1;
                looser = p2;
            }else{
                winner = p2;
                looser = p1;
            }
            winner.winPath.add(looser.number);
            return winner.number;
        }
        for (char c : signPlayer1.getWins()){
            if (Sign.valueOf(String.valueOf(c)) == signPlayer2){
                //System.out.println(String.format("\t\tGagnant : Joueurn°%s (%s bat %s)", p1.number, p1.sign, p2.sign));
                p1.winPath.add(p2.number);
                return p1.number;
            }
        }

        for (char c : signPlayer1.getLoses()){
            if (Sign.valueOf(String.valueOf(c)) == signPlayer2){
                //System.out.println(String.format("\t\tGagnant : Joueurn°%s (%s bat %s)", p2.number, p2.sign, p1.sign));
                p2.winPath.add(p1.number);
                return p2.number;
            }
        }
        return -1;
    }


}


