package com.Widget.RandomNumber;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SetRange extends Activity {
	
	EditText setRange;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.range);
	}
	
	public void Range (View v) {
			// find EditText
			setRange = (EditText) findViewById(R.id.editText);
			
			//Creating string for empty edit text check
			String checkInput = setRange.getText().toString();
			try {
				// checking input
				if (checkInput.trim().equals("")) {
					Toast.makeText(getApplicationContext(),
							"Please enter integer for random number generator", Toast.LENGTH_SHORT).show();
				}
				else {
					Toast.makeText(getApplicationContext(),
							("Your chose range from 1 to " + checkInput), Toast.LENGTH_SHORT).show();
					// Get range from edit text then make string then parse into long
					long mRange = Long.parseLong(setRange.getText().toString());
//					// Create Intent
//					Intent intent = new Intent(SetRange.this, WidgetService.class);
//					intent.putExtra("range", mRange);
//					startService(intent);
					
				}
			}catch (NumberFormatException e) {
				Toast.makeText(getApplicationContext(),
						"Please enter only one integer", Toast.LENGTH_SHORT).show();
			}
//			// Declare and setup "Enter" button
//			Button enterButton = (Button) findViewById(R.id.setR);
//			enterButton.setOnClickListener(new OnClickListener() {
//
//				// Call enterClicked() when pressed
//
//				public void onClick(View v) {
//
//					enterClicked();
//
//				}
//			});
//	}
//			
//			// Sets result to send back to calling Activity and finishes
//
//			private void enterClicked() {
//
//
//				Intent editIntent = new Intent();
//				
//				editIntent.putExtra("key", setRange.getText().toString());
//
//				// TODO - Set Activity's result with result code RESULT_OK
//				setResult(RESULT_OK, editIntent);
//
//				// TODO - Finish the Activity
//				finish();
//
			}

}
