public class Entity{
    private String name;
    private StatBoard stats;
    private Weapon weapon;
    private Buffs buffs;

    private int hp, mp;

    public Entity(String n){
        name = n;
        hp = 0; mp = 0;
        stats = new StatBoard(0, 0, 0, 0, 0, 0, 0);
        weapon = new Weapon("Sword");
        buffs = new Buffs();
    }

    public Entity(String n, int hp, int mp, int a, int d, int m, int md, int s){
        name = n;
        this.hp = hp; this.mp = mp;
        stats = new StatBoard(hp, mp, a, d, m, md, s);
        buffs = new Buffs();
    }

    public void levelUp(int[] allocs){
        stats.levelUp(allocs);
    }

    public void equip(Weapon w){
        weapon = w;
        for(int i = 0; i < weapon.getStats().getStats().length; i++){
            stats.add(i, (double)weapon.getStats().getStats()[i]);
        }
    }

    public void unequip(){
        for(int i = 0; i < weapon.getStats().getStats().length; i++){
            stats.drop(i, (double)weapon.getStats().getStats()[i]);
        }
        weapon = new Weapon("Empty");
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public int getHP(){
        return hp;
    }

    public void setMP(int mp){
        this.mp = mp;
    }

    public int getMP(){
        return mp;
    }

    public static void main(String[] args) {
        Entity crimson = new Entity("Crimson");
        crimson.unequip();
        System.out.println(crimson.getWeapon().getName());
    }
}