package com.example.au21maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.au21maps.databinding.ActivityMapsBinding
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val uniqeString = UUID.randomUUID().toString()


        Log.d("!!!", "onCreate: $uniqeString ")

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val adapter = PlacesInfoAdapter(this)
        mMap.setInfoWindowAdapter(adapter)

       // createMarkers()
        createPlaces()
    }

    fun createMarkers() {

        val sthlm = LatLng(59.3, 18.0)
        val marker = mMap.addMarker(MarkerOptions()
            .position(sthlm)
            .title("Stockholm")
            .snippet("Vackert här!")
        )

        marker.tag = R.drawable.ic_baseline_airplanemode_active_24


        val marker2 = mMap.addMarker(MarkerOptions()
            .position(LatLng(60.0, 19.0))
            .title("Plats2")
            .snippet("Vackert här!")
        )

        marker2.tag = R.drawable.ic_baseline_baby_changing_station_24


        val marker3 = mMap.addMarker(MarkerOptions()
            .position(LatLng(58.0, 17.0))
            .title("Plats3")
            .snippet("Vackert här!")
        )

        marker3.tag = R.drawable.ic_baseline_directions_bus_24
    }

    fun createPlaces() {
        val p1 = PlaceInfo("Hemma", "bäst", LatLng(59.3, 18.0),
            R.drawable.ic_baseline_baby_changing_station_24
        )

        val p2 = PlaceInfo("Borta", "bra", LatLng(59.0, 17.0),
            R.drawable.ic_baseline_airplanemode_active_24
        )

        val placesList = listOf<PlaceInfo>(p1, p2)

        //--------- vi har en lista av platser

        for( place in placesList) {
            val mark = mMap.addMarker(MarkerOptions().position(place.position))
            mark.tag = place
        }


    }

}

class PlaceInfo(val name: String, val info: String, val position: LatLng, val image: Int )