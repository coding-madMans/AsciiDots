package asciiDots;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public abstract class AsciiDotsProgramData {

    public static int LAST_ASCII_PROGRAM_DATA_ID = 0;
    public static HashMap<Integer, AsciiDotsProgramData> PROGRAM_DATA = null;

    private final int ID;
    private int totalInstances;

    public AsciiDotsProgramData(){
        this.ID = AsciiDotsProgramData.LAST_ASCII_PROGRAM_DATA_ID++;
        this.totalInstances = 0;
        AsciiDotsProgramData.pushData(this);
    }

    public static void inti(){
        PROGRAM_DATA = new HashMap<>();
    }

    public static void pushData(AsciiDotsProgramData data){
        PROGRAM_DATA.put(data.ID, data);
    }

    public static @Nullable
    AsciiDotsProgramData popData(int ID){
        if(PROGRAM_DATA.containsKey(ID)){
            return PROGRAM_DATA.remove(ID);
        }
        return null;
    }

    abstract public @Nullable AsciiDotsProgramData Clone();

    public String repr(){
        return "{ ID : " + this.ID + ", ";
    }

}
