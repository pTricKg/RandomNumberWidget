package com.Widget.RandomNumber;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 * Simple widget gives Random Number
 * 
 * @author Patrick G
 * @version Not Sure
 */

public class SetRange extends Activity {

	public static EditText mSetRange;
	public static EditText mSetRangeMin;
	public static int i = 10;
	public static int e = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.range);

		// find EditText
		mSetRange = (EditText) findViewById(R.id.editText);
		mSetRangeMin = (EditText) findViewById(R.id.editText2);

		// Declare and setup "Enter" button
		Button enterButton = (Button) findViewById(R.id.setR);
		enterButton.setOnClickListener(new OnClickListener() {
			// Call enterClicked() when pressed

			public void onClick(View v) {

				sendToWidget();
				

			}

		});

	}

	public int sendToWidget() {

		// Convert EditText to string then to Integer
		String value = mSetRange.getText().toString();
		i = Integer.parseInt(value);

		String value2 = mSetRangeMin.getText().toString();
		e = Integer.parseInt(value2);

		// check user input for min and max validity
		if (e >= i) {
			Toast toast2 = Toast.makeText(getApplicationContext(),
					"Minimum value must be less than Maximum value. Set widget values to default.", Toast.LENGTH_LONG);
			toast2.setGravity(Gravity.TOP, 25, 400);
			toast2.show();
			i = 10;
			e = 0;
			return i + e;
		} else {
			Toast toast = Toast.makeText(getApplicationContext(),
					"This is being sent to widget" + ": " + e + ", " + i, Toast.LENGTH_LONG);
			toast.setGravity(Gravity.TOP, 25, 400);
			toast.show();
			Log.d("info: ", mSetRange.getText().toString());
			return i + e;
		}

	}
}
