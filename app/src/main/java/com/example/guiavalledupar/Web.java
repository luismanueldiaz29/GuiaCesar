package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {

    private WebView Web;
    private String Url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        AddBusqueda();
    }

    private void AddBusqueda(){
        Url = getIntent().getStringExtra("url");
        if(Url != null && Url != "") {
            SetUrl();
        }
    }

    private void SetUrl() {
        Web = (WebView) findViewById(R.id.Web);
        Web.getSettings().setJavaScriptEnabled(true);
        Web.setWebViewClient(new WebViewClient());
        Web.loadUrl(Url);
    }
}
