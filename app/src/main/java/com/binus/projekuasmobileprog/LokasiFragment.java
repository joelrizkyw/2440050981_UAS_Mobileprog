package com.binus.projekuasmobileprog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class LokasiFragment extends Fragment {

    LatLng cgpAlpha = new LatLng(-6.193924061113853, 106.78813220277623);
    LatLng cgpBeta = new LatLng(-6.20175020412279, 106.78223868546155);

    private ArrayList<LatLng> locationArrayList;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            for (int i = 0; i < locationArrayList.size(); i++) {

                String markerName = "";

                if (i == 0) {

                    markerName = "CGP Alpha";
                }

                else {

                    markerName = "CGP Beta";
                }
                
                // below line is use to add marker to each location of our array list.
                googleMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title(markerName));

                // below line is use to move our camera to the specific location.
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList.get(i)));
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        locationArrayList = new ArrayList<>();

        locationArrayList.add(cgpAlpha);
        locationArrayList.add(cgpBeta);

        return inflater.inflate(R.layout.fragment_lokasi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}