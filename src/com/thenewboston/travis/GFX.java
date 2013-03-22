package com.thenewboston.travis;

import android.app.Activity;
import android.os.Bundle;

public class GFX extends Activity {

	MyBringBack ourView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ourView = new MyBringBack(this);
		setContentView(ourView);
	}

}
