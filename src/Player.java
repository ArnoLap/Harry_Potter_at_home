import java.util.Random;

public class Player extends Characters{
    public static int numAtkUpgrades;
    public static int numDefUpgrades;
    public int numPet;
    int gold, restleft, pots, spells;
    public String[] Pets = {"Howl","Cat","Frog"};
    public String[] atkUpgrades = {"Strenght","Power","Might","Godlike Strenght"};
    public String[] defUpgrades = {"Heavy Bones","Stoneskin","Scale Armor","Holy Aura"};
    public Player(String name) {
        super(name,100,0);
        this.numAtkUpgrades=0;
        this.numDefUpgrades= 0;
        this.gold = 20;
        this.restleft = 1;
        this.pots = 0;
        this.spells = 0;
        chooseTrait();
        choosePet();

    }
    @Override
    public int attack(){
        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3)+ xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }
    @Override
    public int defend(){
        return (int) (Math.random()*(xp/2 + numDefUpgrades*3)+ xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }
    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait");
        System.out.println("(1)"+ atkUpgrades[numAtkUpgrades]);
        System.out.println("(2)"+defUpgrades[numDefUpgrades]);
        int input = GameLogic.readInt("->",2);
        GameLogic.clearConsole();
        if(input == 1){
            GameLogic.printHeading("You chose "+atkUpgrades[numAtkUpgrades]+"!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades]+"!");
            numDefUpgrades++;
        }
        GameLogic.anythingtoContinue();
        }
        public void choosePet(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose your pet");
            System.out.println("(1) Howl");
            System.out.println("(2) Cat");
            System.out.println("(3) Frog ");
            int input = GameLogic.readInt("->",3);
            GameLogic.clearConsole();
            if(input == 1){
                GameLogic.printHeading("You chose Howl ! ");
                this.numPet = 0;

            }else if(input == 2){
                GameLogic.printHeading("You chose Cat ! ");
                this.numPet = 1;

            }else if (input == 3){
                GameLogic.printHeading("You chose Frog !");
                this.numPet = 2;
            }
            GameLogic.anythingtoContinue();


        }


        }




