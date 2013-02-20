package com.panic.panic_button;

import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.app.Activity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;

public class PanicButton extends Activity {	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_button); 
        
        Log.v("-------------------", "EXECUTANDOOOOOO");
        
    }        
    
    
    
    public void BtPanicStart(View view) throws InterruptedException{
    	//Alert for click button
    	VibrateButton(50);
    	//Remove facebook account
    	/*FacebookRemove();
    	Thread.sleep(5000L);    	
    	VibrateButton(50);*/
    	//Remove twitter account
    	/*TwitterRemove();
    	Thread.sleep(5000L);*/
    	//Remove Whatsapp Account
    	WhatsappRemove();
    	Thread.sleep(8000L);
    	VibrateButton(1000);
    	//Finish Application
    	FinishApplication();
    }
    
    public void FacebookRemove(){
    	
    	String facebookType = "com.facebook.auth.login";     
    	String facebookChat = "com.sec.android.app.sns3.facebook";
        String accountType;
        
    	AccountManager accountManager = AccountManager.get(getApplicationContext());
		Account[] accounts = accountManager.getAccounts();                         
        
        for( int i = 0; i < accounts.length; i++){
        	accountType = accounts[i].type.toString();
        	if(accountType.equals(facebookType)){        		
        		Log.v("-------------------", accounts[i].name + " - " + accounts[i].type);
        		//clearPassword(accouns[i].name);
        		//Log.d("------------------", accountManager.removeAccount(accounts[i], null, null).toString());
        		accountManager.removeAccount(accounts[i], null, null);        		
        	}    
        	if(accountType.equals(facebookChat)){        		
        		Log.v("-------------------", accounts[i].name + " - " + accounts[i].type);
        		//clearPassword(accouns[i].name);
        		//Log.d("------------------", accountManager.removeAccount(accounts[i], null, null).toString());
        		accountManager.removeAccount(accounts[i], null, null);        		
        	}    
        }
    }
    
    public void TwitterRemove(){
    	
    	String twitterType = "com.twitter.android.auth.login";
    	String accountType;
    	
    	AccountManager accountManager = AccountManager.get(getApplicationContext());
		Account[] accounts = accountManager.getAccounts();                         
        
        for( int i = 0; i < accounts.length; i++){
        	accountType = accounts[i].type.toString();
        	if(accountType.equals(twitterType)){        		
        		Log.v("-------------------", accounts[i].name + " - " + accounts[i].type);
        		//clearPassword(accouns[i].name);
        		//Log.d("------------------", accountManager.removeAccount(accounts[i], null, null).toString());
        		accountManager.removeAccount(accounts[i], null, null);        		
        	}        	
        }
    }
    
    public void WhatsappRemove(){
    	TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
    	Log.v("-----------------------", tm.getDeviceId());
    	/*String whatsappType = "com.whatsapp";
    	String accountType;
    	
    	AccountManager accountManager = AccountManager.get(getApplicationContext());
		Account[] accounts = accountManager.getAccounts();                         
        
        for( int i = 0; i < accounts.length; i++){
        	accountType = accounts[i].type.toString();
        	//if(accountType.equals(whatsappType)){        		
        		Log.v("-------------------------------", accounts[i].name + " - " + accounts[i].type);
        		//clearPassword(accouns[i].name);
        		//Log.d("------------------", accountManager.removeAccount(accounts[i], null, null).toString());
        		//accountManager.removeAccount(accounts[i], null, null);        		
        	//}        	
        }*/
    }
    
    //public void InstagramRemove(){
    	
    //}
    
    public void VibrateButton(int time){
    	Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    	vibe.vibrate(time);
    }
    
    public void FinishApplication(){
    	this.finish();
    	System.exit(0);
    }
}
