import java.io.*;

public class SaveManager {

    public void saveGame(Player player) {

        try {
            FileWriter writer = new FileWriter("savegame.txt");

            writer.write(player.getScore() + "\n");
            writer.write(player.getCluesFound() + "\n");
            writer.write(player.getAttempts() + "\n");
            writer.write(player.getCurrentChapter() + "\n");

            writer.close();

            System.out.println();
            System.out.println("========================================");
            System.out.println("          GAME SAVED SUCCESSFULLY");
            System.out.println("========================================");

        } catch (IOException e) {
            System.out.println("Error saving game.");
        }
    }

    public boolean loadGame(Player player) {

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("savegame.txt"));

            int score = Integer.parseInt(reader.readLine());
            int clues = Integer.parseInt(reader.readLine());
            int attempts = Integer.parseInt(reader.readLine());
            int currentChapter = Integer.parseInt(reader.readLine());

            reader.close();

            player.setScore(score);
            player.setCluesFound(clues);
            player.setAttempts(attempts);
            player.setCurrentChapter(currentChapter);

            System.out.println();
            System.out.println("========================================");
            System.out.println("          GAME LOADED SUCCESSFULLY");
            System.out.println("========================================");

            return true;

        } catch (FileNotFoundException e) {

            System.out.println();
            System.out.println("No saved game found.");

        } catch (IOException | NumberFormatException e) {

            System.out.println();
            System.out.println("Error loading saved game.");
        }

        return false;
    }
}
