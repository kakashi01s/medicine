package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.fragment

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
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.BaseFragment
import job.search.visa.global.check.migration.internship.news.usa.food.shop.utils.Constants
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.MainActivity
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.WebActivity
import job.search.visa.global.check.migration.internship.news.usa.food.shop.viewmodel.VisaViewModel
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_tools.*
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.adapter.VisaAdapter
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener.VisaClickListener

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TopicsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VisaFragment : BaseFragment(), VisaClickListener<List<String>> {

    private var param1: Int? = null
    private var param2: String? = null

    var rvvisastores : RecyclerView? = null
    var visaAdapter: VisaAdapter? = null
    //linear layout
    var llvisastatus: LinearLayout? = null
    var lltravel: LinearLayout? = null
    var llcitizenship: LinearLayout? = null
    var llmigration: LinearLayout? = null
    var llnews: LinearLayout? = null
    var llglobaluniversities: LinearLayout? = null
    var llweather: LinearLayout? = null


    //array list
    var visastatusList: ArrayList<List<String>>? = ArrayList()
    var travelList: ArrayList<List<String>>? = ArrayList()
    var citizenshipList: ArrayList<List<String>>? = ArrayList()
    var migrationList: ArrayList<List<String>>? = ArrayList()
    var newsList: ArrayList<List<String>>? = ArrayList()
    var globaluniversitiesList: ArrayList<List<String>>? = ArrayList()
    var weatherList: ArrayList<List<String>>? = ArrayList()


    var firebaseAnalytics: FirebaseAnalytics? = null
    var firebaseRemoteConfig: FirebaseRemoteConfig? = null
    var visaViewModel: VisaViewModel? = null

    private var nativeAdFB1: NativeAd? = null
    private var nativeAdFB2: NativeAd? = null
    private var nativeAdFB4: NativeAd? = null

    private var nativeAdLayout: NativeAdLayout? = null
    private var adView: LinearLayout? = null
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
        return inflater.inflate(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.layout.fragment_visa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)

        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

        dialog = Dialog(context!!)

        visaViewModel = ViewModelProvider(activity!!).get(VisaViewModel::class.java)
        visaViewModel?.loadData()

        visaViewModel!!.visastatusData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: dealsLiveData $t")
            visastatusList!!.addAll(t!!)
        })
        visaViewModel!!.newsData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: gamesLiveData $t")
            newsList?.addAll(t!!)
        })

        visaViewModel!!.globaluniversitiesData.observe(this, Observer { t ->
            Log.d("NewsFrag", "onViewCreated: sportsLiveData $t")
            globaluniversitiesList
        })
        visaViewModel!!.migrationData.observe(this, Observer { t ->
            Log.d("News Frag", "onViewCreated: foodLiveData $t")
            migrationList?.addAll(t!!)
        })
        visaViewModel!!.weatherData.observe(this, Observer { t ->
            Log.d("News Frag", "onViewCreated: shopppingtoolsLiveData $t")
            weatherList?.addAll(t!!)
        })
        visaViewModel!!.travelData.observe(this, Observer { t ->
            Log.d("News Frag", "onViewCreated: socialmediaLiveData $t")
            travelList?.addAll(t!!)
        })

        llnews!!.setOnClickListener {
            onShowStores(newsList!!, view)
        }
        llmigration!!.setOnClickListener {
            onShowStores(migrationList!!, view)
        }
        llweather!!.setOnClickListener {
            onShowStores(weatherList!!, view)
        }
        llglobaluniversities!!.setOnClickListener {
            onShowStores(globaluniversitiesList!!, view)
        }
        lltravel!!.setOnClickListener {
            onShowStores(travelList!!, view)
        }
        llvisastatus!!.setOnClickListener {
            onShowStores(visastatusList!!, view)

        }
        llcitizenship!!.setOnClickListener {
            onShowStores(citizenshipList!!, view)


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
                }
            }

        }

        fun initViews(view: View){
            firebaseAnalytics = FirebaseAnalytics.getInstance(activity!!)
            llcitizenship = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.llcitizenship)
            llglobaluniversities = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.llglobaluniversities)
            llnews = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.llnews)
            lltravel = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.lltravel)
            llvisastatus = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.llvisastatus)
            llweather = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.llweather)
            llmigration = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.llmigration)
        }

        fun setRecyclerView(){
            visaAdapter = VisaAdapter(context)
            visaAdapter!!.setListener(this)
            rvvisastores.apply {
                rvvisastores?.layoutManager = GridLayoutManager(activity, 3)
                rvvisastores?.adapter = visaAdapter
            }
        }

        fun onShowStores(list: ArrayList<List<String>>, view: View){
            dialog!!.setContentView(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.layout.dialog_show_stores)
            dialog!!.window!!.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
            rvvisastores = dialog!!.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.rvvisastores)
            setRecyclerView()
            visaAdapter!!.setItems(list)
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
                    nativeAdLayout = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_container_cat_1)
                    val inflater = LayoutInflater.from(context)
                    // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                    adView =
                        inflater.inflate(
                            job.search.visa.global.check.migration.internship.news.usa.food.shop.R.layout.native_ad_layout,
                            nativeAdLayout,
                            false
                        ) as LinearLayout
                    nativeAdLayout!!.addView(adView)

                    inflateAd(nativeAdFB1!!, adView!!)

                    val adChoicesContainer: LinearLayout = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.ad_choices_container)
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
                    nativeAdLayout = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_container_cat_2)
                    val inflater = LayoutInflater.from(context)
                    // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                    adView =
                        inflater.inflate(
                            job.search.visa.global.check.migration.internship.news.usa.food.shop.R.layout.native_ad_layout,
                            nativeAdLayout,
                            false
                        ) as LinearLayout
                    nativeAdLayout!!.addView(adView)

                    inflateAd(nativeAdFB2!!, adView!!)

                    val adChoicesContainer: LinearLayout = view.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.ad_choices_container)
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
                    nativeAdLayout = dialog.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_container_topic_dailog)
                    val inflater = LayoutInflater.from(context)
                    // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                    adView =
                        inflater.inflate(
                            job.search.visa.global.check.migration.internship.news.usa.food.shop.R.layout.native_ad_layout,
                            nativeAdLayout,
                            false
                        ) as LinearLayout
                    nativeAdLayout!!.addView(adView)

                    inflateAd(nativeAdFB4!!, adView!!)

                    val adChoicesContainer: LinearLayout = dialog.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.ad_choices_container)
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
            val nativeAdIcon: com.facebook.ads.MediaView = adView.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_icon)
            val nativeAdTitle: TextView = adView.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_title)
            val nativeAdMedia: com.facebook.ads.MediaView = adView.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_media)
            val nativeAdSocialContext: TextView = adView.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_social_context)
            val nativeAdBody: TextView = adView.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_body)
            val sponsoredLabel: TextView = adView.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_sponsored_label)
            val nativeAdCallToAction: Button = adView.findViewById(job.search.visa.global.check.migration.internship.news.usa.food.shop.R.id.native_ad_call_to_action)

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
           visaViewModel?.reset()
            super.onDestroy()
        }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ToolsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            VisaFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onVisaCardClickClickListener(item: List<String>) {
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