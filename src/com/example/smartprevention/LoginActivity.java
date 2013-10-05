package com.example.smartprevention;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private Button btnSign_up;
	private Button btnLogin_in;
	
	private EditText user_login;
	private EditText user_password;
	private Login loginManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		btnSign_up = (Button) findViewById(R.id.button_sign_up);
		btnLogin_in = (Button) findViewById(R.id.button_login);
		
		//Campos de email y password
		
		user_login = (EditText) findViewById(R.id.user_login);
		user_password = (EditText) findViewById(R.id.user_password);
		
		btnSign_up.setOnClickListener(
				new View.OnClickListener(){
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
						startActivityForResult(intent,0);
					}
		});// end btnSign_up.setOnClickListener
		
		btnLogin_in.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					loginManager = new Login();
					loginManager.setCustomEventListener(new OnCustomEventListener(){
						public void onEvent(){
							if(loginManager.getEvent() == "login"){
								if(loginManager.userLoged){
									Intent intent = new Intent(LoginActivity.this, MainActivity.class);
									startActivityForResult(intent,0);
								}
								else{
									Toast.makeText(getBaseContext(), "Usuario o password invalido", Toast.LENGTH_SHORT).show();
								}
							}
						}
					});
					
					loginManager.login(user_login.getText().toString(), user_password.getText().toString());
				}
		});//end btnLogin_in.setOnClickListener
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
