import java.util.Random;

public class Story {
   public static void printIntro(){
       GameLogic.clearConsole();
       GameLogic.printSeparator(30);
       System.out.println("STORY");
       GameLogic.printSeparator(30);
       System.out.println("Greetings " + GameLogic.player.name + " ! We have the great pleasure to let you know that you have been accepted ");
       System.out.println(" at the international school of wizards : Hogwarts. We are very excited to welcome our students in the next months");
       System.out.println(" and awake the true sorcerer inside each of you.");
       GameLogic.anythingtoContinue();
   }
   public static void printChapter0(){
       GameLogic.clearConsole();;
       GameLogic.printSeparator(30);
       System.out.println("You arrived at Hogwarts for the annual ceremony of repartition and now it's your turn to be placed in a house");
       GameLogic.anythingtoContinue();
       System.out.println("_Sorting Hat : 'Humm well, let see what we have here...'");
       GameLogic.anythingtoContinue();


   }
   public static void printFirstChapter(){
       GameLogic.clearConsole();
       GameLogic.printSeparator(30);
       System.out.println("Chapter 1 : The Philosopher's Stone");
       GameLogic.printSeparator(30);
       System.out.println("During your first day at school, you learned a new spell called 'Wingardium Leviosa' !");

       GameLogic.anythingtoContinue();

   }
   public static void printSecondChapter(){
       
    }
    public static void printThirdChapter() {
    }
    public static void printFourthChapter() {
    }
    public static void printFithChapter() {
    }
    public static void printSixthChapter() {
    }
    public static void printSeventhChapter(){
    }
}
