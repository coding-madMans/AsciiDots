package asciiDots;

public class NumericalData extends AsciiDotsProgramData{

    protected double data;

    public NumericalData(double data){
        super();
        this.data = data;
    }

    public String repr(){
        return super.repr() + "data : " + this.data + "}";
    }

}
