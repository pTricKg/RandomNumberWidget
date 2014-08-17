package com.Widget.RandomNumber;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 * Simple widget gives Random Number
 * 
 * @author Patrick Gorman
 * @version Not Sure
 * Not even sure what is going on here.
 */

public class SetRange extends Activity {

	EditText setRange;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.range);

		// Intent firstIntent =
		// startActivityForResult(firstIntent, GET_TEXT_REQUEST_CODE);
	}

	public void Range(View v) {
		// find EditText
		setRange = (EditText) findViewById(R.id.editText);

		// Creating string for empty edit text check

		try {
			// checking input
			final String checkInput = setRange.getText().toString();
			if (checkInput.trim().equals("")) {
				Toast.makeText(getApplicationContext(),
						"Please enter integer for random number generator",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(),
						("Your chose range from 1 to " + checkInput),
						Toast.LENGTH_SHORT).show();
				// Get range from edit text then make string then parse into
				// long
				@SuppressWarnings("unused")
				long mRange = Long.parseLong(setRange.getText().toString());
				// // Create Intent
				// Intent intent = new Intent(SetRange.this,
				// WidgetService.class);
				// intent.putExtra("range", mRange);
				// startService(intent);

			}
		} catch (NumberFormatException e) {
			Toast.makeText(getApplicationContext(),
					"Please enter only one integer", Toast.LENGTH_SHORT).show();
		}
		// Declare and setup "Enter" button
		Button enterButton = (Button) findViewById(R.id.setR);
		enterButton.setOnClickListener(new OnClickListener() {

			// Call enterClicked() when pressed

			public void onClick(View v) {
				// Intent intent = new Intent(SetRange.this, WidgetService.class
				// );
				// //String message = setRange.getText().toString();
				// intent.putExtra( checkInput, 0);
				// sendBroadcast(intent);
				sendToWidget();

			}
		});
	}

	// Sets result to send back to calling Activity and finishes

	private void sendToWidget() {

		Toast toast = Toast.makeText(getApplicationContext(),
				"This is sendToWidget", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 25, 400);
		toast.show();

		Intent editIntent = new Intent(SetRange.this, WidgetService.class);

		editIntent.putExtra("key", setRange.getText().toString());// 
		sendBroadcast(editIntent);
		System.out.println("key");

		finish();
	}

}
