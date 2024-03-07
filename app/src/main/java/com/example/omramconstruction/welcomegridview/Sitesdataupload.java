package com.example.omramconstruction.welcomegridview;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omramconstruction.R;
import com.example.omramconstruction.WelcomeActivity;

import im.delight.android.webview.AdvancedWebView;

public class Sitesdataupload extends AppCompatActivity implements AdvancedWebView.Listener{
        private static final int INPUT_FILE_REQUEST_CODE = 1;
        SharedPreferences sharedPreferences;
        Context context;
        Button button;

        private static final int FILECHOOSER_RESULTCODE = 1;
        private static final String TAG = WelcomeActivity.class.getSimpleName();

        final static String myBlogAddr = "http://rajatconstructor.rf.gd/sites/addsites/sitesphoto/";
        String myUrl;
        private WebSettings webSettings;
        private ValueCallback<Uri> mUploadMessage;
        private Uri mCapturedImageURI = null;
        private ValueCallback<Uri[]> mFilePathCallback;
        private String mCameraPhotoPath;

        TextView  textView;

        String[] listitem;
        boolean[] checItems;
        private AdvancedWebView mWebView;

        private static final String TEST_PAGE_URL = "http://rajatconstructor.rf.gd/sites/addsites/addsites.php";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sitesdataupload);

            textView=(TextView) findViewById(R.id.txt1);
            textView.setText(getIntent().getStringExtra("mytext"));

            button=(Button)findViewById(R.id.btnclose);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Loading",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Sitesdataupload.this,WelcomeActivity.class));
                }
            });

            context=getApplicationContext();
            sharedPreferences=context.getSharedPreferences("MYPREF",MODE_PRIVATE);
            String tid=sharedPreferences.getString("id",null);

            mWebView = (AdvancedWebView) findViewById(R.id.webview);
            mWebView.setListener(this, this);
            mWebView.setGeolocationEnabled(false);
            mWebView.setMixedContentAllowed(false);
            mWebView.setCookiesEnabled(true);
            mWebView.setThirdPartyCookiesEnabled(true);
            mWebView.setWebViewClient(new WebViewClient() {

                @Override
                public void onPageFinished(WebView view, String url) {
                    Toast.makeText(Sitesdataupload.this, "Finished loading", Toast.LENGTH_SHORT).show();
                }

            });
            mWebView.setWebChromeClient(new WebChromeClient() {

                @Override
                public void onReceivedTitle(WebView view, String title) {
                    super.onReceivedTitle(view, title);
                    Toast.makeText(Sitesdataupload.this, title, Toast.LENGTH_SHORT).show();
                }

            });
            mWebView.addHttpHeader("X-Requested-With", "");
            mWebView.loadUrl(TEST_PAGE_URL);
        }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
        // ... my code ....

    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) { return; }
        // ...
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        mWebView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onPageFinished(String url) {
        mWebView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
        Toast.makeText(Sitesdataupload.this, "onPageError(errorCode = "+errorCode+",  description = "+description+",  failingUrl = "+failingUrl+")", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
        Toast.makeText(Sitesdataupload.this, "onDownloadRequested(url = "+url+",  suggestedFilename = "+suggestedFilename+",  mimeType = "+mimeType+",  contentLength = "+contentLength+",  contentDisposition = "+contentDisposition+",  userAgent = "+userAgent+")", Toast.LENGTH_LONG).show();

		/*if (AdvancedWebView.handleDownload(this, url, suggestedFilename)) {
			// download successfully handled
		}
		else {
			// download couldn't be handled because user has disabled download manager app on the device
		}*/
    }

    @Override
    public void onExternalPageRequest(String url) {
        Toast.makeText(Sitesdataupload.this, "onExternalPageRequest(url = "+url+")", Toast.LENGTH_SHORT).show();
    }

}
