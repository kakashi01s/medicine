package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.fragment

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.ads.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.utils.Constants
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.MainActivity
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.WebActivity
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter.CookingChannelsAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter.LiveNewsAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter.MostUsefulAppsAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.CookingItemClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.LiveNewsItemClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.MostUsefulAppsItemClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.viewmodel.ToolsViewModel
import kotlinx.android.synthetic.main.fragment_tools.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InvestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ToolsFragment : Fragment(), LiveNewsItemClickListener<List<String>>,
    MostUsefulAppsItemClickListener<List<String>>,CookingItemClickListener<List<String>> {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null

    var toolsViewModel: ToolsViewModel? = null

    var rvLiveNews: RecyclerView? = null
    var rvMostUsefulApps: RecyclerView? = null
    var rvCookingChannels: RecyclerView? = null

    var firebaseAnalytics: FirebaseAnalytics? = null
    var firebaseRemoteConfig: FirebaseRemoteConfig? = null
    var liveNewsAdapter: LiveNewsAdapter? = null
    var mostUsefulAppsAdapter: MostUsefulAppsAdapter? = null
    var cookingChannelsAdapter: CookingChannelsAdapter? = null
    private var nativeAdFB1: NativeAd? = null
    private var nativeAdFB2: NativeAd? = null
    private var nativeAdFB3: NativeAd? = null
    private var nativeAdLayout: NativeAdLayout? = null
    private var adView: LinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tools, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        setRecyclerView()

        toolsViewModel = ViewModelProvider(activity!!).get(ToolsViewModel::class.java)
        toolsViewModel?.loadData()

        toolsViewModel!!.currencyData.observe(this, Observer { t ->
            Log.d("NewsFrag", "NewsFragment Live $t")
            liveNewsAdapter?.setItems(t)
        })

        toolsViewModel!!.mostUsefulAppsData.observe(this, Observer { t ->
            Log.d("NewsFrag", "NewsFragment Most $t")
            mostUsefulAppsAdapter?.setItems(t)
        })

        toolsViewModel!!.cookingChannelsData.observe(this, Observer { t ->
            Log.d("NewsFrag", "NewsFragment Most $t")
           cookingChannelsAdapter?.setItems(t)
        })
        if (firebaseRemoteConfig!!.getBoolean(Constants().SHOW_ADS)) {
            onLoadFBNativeAd1(view, context!!)
            onLoadFBNativeAd2(view, context!!)
            onLoadFBNativeAd3(view, context!!)

        }


    }

    fun initViews(view: View){
        firebaseAnalytics = FirebaseAnalytics.getInstance(activity!!)
        rvLiveNews = view.findViewById(R.id.rvLiveNews)
        rvMostUsefulApps = view.findViewById(R.id.rvMostUsefulApps)
        rvCookingChannels = view.findViewById(R.id.rvCookingChannels)
    }

    fun setRecyclerView(){
        liveNewsAdapter = LiveNewsAdapter(context)
        liveNewsAdapter!!.setListener(this)
        rvLiveNews.apply {
            rvLiveNews?.layoutManager = GridLayoutManager(activity, 3)
            rvLiveNews?.adapter = liveNewsAdapter
        }

        mostUsefulAppsAdapter = MostUsefulAppsAdapter(context)
        mostUsefulAppsAdapter!!.setListener(this)
        rvMostUsefulApps.apply {
            rvMostUsefulApps?.layoutManager = GridLayoutManager(activity, 3)
            rvMostUsefulApps?.adapter = mostUsefulAppsAdapter
        }

        cookingChannelsAdapter = CookingChannelsAdapter(context)
        cookingChannelsAdapter!!.setListener(this)
        rvCookingChannels.apply {
            rvCookingChannels?.layoutManager = GridLayoutManager(activity, 3)
            rvCookingChannels?.adapter = cookingChannelsAdapter
        }
    }
    fun onLoadFBNativeAd1(view: View, context: Context) {
        nativeAdFB1 = NativeAd(context, Constants().getFbNativeTool1())
        val nativeAdListener: NativeAdListener = object : NativeAdListener {
            override fun onError(p0: Ad?, p1: AdError?) {
                Log.d("TAG", "onError: onLoadFBNativeAd1 " + p1!!.errorMessage)
            }

            override fun onAdLoaded(ad: Ad?) {

                // Race condition, load() called again before last ad was displayed
                if (nativeAdFB1 == null || nativeAdFB1 !== ad) {
                    return
                }
                // Inflate Native Ad into Container

                // Add the Ad view into the ad container.
                nativeAdLayout = view.findViewById(R.id.native_ad_container_tool_1)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                                R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB1!!, adView!!)

                val adChoicesContainer: LinearLayout = view.findViewById(R.id.ad_choices_container)
                val adOptionsView = AdOptionsView(context, nativeAdFB1, nativeAdLayout)
                adChoicesContainer.removeAllViews()
                adChoicesContainer.addView(adOptionsView, 0)
            }

            override fun onAdClicked(p0: Ad?) {
                Log.d("TAG", "onAdClicked: onLoadFBNativeAd1")
            }

            override fun onLoggingImpression(p0: Ad?) {
                Log.d("TAG", "onLoggingImpression: onLoadFBNativeAd1")
            }

            override fun onMediaDownloaded(p0: Ad?) {
                Log.d("TAG", "onMediaDownloaded: onLoadFBNativeAd1")
            }
        }

        nativeAdFB1!!.loadAd(
                nativeAdFB1!!.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build()
        );
    }

    fun onLoadFBNativeAd2(view: View,context: Context) {
        nativeAdFB2 = NativeAd(context, Constants().getFbNativeTool2())
        val nativeAdListener: NativeAdListener = object : NativeAdListener {
            override fun onError(p0: Ad?, p1: AdError?) {
                Log.d("TAG", "onError: onLoadFBNativeAd1 " + p1!!.errorMessage)
            }

            override fun onAdLoaded(ad: Ad?) {

                // Race condition, load() called again before last ad was displayed
                if (nativeAdFB2 == null || nativeAdFB2 !== ad) {
                    return
                }
                // Inflate Native Ad into Container

                // Add the Ad view into the ad container.
                nativeAdLayout = view.findViewById(R.id.native_ad_container_tool_2)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                                R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB2!!, adView!!)

                val adChoicesContainer: LinearLayout = view.findViewById(R.id.ad_choices_container)
                val adOptionsView = AdOptionsView(context, nativeAdFB2, nativeAdLayout)
                adChoicesContainer.removeAllViews()
                adChoicesContainer.addView(adOptionsView, 0)
            }

            override fun onAdClicked(p0: Ad?) {
                Log.d("TAG", "onAdClicked: onLoadFBNativeAd1")
            }

            override fun onLoggingImpression(p0: Ad?) {
                Log.d("TAG", "onLoggingImpression: onLoadFBNativeAd1")
            }

            override fun onMediaDownloaded(p0: Ad?) {
                Log.d("TAG", "onMediaDownloaded: onLoadFBNativeAd1")
            }
        }

        nativeAdFB2!!.loadAd(
                nativeAdFB2!!.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build()
        );
    }

    fun onLoadFBNativeAd3(view: View,context: Context) {
        nativeAdFB3 = NativeAd(context, Constants().getFbNativeTool3())
        val nativeAdListener: NativeAdListener = object : NativeAdListener {
            override fun onError(p0: Ad?, p1: AdError?) {
                Log.d("TAG", "onError: onLoadFBNativeAd1 " + p1!!.errorMessage)
            }

            override fun onAdLoaded(ad: Ad?) {

                // Race condition, load() called again before last ad was displayed
                if (nativeAdFB3 == null || nativeAdFB3 !== ad) {
                    return
                }
                // Inflate Native Ad into Container

                // Add the Ad view into the ad container.
                nativeAdLayout = view.findViewById(R.id.native_ad_container_tool_3)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                                R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB3!!, adView!!)

                val adChoicesContainer: LinearLayout = view.findViewById(R.id.ad_choices_container)
                val adOptionsView = AdOptionsView(context, nativeAdFB3, nativeAdLayout)
                adChoicesContainer.removeAllViews()
                adChoicesContainer.addView(adOptionsView, 0)
            }

            override fun onAdClicked(p0: Ad?) {
                Log.d("TAG", "onAdClicked: onLoadFBNativeAd1")
            }

            override fun onLoggingImpression(p0: Ad?) {
                Log.d("TAG", "onLoggingImpression: onLoadFBNativeAd1")
            }

            override fun onMediaDownloaded(p0: Ad?) {
                Log.d("TAG", "onMediaDownloaded: onLoadFBNativeAd1")
            }
        }

        nativeAdFB3!!.loadAd(
                nativeAdFB3!!.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build()
        );
    }

    private fun inflateAd(nativeAd: NativeAd, adView: LinearLayout) {
        nativeAd.unregisterView()

        // Add the AdOptionsView

        // Create native UI using the ad metadata.
        val nativeAdIcon: com.facebook.ads.MediaView = adView.findViewById(R.id.native_ad_icon)
        val nativeAdTitle: TextView = adView.findViewById(R.id.native_ad_title)
        val nativeAdMedia: com.facebook.ads.MediaView = adView.findViewById(R.id.native_ad_media)
        val nativeAdSocialContext: TextView = adView.findViewById(R.id.native_ad_social_context)
        val nativeAdBody: TextView = adView.findViewById(R.id.native_ad_body)
        val sponsoredLabel: TextView = adView.findViewById(R.id.native_ad_sponsored_label)
        val nativeAdCallToAction: Button = adView.findViewById(R.id.native_ad_call_to_action)

        // Set the Text.
        nativeAdTitle.text = nativeAd.advertiserName
        nativeAdBody.text = nativeAd.adBodyText
        nativeAdSocialContext.text = nativeAd.adSocialContext
        nativeAdCallToAction.visibility =
                if (nativeAd.hasCallToAction()) View.VISIBLE else View.INVISIBLE
        nativeAdCallToAction.text = nativeAd.adCallToAction
        sponsoredLabel.text = nativeAd.sponsoredTranslation

        // Create a list of clickable views
        val clickableViews: ArrayList<View> = ArrayList()
        clickableViews.add(nativeAdTitle)
        clickableViews.add(nativeAdCallToAction)

        // Register the Title and CTA button to listen for clicks.
        nativeAd.registerViewForInteraction(
                adView, nativeAdMedia, nativeAdIcon, clickableViews
        )
    }


    override fun onDestroy() {
        toolsViewModel?.reset()
        super.onDestroy()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InvestFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            ToolsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onLiveNewsCardClick(item: List<String>) {
        Log.d("TAG", "onLiveNewsCardClick: " + item.get(1))

        val bundle = Bundle()
        bundle.putString("title", item.get(1))
        bundle.putString("url", item.get(2))
        (activity as MainActivity?)!!.onUpdateLogEvent(bundle,"news_visited",true)

        val intent: Intent? = Intent(activity, WebActivity::class.java)
        intent?.putExtra("title", item.get(1))
        intent?.putExtra("url", item.get(2))
        startActivity(intent)
    }

    override fun onMostUsefulAppsCardClick(item: List<String>) {
        Log.d("TAG", "onMostUsefulAppsCardClick: " + item.get(1))
        try {
            val appStoreIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+item.get(2)))
            appStoreIntent.setPackage("com.android.vending")
            startActivity(appStoreIntent)
        } catch (exception: ActivityNotFoundException) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=fund.stock.share.market.money.stakeholder.finance.economy.live")
                )
            )
        }
    }

    override fun onCookingChannelsCardClick(item: List<String>) {
        val bundle = Bundle()
        bundle.putString("title", item.get(1))
        bundle.putString("url", item.get(2))
        (activity as MainActivity?)!!.onUpdateLogEvent(bundle,"cookingChannels",true)

        val intent: Intent? = Intent(activity, WebActivity::class.java)
        intent?.putExtra("title", item.get(1))
        intent?.putExtra("url", item.get(2))
        startActivity(intent)
    }

}