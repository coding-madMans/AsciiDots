package asciiDots;

public class Period {

    public static final byte NO_FLAGS = 0B1000_00_0;
    public static final byte DATA_FLAG = 0B1000_00_1;
    public static final byte DIR_FLAG_EAST = 0B1000_00_0;
    public static final byte DIR_FLAG_SOUTH = 0B1000_01_0;
    public static final byte DIR_FLAG_WEST = 0B1000_10_0;
    public static final byte DIR_FLAG_NORTH = 0B1000_11_0;

    protected int rowPos, colPos;
    protected int dataID;
    protected byte flags;

    public Period(int rowPos, int colPos){
        this.rowPos = rowPos;
        this.colPos = colPos;
        this.dataID = -1;
        this.flags = Period.NO_FLAGS;
    }

}
