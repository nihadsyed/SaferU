package com.example.saferu.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.saferu.R;
import com.example.saferu.databinding.FragmentHomeBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class HomeFragment extends Fragment {

    private GoogleMap myMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Get a handle to the GoogleMap object
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                myMap = googleMap;

                // Set the initial camera position to a specific location and zoom level
                LatLng startingLocation = new LatLng(44.972629, -93.233264);
                float zoomLevel = 15.0f;
                myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingLocation, zoomLevel));

                // Add preset markers to the map
                LatLng location1 = new LatLng(44.9743, -93.2323);
                MarkerOptions markerOptions1 = new MarkerOptions()
                        .position(location1)
                        .title("FIRE")
                        .snippet("Fire in Keller Hall, evacuate East Bank (Kenneth H. Keller Hall, 200 Union St SE, Minneapolis, MN 55455)");
                myMap.addMarker(markerOptions1);

                LatLng location2 = new LatLng(44.970825, -93.227839);
                MarkerOptions markerOptions2 = new MarkerOptions()
                        .position(location2)
                        .title("INDECENT CONDUCT")
                        .snippet("A student reported a suspicious person roaming around Frontier in a black hoodie asking for room tours (701 Fulton Street Southeast, Minneapolis, MN, 55455)");
                myMap.addMarker(markerOptions2);

                LatLng location3 = new LatLng(44.975632, -93.229975);
                MarkerOptions markerOptions3 = new MarkerOptions()
                        .position(location3)
                        .title("ROBBER")
                        .snippet("A student was mugged by two adult males next to the RecWell. They drove away in a gray 2013 Toyota Corolla with a moose license plate(123 SE Harvard St, Minneapolis, MN 55455)");
                myMap.addMarker(markerOptions3);

                LatLng location4 = new LatLng(44.980520, -93.235690);
                MarkerOptions markerOptions4 = new MarkerOptions()
                        .position(location4)
                        .title("ROBBER")
                        .snippet("A situation in Insomnia Cookies involving two adult males is developing. Students reporting gun shots in shop.");
                myMap.addMarker(markerOptions4);

                LatLng location5 = new LatLng(44.981499, -93.237343);
                MarkerOptions markerOptions5 = new MarkerOptions()
                        .position(location5)
                        .title("INDECENT CONDUCT")
                        .snippet("Frank From Philly & Andrea Pizza: Older man wearing a green hoodie displaying indecent conduct with two female students.");
                myMap.addMarker(markerOptions5);


                LatLng location6 = new LatLng(44.980700, -93.235280);
                MarkerOptions markerOptions6 = new MarkerOptions()
                        .position(location6)
                        .title("FIRE")
                        .snippet("EVACUATE 14th Ave SE Dinky Town. Fire at Bonchon.");
                myMap.addMarker(markerOptions6);

                LatLng location7 = new LatLng(44.981201, -93.235558);
                MarkerOptions markerOptions7 = new MarkerOptions()
                        .position(location7)
                        .title("GAS LEAK")
                        .snippet("EVACUATE 14th Ave SE Dinky Town. Gas leak detected Wally's.");
                myMap.addMarker(markerOptions7);

                LatLng location8 = new LatLng(44.980820, -93.235810);
                MarkerOptions markerOptions8 = new MarkerOptions()
                        .position(location8)
                        .title("ACTIVE SHOOTER")
                        .snippet("Active shooter at CrunCheese in Dinky Town");
                myMap.addMarker(markerOptions8);

                LatLng location9 = new LatLng(44.98077257577752, -93.23591335234197);
                MarkerOptions markerOptions9 = new MarkerOptions()
                        .position(location9)
                        .title("ASSAULT")
                        .snippet("Young male assaulted by a group of three older men in the corner of Tony diner.");
                myMap.addMarker(markerOptions9);

                LatLng location10 = new LatLng(44.9808081610229, -93.23577951070067);
                MarkerOptions markerOptions10 = new MarkerOptions()
                        .position(location10)
                        .title("CARJACKING")
                        .snippet("Reported carjacking at Bober Tea & Mochi Dough Dinkytown.");
                myMap.addMarker(markerOptions10);
            }

        });
        return view;
    }

}
