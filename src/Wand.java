import java.util.Scanner;
public class Wand {
    public  int numCore;
    public Wand(){
        chooseWand();
    }
    static Scanner scanner = new Scanner(System.in);
    public  int size;
    public String[] Core = {"Phoenix_Feather", "Dragon HeartString"};
    public void chooseWand(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a core for your wand !");
        System.out.println("(1)" +Core[0]);
        System.out.println("(2)" +Core[1]);
        int input = GameLogic.readInt("->",2);
        if (input == 1){
            System.out.println("You chose Phoenix Feather!");
            this.numCore=0;

        } else if (input==2) {
            System.out.println("You chose Dragon HeartString!");
            this.numCore=1;
        }
        GameLogic.anythingtoContinue();
        GameLogic.printHeading("Now let's choose the size of your wand (in centimeters) ");
        size = Integer.parseInt(scanner.next());
        do {
            System.out.println("Choose another size for your wand");

        }while(size < 10 || size>  30);

        }


    }

