import java.util.*;

public class ModuloTest {
    public static void main(String[] args) {
        ArrayList<Double> mods = new ArrayList<>();
        mods.add(10.00);    // can add Doubles to a list of modifiers in StatBoard
        mods.add(10.1);     // why? because you can reference values with no remainder as full numbers to add, and
                              // ones with remainder as percentage boosts (+10%, -20%...)
        mods.add(5.00);
        mods.add(-20.5);

        Double total = 0d;
        for(Double d : mods){
            if(d % 1 == 0){
                total += d;
            }
            else{
                total += (total * (d - (d % 1)) / 100);
            }
        }

        Double initialD = 10.00;
        Double d = initialD;

        /*
        d += (initialD * -.20);
        System.out.println(d);
        d-= (initialD * -.20);
        System.out.println(d);
        */

        Scanner choose = new Scanner(System.in);
        int[] stats = new int[7];
        Stack<Integer> statTracker = new Stack<>();

        for(int alloc = 10; alloc > 0; alloc--){
            System.out.print("Choose a stat to increase(" + alloc + " points remaining): ");
            String choice = choose.nextLine();
            if(choice.equals("x")){
                if(alloc < 10){
                    stats[statTracker.pop()]--;
                    alloc++;
                }
                alloc++;
                // also keep track of stats allocated to properly deallocate after player cancels
            }
            else{
                stats[Integer.parseInt(choice)] += 1;
                statTracker.push(Integer.parseInt(choice));
            }
        }

        for(int i = 0; i < stats.length; i++){
            System.out.print(stats[i] + " ");
        }
        System.out.println();

        // Entity.levelUp(int[] allocs) function
        /*
        
        public void levelUp(int[] allocs){
            stats.levelUp(int[] allocs);
        }

        --StatBoard--
        public void levelUp(int[] allocs){
            hp += allocs[0] * 20; mp += allocs[1] * 5;
            atk += allocs[2]; def += allocs[3];
            mag += allocs[4]; mgdf += allocs[5];
            spd += allocs[6];
        }
    
        idea: make an array for stats instead of individual ints

        */
    }
}
