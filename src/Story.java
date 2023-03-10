import java.sql.SQLOutput;
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
       GameLogic.clearConsole();
       GameLogic.printSeparator(30);
       System.out.println("Chapter 2 : The Chamber of Secret");
       GameLogic.printSeparator(30);
       System.out.println("Mr.Flitwick showed you a whole new spell called 'Accio'. Use it to grab objects next to you ! ");
       GameLogic.anythingtoContinue();
       
    }
    public static void printThirdChapter() {
       GameLogic.clearConsole();
       GameLogic.printSeparator(30);
       System.out.println("Chapter 3 : The Prisoner of Azkaban and AVADA KABRA");
       GameLogic.printSeparator(30);
       System.out.println("This your 3rd year at Hogwarts and some strange creatures are supervising the school.");
       System.out.println("At the end of the Defence Against the Dark Art course, Mr.Lupin show you in secret the spell 'Expecto Patronum' ");
       GameLogic.printSeparator(30);
       GameLogic.clearConsole();
       System.out.println("However you're still unable to properly control it !");
       GameLogic.anythingtoContinue();

    }
    public static void printFourthChapter() {
       GameLogic.clearConsole();
       GameLogic.printSeparator(30);
       System.out.println("Chapter 4 : The Goblet of Fire");
       GameLogic.printSeparator(30);
       System.out.println("A new year begin, ");


    }
    public static void printFithChapter() {
    }
    public static void printSixthChapter() {
    }
    public static void printSeventhChapter(){
    }
}
