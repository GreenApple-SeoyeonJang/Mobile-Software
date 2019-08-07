package com.example.puppy.r1610861_3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final LatLng SEOUL = new LatLng(37.566, 126.977);
    ArrayList<LatLng> arrayp;
    LatLng position,position2;
    private GoogleMap mMap;
    Button bt;
    int flag;
    double lat;
    double longt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        arrayp = new ArrayList<LatLng>();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        flag=0;

        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        if (flag==0) {
            arrayp.add(SEOUL);
            position = SEOUL;
        }

        LocationListener mLocationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                if (flag==0) {
                    arrayp.add(SEOUL);
                    position = SEOUL;
                }
                position2 = new LatLng(lat, longt);
                lat = location.getLatitude();
                longt = location.getLongitude();
                arrayp.add(position2);
                flag=1;
                onMapReady(mMap);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

        try {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, mLocationListener);
            }
        }
        catch(SecurityException e){
            e.printStackTrace();
        }
        bt = findViewById(R.id.button);
        bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL,15));
        if (flag == 1) {
            PolylineOptions line = new PolylineOptions().color(Color.RED).width(5).add(position).add(position2);
            line.add(position2);
            mMap.addPolyline(line);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position2, 15));
            position = position2;
            line.addAll(arrayp);
            Polyline pl = mMap.addPolyline(line);
        }

    }
}