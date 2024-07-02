import java.util.*;

public class StatBoard{
    private int baseStats[] = new int[7];
    private int trueStats[] = new int[7];
    // private ArrayList<Double>[] mods;
    private ArrayList<Integer>[] modAdds;
    private ArrayList<Double>[] modMults;
    private Integer[] addTotal = {0, 0, 0, 0, 0, 0, 0};
    private Double[] multTotal = {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};

    @SuppressWarnings("unchecked")
    public StatBoard(int hp, int mp, int a, int d, int m, int md, int s){
        baseStats[0] = hp; baseStats[1] = mp;
        baseStats[2] = a; baseStats[3] = d;
        baseStats[4] = m; baseStats[5] = md;
        baseStats[6] = s;

        modAdds = new ArrayList[7];
        modMults = new ArrayList[7];
        for(int i = 0; i < modAdds.length; i++){
            modAdds[i] = new ArrayList<>();
            modMults[i] = new ArrayList<>();
        }
    }

    public void levelUp(int[] allocs){
        baseStats[0] += (allocs[0] * 20); baseStats[1] += (allocs[1] * 5);
        for(int i = 2; i < baseStats.length; i++){
            baseStats[i] += allocs[i];
        }
    }

    public void updateStats(){
        for(int i = 0; i < trueStats.length; i++){
            for(Integer adder : modAdds[i]){
                addTotal[i] += adder;
            }
            for(Double multer : modMults[i]){
                multTotal[i] += multer;
            }
            Double d = ((addTotal[i]) * multTotal[i]);
            trueStats[i] = d.intValue();
        }
    }

    // then some separate methods/procedures added in for whenever equipment is unequipped,
    // new equipment is put on, character levels up, etc.

    public void add(int whichStat, Integer mod){
        modAdds[whichStat].add(mod);
        addTotal[whichStat] += mod;
    }

    public void add(int whichStat, Double mod){
        modMults[whichStat].add(mod);
        multTotal[whichStat] += mod;
    }

    public void drop(int whichStat, Integer mod){
        if(modAdds[whichStat].remove(mod)){
            trueStats[whichStat] -= mod;
        }
    }

    public void drop(int whichStat, Double mod){
        if(modMults[whichStat].remove(mod)){
            trueStats[whichStat] -= mod;
        }
    }

    public int[] getStats(){
        return baseStats;
    }

public static void main(String[] args) {
    double baseStat = 10; double mod1 = 3, mod2 = 4;

    System.out.println(baseStat * (1.0 + (mod2 / 10.0)));

    double trueStat = (baseStat + mod1) * (1.0 + (mod2 / 10.0));
    System.out.println(trueStat);

    System.out.println(trueStat);
}

/*
* trueStat = (baseStat + something + mod) * (other modifiers)
* 
* subtracting mod out simply means subtracting from trueStat
* the ratio mod has with the rest of baseStat
* 
* if mod is 1/3 of baseStat, then removing it means subtracting
* 1/4 of trueStat from itself
* 
* trueStat -= ((mod / (baseStat + 1.0)) * trueStat);
* 
* trueStat = 15; mod = 3;
* trueStat -= ((3 / (10 + 1)) * 15)

 * t = m((n + 1) / 10)
 * m = b + m1 + m2 + ... + mk
 * n = n1 + n2 + ... + nk
 * 
 * r = t / b, the multiplier for how powerful t is compared to b
 * t = br
 * b = t / r
 * 
 * if m1 is 1/x of b, then m1 is 1/xr of t
 * 
 * so to get rid of m1, we get rid of 1/xr of t
 * 
 * t -= ((t / r) * (m1 / b))
 * where r = t / b
 * 
 * t -= (t / ((m1 / b) * (t / b)))

    public void setMaxHP(int hp){
        maxHP = hp;
    }

    public int getMaxHP(){
        return maxHP;
    }

    public void setMaxMP(int mp){
        maxMP = mp;
    }

    public int getMaxMP(){
        return maxMP;
    }

    public void setAtk(int a){
        atk = a;
    }

    public int getAtk(){
        return atk;
    }

    public void setDef(int a){
        def = a;
    }

    public int getDef(){
        return def;
    }

    public void setMag(int m){
        mag = m;
    }

    public int getMag(){
        return mag;
    }

    public void setMgdf(int md){
        mgdf = md;
    }

    public int getMgdf(){
        return mgdf;
    }

    public void setSpd(int s){
        spd = s;
    }

    public int getSpd(){
        return spd;
    }
    */
}
