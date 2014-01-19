package com.radio.radioroks;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OnlineState extends Activity {
	WebView online;
	// final static String MOBILE_ROKS = "http://m.radioroks.com.ua/";

	final static String MOBILE_ROKS = "http://www.radioroks.com.ua/digiton/index/inline";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.online);
		online = (WebView) findViewById(R.id.webViewOnline);
		settingParamsForLayout();
		online.loadUrl(MOBILE_ROKS);

	}

	private void settingParamsForLayout() {
		online.getSettings().setBuiltInZoomControls(true);
		online.setFocusableInTouchMode(false);
		online.setFocusable(false);
		online.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return true;
			}
		});

		WebSettings settings = online.getSettings();
		settings.setDefaultTextEncodingName("utf-8");
	}
}
