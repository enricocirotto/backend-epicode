package NextDevs;

import java.util.HashMap;
import java.util.Map;

public enum Periodicita {
    SETTIMANALE,MENSILE,SEMESTRALE;


    private static final Map<String,Periodicita> stringaEnum=new HashMap<>();
    static {
        for (Periodicita periodicita : values()){
            stringaEnum.put(periodicita.toString(),periodicita);
        }
    }

    public static Periodicita formatoStringa(String string){
        return stringaEnum.get(string.toUpperCase());
    }

}
