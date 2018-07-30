package com.Widget.RandomNumber;




import android.app.Activity;
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
 * Not even sure what is going on here. This is
 * working.
 */

public class SetRange extends Activity {

	EditText setRange;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.range);

		// find EditText
		setRange = (EditText) findViewById(R.id.editText);
		
		

		// Declare and setup "Enter" button
		Button enterButton = (Button) findViewById(R.id.setR);
		enterButton.setOnClickListener(new OnClickListener() {

			// Call enterClicked() when pressed

			public void onClick(View v) {

				sendToWidget();
				

			}
		});
	}

	public void sendToWidget() {

		Toast toast = Toast.makeText(getApplicationContext(),
				"This is sendToWidget", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.TOP, 25, 400);
		toast.show();
	}

	public void setRange(Intent intent) {
		// TODO Auto-generated method stub
		// Get edit text then make string then parse
		int input = Integer.parseInt(setRange.getText().toString());
		// Create Intent
		intent = new Intent(SetRange.this, WidgetService.class);
		intent.putExtra("upper limit", input);
		setRange(intent);
		
	}

}
