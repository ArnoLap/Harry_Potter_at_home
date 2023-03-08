public abstract class Characters {
    public String name;
    public int maxhp;
    public int hp;
    public static int xp;
    public Characters(String name, int maxhp,int xp){
        this.name=name;
        this.maxhp= maxhp;
        this.hp= maxhp;
        this.xp= xp;
    }
    public abstract int attack();
    public abstract int defend();
}
