package com.thenewboston.travis;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity implements View.OnClickListener {

	Button chkCmd;
	ToggleButton passTog;
	EditText input;
	TextView display;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		baconAndEggs();
		passTog.setOnClickListener(this);		
		chkCmd.setOnClickListener(this);
	}

	private void baconAndEggs() {
		chkCmd = (Button) findViewById(R.id.bResults);
		passTog = (ToggleButton) findViewById(R.id.tbPassword);
		input = (EditText) findViewById(R.id.etCommands);
		display = (TextView) findViewById(R.id.tvResults);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bResults:
			if (passTog.isChecked()) {
				input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			} else {
				input.setInputType(InputType.TYPE_CLASS_TEXT);
			}			
			break;
			
		case R.id.tbPassword:
			String check = input.getText().toString();
			display.setText(check);
			if (check.contentEquals("left")) {
				display.setGravity(Gravity.LEFT);
			} else if (check.contentEquals("center")) {
				display.setGravity(Gravity.CENTER);
			} else if (check.contentEquals("right")) {
				display.setGravity(Gravity.RIGHT);
			} else if (check.contentEquals("blue")) {
				display.setTextColor(Color.BLUE);
			} else if (check.contains("WTF")) {
				Random crazy = new Random();
				display.setText("WTF!!!");
				display.setTextSize(crazy.nextInt(75));
				display.setTextColor(Color.rgb(crazy.nextInt(265), crazy.nextInt(265), crazy.nextInt(265)));
				switch (crazy.nextInt(3)) { //random results: 0/1/2
				case 0:
					display.setGravity(Gravity.LEFT);
					break;
				case 1:
					display.setGravity(Gravity.CENTER);
					break;
				case 2:
					display.setGravity(Gravity.RIGHT);
					break;
				}
			} else {
				display.setText("invalid");
				display.setGravity(Gravity.CENTER);
				display.setTextColor(Color.WHITE);
			}			
			break;

		default:
			break;
		}
		
	}
	
}
