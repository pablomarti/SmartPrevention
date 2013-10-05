package com.example.smartprevention;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ParseReceiver extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent){
		Bundle extras = intent.getExtras();
		String message = extras != null ? extras.getString("com.parse.Data") : "";
		
		JSONObject jObject;
		try{
			jObject = new JSONObject(message);
			Log.d("ParseReceiver", jObject.get("title").toString());
		}
		catch(JSONException e){
			e.printStackTrace();
		}
	}

}
