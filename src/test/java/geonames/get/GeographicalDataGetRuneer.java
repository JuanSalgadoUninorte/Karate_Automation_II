package geonames.get;

import com.intuit.karate.junit5.Karate;

public class GeographicalDataGetRuneer {

    @Karate.Test
    Karate geographicalDataGet(){
        return Karate.run().relativeTo(getClass());
    }

}
