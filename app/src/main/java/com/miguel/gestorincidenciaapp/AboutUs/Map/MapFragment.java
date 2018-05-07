package com.miguel.gestorincidenciaapp.AboutUs.Map;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguel.gestorincidenciaapp.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.clustering.RadiusMarkerClusterer;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.MinimapOverlay;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;


public class MapFragment extends Fragment {

    private MapView map;
    private IMapController mapController;
    private MyLocationNewOverlay miPosicion;
    private MinimapOverlay mMinimapOverlay;
    private ScaleBarOverlay mScaleBarOverlay;
    private CompassOverlay mCompassOverlay;
    private RadiusMarkerClusterer institud;


    public MapFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_map, container, false);

        map = inflate.findViewById(R.id.mapView);

        prepareMap();
        setZoom();
        implementOverlays();
        setMarker();

        return inflate;
    }

    private void setMarker(){
        prepareMarkers();

        Marker marker = new Marker(map);

        GeoPoint point = new GeoPoint(new Double(41.398297), new Double(2.203253));

        marker.setPosition(point);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);

        marker.setIcon(getResources().getDrawable(R.drawable.marker_default));

        marker.setTitle("ECAIB");
        marker.setPosition(point);
        marker.setAlpha(0.6f);

        institud.add(marker);

        map.invalidate();
    }

    private void prepareMarkers(){

        institud = new RadiusMarkerClusterer(getContext());
        map.getOverlays().add(institud);

        Drawable drawable = getResources().getDrawable(R.drawable.marker_cluster);
        Bitmap clusterIcon = ((BitmapDrawable)drawable).getBitmap();

        institud.setIcon(clusterIcon);
        institud.setRadius(100);

    }

    private void implementOverlays() {

        final DisplayMetrics dm = getResources().getDisplayMetrics();

        miPosicion = new MyLocationNewOverlay(
                new GpsMyLocationProvider(getContext()),
                map
        );

        miPosicion.enableMyLocation();
        miPosicion.runOnFirstFix(new Runnable() {
            public void run() {
                mapController.animateTo( miPosicion
                        .getMyLocation());
            }
        });

        mScaleBarOverlay = new ScaleBarOverlay(map);
        mScaleBarOverlay.setCentred(true);
        mScaleBarOverlay.setScaleBarOffset(dm.widthPixels / 2, 10);

        mCompassOverlay = new CompassOverlay(
                getContext(),
                new InternalCompassOrientationProvider(getContext()),
                map
        );
        mCompassOverlay.enableCompass();

        map.getOverlays().add(miPosicion);
        map.getOverlays().add(this.mScaleBarOverlay);
        map.getOverlays().add(this.mCompassOverlay);

    }

    private void setZoom() {

        mapController = map.getController();
        mapController.setZoom(14);

    }

    private void prepareMap() {

        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setTilesScaledToDpi(true);

        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

    }

}
