package com.example.smartprevention;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	public ImageButton alert_critic_button,sos_button, save_button,unknow_button; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.alert_menu:
	            //newGame();
	        	Intent intent = new Intent(MainActivity.this, AlertActivity.class);
				startActivityForResult(intent, 0);
	            return true;
	        case R.id.prevention_menu:
	            //showHelp();
	            return true;
	        case R.id.about_us:
	            //showHelp();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}

