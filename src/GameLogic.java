import java.sql.SQLOutput;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    static Wand wand;
    static House house;
    public static boolean isRunning;
    public static int place = 0, act = 1;
    public static String[] places = {"The Toilets", "The Secret Chamber", "The London's streets", "The Graveyard", "The Great Hall", "Hogwarts's Main Gate", "The Courtyard"};


    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer !");
            }

        } while (input < 1 || input > userChoices);
        return input;
    }

    public static void clearConsole() {
        for (int i = 0; i > 100; i++)
            System.out.println();
    }

    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void chekAct() {
        if (player.xp >= 10 && act == 1) {
            act = 2;
            place = 1;
            Story.printFirstChapter();
            player.chooseTrait();
        } else if (player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            Story.printSecondChapter();
        } else if (player.xp >= 100 && act == 3) {
            act = 4;
            Story.printThirdChapter();

        }
    }

    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void anythingtoContinue() {
        System.out.print("\nPress any button to continue...");
        scanner.next();
    }

    public static void startGame() {
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Harry Potter at Home");
        System.out.println("By Arno Laperotine");
        printSeparator(30);
        printSeparator(40);
        anythingtoContinue();
        do {
            clearConsole();
            printHeading("What's your name?");
            name = scanner.next();
            clearConsole();
            printHeading("Your name is " + name + ".\nIs that correct ?");
            System.out.println("(1) Yes !");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("->", 2);
            if (input == 1)
                nameSet = true;
        } while (!nameSet);
        player = new Player(name);
        Story.printIntro();
        wand = new Wand();
        Story.printChapter0();
        house = new House();
        Story.printFirstChapter();
        Levels.Level1();


        isRunning = true;
        gameLoop();
    }

    public static void continueJourney() {

    }

    public static void characterInfo() {
        clearConsole();
        printHeading("Character Info");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxhp);
        printSeparator(20);
        System.out.println("XP : " + player.xp + "\tGold: " + player.gold);
        printSeparator(20);
        System.out.println("# of Potions : " + player.pots);
        printSeparator(20);
        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait : " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(10);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive trait : " + player.defUpgrades[player.numDefUpgrades - 1]);
            printSeparator(10);
        }
        System.out.println("House : " + house.type[house.numHouse]);
        System.out.println("Pet : " + player.Pets[player.numPet]);
        System.out.println("Wand Core : " + wand.Core[wand.numCore]);
        System.out.println("Wand Size : " + wand.size);

        anythingtoContinue();

    }

    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action :");
        printSeparator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("->", 3);
            if (input == 1)
                continueJourney();
            else if (input == 2)
                characterInfo();
        }

    }

    public static void randomBattle() {
        clearConsole();
        anythingtoContinue();
        battle(new Enemy(Enemy.enemies[(int) (Math.random() * Enemy.enemies.length)], player.xp));

    }

    public static void playerDied() {
        clearConsole();
        printHeading("You died...");
        printHeading("You earned" + player.xp + "XP on your journey.Try to earn more next time !");
        System.out.println("Thank you for playing Harry Potter at Home and hope you enjoyed it");
        isRunning = false;
    }

    public static void battle(Enemy enemy) {
        while (true) {
            clearConsole();
            printHeading(enemy.name + "\nHp:" + enemy.hp + "/" + enemy.maxhp);
            printHeading(player.name + "\nHp" + player.hp + "/" + player.maxhp);
            System.out.println("Choose an action");
            printSeparator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("->", 3);
            if (input == 1) {
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                if (dmgTook < 0) {
                    dmg -= dmgTook / 2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                    dmg = 0;
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                printSeparator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                anythingtoContinue();
                if (player.hp <= 0) {
                    playerDied();
                    break;
                } else if (enemy.hp <= 0) {
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP !");
                    boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random() * enemy.xp);
                    if (addRest) {
                        player.restleft++;
                        System.out.println("You earned the chance to get an additional rest!");
                    }
                    if (goldEarned > 0) {
                        player.gold += goldEarned;
                        System.out.println("You collect " + goldEarned + "gold from the " + enemy.name + "'s body");
                    }
                    anythingtoContinue();
                    break;
                }
            } else if (input == 2) {
                clearConsole();
                if (player.pots > 0 && player.hp < player.maxhp) {
                    printHeading("Do you want to drink a potion ? (" + player.pots + "left).");
                    System.out.println("(1) Yes\n(2) No");
                    input = readInt("->", 2);
                    if (input == 1) {
                        player.hp = player.maxhp;
                        clearConsole();
                        printHeading("You drank a magic potion.It restored your health back to " + player.maxhp);
                        anythingtoContinue();
                    }

                }

            } else {
                printHeading("You don't have any potions or you're at full health");
                anythingtoContinue();
            }


        }
    }

    public static void Bossbattle1(Boss enemy) {
        while (true) {
            clearConsole();
            printHeading(enemy.name + "\nHp:" + enemy.hp + "/" + enemy.maxhp);
            printHeading(player.name + "\nHp" + player.hp + "/" + player.maxhp);
            System.out.println("Choose an action : ");
            printSeparator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n");
            int input = readInt("->", 2);
            if (input == 1) {
                System.out.println("Choose a spell : ");
                printSeparator(20);
                System.out.println("(1) Wingardium Leviosa");
                int input2 = readInt("->", 1);
                if (input2 == 1){
                Random random = new Random();
                int x = random.nextInt(100) + 1;
                if(x > 40) {
                    int dmg = Spell.attackWg() - enemy.defend();
                    int dmgTook = enemy.attack() - player.defend();
                    if (dmgTook < 0) {
                        dmg -= dmgTook / 2;
                        dmgTook = 0;
                    }
                    if (dmg < 0)
                        dmg = 0;
                    player.hp -= dmgTook;
                    enemy.hp -= dmg;
                    clearConsole();
                    printHeading("BATTLE");
                    System.out.println("You touch the " + enemy.name + " with " + Spell.spells[0] + " !");
                    System.out.println("You dealt " + dmg + " damage to him.");
                    printSeparator(15);
                    System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                    anythingtoContinue();
                }else{ int dmgTook = enemy.attack() - player.defend();
                    if (dmgTook < 0) {
                        dmgTook = 0;
                    }
                     player.hp -= dmgTook;
                    printHeading("BATTLE");
                    System.out.println(" You missed your attack on the " + enemy.name + "!");
                    printSeparator(15);
                    System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                    anythingtoContinue();}}else{
                    System.out.println("You don't know other spell !");
                    anythingtoContinue();
                }
                if (player.hp <= 0) {
                    playerDied();
                    break;
                } else if (enemy.hp <= 0) {
                    clearConsole();
                    printHeading("You defeated the " + enemy.name + "!");
                    player.xp += enemy.xp;
                    System.out.println("You earned " + enemy.xp + " XP !");
                    boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                    int goldEarned = (int) (Math.random() * enemy.xp);
                    if (addRest) {
                        player.restleft++;
                        System.out.println("You earned the chance to get an additional rest!");
                    }
                    if (goldEarned > 0) {
                        player.gold += goldEarned;
                        System.out.println("You collect " + goldEarned + " gold from the " + enemy.name + "'s body");
                    }
                    anythingtoContinue();
                    break;
                }
            } else if (input == 2) {
                clearConsole();
                if (player.pots > 0 && player.hp < player.maxhp) {
                    printHeading("Do you want to drink a potion ? (" + player.pots + "left).");
                    System.out.println("(1) Yes\n(2) No");
                    input = readInt("->", 2);
                    if (input == 1) {
                        player.hp = player.maxhp;
                        clearConsole();
                        printHeading("You drank a magic potion.It restored your health back to " + player.maxhp);
                        anythingtoContinue();
                    }

                }
                else {
                    printHeading("You don't have any potions or you're at full health");
                    anythingtoContinue();
                }

            }


        }
    }

    public static void shop() {
        clearConsole();
        printHeading("You meet a mysterious stranger.\nHe offers you something");
        int price = (int) (Math.random() * (10 + player.pots * 3) + 10 + player.pots);
        System.out.println("-Magic Potion : " + price + "gold.");
        printSeparator(20);
        System.out.println("Do you want to buy one ?\n(1) Yes !\n(2) No thanks.");
        int input = readInt("->", 2);
        if (input == 1) {
            clearConsole();
            if (player.gold >= price) {
                printHeading("You bought a magical potion for" + price + "gold.");
                player.pots++;
                player.gold -= price;
            } else {
                printHeading("You don't have enough gold to buy this...");
                anythingtoContinue();
            }
        }

    }
    public static void takeRest(){
        clearConsole();
        if (player.restleft >= 1){
            printHeading ("Do you want to take a rest ? (" + player.restleft + "rest(s) left).");
            System.out.println("(1) Yes\n(2) No, not now.");
            int input= readInt("->", 2);
            if(input == 1){
                clearConsole();
                if(player.hp < player.maxhp) {
                    int hpRestored = (int) (Math.random() * (player.xp / 4 + 1) + 10);
                    player.hp = player.maxhp;
                    System.out.println("You took a rest and restored up to " + hpRestored + "health.");
                    System.out.println("You're now at " + player.hp + "/" + player.maxhp + " health.");
                    player.restleft--;
                }
        }else{
                System.out.println("You're at full health. You don't need to rest now !");
            anythingtoContinue();}
    }
}}

