package com.ali.reminderapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/************************************************************************
 * the MainActivity will load when the application is started
 * @author Mazahir Clipwala
 *  @since Feb 18, 2015 
 ************************************************************************/
public class MainActivity extends ActionBarActivity {

	/************************************************************************
	 * the onCreate function gets called when the Activity is loaded
	 ************************************************************************/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/************************************************************************
	 * the onCreate function gets called when the Activity is loaded
	 ************************************************************************/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/************************************************************************
	 * the onCreate function gets called when the Activity is loaded
	 ************************************************************************/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/************************************************************************
	 * the doneAction event handler is called when the Done button widget is
	 * clicked. look at the activity_main.xml for the event handler definition
	 ************************************************************************/
	public void doneAction (View view) {
		
		/************************************************************************
		 * get a reference/handle to the "reminderET" and "reminderDateTimeET" 
		 * widget. look at the activity_main.xml for the widget definition
		 ************************************************************************/
		EditText reminderET = (EditText)findViewById (R.id.reminderET);
		EditText reminderDateTimeET = (EditText)findViewById (R.id.reminderDateTimeET);
		
		/************************************************************************
		 * use the "Log" to print debugging statements to the console.
		 ************************************************************************/
		Log.v ("MainActivity", reminderET.getText ().toString ());
		Log.v ("MainActivity", reminderDateTimeET.getText ().toString ());
		
		
		Intent displayReminderIntent = new Intent (getApplication (), DisplayReminder.class);
		
		displayReminderIntent.putExtra ("reminderET", reminderET.getText ().toString ());
		displayReminderIntent.putExtra ("reminderDateTimeET", reminderDateTimeET.getText ().toString ());
		
		startActivity (displayReminderIntent);
	}
}