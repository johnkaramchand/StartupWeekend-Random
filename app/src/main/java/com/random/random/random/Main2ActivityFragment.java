package com.random.random.random;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A placeholder fragment containing a simple view.
 */
public class Main2ActivityFragment extends Fragment  implements OnMapReadyCallback {
    private GoogleMap mMap;


    public Main2ActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment =  (SupportMapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return inflater.inflate(R.layout.fragment_main2, container, false);
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
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        ///////////////////////////////////////////////////////////////////////
        InfoWindowData info = new InfoWindowData();
        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(getContext());
        mMap.setInfoWindowAdapter(customInfoWindow);
        Marker m = mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        m.setTag(info);
        m.showInfoWindow();

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(getContext(), "Yay Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////

    }
}
