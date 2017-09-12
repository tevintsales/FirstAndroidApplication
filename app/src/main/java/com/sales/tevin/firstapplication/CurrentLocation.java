package com.sales.tevin.firstapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CurrentLocation extends AppCompatActivity {

    private LocationManager locationManager;
    private LocationListener locationListener;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, locationListener);
            }
        }
    }








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                // Get geocode info
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                try {
                    List<Address> listAddresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                    if(listAddresses != null && listAddresses.size() > 0){
                        String address = "";
                        //ROAD NUMBER
                        if(listAddresses.get(0).getSubThoroughfare() != null){
                            address += listAddresses.get(0).getSubThoroughfare() + " ";
                        }
                        //STREET NAME
                        if(listAddresses.get(0).getThoroughfare() != null){
                            address += listAddresses.get(0).getThoroughfare() + ", ";
                        }
                        //TOWN NAME
                        if(listAddresses.get(0).getLocality() != null){
                            address += listAddresses.get(0).getSubThoroughfare() + ", ";
                        }
                        //POSTAL CODE
                        if(listAddresses.get(0).getPostalCode() != null){
                            address += listAddresses.get(0).getSubThoroughfare() + ", ";
                        }
                        //Country Name
                        if(listAddresses.get(0).getCountryName() != null){
                            address += listAddresses.get(0).getSubThoroughfare() + ".";
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };


        //if device is running SDK < 23
        if(Build.VERSION.SDK_INT < 23){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, locationListener);
        }else {

            //ask for permission
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            // Permission already granted
            else {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, locationListener);
            }
        }
    }






}
