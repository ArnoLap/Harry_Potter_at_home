public class Spell {
    public static String[] spells = {"Wingardium Leviosa", "Stupefix", "Expeliarmus", "Accio" };
    public static int attackWg(){
        return (int) (Math.random()*(Player.xp/4 + Player.numAtkUpgrades*3 + 3)+ Player.xp/10 + Player.numAtkUpgrades*2 + Player.numDefUpgrades + 1)+1;
    }
    public int attackSp(){
        return (int) (Math.random()*(Player.xp/4 + Player.numAtkUpgrades*3 + 3)+ Player.xp/10 + Player.numAtkUpgrades*2 + Player.numDefUpgrades + 1)+7;
    }
}
