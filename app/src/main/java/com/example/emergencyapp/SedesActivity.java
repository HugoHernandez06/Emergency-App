package com.example.emergencyapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SedesActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sedes);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //LatLng colombia = new LatLng(4.6094682,-83.4145277);
        LatLng antioquia = new LatLng(7.2020663305348185,-75.33587);

        LatLng EMPRESASOCIALDELESTADOHOSPITALGENERALDEMEDELLINLUZCASTRODEGUTIERREZ = new LatLng(6.23477, -75.5750367);
        LatLng METROSALUD = new LatLng(6.244572, -75.5720487);
        LatLng CENTRODEATENCIONYREHABILITACIONENSALUDMENTALDEANTIOQUIACARISMA = new LatLng(6.242055, -75.6207307);
        LatLng EMPRESASOCIALDELESTADOHOSPITALLAMARIA = new LatLng(6.28661, -75.5763677);
        LatLng ESEHOSPITALMENTALDEANTIOQUIA = new LatLng(6.324341, -75.564802);
        LatLng EMPRESASOCIALDELESTADOHOSPITALMARCOFIDELSUAREZ = new LatLng(6.330313, -75.557731);
        LatLng EMPRESASOCIALDELESTADOBELLOSALUD = new LatLng(6.339078, -75.56404);
        LatLng ESEHOSPITALSANTAMARGARITA = new LatLng(6.349485, -75.505182);
        LatLng ESEHOSPITALMANUELURIBEANGEL = new LatLng(6.166892, -75.580128);
        LatLng CLINICASANTAGERTRUDIS = new LatLng(6.168454, -75.581989);
        LatLng ESEHOSPITALSANRAFAELDEITAGUI = new LatLng(6.171281, -75.613242);
        LatLng ESEHOSPITALDELSURGABRIELJARAMILLOPIEDRAHITA = new LatLng(6.165313, -75.621337);
        LatLng ESEHOSPITALVENACIODIAZDIAZ = new LatLng(6.148166, -75.621836);
        LatLng EMPRESASOCIALDELESTADOHOSPITALLAESTRELLA = new LatLng(6.157163, -75.64302);

        mMap.addMarker(new MarkerOptions().position(EMPRESASOCIALDELESTADOHOSPITALGENERALDEMEDELLINLUZCASTRODEGUTIERREZ).title("EMPRESA SOCIAL DEL ESTADO HOSPITAL GENERAL DE MEDELLIN LUZ CASTRO DE GUTIERREZ"));
        mMap.addMarker(new MarkerOptions().position(METROSALUD).title("METROSALUD"));
        mMap.addMarker(new MarkerOptions().position(CENTRODEATENCIONYREHABILITACIONENSALUDMENTALDEANTIOQUIACARISMA).title("CENTRO DE ATENCION Y REHABILITACION EN SALUD MENTAL DE ANTIOQUIA CARISMA"));
        mMap.addMarker(new MarkerOptions().position(EMPRESASOCIALDELESTADOHOSPITALLAMARIA).title("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MARIA"));
        mMap.addMarker(new MarkerOptions().position(ESEHOSPITALMENTALDEANTIOQUIA).title("E.S.E. HOSPITAL MENTAL DE ANTIOQUIA"));
        mMap.addMarker(new MarkerOptions().position(EMPRESASOCIALDELESTADOHOSPITALMARCOFIDELSUAREZ).title("EMPRESA SOCIAL DEL ESTADO HOSPITAL MARCO FIDEL SUAREZ"));
        mMap.addMarker(new MarkerOptions().position(EMPRESASOCIALDELESTADOBELLOSALUD).title("EMPRESA SOCIAL DEL ESTADO BELLO SALUD"));
        mMap.addMarker(new MarkerOptions().position(ESEHOSPITALSANTAMARGARITA).title("E.S.E. HOSPITAL SANTA MARGARITA"));
        mMap.addMarker(new MarkerOptions().position(ESEHOSPITALMANUELURIBEANGEL).title("ESE HOSPITAL MANUEL URIBE ANGEL"));
        mMap.addMarker(new MarkerOptions().position(CLINICASANTAGERTRUDIS).title("CLINICA SANTA GERTRUDIS"));
        mMap.addMarker(new MarkerOptions().position(ESEHOSPITALSANRAFAELDEITAGUI).title("E.S.E. HOSPITAL SAN RAFAEL DE ITAGUI"));
        mMap.addMarker(new MarkerOptions().position(ESEHOSPITALDELSURGABRIELJARAMILLOPIEDRAHITA).title("E.S.E. HOSPITAL DEL SUR GABRIEL JARAMILLO PIEDRAHITA"));
        mMap.addMarker(new MarkerOptions().position(ESEHOSPITALVENACIODIAZDIAZ).title("E.S.E. HOSPITAL VENACIO DIAZ DIAZ"));
        mMap.addMarker(new MarkerOptions().position(EMPRESASOCIALDELESTADOHOSPITALLAESTRELLA).title("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA ESTRELLA"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(antioquia));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
}
