

package com.predictor.aviator.real;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
// Ajout de l'import pour le Pop-up
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        // Affichage du Pop-up dès l'ouverture de l'application
        showWelcomeDialog();

        this.webView = (WebView) findViewById(R.id.webview);
        this.webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed(); // Risque de sécurité maintenu selon ton code initial
            }
        });

        // Chargement de ton nouveau lien d'affiliation
        this.webView.loadUrl("https://joker9.lineorgs.com/");
        
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
    }

    // Fonction qui crée et affiche le message de bienvenue
    private void showWelcomeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("تنبيه هام");
        builder.setMessage("مرحبا بك في تطبيق الروبوت المهكر للعبة crash و apple of fortune. \n\n" +
                "تذكر أن الروبوت يشتغل فقط في تطبيق Linebet. اتبع الخطوات التالية ليشتغل معك الروبوت بشكل مجاني لمدة أسبوع: \n\n" +
                "1. قم بالتسجيل واستعمل كود برومو joker9 ليشتغل معك. \n" +
                "2. قم بشحن رصيدك في Linebet. \n" +
                "3. بعدها مباشرة ستعود للتطبيق لتجده مفعلاً أوتوماتيكياً لتستفيد من تعليماته في اختياراتك لتحصل على توقعات صحيحة في اللعبتين.");
        
        builder.setPositiveButton("فهمت", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}