package com.example.au21maps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import org.w3c.dom.Text

class PlacesInfoAdapter(val context : Context) : GoogleMap.InfoWindowAdapter {

    val layoutInflater = LayoutInflater.from(context)

    override fun getInfoContents(p0: Marker): View? {

        return null
    }

    override fun getInfoWindow(marker: Marker): View? {
        val infoWindow = layoutInflater.inflate(R.layout.info_window, null)

        val imageView = infoWindow.findViewById<ImageView>(R.id.image)
        val titleView = infoWindow.findViewById<TextView>(R.id.titleText)
        val secondLineView = infoWindow.findViewById<TextView>(R.id.secondLine)

        /* alternativ när vi använder vår createmarker funktion
        titleView.text = marker.title
        secondLineView.text = marker.snippet
        imageView.setImageResource(marker.tag as Int )
*/
        val place = marker.tag as PlaceInfo

        titleView.text = place.name
        secondLineView.text = place.info
        imageView.setImageResource(place.image)

        return infoWindow
    }
}