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
    }
}
