public class Case {

    Evidence evidence = new Evidence();
    Decision decision = new Decision();
    Story story = new Story();

    private Player player;

    public Case(Player player) {
        this.player = player;
    }

    // =========================================================
    // CHAPTER 1
    // =========================================================

    public void chapterOne() {

        System.out.println("========================================");
        System.out.println("CHAPTER 1");
        System.out.println("THE LOG-IN MYSTERY");
        System.out.println("========================================");
        System.out.println();

        System.out.println("You discovered an unusual login pattern.");
        System.out.println();
        System.out.println("The attacker is still inside the network.");
        System.out.println();
        System.out.println("Find the correct clue before the traces disappear.");
        evidence.showLoginLog();
        int choice = decision.firstDecision();

        switch (choice) {
            case 1:

                evidence.showServerConnection();
                player.addScore(10);
                player.addLog("Suspicious IP detected");
                player.addClue();
                evidence.showIPAddress();
                story.showIPClue();

                int nextChoice = decision.secondDecision();

                switch (nextChoice) {
                    case 1:
                        evidence.showNetworkTraffic();
                        evidence.showServerClue();

                        int serverChoice = decision.serverDecision();
                        switch (serverChoice) {

                            case 1:
                                evidence.showServerConnection();
                                player.addScore(10);
                                player.addClue();
                                break;

                            case 2:
                                evidence.showServerLogs();
                                story.showServerLogClue();
                                int followChoice = decision.followUpDecision();

                                switch (followChoice) {
                                    case 1:
                                        evidence.showEmployeeInvestigation();
                                        player.addScore(10);
                                        player.addClue();
                                        break;

                                    case 2:
                                        evidence.showFinanceAccess();
                                        player.addScore(15);
                                        player.addClue();
                                        break;

                                    case 3:
                                        evidence.showDownloadedFile();
                                        player.addScore(15);
                                        player.addClue();
                                        break;

                                    case 4:
                                        System.out.println("Investigation paused.");
                                        return;

                                    default:
                                        System.out.println("Invalid Choice!");
                                        return;
                                }
                                break;

                            case 3:
                                evidence.showEmployeeRecords();
                                player.addScore(10);
                                player.addClue();
                                break;

                            case 4:
                                System.out.println("Investigation paused.");
                                return;

                            default:
                                System.out.println("Invalid Choice!");
                                return;
                        }
                        break;

                    case 2:
                        evidence.showWifiLocation();
                        player.addScore(5);
                        player.addLog("Public Wi-Fi identified");
                        player.addClue();
                        break;

                    case 3:
                        evidence.showEmployeeRecords();
                        player.addScore(10);
                        player.addClue();
                        break;

                    case 4:
                        System.out.println("Investigation paused.");
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                        return;
                }

                int finalChoice = decision.chapterOneDecision();
                switch (finalChoice) {

                    case 1:
                        player.loseAttempt();
                        System.out.println(Colors.RED + "Attempts Remaining : " + player.getAttempts() + Colors.RESET);
                        System.out.println();
                        System.out.println("You decide to confront Employee_17.");
                        System.out.println("The investigation moves to the employee.");
                        if (checkGameOver()) {
                            return;
                        }
                        break;

                    case 2:
                        System.out.println("You continue tracing the hidden server.");
                        System.out.println("A deeper connection is discovered.");
                        player.addScore(20);
                        player.addClue();
                        player.addLog("Hidden server discovered");

                        // MOVE TO CHAPTER 2
                        player.setCurrentChapter(2);
                        chapterTwo();
                        break;

                    case 3:
                        player.loseAttempt();
                        System.out.println(Colors.RED + "Attempts Remaining : " + player.getAttempts() + Colors.RESET);
                        System.out.println();
                        System.out.println("You investigate the stolen financial data.");
                        System.out.println("The evidence confirms that sensitive files were targeted.");
                        if (checkGameOver()) {
                            return;
                        }
                        break;

                    case 4:
                        System.out.println("Chapter 1 investigation ended.");
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                        return;
                }
                break;

            // =================================================
            // WRONG DECISION
            // =================================================

            case 2:
                player.loseAttempt();
                System.out.println(Colors.RED + "Attempts Remaining : " + player.getAttempts() + Colors.RESET);

                evidence.showPasswordHistory();

                System.out.println();
                System.out.println("The password history is suspicious,");
                System.out.println("but it does not directly identify the attacker.");
                if (checkGameOver()) {
                    return;
                }
                break;

            // =================================================
            // PARTIAL CLUE
            // =================================================

            case 3:
                player.loseAttempt();
                System.out.println(Colors.RED + "Attempts Remaining : " + player.getAttempts() + Colors.RESET);
                evidence.showUserActivity();

                if (checkGameOver()) {
                    return;
                }
                break;

            default:
                System.out.println("Invalid Choice!");
                break;
        }
    }

    // =========================================================
    // CHAPTER 2
    // =========================================================

