package com.heyl.chemicalanalysis;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.heyl.chemicalanalysis.base.BaseActivity;

/**
 * Created by heyl on 2016/12/4.
 */

public class ContentActivity  extends BaseActivity{

    private WebView webview;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_content);
        webview = (WebView) findViewById(R.id.webview);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        // 添加js交互接口类，并起别名 imagelistener
        // webview.addJavascriptInterface(new MyJavascriptInterface(this), "imagelistner");
        webview.addJavascriptInterface(new MyJavascriptInterface(this), "imagelistener");
        webview.setWebViewClient(new MyWebViewClient());
        webview.loadUrl(" file:///android_asset/solid_analysis/2.html");

    }

    // 注入js函数监听
    private void addImageClickListner() {
        // 这段js函数的功能就是，遍历所有的img几点，并添加onclick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
        String script = "javascript:(function(){" + "var objs = document.getElementsByTagName(\"img\"); " + "for(var i=0;i<objs.length;i++)  " + "{" + "objs[i].onclick=function()  " + " {  " + " window.imagelistener.openImage(this.src);  " + " }" + "}" + "})()";
        webview.loadUrl(script);

    }

    // js通信接口
    public class MyJavascriptInterface {

        private Context context;

        public MyJavascriptInterface(Context context) {
            this.context = context;
        }

        @JavascriptInterface
        public void openImage(String img) {
            Toast.makeText(context, img + "", Toast.LENGTH_SHORT).show();
            Log.e("img", img + "");
            //
//            Intent intent = new Intent();
//            intent.putExtra("image", img);
//            intent.setClass(context, ShowWebImageActivity.class);
//            context.startActivity(intent);
//            System.out.println(img);
        }
    }

    // 监听
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            view.getSettings().setJavaScriptEnabled(true);

            super.onPageFinished(view, url);
            // html加载完成之后，添加监听图片的点击js函数
            addImageClickListner();

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            view.getSettings().setJavaScriptEnabled(true);

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            super.onReceivedError(view, errorCode, description, failingUrl);

        }
    }
}
