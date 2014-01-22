package com.radio.radioroks;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener {
	ImageButton buttonBack, buttonPlay, buttonForvard;
	MediaPlayer mediaPlayer;

	static final String AUDIO = "http://online-radioroks.tavrmedia.ua:8000/RadioROKS_32";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		removeActionBar();
		setContentView(R.layout.activity_main);
		initializationAndSettingListeners();

	}

	private void removeActionBar() {
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().hide();
	}

	private void initializationAndSettingListeners() {

		findViewById(R.id.buttonPlay).setOnClickListener(this);

		// Roks site
		// findViewById(R.id.buttonOfficialSite).setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonPlay:

			try {
				new StreamingThread().execute(AUDIO);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}

		/*
		 * case R.id.buttonOfficialSite: start new Intent with site params
		 */

	}

	private void resetMediaPlayer() {
		if (mediaPlayer != null) {
			try {
				mediaPlayer.release();
			} catch (Exception e) {

			}
		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mediaPlayer.release();
		finish();
	}

	public class StreamingThread extends AsyncTask<String, Integer, String>
			implements OnPreparedListener {

		@Override
		protected String doInBackground(String... params) {
			String s = params[0];

			mediaPlayer = new MediaPlayer();
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			try {
				mediaPlayer.setDataSource(s);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mediaPlayer.setOnPreparedListener(this);
			mediaPlayer.prepareAsync();

			return null;
		}

		@Override
		public void onPrepared(MediaPlayer mp) {
			mediaPlayer.start();
		}

	}
}
