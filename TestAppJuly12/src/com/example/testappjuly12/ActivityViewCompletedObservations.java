package com.example.testappjuly12;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.example.redsquirrelobserver.R;

public class ActivityViewCompletedObservations extends ListActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		List<SquirrelSite> sites = SquirrelSite.getSiteList();
		String[] arrayOfStuff = new String[sites.size()];
		int index = 0;
		for (Object value : sites) {
			arrayOfStuff[index] = String.valueOf(value);
			index++;
		}
				
		//Bind array to ListAdapter
	    this.setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_view_completed_observations, R.id.list_item, arrayOfStuff));

	}

	public void onSubmit(View v) {
		this.finish();
	}
}
