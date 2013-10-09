package com.example.smartprevention;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class PreventionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prevention);
		setTitle("Prevenciones");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prevention, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
		Intent prevention_intent = null;
		
	    switch (item.getItemId()){
	        case R.id.alert_menu:
	            //newGame();
	        	prevention_intent = new Intent(PreventionActivity.this, AlertActivity.class);
				startActivityForResult(prevention_intent, 0);
	            return true;
	        case R.id.location_menu:
	            //showHelp();
	        	prevention_intent = new Intent(PreventionActivity.this, MainActivity.class);
	        	startActivityForResult(prevention_intent, 0);
	            return true;
	        case R.id.about_us:
	            //showHelp();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
