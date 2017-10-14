package com.google.devplat.lmoroney.maps3_1;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowHockeyActivity extends ActionBarActivity implements OnMapReadyCallback {

    static final CameraPosition MLG = CameraPosition.builder()
            .target(new LatLng(-7.970555, 112.631826))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions myHouse;
    MarkerOptions smp;
    MarkerOptions alun;
    MarkerOptions smk;
    MarkerOptions dot;

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hockey);

        myHouse = new MarkerOptions()
                .position(new LatLng(-7.951070, 112.750013))
                .title("My House")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        smp = new MarkerOptions()
                .position(new LatLng(-7.947758, 112.743981))
                .title("SMPN 1 Jabung")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        alun = new MarkerOptions()
                .position(new LatLng(-7.982511, 112.630867))
                .title("Alun-alun Kota Malang")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        smk = new MarkerOptions()
                .position(new LatLng(-7.977078, 112.658731))
                .title("SMK Telkom")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));

        dot = new MarkerOptions()
                .position(new LatLng(-7.927564, 112.600634))
                .title("DOT Indonesia")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        //MapsInitializer.initialize(getApplicationContext());
        mapReady = true;
        m_map = map;
        m_map.addMarker(myHouse);
        m_map.addMarker(smp);
        m_map.addMarker(alun);
        m_map.addMarker(smk);
        m_map.addMarker(dot);
        flyTo(MLG);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
