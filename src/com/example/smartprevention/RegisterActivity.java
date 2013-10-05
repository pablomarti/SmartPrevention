package com.example.smartprevention;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	
	private Button login_register;
	private Button sign_in_register;
	private Login loginManager;
	
	private EditText user_sign_in, email_sign_in,password_sign_in;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		//
		sign_in_register = (Button) findViewById(R.id.sign_in_register);
		login_register = (Button) findViewById(R.id.login_register);
		
		user_sign_in = (EditText) findViewById(R.id.user_sign_in);
		email_sign_in = (EditText) findViewById(R.id.email_sign_in);
		password_sign_in = (EditText) findViewById(R.id.password_sign_in);
		//
		
		login_register.setOnClickListener(
			new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
				startActivityForResult(intent, 0);
			}
		});//end login_register.setOnClickListener
		sign_in_register.setOnClickListener(
			new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				loginManager = new Login();
				loginManager.setCustomEventListener(new OnCustomEventListener(){
					public void onEvent(){
						if(loginManager.getEvent() == "signUp"){
							if(loginManager.userLoged){
								Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
								startActivityForResult(intent,0);
							}
							else{
								Toast.makeText(getBaseContext(), "Hubo un error al momento de crear su cuenta, por favor revise sus datos personales", Toast.LENGTH_SHORT).show();
							}
						}
					}
				});
				
				loginManager.signUp(user_sign_in.getText().toString(), email_sign_in.getText().toString(), password_sign_in.getText().toString());
				
			}
		});//end sign_in_register.setOnClickListener
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
