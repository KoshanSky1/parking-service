package parking_service.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    public static boolean isEmpty(String value){
        return value == null || value.isEmpty();
    }

}
