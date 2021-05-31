package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.fragment

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
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.BaseFragment
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.utils.Constants
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.MainActivity
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.WebActivity
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.adapter.CategoryStoresAdapter
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.listener.GlobalStoresItemClickListener
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.viewmodel.GlobalViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GlobalFragment : BaseFragment(), GlobalStoresItemClickListener<List<String>> {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null

    var rvCategoryStores: RecyclerView? = null
    var categoryStoresAdapter: CategoryStoresAdapter? = null
    var globalViewModel: GlobalViewModel? = null

    var firebaseRemoteConfig: FirebaseRemoteConfig? = null
    var firebaseAnalytics: FirebaseAnalytics? = null
    private var nativeAdFB1: NativeAd? = null
    private var nativeAdFB2: NativeAd? = null
    private var nativeAdFB3: NativeAd? = null
    private var nativeAdFB4: NativeAd? = null

    private var nativeAdLayout: NativeAdLayout? = null
    private var adView: LinearLayout? = null

    // linear layouts
    var llAdvice: LinearLayout? = null
    var llAfter: LinearLayout? = null
    var llCalculator: LinearLayout? = null
    var llDiet: LinearLayout? = null
    var llDuedate: LinearLayout? = null
    var llExercies: LinearLayout? = null
    var llMiscarriage: LinearLayout? = null
    var llPrecaution: LinearLayout? = null
    var llSymptoms: LinearLayout? = null
    var llPregnancyCalender: LinearLayout? = null
    var llTest: LinearLayout? = null
    var llWeight: LinearLayout? = null


    var AdviceList: ArrayList<List<String>>? = ArrayList()
    var AfterList: ArrayList<List<String>>? = ArrayList()
    var CalculatorList: ArrayList<List<String>>? = ArrayList()
    var DietList: ArrayList<List<String>>? = ArrayList()
    var DuedateList: ArrayList<List<String>>? = ArrayList()
    var ExerciesList: ArrayList<List<String>>? = ArrayList()
    var MiscarriageList: ArrayList<List<String>>? = ArrayList()
    var precautionList: ArrayList<List<String>>? = ArrayList()
    var symptomsList: ArrayList<List<String>>? = ArrayList()
    var pregnancyCalenderList: ArrayList<List<String>>? = ArrayList()
    var TestList: ArrayList<List<String>>? = ArrayList()
    var WeightList: ArrayList<List<String>>? = ArrayList()


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
        return inflater.inflate(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.layout.fragment_global, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)

        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

        dialog = Dialog(context!!)

        globalViewModel = ViewModelProvider(activity!!).get(GlobalViewModel::class.java)
        globalViewModel?.loadData()


        globalViewModel!!.AfterLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: usaLiveData $t")
            AfterList!!.addAll(t!!)
        })
        globalViewModel!!.AdviceLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: russiaLiveData $t")
            AdviceList!!.addAll(t!!)
        })

        globalViewModel!!.CalculatorLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: pakistanLiveData $t")
            CalculatorList!!.addAll(t!!)
        })
        globalViewModel!!.MiscarriageLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: chinaLiveData $t")
            MiscarriageList!!.addAll(t!!)
        })

        globalViewModel!!.DietLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: germanyLiveData $t")
            DietList!!.addAll(t!!)
        })
        globalViewModel!!.DuedateLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: turkeyLiveData $t")
            DuedateList!!.addAll(t!!)
        })

        globalViewModel!!.ExerciesLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: uaeLiveData $t")
                ExerciesList!!.addAll(t!!)
        })
        globalViewModel!!.PrecautionLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: italyLiveData $t")
            precautionList!!.addAll(t!!)
        })

        globalViewModel!!.SymptomsLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: switzerlandLiveData $t")
            symptomsList!!.addAll(t!!)
        })
        globalViewModel!!.PregnancyCalenderLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: canadaLiveData $t")
            pregnancyCalenderList!!.addAll(t!!)
        })

        globalViewModel!!.TestLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: singaporeLiveData $t")
            TestList!!.addAll(t!!)
        })

        globalViewModel!!.WeightLiveData.observe(this, Observer { t ->
            Log.d("TAG", "onViewCreated: southAfricaLiveData $t")
            WeightList!!.addAll(t!!)
        })



        llPrecaution!!.setOnClickListener {
            onShowStores(precautionList!!,view)
        }
        llPregnancyCalender!!.setOnClickListener {
            onShowStores(pregnancyCalenderList!!,view)
        }
        llTest!!.setOnClickListener {
            onShowStores(TestList!!,view)
        }
        llWeight!!.setOnClickListener {
            onShowStores(WeightList!!,view)
        }
        llCalculator!!.setOnClickListener {
            onShowStores(CalculatorList!!,view)
        }
        llAdvice!!.setOnClickListener {
            onShowStores(AdviceList!!,view)
        }
        llAfter!!.setOnClickListener {
            onShowStores(AfterList!!,view)
        }
        llSymptoms!!.setOnClickListener {
            onShowStores(symptomsList!!,view)
        }
        llMiscarriage!!.setOnClickListener {
            onShowStores(MiscarriageList!!,view)
        }
        llDiet!!.setOnClickListener {
            onShowStores(DietList!!,view)
        }
        llDuedate!!.setOnClickListener {
            onShowStores(DuedateList!!,view)
        }
        llExercies!!.setOnClickListener {
            onShowStores(ExerciesList!!,view)
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
        llExercies = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llExercies)
        llDuedate = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llDuedate)
        llDiet = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llDiet)
        llMiscarriage = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llMiscarriage)
        llSymptoms = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llSymptoms)
        llAfter = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llAfter)
        llAdvice = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llAdvice)
        llCalculator = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llCalculator)
        llWeight = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llWeight)
        llTest = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llTest)
        llPregnancyCalender = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llPregnancyCalender)
        llPrecaution = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.llPrecaution)
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
        dialog!!.setContentView(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.layout.dialog_show_stores)
        dialog!!.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT);
        rvCategoryStores = dialog!!.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.rvCategoryStores)
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
                nativeAdLayout = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_container_cat_1)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                            medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB1!!, adView!!)

                val adChoicesContainer: LinearLayout = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.ad_choices_container)
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
                nativeAdLayout = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_container_cat_2)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                            medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB2!!, adView!!)

                val adChoicesContainer: LinearLayout = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.ad_choices_container)
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
                nativeAdLayout = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_container_cat_3)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                            medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB3!!, adView!!)

                val adChoicesContainer: LinearLayout = view.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.ad_choices_container)
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
                nativeAdLayout = dialog.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_container_topic_dailog)
                val inflater = LayoutInflater.from(context)
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView =
                        inflater.inflate(
                            medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.layout.native_ad_layout,
                                nativeAdLayout,
                                false
                        ) as LinearLayout
                nativeAdLayout!!.addView(adView)

                inflateAd(nativeAdFB4!!, adView!!)

                val adChoicesContainer: LinearLayout = dialog.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.ad_choices_container)
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
        val nativeAdIcon: com.facebook.ads.MediaView = adView.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_icon)
        val nativeAdTitle: TextView = adView.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_title)
        val nativeAdMedia: com.facebook.ads.MediaView = adView.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_media)
        val nativeAdSocialContext: TextView = adView.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_social_context)
        val nativeAdBody: TextView = adView.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_body)
        val sponsoredLabel: TextView = adView.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_sponsored_label)
        val nativeAdCallToAction: Button = adView.findViewById(medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R.id.native_ad_call_to_action)

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
        globalViewModel?.reset()
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
            GlobalFragment().apply {
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