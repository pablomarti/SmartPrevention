package com.example.smartprevention;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AlertActivity extends Activity {
	private LinearLayout panic_item,sos_item,save_item;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert);
		
		panic_item = (LinearLayout) findViewById(R.id.panic_item);
		sos_item = (LinearLayout) findViewById(R.id.sos_item);
		save_item = (LinearLayout) findViewById(R.id.save_item);
		//Boton de panico
		panic_item.setOnTouchListener(
			new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Toast toast1 =
			            Toast.makeText(getApplicationContext(),
			                    "Panic Item", Toast.LENGTH_SHORT);
			        toast1.show();
				return false;
			}
		});
		//Boton de panico
		sos_item.setOnTouchListener(
			new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Toast toast1 =
			            Toast.makeText(getApplicationContext(),
			                    "SOS Item", Toast.LENGTH_SHORT);
			        toast1.show();
				return false;
			}
		});
		//Boton de panico
		save_item.setOnTouchListener(
			new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Toast toast1 =
			            Toast.makeText(getApplicationContext(),
			                    "Save Item", Toast.LENGTH_SHORT);
			        toast1.show();
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alert, menu);
		return true;
	}

}
