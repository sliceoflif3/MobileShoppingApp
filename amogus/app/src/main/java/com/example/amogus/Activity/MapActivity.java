package com.example.amogus.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.amogus.Adapter.CategoryAdapter;
import com.example.amogus.Adapter.RecommendedAdapter;
import com.example.amogus.Domain.CategoryDomain;
import com.example.amogus.Domain.ElectronicDomain;
import com.example.amogus.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        LatLng Amogus1 = new LatLng(10.799014337474052, 106.6474469093028);
        map.addMarker(new MarkerOptions().position(Amogus1).title("Amogus1"));
        LatLng Amogus2 = new LatLng(10.8595538925561, 106.75938814380018);
        map.addMarker(new MarkerOptions().position(Amogus2).title("Amogus2"));
        LatLng Amogus3 = new LatLng(10.753428829096821, 106.6741759739076);
        map.addMarker(new MarkerOptions().position(Amogus3).title("Amogus3"));
        LatLng Amogus4 = new LatLng(10.77386961897219, 106.68928423979033);
        map.addMarker(new MarkerOptions().position(Amogus4).title("Amogus4"));
        LatLng Amogus5 = new LatLng(10.796503689290953, 106.647063037684083);
        map.addMarker(new MarkerOptions().position(Amogus5).title("Amogus5"));
        LatLng Amogus6 = new LatLng(10.792363992752145, 106.65586318417914);
        map.addMarker(new MarkerOptions().position(Amogus6).title("Amogus6"));
        LatLng Amogus7 = new LatLng(10.796746315286683, 106.66482807282472);
        map.addMarker(new MarkerOptions().position(Amogus7).title("Amogus7"));
        LatLng Amogus8 = new LatLng(10.787961565245752, 106.66250105773183);
        map.addMarker(new MarkerOptions().position(Amogus8).title("Amogus8"));
        LatLng Amogus9 = new LatLng(10.75983938492402, 106.66925599094226);
        map.addMarker(new MarkerOptions().position(Amogus9).title("Amogus9"));
        LatLng Amogus10 = new LatLng(10.785762643551216, 106.64185037775349);
        map.addMarker(new MarkerOptions().position(Amogus10).title("Amogus10"));
        LatLng Amogus11 = new LatLng(10.755702063018425, 106.63463060802191);
        map.addMarker(new MarkerOptions().position(Amogus11).title("Amogus11"));

        float zoom = 11;
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(Amogus5, zoom));
    }
}
