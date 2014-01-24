package com.radio.radioroks;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RecentlyPlayedSongs extends Activity {
	WebView online;
	// final static String MOBILE_ROKS = "http://m.radioroks.com.ua/";

	final static String MOBILE_ROKS = "http://www.radioroks.com.ua/digiton/index/inline";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.online);

		settingParamsForLayout();
		online.loadUrl(MOBILE_ROKS);

	}

	private void settingParamsForLayout() {
		online = (WebView) findViewById(R.id.webViewOnline);
		online.getSettings().setBuiltInZoomControls(true);
		online.setFocusableInTouchMode(false);
		online.setFocusable(false);
		online.setBackgroundColor(Color.TRANSPARENT);
		online.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return true;
			}
		});

		WebSettings settings = online.getSettings();
		settings.setDefaultTextEncodingName("utf-8");
		settings.setDefaultFontSize(20);
	}

}
