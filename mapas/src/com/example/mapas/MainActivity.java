package com.example.mapas;

import android.support.v7.app.ActionBarActivity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final LocationListener mLocationListener = new LocationListener() {
		    @Override
		    public void onLocationChanged(final Location location) {
		        TextView latitud = (TextView) findViewById(R.id.txtLatitud);
		        TextView longitud = (TextView) findViewById(R.id.txtLongitud);
		        latitud.setText(Double.toString(location.getLatitude()));
		        longitud.setText(Double.toString(location.getLongitude()));
		    }

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
		};
			
		
	    LocationManager mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

	    mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100,
	            1, mLocationListener);
	}
	
	public void cargarMapa(View view){
        TextView txtLatitud = (TextView) findViewById(R.id.txtLatitud);
        TextView txtLongitud = (TextView) findViewById(R.id.txtLongitud);
        String latitud = txtLatitud.getText().toString();
        String longitud =txtLongitud.getText().toString();
		WebView webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setSupportZoom(true);
		webView.loadUrl("http://www.openstreetmap.org/?mlat="+latitud+"&mlon="+longitud+"#map=14/"+latitud+"/"+longitud+"&layers=N");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
