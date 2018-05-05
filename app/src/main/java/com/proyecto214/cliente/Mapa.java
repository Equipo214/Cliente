package com.proyecto214.cliente;

import org.osmdroid.api.IMapController;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

class Mapa {


    static void setMap(MapView map){
        map.setTileSource(TileSourceFactory.MAPNIK); // fuente de las imagnes creo que aca tengo que tocar para el offline
        // map.setTileSource(new XYTileSource("YOUR MAP SOURCE", 0, 18, 256, ".jpg", new String[] {}));
        //map.setUseDataConnection(false);
        map.setMultiTouchControls(true);
        map.setBuiltInZoomControls(false);
    }
    static void setUbicacion(MapView map, double latitudeAct,double longitudeAct){
        IMapController mapController = map.getController();
        mapController.setZoom(15.0);
        GeoPoint startPoint = new GeoPoint(latitudeAct,longitudeAct);
        mapController.setCenter(startPoint);
        Marker startMarker = new Marker(map);
        startMarker.setPosition(startPoint); // deberia poner una marca en el centro :th
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(startMarker);
    }

}
