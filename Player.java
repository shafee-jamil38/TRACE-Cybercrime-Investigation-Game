import java.util.ArrayList;

public class Player {

    private int score;
    private int attempts;
    private int cluesFound;
    private int currentChapter;

    private ArrayList<String> investigationLog;

    public Player() {
        score = 0;
        attempts = 3;
        cluesFound = 0;
        currentChapter = 1;
        investigationLog = new ArrayList<>();
    }

    public int getScore() {
        return score;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getCluesFound() {
        return cluesFound;
    }

    public int getCurrentChapter() {
        return currentChapter;
    }

    public ArrayList<String> getInvestigationLog() {
        return investigationLog;
    }

    public void addScore(int points) {
        score += points;
    }

    public void addClue() {
        cluesFound++;
    }

    public void loseAttempt() {
        if (attempts > 0) {
            attempts--;

            // bhul choice e 10 point penalty hobe
            score = Math.max(0, score - 10);
            System.out.println(Colors.RED + "Wrong decision! -10 points" + Colors.RESET);
        }
    }
    public boolean hasAttempts() {
        return attempts > 0;
    }

    public void setCurrentChapter(int chapter) {
        currentChapter = chapter;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void setCluesFound(int cluesFound) {
        this.cluesFound = cluesFound;
    }

    // ==============================
    // INVESTIGATION LOG
    // ==============================

    public void addLog(String message) {
        investigationLog.add(message);
    }

    // ==============================
    // INVESTIGATION RANK
    // ==============================
    
    public String getRank() {
        if (score >= 165) {
            return "ELITE INVESTIGATOR";
        }
        if (score >= 145) {
            return "SENIOR INVESTIGATOR";
        }
        if (score >= 125) {
            return "FIELD INVESTIGATOR";
        }
        return "ROOKIE INVESTIGATOR";
    }
}