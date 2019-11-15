package com.mrhi.ex68googlemaptest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프레그먼트 관리자 객체 소환
        FragmentManager fragmentManager= getSupportFragmentManager();

        //관리자에게 xml에 있는 프레그먼트를 찾아와달라고 요청
        SupportMapFragment mapFragment= (SupportMapFragment)fragmentManager.findFragmentById(R.id.frag_map);

        //프레그먼트에게 맵 가져오도록
        mapFragment.getMapAsync(this);
    }

    //구글 맵 로딩이 완료되면 실행되는 콜백메소드
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap= googleMap;

        LatLng SEOUL= new LatLng(37.56, 126.97);

        //마커객체 생성 및 설정
        MarkerOptions markerOptions= new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");

        //마커 맵에 추가하기
        gMap.addMarker(markerOptions);


        //마커객체 생성 및 설정
        MarkerOptions markerOptions2= new MarkerOptions();
        markerOptions2.position(SEOUL);
        markerOptions2.title("서울");
        markerOptions2.icon(BitmapDescriptorFactory.fromResource(R.drawable.thumb_moana));
        markerOptions2.snippet("한국의 수도");

        gMap.addMarker(markerOptions2);


        //지도 위치 지정 및 줌
        gMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 15));

        //대표적인 맵 설정
        UiSettings settings= gMap.getUiSettings();
        settings.setZoomControlsEnabled(true);




    }
}
