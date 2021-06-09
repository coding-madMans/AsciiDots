package asciiDots;

import org.jetbrains.annotations.Nullable;

public class StringData extends AsciiDotsProgramData {

    private final String data;

    public StringData(String data){
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
