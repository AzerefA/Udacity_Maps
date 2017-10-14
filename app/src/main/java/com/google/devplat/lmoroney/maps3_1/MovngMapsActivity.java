package com.google.devplat.lmoroney.maps3_1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MovngMapsActivity extends ActionBarActivity implements OnMapReadyCallback {

    static final CameraPosition MLG = CameraPosition.builder()
            .target(new LatLng(-7.970555, 112.631826))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition SBY = CameraPosition.builder()
            .target(new LatLng(-7.265698, 112.744147))
            .zoom(17)
            .bearing(0)
            .tilt(45)
            .build();
    static final CameraPosition TBN = CameraPosition.builder()
            .target(new LatLng(-6.949541, 111.882250))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    static final CameraPosition PSN = CameraPosition.builder()
            .target(new LatLng(-7.724006, 112.798226))
            .zoom(17)
            .bearing(90)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movng_maps);

        Button btnSeattle = (Button) findViewById(R.id.btnSby);
        btnSeattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(SBY);
            }
        });

        Button btnDublin = (Button) findViewById(R.id.btnTuban);
        btnDublin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(TBN);
            }
        });

        Button btnTokyo = (Button) findViewById(R.id.btnPasuruan);
        btnTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapReady)
                    flyTo(PSN);
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }

    private void flyTo(CameraPosition target) {
        m_map.animateCamera(CameraUpdateFactory.newCameraPosition(target), 10000, null);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        Toast toast = Toast.makeText(getApplicationContext(), "Map Ready!", Toast.LENGTH_SHORT);
        toast.show();
        mapReady = true;
        m_map = map;
        m_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        flyTo(MLG);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
