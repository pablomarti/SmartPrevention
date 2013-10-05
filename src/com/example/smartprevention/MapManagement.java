package com.example.smartprevention;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

public class MapManagement extends WebServiceManager {
	
	public JSONArray zones;
	
	public void getSafeZones(){
    	operation = "getSafeZones";
    	startConnection("zones.json", "GET");		
	}
	
	public void getNearestSafeZones(Double longitude, Double latitude){
    	JSONObject json = new JSONObject();
		JSONObject position = new JSONObject();
		
		String getData = "";
		try{
			position.put("longitude", longitude);
			position.put("latitude", latitude);
			json.put("position", position);
			getData = json.getString("position");
		}
    	catch(Exception ex){
    		//TODO
    	}
		
    	operation = "getSafeZones";
    	startConnection("zones.json?" + getData, "GET");	
	}
    
    protected void onPostExecute(String result) {
    	try {           
    		JSONObject jsonObject = new JSONObject(result);
        	zones = new JSONArray(jsonObject.getString("zones")); 
        	mListener.onEvent();
    	}
    	catch (Exception e) {
    		Log.d("MapManagement", e.getLocalizedMessage());
    	}
    }

}
