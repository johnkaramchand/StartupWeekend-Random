package com.random.random.random;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity implements OnMapReadyCallback {


    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Comming Soon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



        FloatingActionButton fabprofile = findViewById(R.id.fab2);
        fabprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          /*      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                startActivity(new Intent(Main3Activity.this,ProfileActivity.class));
            }
        });
            }
        });




        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(12.93553806, 77.61409526);

        CameraPosition position = CameraPosition.builder()
                .target( new LatLng( 12.9355324, 77.6119066 ) )
                .zoom( 16f )
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition( position ), null );
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        ///////////////////////////////////////////////////////////////////////
        InfoWindowData info = new InfoWindowData();
        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m = mMap.addMarker(new MarkerOptions().position(sydney).title("Koramangala Social"));
        m.setTag(info);
        m.showInfoWindow();

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(Main3Activity.this, "Yay Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main3Activity.this,modeData.class));
            }
        });
        ////////////////////////////////////////////////////////////////////////////////

    }
}
