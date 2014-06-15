package com.Widget.RandomNumber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SetRange extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.range);
	}
	
	public void Range (View v) {
	// find EditText
			EditText setRange = (EditText) findViewById(R.id.editText);
			
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
							"Your chose range from 1 to %d", Toast.LENGTH_SHORT).show();
					// Get range from edit text then make string then parse into long
					long mRange = Long.parseLong(setRange.getText().toString());
					
					Intent intent = new Intent(SetRange.this, WidgetService.class);
					intent.putExtra("range", mRange);
					Range(intent);
					
				}
			}catch (NumberFormatException e) {
				Toast.makeText(getApplicationContext(),
						"Please enter only one integer", Toast.LENGTH_SHORT).show();
			}
	}
}
