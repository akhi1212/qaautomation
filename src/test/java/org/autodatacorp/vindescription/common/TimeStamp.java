package org.autodatacorp.vindescription.common;

import java.time.Instant;

public class TimeStamp {

    private static Instant myself = Instant.now();

    private TimeStamp(){ }

    public static Instant getInstance(){
        if(myself == null){
            myself  = Instant.now();
        }
        return myself;
    }

    public static void ClearTimeStamp(){
        myself = null;
    }
}
