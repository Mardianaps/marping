package comww.example.android.utsmardiana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class webView extends AppCompatActivity {

    private WebView mWebView;
    private Button mOpenBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = findViewById(R.id.webbb);
        mWebView.loadUrl("https://www.google.com/");
    }
}
