package com.example.testappjuly12;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.redsquirrelobserver.R;

public class ActivityStartObservation extends Activity {
	
	Handler handler;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_observation);
		
		Button startObservationButton = (Button) findViewById(R.id.start_observation_start_button);
		startObservationButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				EditText siteName = (EditText) findViewById(R.id.site_name);
				String siteValue = siteName.getText().toString();
				
				EditText siteDistance = (EditText) findViewById(R.id.site_length);
				int distValue;
				if (siteDistance.length() > 0) {
					distValue = Integer.parseInt(siteDistance.getText().toString());
				} else {
					distValue = 0;
				}
				
				List<SquirrelSite> sites = SquirrelSite.getSiteList();
				boolean foundName = false;
				for (SquirrelSite ss : sites) {
					if (ss.siteName.equals(siteValue)) {
						foundName = true;
						return;
					}
				}
				Intent i = new Intent(ActivityStartObservation.this, ActivityWalkTransect.class);
				if (foundName) {
					
					showToast("Site name taken");
					
					//Toast.makeText(getBaseContext(), "FB pressed", Toast.LENGTH_LONG).show();
					
					/*
					Toast theToast = Toast.makeText(ActivityStartObservation.this, "Site name already in use, please choose another.", Toast.LENGTH_SHORT);
					theToast.setGravity(Gravity.CENTER, 0, 0);
					theToast.show();
					/*
					new Thread() {
			            @Override
			            public void run() {
			                Toast.makeText(getApplicationContext(), "Application crashed", Toast.LENGTH_LONG).show();
			            }
			        }.start();
			        /*
					ActivityStartObservation.this.runOnUiThread(new Runnable() {

				        public void run() {
				            Toast.makeText(ActivityStartObservation.this, "Site name already in use, please choose another.", Toast.LENGTH_SHORT).show();
				        }
				    });
				    */
				} else {
					
					SquirrelSite thisSite = new SquirrelSite();
					thisSite.siteName = siteValue;
					thisSite.siteDistance = distValue;
					thisSite.squirrelCount = 0;
					thisSite.save();
					
					showToast("Site created.");
					
					i.putExtra("siteName", siteValue);
					startActivity(i);
				}
			}
		});
	}
	public void onSubmit(View v) {
		this.finish();
	}
	
	public void showToast(final String toast)
	{
	    runOnUiThread(new Runnable() {
	        public void run()
	        {
	            Toast theToast = Toast.makeText(ActivityStartObservation.this, toast, Toast.LENGTH_SHORT);
	            theToast.setGravity(Gravity.CENTER, 0, 0);
	            theToast.show();
	        }
	    });
	}
}
