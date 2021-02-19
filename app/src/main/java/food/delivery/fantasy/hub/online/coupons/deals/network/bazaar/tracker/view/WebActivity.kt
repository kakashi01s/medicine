package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.facebook.ads.*
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.utils.Constants
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : AppCompatActivity() {

    var webView: WebView? = null
    var appTitle: String? = null
    var appUrl: String? = null
    var appIcon: String? = null

    var rlWebSplash: RelativeLayout? = null
    var ivAppIcon: ImageView? = null

    private val TAG: String = WebActivity::class.java.simpleName

    private var interstitialFbAd: com.facebook.ads.InterstitialAd? = null
    private var adView: AdView? = null
    lateinit var fullscreenView: View

    var firebaseRemoteConfig: FirebaseRemoteConfig? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        initViews()
        initData()

        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

        if(firebaseRemoteConfig!!.getBoolean(Constants().SHOW_ADS)){

            onFbBannerAds()
            onLoadFbInterstitial()
        }
        loadWebSplash()

        webViewSettings()

        webView?.loadUrl(appUrl)

    }

    fun initViews(){
        webView = findViewById(R.id.webViewMain)
        rlWebSplash = findViewById(R.id.rlWebSplash)
        ivAppIcon = findViewById(R.id.ivAppIcon)
    }

    fun initData(){
        val bundle: Bundle? = intent.extras
        appUrl = bundle?.getString("url")
        appIcon = bundle?.getString("app_icon")
        Log.d("TAG", "initData: " + bundle?.getString("url"))

    }

    fun webViewSettings(){
        webView!!.settings.loadsImagesAutomatically = true
        webView!!.settings.javaScriptEnabled = true
        webView!!.settings.allowContentAccess = true

        webView!!.settings.useWideViewPort = true
        webView!!.settings.loadWithOverviewMode = true
        webView!!.settings.domStorageEnabled = true
        webView!!.clearView()
        webView!!.isHorizontalScrollBarEnabled = false
        webView!!.settings.setAppCacheEnabled(true)
        webView!!.settings.databaseEnabled = true
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            webView!!.settings.databasePath = "/data/data/" + this.packageName + "/databases/"
        }
        webView!!.isVerticalScrollBarEnabled = false
        webView!!.settings.builtInZoomControls = true
        webView!!.settings.displayZoomControls = false
        webView!!.settings.allowFileAccess = true
        webView!!.settings.pluginState = WebSettings.PluginState.OFF
        webView!!.isScrollbarFadingEnabled = false
        webView!!.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webView!!.settings.defaultZoom = WebSettings.ZoomDensity.FAR
        webView!!.webViewClient = WebViewClient()
        webView!!.settings.setRenderPriority(WebSettings.RenderPriority.HIGH)
        webView!!.setInitialScale(1)

        webView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
            ): Boolean {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.url.toString())
                }
                return false
            }
        }

        webView!!.webChromeClient = object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if(newProgress >= 80){
                    rlWebSplash!!.visibility = View.GONE
                }
            }

            override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
                super.onShowCustomView(view, callback)

                if (view is FrameLayout){

                    fullscreenView = view
                    fullScreenContainer.addView(fullscreenView)
                    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                    fullScreenContainer.visibility = View.VISIBLE
                    mainContainer.visibility = View.GONE

                }
            }

            override fun onHideCustomView() {
                super.onHideCustomView()
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                fullScreenContainer.removeView(fullscreenView)
                fullScreenContainer.visibility = View.GONE
                mainContainer.visibility = View.VISIBLE
            }
        }
    }

    fun loadWebSplash(){
        Glide.with(ivAppIcon!!.context)
                .load(appIcon)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(ivAppIcon!!)
    }

    fun onLoadFbInterstitial() {
        interstitialFbAd = InterstitialAd(this, Constants().getFbInterstitialWebExit())

        val interstitialAdListener: InterstitialAdListener = object : InterstitialAdListener {
            override fun onInterstitialDisplayed(ad: Ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.")
            }

            override fun onInterstitialDismissed(ad: Ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.")
                finish()
            }

            override fun onError(ad: Ad?, adError: AdError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage())
            }

            override fun onAdLoaded(ad: Ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!")
                // Show the ad
//                interstitialFbAd.show()
            }

            override fun onAdClicked(ad: Ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!")
            }
        }

        interstitialFbAd!!.loadAd(interstitialFbAd!!.buildLoadAdConfig()
                .withAdListener(interstitialAdListener)
                .build());

    }

    fun onFbBannerAds() {
        adView = AdView(this, Constants().getFbBannerWeb(), AdSize.BANNER_HEIGHT_50)

        // Find the Ad Container
        val adContainer = findViewById<View>(R.id.banner_container) as LinearLayout

        // Add the ad view to your activity layout
        adContainer.addView(adView)

        val adListenerBanner: com.facebook.ads.AdListener = object : com.facebook.ads.AdListener {
            override fun onError(ad: Ad?, adError: AdError) {
                // Ad error callback
            }

            override fun onAdLoaded(ad: Ad?) {
                Log.d(TAG, "onAdLoaded: Banner")
            }

            override fun onAdClicked(ad: Ad?) {
                // Ad clicked callback
            }

            override fun onLoggingImpression(ad: Ad?) {
                // Ad impression logged callback
            }
        }

        // Request an ad
        adView!!.loadAd(adView!!.buildLoadAdConfig().withAdListener(adListenerBanner).build())
    }

    public override fun onPause() {
//        adView.pause()
        super.onPause()
    }

    // Called when returning to the activity
    public override fun onResume() {
        super.onResume()
//        adView.resume()
    }

    // Called before the activity is destroyed
    public override fun onDestroy() {
        if(adView!=null){
            adView!!.destroy()
        }
        super.onDestroy()
    }

    override fun onBackPressed() {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        }
        else{
            if (interstitialFbAd!=null && interstitialFbAd!!.isAdLoaded) {
                if (interstitialFbAd!!.isAdInvalidated) {
                    super.onBackPressed()
                } else {
                    interstitialFbAd!!.show()
                }
            } else {
                super.onBackPressed()
            }
        }
    }
}