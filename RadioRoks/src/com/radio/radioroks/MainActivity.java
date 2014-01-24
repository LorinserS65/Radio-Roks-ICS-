package com.radio.radioroks;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
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
	static MediaPlayer mediaPlayer = new MediaPlayer();
	MainActivity.StreamingThread roksStationOnlineStream = new StreamingThread();
	// TODO start playing from local file instead
	static final String AUDIO = "http://online-radioroks.tavrmedia.ua:8000/RadioROKS";

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
		findViewById(R.id.buttonRecantlyPlayedSongsActivity)
				.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.buttonPlay:

			try {

				roksStationOnlineStream.execute(AUDIO);

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
		case R.id.buttonRecantlyPlayedSongsActivity:
			new RecentlyPlayedOnSite().execute();
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
		} else {
			return;
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

	// TODO
	public void sendMessage(View view) {

	}

	public class RecentlyPlayedOnSite extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			Intent intent = new Intent(MainActivity.this,
					RecentlyPlayedSongs.class);
			startActivity(intent);

			return null;

		}

	}

}
