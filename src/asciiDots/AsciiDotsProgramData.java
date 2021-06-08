package asciiDots;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public abstract class AsciiDotsProgramData {

    public static int LAST_ASCII_PROGRAM_DATA_ID = 0;
    public static HashMap<Integer, AsciiDotsProgramData> PROGRAM_DATA = null;

    protected int ID;

    public AsciiDotsProgramData(){
        this.ID = AsciiDotsProgramData.LAST_ASCII_PROGRAM_DATA_ID++;
        AsciiDotsProgramData.pushData(this);
    }

    public static void AsciiDotsProgramDataInit(){
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

    public String repr(){
        return "{ ID : " + this.ID + ", ";
    }

}
