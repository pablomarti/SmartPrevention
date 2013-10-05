package com.example.smartprevention;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Login extends WebServiceManager {
	
	protected boolean userLoged = false;
	
	public void login(String username, String password){
    	JSONObject json = new JSONObject();
    	try{
            json.put("username", username);
            json.put("password", password);
            
        	postData = json;
        	operation = "login";
        	startConnection("api/users/log_in", "POST");			
    	}
    	catch(Exception ex){
    		//TODO
    	}	
	}
	
	public void signUp(String username, String email, String password){
    	JSONObject json = new JSONObject();
		JSONObject userData = new JSONObject();
		
    	try{
    		userData.put("username", username);
    		userData.put("email", email);
    		userData.put("password", password);
    		
    		json.put("user", userData);
            
        	postData = json;
        	operation = "signUp";
        	startConnection("api/users/sign_up", "POST");			
    	}
    	catch(Exception ex){
    		//TODO
    	}	
	}
    
    protected void onPostExecute(String result) {
    	try {      
           if(operation == "login"){
        	   if (Error != null) {
        		   //Error
        	   }
        	   else{
        		   postData = null;
                   //JSONObject jsonResponse = new JSONObject(response.getParams().toString());
                   
                   //Log.i("Login", jsonResponse.toString());
                   
                   userLoged = true;
                   
                   /*try {                          
                        jsonResponse = new JSONObject(response.getParams().toString());
                          
                        JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");
      
                        int lengthJsonArr = jsonMainNode.length();  
      
                        for(int i=0; i < lengthJsonArr; i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);                              
                            String name = jsonChildNode.optString("name").toString();                        
                       }
                   } 
                   catch (JSONException e) {              
                        e.printStackTrace();
                   }*/
                   
            	   mListener.onEvent();
        	   }
           }   
           if(operation == "signUp"){
        	   if (Error != null) {
        		   //Error
        	   }
        	   else{
        		   postData = null;
        		   //Log.i("Params", response.getParams().toString());
                   //JSONObject jsonResponse = new JSONObject(response.getParams().toString());
                   
                   //Log.i("SignUp", jsonResponse.toString());
                   
                   userLoged = true;
                   
                   /*try {                          
                        jsonResponse = new JSONObject(response.getParams().toString());
                          
                        JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");
      
                        int lengthJsonArr = jsonMainNode.length();  
      
                        for(int i=0; i < lengthJsonArr; i++) {
                            JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);                              
                            String name = jsonChildNode.optString("name").toString();                        
                       }
                   } 
                   catch (JSONException e) {              
                        e.printStackTrace();
                   }*/
                   
            	   mListener.onEvent();
        	   }
           }
    	}
    	catch (Exception e) {
    		Log.d("LoginWebService", e.getLocalizedMessage());
    	}
    }

}
