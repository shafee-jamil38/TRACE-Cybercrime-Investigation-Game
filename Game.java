import java.util.Scanner;

class Game {

    // ==============================
    // COLORS
    // ==============================

    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String CYAN = "\u001B[36m";

    Scanner input = new Scanner(System.in);

    Player player = new Player();
    Story story = new Story();
    Case currentCase = new Case(player);
    SaveManager saveManager = new SaveManager();

    public void start() {
        showTitle();
        showMainMenu();
    }
   
    public void loadingEffect(String message) {

        System.out.print(message);

        for (int i = 0; i<3; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.print(".");
        }

        System.out.println();
    }

    public void showTitle() {
        System.out.println();
        System.out.println("=================================");
        System.out.println("              TRACE");
        System.out.println("   A Cybercrime Investigation Game");
        System.out.println("=================================");
    }

    // ==============================
    // MAIN MENU
    // ==============================

    public void showMainMenu() {

        while (true) {

            System.out.println();
            System.out.println("1. Start Investigation");
            System.out.println("2. Save Game");
            System.out.println("3. Load Game");
            System.out.println("4. About");
            System.out.println("5. Exit");

            System.out.print("\nEnter Choice: ");

            
            if (!input.hasNextInt()) {
                input.next();
                System.out.println(RED + "Invalid Choice!" + RESET);
                continue;
            }
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    startInvestigation();
                    break;

                case 2:
                    saveManager.saveGame(player);
                    break;

                case 3:
                    if (saveManager.loadGame(player)) {
                        System.out.println();
                        System.out.println(GREEN + "Game loaded successfully." + RESET);
                        showPlayerStatus();
                    }
                    break;

                case 4:
                    showAbout();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Exiting Game...");
                    return;

                default:
                    System.out.println();
                    System.out.println(RED + "Invalid Choice!" + RESET);
            }
        }
    }


    // ==============================
    // START INVESTIGATION
    // ==============================

    public void startInvestigation() {

        if (!player.hasAttempts()) {
            showGameOver();
            return;
        }
        loadingEffect("Initializing investigation");


        switch (player.getCurrentChapter()) {

            case 1:
                story.showIntroduction();
                currentCase.chapterOne();
                break;

            case 2:
                currentCase.chapterTwo();
                break;

            case 3:
                currentCase.chapterThree();
                break;

            case 4:
                currentCase.chapterFour();
                break;

            default:
                // Case already solved -> report abar dekhabe
                currentCase.showFinalReport();
        }
    }

    // ==============================
    // GAME OVER
    // ==============================

    public void showGameOver() {

        System.out.println();
        System.out.println(RED + "========================================" + RESET);
        System.out.println(RED + "              GAME OVER" + RESET);
        System.out.println(RED + "========================================" + RESET);
        System.out.println();
        System.out.println("You have run out of investigation attempts.");
        System.out.println();
        System.out.println("Final Score   : " + player.getScore());
        System.out.println("Clues Found   : " + player.getCluesFound());
        System.out.println();
        System.out.println(RED + "INVESTIGATION FAILED" + RESET);
    }

    // ==============================
    // PLAYER STATUS
    // ==============================

    public void showPlayerStatus() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("          PLAYER STATUS");
        System.out.println("=================================");
        System.out.println();
        System.out.println("Score           : " + player.getScore());
        System.out.println("Clues           : " + player.getCluesFound());
        System.out.println("Attempts        : " + player.getAttempts());
        System.out.println("Current Chapter : " + player.getCurrentChapter());
        System.out.println("Rank            : " + player.getRank());
    }

    // ==============================
    // ABOUT
    // ==============================

    public void showAbout() {

        System.out.println();
        System.out.println("========================================");
        System.out.println("                ABOUT");
        System.out.println("========================================");
        System.out.println();
        System.out.println("TRACE");
        System.out.println("A Cybercrime Investigation Game");
        System.out.println();
        System.out.println("Version : 1.0");
        System.out.println("Genre   : Text-Based Investigation");
        System.out.println("Language: Java");
        System.out.println();
        System.out.println("Investigate clues, analyze evidence,");
        System.out.println("and identify the real attacker.");
        System.out.println("========================================");
    }
}