    public void chapterTwo() {

        story.showChapterTwoIntroduction();
        evidence.showServerDetails();
        int choice = decision.chapterTwoDecision();
        switch (choice) {

            case 1:
                evidence.showChapterTwoServerLogs();
                player.addScore(10);
                player.addClue();

                System.out.println();
                System.out.println("A new clue has been discovered.");
                System.out.println("The attacker tried to delete server logs.");
                break;

            case 2:
                evidence.showServerLocation();
                player.addScore(10);
                player.addClue();

                System.out.println();
                System.out.println("A possible server location has been identified.");
                break;

            case 3:
                evidence.showServerSecurity();
                player.addScore(10);
                player.addClue();

                System.out.println();
                System.out.println("========================================");
                System.out.println("NEW CLUE FOUND");
                System.out.println("========================================");
                System.out.println();
                System.out.println("Someone attempted to erase the server logs.");
                System.out.println();
                System.out.println("The attacker has privileged access.");
                System.out.println();
                System.out.println("This may not be a simple employee account compromise.");
                break;

            case 4:
                System.out.println("Investigation paused.");
                return;

            default:
                System.out.println("Invalid Choice!");
                return;
        }

        // =====================================================
        // CHAPTER 2 FINAL DECISION
        // =====================================================

        int finalChoice = decision.chapterTwoFinalDecision();
        switch (finalChoice) {

            case 1:
                System.out.println("You trace the privileged session.");
                player.addLog("Privileged session traced");
                System.out.println("The session was created using a hidden administrator account.");

                player.addScore(20);
                player.addClue();
                System.out.println();
                System.out.println("The hidden administrator account becomes a major suspect.");

                // MOVE TO CHAPTER 3
                player.setCurrentChapter(3);
                chapterThree();
                return;

            case 2:
                System.out.println("You investigate the deleted server logs.");
                System.out.println("A backup log reveals activity from an unknown administrator.");
                player.addScore(20);
                player.addClue();

                System.out.println();
                System.out.println("The recovered logs point toward a privileged insider.");

                // MOVE TO CHAPTER 3
                player.setCurrentChapter(3);
                chapterThree();
                return;

            case 3:
                System.out.println("You investigate the real attacker.");
                System.out.println("The evidence suggests that Employee_17 was only used as a cover.");
                player.addScore(25);
                player.addClue();

                // MOVE TO CHAPTER 3
                player.setCurrentChapter(3);
                chapterThree();
                return;

            case 4:
                System.out.println("Chapter 2 investigation ended.");
                return;

            default:
                System.out.println("Invalid Choice!");
                return;
        }
    }

    // =========================================================
    // CHAPTER 3
    // =========================================================

    public void chapterThree() {

        story.showChapterThreeIntroduction();
        int choice = decision.chapterThreeDecision();
        switch (choice) {

            case 1:
                evidence.showAdminAccount();
                player.addScore(10);
                player.addClue();
                System.out.println();
                System.out.println("The administrator account was active during the attack.");
                break;

            case 2:
                evidence.showPrivilegedSession();
                player.addScore(15);
                player.addClue();
                System.out.println();
                System.out.println("The privileged session controlled the hidden server.");
                break;

            case 3:
                evidence.showEmployeeConnection();
                player.addScore(10);
                player.addClue();
                System.out.println();
                System.out.println("Employee_17 may have been used as a cover.");
                break;

            case 4:
                System.out.println("Investigation paused.");
                return;

            default:
                System.out.println("Invalid Choice!");
                return;
        }

        // =====================================================
        // INSIDER FINAL DECISION
        // =====================================================

        int insiderChoice = decision.insiderFinalDecision();

        switch (insiderChoice) {

            case 1:
                System.out.println("========================================");
                System.out.println("ADMINISTRATOR LOGIN TRACE");
                System.out.println("========================================");
                System.out.println();

                System.out.println("Account : sys_admin_04");
                System.out.println("Login Time : 02:15 AM");
                System.out.println("Source : Internal Network");
                System.out.println("Status : Suspicious");

                player.addScore(15);
                player.addClue();
                player.addLog("Administrator login traced");
                break;

            case 2:
                System.out.println("========================================");
                System.out.println("ACCESS RECORD COMPARISON");
                System.out.println("========================================");
                System.out.println();
                System.out.println("Employee_17 accessed the Finance system.");
                System.out.println("sys_admin_04 accessed the hidden server.");
                System.out.println();
                System.out.println("The access times overlap.");
                System.out.println("This suggests a coordinated attack.");

                player.addScore(20);
                player.addClue();
                break;

            case 3:
                System.out.println("========================================");
                System.out.println("INSIDER IDENTIFICATION");
                System.out.println("========================================");
                System.out.println();
                System.out.println("The evidence points toward sys_admin_04.");
                System.out.println();
                System.out.println("Employee_17 credentials were used as a cover.");
                System.out.println("The privileged administrator account controlled");
                System.out.println("the hidden server.");

                player.addScore(25);
                player.addClue();
                player.addLog("Insider identified");  

                // MOVE TO CHAPTER 4
                player.setCurrentChapter(4);
                chapterFour();
                return;

            case 4:
                System.out.println("Investigation ended.");
                return;

            default:
                System.out.println("Invalid Choice!");
                return;
        }
    }

