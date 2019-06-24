package com.example.guwap.view;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guwap.R;
import com.example.guwap.entity.Location;
import com.example.guwap.entity.Universe;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapcreation);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng atlanta = new LatLng(33.7490, 84.3880);
        mMap.addMarker(new MarkerOptions().position(atlanta).title("Marker in Smith"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(atlanta));


        for (Location location: Universe.locationArrayList) {
            Log.d(location.getName(), location.getPeopleType(), location.getResources());
            LatLng marker = new LatLng(location.getLattitude(), location.getLongitude());
            Marker marker1 = mMap.addMarker(new MarkerOptions().position(marker).title(location.getName()));
            marker1.setTag(marker1.hashCode());
        }


    }
}