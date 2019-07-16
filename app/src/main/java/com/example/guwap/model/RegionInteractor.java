package com.example.guwap.model;

import com.example.guwap.entity.Region;

import java.util.List;

public class RegionInteractor extends Interactor{
    public RegionInteractor(Repository repo) { super (repo);}

    public List<Region> getAllRegions() { return getRepository().getAllRegions(); }

    /**
     * add region
     * @param p region to add
     */
    public void addRegion (Region p) { getRepository().addRegion(p); }

    /**
     * Distance between two locations
     * @param current current location
     * @param destination destination location
     * @return distance between
     */
    public double distanceBetween (Region current, Region destination) {
        double curlat = current.getLattitude();
        double curlong = current.getLongitude();
        double destlat = destination.getLattitude();
        double destlong = destination.getLongitude();

        double latdif2 = Math.pow((destlat - curlat), 2);
        double longdif2 = Math.pow((destlong - curlong), 2);

        return Math.sqrt(latdif2 + longdif2);
    }
}
