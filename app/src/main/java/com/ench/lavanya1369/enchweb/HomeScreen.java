package com.ench.lavanya1369.enchweb;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HomeScreen extends AppCompatActivity {
    public WebView mWebView;
    ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        String data2 = getIntent().getExtras().getString("link");
        String data3 = getIntent().getExtras().getString("domain");
        mProgress = ProgressDialog.show(this, "Loading", "Please wait for a moment...");;
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings = mWebView.getSettings();
        /*progressBar = (ProgressBar) findViewById(R.id.progressBar1)*/;
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient());

        mWebView.setWebViewClient(new WebViewClient() {
            // load url
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            // when finish loading page
            public void onPageFinished(WebView view, String url) {
                if(mProgress.isShowing()) {
                    mProgress.dismiss();
                }
            }
        });


        mWebView.loadUrl("https://www."+data2+data3+"/");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
