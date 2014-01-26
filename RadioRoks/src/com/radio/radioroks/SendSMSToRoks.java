package com.radio.radioroks;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

public class SendSMSToRoks extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_sms_to_studio);

	}

	class sendSMSToStudioThread extends AsyncTask<Void, Void, Void> {

		//TODO
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
