package br.com.android;

import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class GoogleMaps extends MapActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Aqui é apontado para a View MapView em nosso layout padrão
		MapView mapView = (MapView) findViewById(R.id.mapview);
		// Adicionar o zoom em nosso mapa
		mapView.setBuiltInZoomControls(true);

		
		
		
		// Lista com as camadas que iremos usar em nosso exemplo
		List<Overlay> mapOverlays = mapView.getOverlays();
		// imagem que iremos usar em nossa camada
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.ic_launcher);
		// objeto de nossa classe HelloItemizedOverlay, que é responsavel pelas
		// camadas já passando a imagem como parametro
		HelloItemizedOverlay itemizedoverlay = new HelloItemizedOverlay(
				drawable, this);
		// Coordenada geografica de inicio para nossa camada
		GeoPoint point = new GeoPoint(-22559725, -44959370);
		// item da camada
		OverlayItem overlayitem = new OverlayItem(point,
				"Olá Pessoal para quem não conhece", "Aqui é Cruzeiro");

		// adicionando os parametros para o metodo de nossa classe
		itemizedoverlay.addOverlay(overlayitem);

		// camada acrescentada em nossa Lista
		mapOverlays.add(itemizedoverlay);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}