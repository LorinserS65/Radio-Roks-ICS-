package com.radio.radioroks;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OnlineState extends Activity {
	WebView online;
	final static String MOBILE_ROKS = "http://m.radioroks.com.ua/";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.online);
		online = (WebView) findViewById(R.id.webViewOnline);
		online.getSettings().setBuiltInZoomControls(true);
		online.setFocusableInTouchMode(false);
		online.setFocusable(false);

		online.loadUrl(MOBILE_ROKS);
		online.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return true;
			}
		});

	}
}
