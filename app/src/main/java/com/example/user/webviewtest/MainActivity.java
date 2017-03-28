package com.example.user.webviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);



        webView.getSettings().setJavaScriptEnabled(true); //웹페이지에서 JavaScript 허용
        webView.getSettings().setBuiltInZoomControls(true); //줌 컨트롤 사용여부 지정
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); //JavaScript에서 윈도우를 새로 열 수 있는지 지정
        webView.getSettings().setLightTouchEnabled(true);
        webView.getSettings().setSavePassword(true); //폼 데이터 중 패스워드의 저장 여부를 설정
        webView.getSettings().setSaveFormData(true); //폼데이터의 저장 여부를 설정

        webView.setWebViewClient(new MyWebViewClient());

        webView.loadUrl("http://www.denple.com"); //웹뷰에 원하는 웹페이지를 로딩하기 위한 메소드
    }



    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
