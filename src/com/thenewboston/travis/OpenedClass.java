package com.thenewboston.travis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener, OnCheckedChangeListener {

	TextView question, test;
	Button returnData;
	RadioGroup selectionList;
	String gotBread, setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send);
		initialize();
//		Bundle gotBasket = getIntent().getExtras();
//		gotBread = gotBasket.getString("key");
//		question.setText(gotBread);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		question = (TextView) findViewById(R.id.tvQuestion);
		test = (TextView) findViewById(R.id.tvText);
		returnData = (Button) findViewById(R.id.bReturn);
		selectionList = (RadioGroup) findViewById(R.id.rgAnswers);
		returnData.setOnClickListener(this);
		selectionList.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rCrazy:
			setData = "Probably right!";
			break;
		
		case R.id.rSexy:
			setData = "Definitely right!";
			break;
		
		case R.id.rBoth:
			setData = "Spot Ont!";
			break;
		
		default:
			break;
		}
		test.setText(setData);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent person = new Intent();
		Bundle backpack = new Bundle();
		backpack.putString("answer", setData);
		person.putExtras(backpack);
		setResult(RESULT_OK, person);
		finish();
	}

}
