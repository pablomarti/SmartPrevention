package com.example.smartprevention;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	LocationManager lm; 
	LocationListener locationListener;
	public ImageButton alert_critic_button,sos_button, save_button,unknow_button; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
		locationListener = new MyLocationListener();

		/*Button btn1 = (Button)findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				try{
					LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE); 
					Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
					Log.i("MainActivity1", LocationManager.GPS_PROVIDER);
					Log.i("MainActivity2", location.toString());
					double longitude = location.getLongitude();
					double latitude = location.getLatitude();
					
					Toast.makeText(getBaseContext(), "Longitude: " + longitude + "; Latitude: " + latitude, Toast.LENGTH_SHORT).show();					
				}
				catch(Exception e){
					Log.d("MainActivity3", e.toString());
				}
			}
		});*/
	    
	    Parse.initialize(this, "E7c9LwTnI8NgF3QXtS8WdpQgqzpHYcKJCfcTacXy", "D1V5tfIKQHOuP54JfGnmiRxcb5Dn5rulIdsV5Acs"); 
	    PushService.setDefaultPushCallback(this, MainActivity.class);
	    ParseInstallation.getCurrentInstallation().saveInBackground();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		//---remove the location listener---
		lm.removeUpdates(locationListener);
	}
	
	private class MyLocationListener implements LocationListener {		
		@Override
		public void onLocationChanged(Location loc) {
			if (loc != null) { 
				Toast.makeText(getBaseContext(), "Location changed : Lat: " + loc.getLatitude() + " Lng: " + loc.getLongitude(), Toast.LENGTH_SHORT).show();
			} 
		}
		
		@Override
		public void onProviderDisabled(String provider) {
			Toast.makeText(getBaseContext(), "Provider: " + provider + " disabled", Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public void onProviderEnabled(String provider) {
			Toast.makeText(getBaseContext(), "Provider: " + provider + " enabled", Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) { 
			String statusString = ""; 
			
			switch (status) {
					case android.location.LocationProvider.AVAILABLE: 
																		statusString = "available";
					case android.location.LocationProvider.OUT_OF_SERVICE: 
																		statusString = "out of service";
					case android.location.LocationProvider.TEMPORARILY_UNAVAILABLE: 
																		statusString = "temporarily unavailable";
			}
			
			Toast.makeText(getBaseContext(), provider + " " + statusString, Toast.LENGTH_SHORT).show();
		}
	}


}

