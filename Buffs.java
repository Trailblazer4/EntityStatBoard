import java.util.*;

public class Buffs {
    private Stack<Status>[] buffs;

    @SuppressWarnings("unchecked")
    public Buffs(){
        buffs = new Stack[5];
        for(int i = 0; i < 5; i++){
            buffs[i] = new Stack<>();
        }
    }

    public void put(Status buff){
        int indx = 0;

        switch(buff){
            case ATKUP:
            case ATKDWN:
                indx = 0;
                break;
            case DEFUP:
            case DEFDWN:
                indx = 1;
                break;
            case MAGUP:
            case MAGDWN:
                indx = 2;
                break;
            case MGDFUP:
            case MGDFDWN:
                indx = 3;
                break;
            case SPDUP:
            case SPDDWN:
                indx = 4;
                break;
        }

        buffs[indx].push(buff);
    }
}
