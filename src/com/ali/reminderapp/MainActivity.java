package com.ali.reminderapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/************************************************************************
 * the MainActivity will load when the application is started
 * @author Mazahir Clipwala
 *  @since Feb 18, 2015 
 ************************************************************************/
public class MainActivity extends ActionBarActivity {
	
	private static EditText reminderET,
							reminderDateTimeET;

	/************************************************************************
	 * the onCreate function gets called when the Activity is loaded
	 ************************************************************************/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/* set the contents view to the activity_main.xml*/
		setContentView(R.layout.activity_main);
		
		/* get a reference/handle to the "reminderET" and "reminderDateTimeET" 
		 * widget. look at the activity_main.xml for the widget definition */		
		reminderET = (EditText)findViewById (R.id.reminderET);
		reminderDateTimeET = (EditText)findViewById (R.id.reminderDateTimeET);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat ("dd MMM yyyy HH:mm:ss");
		String reminderDateTime = dateFormat.format (new Date ());
		reminderDateTimeET.setText (reminderDateTime);
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
		/* use the "Log" to print debugging statements to the console.*/
		/*Log.v ("MainActivity", reminderET.getText ().toString ());
		Log.v ("MainActivity", reminderDateTimeET.getText ().toString ());
*/		
		//showAlertDialog ();
		
		/* use the Intent to start an Activity
		 * and use the Intent to pass in data to another Activity */
		Intent showReminderIntent = new Intent (getApplication (), ShowReminderActivity.class);
		
		showReminderIntent.putExtra ("reminderET", reminderET.getText ().toString ());
		showReminderIntent.putExtra ("reminderDateTimeET", reminderDateTimeET.getText ().toString ());
		
		startActivity (showReminderIntent);
	}
	
	/************************************************************************
	 * the method will display the Alert Dialog to the user showing the
	 * reminder and the date and time
	 ************************************************************************/
	private void showAlertDialog () {
		String reminder = reminderET.getText ().toString ();
		String reminderDateTime = reminderDateTimeET.getText ().toString ();
		
		/* build the alert dialog by setting its: Title, Message & Button */
		AlertDialog.Builder alertBuilder = new AlertDialog.Builder (this);
		alertBuilder.setTitle ("Reminder");
		alertBuilder.setMessage (reminder + "\n" + reminderDateTime);
		alertBuilder.setPositiveButton("OK", null);
		
		/* create the dialog and show it */
		AlertDialog alertDialog = alertBuilder.create ();
		alertDialog.show ();
	}
}