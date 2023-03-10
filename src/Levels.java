public class Levels {
    public static void Level1(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("The toilets");
        GameLogic.printSeparator(30);
        System.out.println(" A terrible troll succeed to enter into the toilets near the Dungeon ! Use the spell 'Wingardium Leviosa' ");
        System.out.println("to levitate objects and drop them when they are at the top of the troll's head");
        GameLogic.anythingtoContinue();
        GameLogic.Bossbattle1(new Boss(Boss.boss[0], GameLogic.player.xp));
        GameLogic.shop();
        GameLogic.anythingtoContinue();
    }
    public static void Level2(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("The Chamber of Secrets");
        GameLogic.printSeparator(30);
        System.out.println("You entered in a mysterious chamber before getting attacked by the horrific Basilic. Try to use ");
        System.out.println("the Gryffindor's sword or use 'Accio' to catch one of its fang to destroy Tom Jedusor's book before it's too late !");
        GameLogic.anythingtoContinue();
        GameLogic.Bossbattle2(new Boss(Boss.boss[1], GameLogic.player.xp));
        GameLogic.anythingtoContinue();

    }

    public static void Level3(){
        GameLogic.clearConsole();;
        GameLogic.printSeparator(30);
        System.out.println("Lake of the Forbidden Forest");
        GameLogic.printSeparator(30);
        System.out.println("You've been purchased by a Werewolf in the Forest and you're a now facing a group of dementors ! ");
        System.out.println("Be brave and and find a way to scared them before they get to you !");
        GameLogic.anythingtoContinue();
        GameLogic.Bossbattle3(new Boss(Boss.boss[2], GameLogic.player.xp));
        GameLogic.anythingtoContinue();

    }
}
