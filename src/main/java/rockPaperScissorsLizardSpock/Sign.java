package rockPaperScissorsLizardSpock;

public enum Sign {
    R (new char[]{'L', 'C'}, new char[]{'P', 'S'}) ,
    P (new char[]{'R', 'S'}, new char[]{'C', 'L'}),
    C (new char[]{'P', 'L'}, new char[]{'R', 'S'}),
    L (new char[]{'P', 'S'}, new char[]{'R', 'C'}),
    S (new char[]{'C', 'R'}, new char[]{'L', 'P'});

    private final char[] wins;
    private final char[] loses;


    public char[] getWins() {
        return wins;
    }

    public char[] getLoses() {
        return loses;
    }

    Sign (char[] wins, char[] loses){
        this.wins = wins;
        this.loses = loses;
    }


}
