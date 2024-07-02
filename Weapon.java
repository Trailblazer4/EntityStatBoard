public class Weapon {
    private String name;
    private StatBoard stats;
    private Enchantments enchants;

    public Weapon(String n){
        name = n;
        stats = new StatBoard(0, 0, 0, 0, 0, 0, 0);
    }

    public Weapon(String n, int hp, int mp, int a, int d, int m, int md, int s){
        name = n;
        stats = new StatBoard(hp, mp, a, d, m, md, s);
    }

    public String getName(){
        return name;
    }

    public StatBoard getStats(){
        return stats;
    }
}