    // =========================================================
    // CHAPTER 4
    // =========================================================

    public void chapterFour() {

        story.showChapterFourIntroduction();

        boolean adminTraced = false;
        boolean evidenceRecovered = false;

        while (true) {

            int choice = decision.chapterFourDecision();

            switch (choice) {

                case 1:
                    if (adminTraced) {
                        System.out.println();
                        System.out.println("You already traced this account. Try something else.");
                        break;
                    }
                    adminTraced = true;

                    evidence.showAdminTrace();
                    player.addScore(15);
                    player.addClue();

                    System.out.println();
                    System.out.println("The administrator account was active");
                    System.out.println("during the critical server activity.");
                    System.out.println();
                    System.out.println("The trace alone is not enough.");
                    System.out.println("You must continue the final investigation.");
                    break;

                case 2:
                    if (evidenceRecovered) {
                        System.out.println();
                        System.out.println("Evidence already recovered. Try something else.");
                        break;
                    }
                    evidenceRecovered = true;

                    evidence.showDeletedEvidence();
                    player.addScore(20);
                    player.addClue();

                    System.out.println();
                    System.out.println("Important deleted logs have been recovered.");
                    player.addLog("Deleted evidence recovered");
                    System.out.println();
                    System.out.println("The recovered evidence strengthens the case.");
                    break;

                case 3:
                    evidence.showInsiderEvidence();
                    player.addScore(25);
                    player.addClue();

                    System.out.println();
                    System.out.println("Strong evidence connects the insider");
                    System.out.println("to the hidden server operation.");

                    System.out.println();
                    System.out.println(Colors.GREEN + "========================================" + Colors.RESET);
                    System.out.println(Colors.GREEN + "CASE SOLVED" + Colors.RESET);
                    System.out.println(Colors.GREEN + "========================================" + Colors.RESET);
                    System.out.println();
                    System.out.println("The real attacker has been identified.");
                    System.out.println("The hidden server has been secured.");
                    System.out.println("The investigation is complete.");

                    // GAME COMPLETED
                    player.setCurrentChapter(5);

                    // solve howar shathe shathe report ekhanei print hobe
                    showFinalReport();
                    return;

                case 4:
                    System.out.println("Investigation ended.");
                    return;

                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }

    // =========================================================
    // FINAL REPORT 
    // =========================================================

    public void showFinalReport() {

        String G = Colors.GREEN, C = Colors.CYAN, Y = Colors.YELLOW, R = Colors.RESET;

        System.out.println();
        System.out.println(G + "========================================" + R);
        System.out.println(G + "        INVESTIGATION COMPLETE" + R);
        System.out.println(G + "========================================" + R);
        System.out.println();

        System.out.println("Final Score    : " + Y + player.getScore() + R);
        System.out.println("Clues Found    : " + Y + player.getCluesFound() + R);
        System.out.println("Attempts Left  : " + Y + player.getAttempts() + R);
        System.out.println();

        System.out.println("Investigation Rank : " + G + player.getRank() + R);
        System.out.println();

        System.out.println(C + "========================================" + R);
        System.out.println(C + "        INVESTIGATION LOG" + R);
        System.out.println(C + "========================================" + R);
        System.out.println();

        if (player.getInvestigationLog().isEmpty()) {
            System.out.println("No clues discovered.");
        } else {
            for (String log : player.getInvestigationLog()) {
                System.out.println(G + "✓ " + R + log);
            }
        }

        System.out.println();
        System.out.println(C + "========================================" + R);
    }

    // =========================================================
    // GAME OVER
    // =========================================================

    private boolean checkGameOver() {

        if (!player.hasAttempts()) {

            System.out.println();
            System.out.println(Colors.RED + "========================================" + Colors.RESET);
            System.out.println(Colors.RED + "              GAME OVER" + Colors.RESET);
            System.out.println(Colors.RED + "========================================" + Colors.RESET);
            System.out.println();
            System.out.println("You have run out of investigation attempts.");
            System.out.println("The attacker escaped before you could");
            System.out.println("complete the investigation.");
            System.out.println();
            System.out.println("Final Score   : " + player.getScore());
            System.out.println("Clues Found   : " + player.getCluesFound());
            System.out.println();
            System.out.println(Colors.RED + "========================================" + Colors.RESET);
            System.out.println(Colors.RED + "       INVESTIGATION FAILED" + Colors.RESET);
            System.out.println(Colors.RED + "========================================" + Colors.RESET);

            return true;
        }
        return false;
    }
}