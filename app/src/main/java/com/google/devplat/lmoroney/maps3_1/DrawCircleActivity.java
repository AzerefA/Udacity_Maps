package com.google.devplat.lmoroney.maps3_1;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class DrawCircleActivity extends ActionBarActivity implements OnMapReadyCallback {

    static final CameraPosition MLG = CameraPosition.builder()
            .target(new LatLng(-7.970555, 112.631826))
            .zoom(15)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    LatLng renton = new LatLng(-7.970555, 112.631826);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_circle);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(MLG));
        map.addCircle(new CircleOptions()
                .center(renton)
                .radius(200)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(64, 0, 255, 50)));
    }
}
