package asciiDots;

import org.jetbrains.annotations.Nullable;

public class NumericalData extends AsciiDotsProgramData{

    private final double data;

    public NumericalData(double data){
        super();
        this.data = data;
    }

    @Override
    public @Nullable AsciiDotsProgramData Clone() {
        return null;
    }

    public String repr(){
        return super.repr() + "data : " + this.data + "}";
    }

}
