package food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.fragment

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.ads.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.base.BaseFragment
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.utils.Constants
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.MainActivity
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.WebActivity
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.adapter.CategoryStoresAdapter
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.listener.CategoryStoresItemClickListener
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.viewmodel.CategoryViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoryFragment : BaseFragment(), CategoryStoresItemClickListener<List<String>> {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null

    var rvCategoryStores: RecyclerView? = null
    var categoryStoresAdapter: CategoryStoresAdapter? = null
    var categoryViewModel: CategoryViewModel? = null

    var firebaseRemoteConfig: FirebaseRemoteConfig? = null
    var firebaseAnalytics: FirebaseAnalytics? = null
    private var nativeAdFB1: NativeAd? = null
    private var nativeAdFB2: NativeAd? = null
    private var nativeAdFB3: NativeAd? = null
    private var nativeAdFB4: NativeAd? = null

    private var nativeAdLayout: NativeAdLayout? = null
    private var adView: LinearLayout? = null
    var llIndia: LinearLayout? = null
    var llUsa: LinearLayout? = null
    var llRussia: LinearLayout? = null
    var llPakistan: LinearLayout? = null
    var llChina: LinearLayout? = null
    var llGermany: LinearLayout? = null
    var llTurkey: LinearLayout? = null
    var llUae: LinearLayout? = null
    var llItaly: LinearLayout? = null
    var llSwitzerland: LinearLayout? = null
    var llCanada: LinearLayout? = null
    var llSingapore: LinearLayout? = null
    var llSouthAfrica: LinearLayout? = null
    var llFrance: LinearLayout? = null
    var llIndonesia: LinearLayout? = null
    var llUk: LinearLayout? = null
    var llJapan: LinearLayout? = null
    var llBrazil: LinearLayout? = null
    var llNigeria: LinearLayout? = null
    var llPortugal: LinearLayout? = null
    var llAustralia: LinearLayout? = null
    var llGreece: LinearLayout? = null


    var indiaList: ArrayList<List<String>>? = ArrayList()
    var usaList: ArrayList<List<String>>? = ArrayList()
    var russiaList: ArrayList<List<String>>? = ArrayList()
    var pakistanList: ArrayList<List<String>>? = ArrayList()
    var chinaList: ArrayList<List<String>>? = ArrayList()
    var germanyList: ArrayList<List<String>>? = ArrayList()
    var turkeyList: ArrayList<List<String>>? = ArrayList()
    var uaeList: ArrayList<List<String>>? = ArrayList()
    var italyList: ArrayList<List<String>>? = ArrayList()
    var switzerlandList: ArrayList<List<String>>? = ArrayList()
    var canadaList: ArrayList<List<String>>? = ArrayList()
    var singaporeList: ArrayList<List<String>>? = ArrayList()
    var southAfricaList: ArrayList<List<String>>? = ArrayList()
    var franceList: ArrayList<List<String>>? = ArrayList()
    var indonesiaList: ArrayList<List<String>>? = ArrayList()
    var ukList: ArrayList<List<String>>? = ArrayList()
    var japanList: ArrayList<List<String>>? = ArrayList()
    var brazilList: ArrayList<List<String>>? = ArrayList()
    var nigeriaList: ArrayList<List<String>>? = ArrayList()
    var portugalList: ArrayList<List<String>>? = ArrayList()
    var australiaList: ArrayList<List<String>>? = ArrayList()
    var greeceList: ArrayList<List<String>>? = ArrayList()


    var dialog: Dialog? = null

    override val bindingVariable: Int
        get() = 0
    override val layoutId: Int
        get() = 0

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
        return inflater.inflate(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)

        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

        dialog = Dialog(context!!)

        categoryViewModel = ViewModelProvider(activity!!).get(CategoryViewModel::class.java)
        categoryViewModel?.loadData()

        categoryViewModel!!.indiaLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: indiaLiveData $t")
            indiaList!!.addAll(t!!)
        })

        categoryViewModel!!.usaLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: usaLiveData $t")
            usaList!!.addAll(t!!)
        })
        categoryViewModel!!.russiaLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: russiaLiveData $t")
            russiaList!!.addAll(t!!)
        })

        categoryViewModel!!.pakistanLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: pakistanLiveData $t")
            pakistanList!!.addAll(t!!)
        })
        categoryViewModel!!.chinaLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: chinaLiveData $t")
            chinaList!!.addAll(t!!)
        })

        categoryViewModel!!.germanyLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: germanyLiveData $t")
            germanyList!!.addAll(t!!)
        })
        categoryViewModel!!.turkeyLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: turkeyLiveData $t")
            turkeyList!!.addAll(t!!)
        })

        categoryViewModel!!.uaeLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: uaeLiveData $t")
                uaeList!!.addAll(t!!)
        })
        categoryViewModel!!.italyLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: italyLiveData $t")
            italyList!!.addAll(t!!)
        })

        categoryViewModel!!.switzerlandLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: switzerlandLiveData $t")
            switzerlandList!!.addAll(t!!)
        })
        categoryViewModel!!.canadaLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: canadaLiveData $t")
            canadaList!!.addAll(t!!)
        })

        categoryViewModel!!.singaporeLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: singaporeLiveData $t")
            singaporeList!!.addAll(t!!)
        })

        categoryViewModel!!.southAfricaLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: southAfricaLiveData $t")
            southAfricaList!!.addAll(t!!)
        })

        categoryViewModel!!.franceLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: franceLiveData $t")
            franceList!!.addAll(t!!)
        })

        categoryViewModel!!.indonesiaLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: indonesiaLiveData $t")
            indonesiaList!!.addAll(t!!)
        })

        categoryViewModel!!.ukLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: ukLiveData $t")
            ukList!!.addAll(t!!)
        })

        categoryViewModel!!.japanLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: japanLiveData $t")
            japanList!!.addAll(t!!)
        })

        categoryViewModel!!.brazilLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: brazilLiveData $t")
            brazilList!!.addAll(t!!)
        })

        categoryViewModel!!.nigeriaLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: nigeriaLiveData $t")
            nigeriaList!!.addAll(t!!)
        })

        categoryViewModel!!.portugalLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: portugalLiveData $t")
            portugalList!!.addAll(t!!)
        })

        categoryViewModel!!.australiaLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: australiaLiveData $t")
            australiaList!!.addAll(t!!)
        })

        categoryViewModel!!.greeceLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: greeceLiveData $t")
            greeceList!!.addAll(t!!)
        })

        llIndia!!.setOnClickListener {
            onShowStores(indiaList!!,view)
        }
        llUsa!!.setOnClickListener {
            onShowStores(usaList!!,view)
        }
        llRussia!!.setOnClickListener {
            onShowStores(russiaList!!,view)
        }
        llPakistan!!.setOnClickListener {
            onShowStores(pakistanList!!,view)
        }
        llChina!!.setOnClickListener {
            onShowStores(chinaList!!,view)
        }
        llGermany!!.setOnClickListener {
            onShowStores(germanyList!!,view)
        }
        llTurkey!!.setOnClickListener {
            onShowStores(turkeyList!!,view)
        }
        llUae!!.setOnClickListener {
            onShowStores(uaeList!!,view)
        }
        llItaly!!.setOnClickListener {
            onShowStores(italyList!!,view)
        }
        llSwitzerland!!.setOnClickListener {
            onShowStores(switzerlandList!!,view)
        }
        llCanada!!.setOnClickListener {
            onShowStores(canadaList!!,view)
        }
        llSingapore!!.setOnClickListener {
            onShowStores(singaporeList!!,view)
        }
        llSouthAfrica!!.setOnClickListener {
            onShowStores(southAfricaList!!,view)
        }
        llFrance!!.setOnClickListener {
            onShowStores(franceList!!,view)
        }
        llIndonesia!!.setOnClickListener {
            onShowStores(indonesiaList!!,view)
        }
        llUk!!.setOnClickListener {
            onShowStores(ukList!!,view)
        }
        llJapan!!.setOnClickListener {
            onShowStores(japanList!!,view)
        }
        llBrazil!!.setOnClickListener {
            onShowStores(brazilList!!,view)
        }
        llNigeria!!.setOnClickListener {
            onShowStores(nigeriaList!!,view)
        }
        llPortugal!!.setOnClickListener {
            onShowStores(portugalList!!,view)
        }
        llAustralia!!.setOnClickListener {
            onShowStores(australiaList!!,view)
        }
        llGreece!!.setOnClickListener {
            onShowStores(greeceList!!,view)
        }

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        if(isVisibleToUser){
            if(firebaseRemoteConfig == null){
                firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
            }
            if (firebaseRemoteConfig!!.getBoolean(Constants().SHOW_ADS)) {
                onLoadFBNativeAd1(view!!, context!!)
                onLoadFBNativeAd2(view!!, context!!)
                onLoadFBNativeAd3(view!!, context!!)

            }
        }

    }

    fun initViews(view: View){
        firebaseAnalytics = FirebaseAnalytics.getInstance(activity!!)
        llIndia = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llIndia)
        llUsa = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llUsa)
        llRussia = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llRussia)
        llPakistan = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llPakistan)
        llChina = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llChina)
        llGermany = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llGermany)
        llTurkey = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llTurkey)
        llUae = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llUae)
        llItaly = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llItaly)
        llSwitzerland = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llSwitzerland)
        llCanada = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llCanada)
        llSingapore = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llSingapore)
        llSouthAfrica = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llSouthAfrica)
        llFrance = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llFrance)
        llIndonesia = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llIndonesia)
        llUk = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llUk)
        llJapan = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llJapan)
        llBrazil = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llBrazil)
        llNigeria = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llNigeria)
        llPortugal = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llPortugal)
        llAustralia = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llAustralia)
        llGreece = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.llGreece)
    }

    fun setRecyclerView(){
        categoryStoresAdapter = CategoryStoresAdapter(context)
        categoryStoresAdapter!!.setListener(this)
        rvCategoryStores.apply {
            rvCategoryStores?.layoutManager = GridLayoutManager(activity, 3)
            rvCategoryStores?.adapter = categoryStoresAdapter
        }
    }

    fun onShowStores(list: ArrayList<List<String>>, view: View){
        dialog!!.setContentView(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.layout.dialog_show_stores)
        dialog!!.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT);
        rvCategoryStores = dialog!!.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.rvCategoryStores)
        setRecyclerView()
        categoryStoresAdapter!!.setItems(list)
        if(firebaseRemoteConfig!!.getBoolean(Constants().SHOW_ADS)){
            onLoadFBNativeAdCatDailog(view, context!!, dialog!!)
        }

        dialog!!.show()

    }
    fun onLoadFBNativeAd1(view: View, context: Context) {
        nativeAdFB1 = NativeAd(context, Constants().getFbNativeCat1())
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
                nativeAdLayout = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_container_cat_1)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                            food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB1!!, adView!!)

                val adChoicesContainer: LinearLayout = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.ad_choices_container)
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
        nativeAdFB2 = NativeAd(context, Constants().getFbNativeCat2())
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
                nativeAdLayout = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_container_cat_2)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                            food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB2!!, adView!!)

                val adChoicesContainer: LinearLayout = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.ad_choices_container)
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
        nativeAdFB3 = NativeAd(context, Constants().getFbNativeCat3())
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
                nativeAdLayout = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_container_cat_3)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                            food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB3!!, adView!!)

                val adChoicesContainer: LinearLayout = view.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.ad_choices_container)
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

    fun onLoadFBNativeAdCatDailog(view: View, context: Context, dialog: Dialog) {
        nativeAdFB4 = NativeAd(context, Constants().getFbNativeDailog())
        val nativeAdListener: NativeAdListener = object : NativeAdListener {
            override fun onError(p0: Ad?, p1: AdError?) {
                Log.d("TAG", "onError: onLoadFBNativeAd1 " + p1!!.errorMessage)
            }

            override fun onAdLoaded(ad: Ad?) {

                // Race condition, load() called again before last ad was displayed
                if (nativeAdFB4 == null || nativeAdFB4 !== ad) {
                    return
                }
                // Inflate Native Ad into Container

                // Add the Ad view into the ad container.
                nativeAdLayout = dialog.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_container_topic_dailog)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                            food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB4!!, adView!!)

                val adChoicesContainer: LinearLayout = dialog.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.ad_choices_container)
                val adOptionsView = AdOptionsView(context, nativeAdFB4, nativeAdLayout)
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

        nativeAdFB4!!.loadAd(
                nativeAdFB4!!.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build()
        );
    }




    private fun inflateAd(nativeAd: NativeAd, adView: LinearLayout) {
        nativeAd.unregisterView()

        // Add the AdOptionsView

        // Create native UI using the ad metadata.
        val nativeAdIcon: com.facebook.ads.MediaView = adView.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_icon)
        val nativeAdTitle: TextView = adView.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_title)
        val nativeAdMedia: com.facebook.ads.MediaView = adView.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_media)
        val nativeAdSocialContext: TextView = adView.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_social_context)
        val nativeAdBody: TextView = adView.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_body)
        val sponsoredLabel: TextView = adView.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_sponsored_label)
        val nativeAdCallToAction: Button = adView.findViewById(food.delivery.online.global.shopping.world.social.media.news.virtual.all.R.id.native_ad_call_to_action)

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
        categoryViewModel?.reset()
        super.onDestroy()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun CategoryStoresCardClick(item: List<String>) {
        Log.d("TAG", "onAllBrokersCardClick: " + item.get(1))

        val bundle = Bundle()
        bundle.putString("title", item.get(1))
        bundle.putString("url", item.get(2))
        (activity as MainActivity?)!!.onUpdateLogEvent(bundle,"brokers_visited",true)

        val intent: Intent? = Intent(activity, WebActivity::class.java)
        intent?.putExtra("title", item.get(1))
        intent?.putExtra("url", item.get(2))
        startActivity(intent)
    }
}