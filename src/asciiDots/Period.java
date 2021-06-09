package asciiDots;

public class Period {

    public static int LAST_PERIOD_ID = 0;

    public static final char NO_FLAGS = 0B0000000000000_00_0;
    public static final char DATA_FLAG = 0B0000000000000_00_1;
    public static final char DIR_FLAG_EAST = 0B0000000000000_00_0;
    public static final char DIR_FLAG_SOUTH = 0B0000000000000_01_0;
    public static final char DIR_FLAG_WEST = 0B0000000000000_10_0;
    public static final char DIR_FLAG_NORTH = 0B0000000000000_11_0;

    private int rowPos, colPos;
    private AsciiDotsProgramData data;
    private char flags;
    private final int ID;

    public Period(int rowPos, int colPos){
        this.ID = Period.LAST_PERIOD_ID++;
        this.rowPos = rowPos;
        this.colPos = colPos;
        this.data = null;
        this.flags = Period.NO_FLAGS;
    }

    public int getID(){
        return this.ID;
    }

    public char getFlags(){
        return this.flags;
    }

    private AsciiDotsProgramData getData(){
        if((this.flags | Period.DATA_FLAG) != Period.DATA_FLAG){
            return null;
        }
        return this.data.Clone();
    }

    private void setData(AsciiDotsProgramData data){
        if(data == null){
            this.data = null;
            char dir = this.getDir();
            this.flags = Period.NO_FLAGS;
            this.changePeriodDirection(dir);
            return;
        }
        this.flags |= Period.DATA_FLAG;
        this.data = data.Clone();
    }

    private void changePeriodDirection(char dir){
        boolean dataFlag = ((this.flags | Period.DATA_FLAG) == Period.DATA_FLAG);
        switch(dir){
            case 'E' -> this.flags = (dataFlag) ? Period.DATA_FLAG | Period.DIR_FLAG_EAST : Period.DIR_FLAG_EAST;
            case 'S' -> this.flags = (dataFlag) ? Period.DATA_FLAG | Period.DIR_FLAG_SOUTH : Period.DIR_FLAG_SOUTH;
            case 'W' -> this.flags = (dataFlag) ? Period.DATA_FLAG | Period.DIR_FLAG_WEST : Period.DIR_FLAG_WEST;
            case 'N' -> this.flags = (dataFlag) ? Period.DATA_FLAG | Period.DIR_FLAG_NORTH : Period.DIR_FLAG_NORTH;
        }
    }

    public int getRowPos(){
        return this.rowPos;
    }

    public int getColPos(){
        return this.colPos;
    }

    public char getDir(){
        char dir;
        if((this.flags | Period.DIR_FLAG_EAST) == Period.DIR_FLAG_EAST){
            dir = 'E';
        }else if((this.flags | Period.DIR_FLAG_SOUTH) == Period.DIR_FLAG_SOUTH){
            dir = 'S';
        }else if((this.flags | Period.DIR_FLAG_WEST) == Period.DIR_FLAG_WEST){
            dir = 'W';
        }else{
            dir = 'E';
        }
        return dir;
    }

    public void updatePosition(AsciiDots asciiDotsProgram){
        this.colPos += 1;
        this.rowPos += 1;
    }

}
