package com.example.testappjuly12;

import com.example.redsquirrelobserver.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitySquirrelSide extends Activity{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_squirrel_side);
		
		final String siteName = getIntent().getStringExtra("siteName");
		
		Button leftSquirrelButton = (Button) findViewById(R.id.left_squirrel_button);
		leftSquirrelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SquirrelSite ss = SquirrelSite.getSquirrelSite(siteName);
				ss.addSquirrel();
				ss.save();
				finish();
			}
		});
		
		Button rightSquirrelButton = (Button) findViewById(R.id.right_squirrel_button);
		rightSquirrelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				SquirrelSite ss = SquirrelSite.getSquirrelSite(siteName);
				ss.addSquirrel();
				ss.save();
				finish();
			}
		});
		
		Button noSquirrelButton = (Button) findViewById(R.id.no_squirrel_button);
		noSquirrelButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	public void onSubmit(View v) {
		this.finish();
	}
}
