package com.example.testappjuly12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.redsquirrelobserver.R;

public class ActivityWalkTransect extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_walk_transect);
		
		final String siteName = getIntent().getStringExtra("siteName");
		
		Button squirrelButton = (Button) findViewById(R.id.walk_squirrel_button);
		squirrelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(ActivityWalkTransect.this, ActivitySquirrelSide.class );
				i.putExtra("siteName", siteName);
				startActivity(i);
			}
		});
		
		TextView tv = (TextView) findViewById(R.id.walk_squirrel_count);
		SquirrelSite ss = SquirrelSite.getSquirrelSite(siteName);
		
		tv.setText(String.valueOf(ss.getCount()));
	}
	
	public void onSubmit(View v) {
		this.finish();
	}
	
	@Override
	protected void onResume() {

	   super.onResume();
	   this.onCreate(null);
	}
	
}
