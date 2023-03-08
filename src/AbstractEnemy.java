public abstract class AbstractEnemy extends Characters {
    int playerXp;

    public AbstractEnemy(String name, int playerXp, int i){
        super(name, (int) (Math.random()*playerXp + playerXp/3 + 5),(int)(Math.random()*(playerXp/4 +2)+1));
        this.playerXp = playerXp;
    }
}
