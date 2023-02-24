package org.artemis.artemiscommon.utils;

public class Utils {

    public static <T> boolean in(T value, T ... variants) {
        for(var option : variants){
            if(option.equals(value)){
                return true;
            }
        }
        return false;
    }

}
