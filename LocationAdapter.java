
package twitter;

import twitter4j.GeoLocation;

class LocationAdapter {
    String name;
    GeoLocation geolocation;
    public LocationAdapter(String name,GeoLocation geolocation)
    {
        this.name=name;
        this.geolocation=geolocation;
    }
    
}
