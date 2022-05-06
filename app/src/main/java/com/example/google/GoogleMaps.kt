package com.example.google

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class GoogleMaps : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_map)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        // Add a marker in Sydney and move the camera
        val laSabana = LatLng(9.9340475, -84.1033985)
        val cascajal = LatLng(10.036806, -83.928864)
        val barba = LatLng(10.183835, -84.154914)
        val ranchoRedondo = LatLng(9.958139, -83.952854)
        val llanoGrande = LatLng(9.939656, -83.910670)
        val atenas = LatLng(9.978431, -84.376526)
        val miramar = LatLng(10.076064, -84.730133)
        val lasNubes = LatLng(9.986386, -83.961321)

        mMap.addMarker(MarkerOptions()
            .position(laSabana)
            .title("La Sabana, San José, Costa Rica"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(laSabana))

        mMap.addMarker(MarkerOptions()
            .position(cascajal)
            .title("Cascajal, San José, Costa Rica"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cascajal))

        mMap.addMarker(MarkerOptions()
            .position(barba)
            .title("Barba, Heredia, Costa Rica"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(barba))

        mMap.addMarker(MarkerOptions()
            .position(ranchoRedondo)
            .title("Rancho Redondo, San José, Costa Rica"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ranchoRedondo))

        mMap.addMarker(MarkerOptions()
            .position(llanoGrande)
            .title("LLano Grande, Cartago, Costa Rica"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(llanoGrande))

        mMap.addMarker(MarkerOptions()
            .position(atenas)
            .title("Atenas, Alajuela, Costa Rica"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(atenas))

        mMap.addMarker(MarkerOptions()
            .position(miramar)
            .title("Miramar, Puntarenas, Costa Rica"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(miramar))

        mMap.addMarker(MarkerOptions()
            .position(lasNubes)
            .title("Las Nubes, San José, Costa Rica"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lasNubes))

        Toast.makeText(this, "onMapReady()", Toast.LENGTH_SHORT).show()
    }
}