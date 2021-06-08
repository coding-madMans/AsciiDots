package asciiDots;

public class StringData extends AsciiDotsProgramData {

    protected String data;

    public StringData(String data){
        super();
        this.data = data;
    }

    public String repr(){
        return super.repr() + "data : " + this.data + "}";
    }

}
