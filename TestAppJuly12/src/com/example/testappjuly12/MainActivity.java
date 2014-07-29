package com.example.testappjuly12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.redsquirrelobserver.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button startButton = (Button) findViewById(R.id.start_button);
		startButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, ActivityStartObservation.class);
				startActivity(i);
			}
		});
		
		Button viewCompletedButton = (Button) findViewById(R.id.view_completed_button);
		viewCompletedButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, ActivityViewCompletedObservations.class);
				startActivity(i);
			}
		});
	}
}
