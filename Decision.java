import java.util.Scanner;

public class Decision{
    Scanner input = new Scanner(System.in);

    private int getValidChoice(int min,int max){
        while(true){
            if(input.hasNextInt()){
                int choice=input.nextInt();

                if(choice>=min && choice<=max){
                    return choice;
                }
            }else{
                input.next();
            }
            System.out.println("Invalid Choice! Enter again: ");
        }
    }

    public int firstDecision(){
    System.out.println("========================================");
    System.out.println("INVESTIGATION OPTIONS");
    System.out.println("========================================");
    System.out.println();

    System.out.println("1. Trace IP Address");
    System.out.println("2. Check Password History");
    System.out.println("3. View User Activity");

    System.out.println();
    
    System.out.print("Enter Choice: ");
    return getValidChoice(1, 3);
   }

   public int secondDecision(){
            System.out.println("========================================");
            System.out.println("NEXT INVESTIGATION");
            System.out.println("========================================");
            System.out.println();

            System.out.println("1. Analyze Network Traffic");
            System.out.println("2. Trace Wi-Fi Location");
            System.out.println("3. Examine Employee_17");
            System.out.println("4. Stop Investigation");

            System.out.println();

            System.out.print("Enter Choice: ");
            return getValidChoice(1, 4);

        }
    
    public int serverDecision() {

    System.out.println("========================================");
    System.out.println("SERVER INVESTIGATION");
    System.out.println("========================================");
    System.out.println();

    System.out.println("1. Trace Server Connection");
    System.out.println("2. Analyze Server Logs");
    System.out.println("3. Search Employee_17 Records");
    System.out.println("4. Stop Investigation");

    System.out.println();

    System.out.print("Enter Choice: ");


    return getValidChoice(1, 4);
    }  

    public int followUpDecision() {
    
    System.out.println("========================================");
    System.out.println("FOLLOW-UP INVESTIGATION");
    System.out.println("========================================");
    System.out.println();

    System.out.println("1. Investigate Employee_17");
    System.out.println("2. Examine Finance Access");
    System.out.println("3. Trace Downloaded File");
    System.out.println("4. Continue Later");

    System.out.println();

    System.out.print("Enter Choice: ");

    return getValidChoice(1, 4);
   }

   public int chapterOneDecision() {

    System.out.println("========================================");
    System.out.println("CHAPTER 1 - FINAL INVESTIGATION");
    System.out.println("========================================");
    System.out.println();

    System.out.println("1. Arrest Employee_17");
    System.out.println("2. Continue Tracing Server");
    System.out.println("3. Investigate Financial Data");
    System.out.println("4. End Chapter");

    System.out.println();

    System.out.print("Enter Choice: ");

    return getValidChoice(1, 4);
   }
    
   public int chapterTwoDecision(){

    System.out.println("========================================");
    System.out.println("SERVER INVESTIGATION");
    System.out.println("========================================");
    System.out.println();

    System.out.println("1. Analyze Server Logs");
    System.out.println("2. Trace Server Location");
    System.out.println("3. Examine Server Security");
    System.out.println("4. Stop Investigation");

    System.out.println();

    System.out.print("Enter Choice: ");
    return getValidChoice(1, 4);
   }

   public int chapterTwoFinalDecision() {

    System.out.println("========================================");
    System.out.println("CHAPTER 2 - FINAL INVESTIGATION");
    System.out.println("========================================");
    System.out.println();

    System.out.println("1. Trace the Privileged Session");
    System.out.println("2. Investigate the Deleted Logs");
    System.out.println("3. Identify the Real Attacker");
    System.out.println("4. End Chapter");

    System.out.println();

    System.out.print("Enter Choice: ");

    return getValidChoice(1, 4);
   }

   public int chapterThreeDecision() {

    System.out.println("========================================");
    System.out.println("CHAPTER 3 - THE INSIDER");
    System.out.println("========================================");
    System.out.println();
    System.out.println("1. Investigate Administrator Account");
    System.out.println("2. Trace Privileged Session");
    System.out.println("3. Investigate Employee_17 Connection");
    System.out.println("4. Stop Investigation");
    System.out.println();
    System.out.print("Enter Choice: ");

    return getValidChoice(1, 4);
   }

   public int insiderFinalDecision() {

    System.out.println("========================================");
    System.out.println("INSIDER INVESTIGATION");
    System.out.println("========================================");
    System.out.println();

    System.out.println("1. Trace Administrator Login");
    System.out.println("2. Compare Access Records");
    System.out.println("3. Identify the Insider");
    System.out.println("4. End Investigation");

    System.out.println();

    System.out.print("Enter Choice: ");

    return getValidChoice(1, 4);
   }

   public int chapterFourDecision() {

    System.out.println("========================================");
    System.out.println("CHAPTER 4 - THE FINAL TRACE");
    System.out.println("========================================");
    System.out.println();
    System.out.println("1. Trace the Admin Account");
    System.out.println("2. Recover Deleted Evidence");
    System.out.println("3. Confront the Insider");
    System.out.println("4. End Investigation");
    System.out.println();
    System.out.print("Enter Choice: ");
    

    return getValidChoice(1, 4);
   }

   
}