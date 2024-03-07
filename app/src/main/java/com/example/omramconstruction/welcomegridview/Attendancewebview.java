package com.example.omramconstruction.welcomegridview;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import com.example.omramconstruction.R;

public class Attendancewebview extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendancewebview);

        textView=(TextView) findViewById(R.id.txt1);

        textView.setText(getIntent().getStringExtra("mytext"));


        WebView webView =(WebView) findViewById(R.id.webview);
        WebSettings webSettings= webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //javascript enabled
        webView.setWebChromeClient(new WebChromeClient()); //javascript popup will work
        webView.loadUrl(getIntent().getStringExtra(EXTRA_MESSAGE));

        // Force links and redirects to open in the WebView instead of in a browser
        webView.setWebViewClient(new WebViewClient());


        Button button=(Button)findViewById(R.id.btnclose);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}