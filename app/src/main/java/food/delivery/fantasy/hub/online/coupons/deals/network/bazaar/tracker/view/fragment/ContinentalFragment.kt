package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.fragment

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.ads.*
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.BaseFragment
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.utils.Constants
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.MainActivity
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.WebActivity
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter.ContinentalCardsAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter.ContinentalDialogAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.ContinentalCardsListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.ContinentalDialogListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.viewmodel.ContinentalViewModel
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_continental.*
import kotlinx.android.synthetic.main.fragment_tools.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TopicsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContinentalFragment : BaseFragment(), ContinentalCardsListener, ContinentalDialogListener {

    private var param1: Int? = null
    private var param2: String? = null

    var continentalCardsAdapter: ContinentalCardsAdapter? = null
    var continentalDialogAdapter: ContinentalDialogAdapter? = null

    var firebaseAnalytics: FirebaseAnalytics? = null
    var firebaseRemoteConfig: FirebaseRemoteConfig? = null
    var continentalViewModel: ContinentalViewModel? = null

    var rvContinental: RecyclerView? = null
    var rvDialog: RecyclerView? = null

    var continentalCardsList: ArrayList<List<String>>? = ArrayList()
    var dialogList: ArrayList<List<String>>? = ArrayList()
    private var nativeAdFB1: NativeAd? = null
    private var nativeAdFB2: NativeAd? = null

    private var nativeAdLayout: NativeAdLayout? = null
    private var adView: LinearLayout? = null

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
        return inflater.inflate(R.layout.fragment_continental, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)

        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        setRecyclerView()

        continentalViewModel = ViewModelProvider(activity!!).get(ContinentalViewModel::class.java)
        continentalViewModel?.loadData()

        continentalViewModel!!.continentalCardsData.observe(this, Observer { t ->
            Log.d("TAG", "A $t")
            continentalCardsList!!.clear()
            continentalCardsList!!.addAll(t!!)
            continentalCardsAdapter!!.notifyDataSetChanged()
        })

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser){
            if(firebaseRemoteConfig == null){
                firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
            }
            if (firebaseRemoteConfig!!.getBoolean(Constants().SHOW_ADS)) {
                onLoadFBNativeAd1(view!!, context!!)
            }
        }
    }

    fun initViews(view: View) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(activity!!)
        rvContinental = view.findViewById(R.id.rvContinental)
    }

    fun onShowDialog(List: ArrayList<List<String>>) {
        val dialog = Dialog(context!!, R.style.Theme_MaterialComponents_Light_NoActionBar)
        dialog.setContentView(R.layout.dialog_show)
        rvDialog = dialog.findViewById(R.id.rvDailog)

        continentalDialogAdapter = ContinentalDialogAdapter(context, List, this)
        rvDialog.apply {
            rvDialog?.layoutManager = GridLayoutManager(context!!, 3)
            rvDialog?.adapter = continentalDialogAdapter
            if (firebaseRemoteConfig!!.getBoolean(Constants().SHOW_ADS)) {
                onLoadFBNativeAdCatDailog(context!!, dialog!!)
            }

        }
        dialog.show()
    }

    fun setRecyclerView() {
        continentalCardsAdapter = ContinentalCardsAdapter(context, continentalCardsList!!, this)
        rvContinental.apply {
            rvContinental?.layoutManager = GridLayoutManager(context!!, 2)
            rvContinental?.adapter = continentalCardsAdapter
        }
    }

    fun onLoadFBNativeAd1(view: View, context: Context) {
        nativeAdFB1 = NativeAd(context, Constants().getFbNativeContinental())
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
                nativeAdLayout = view.findViewById(R.id.native_ad_container_continental_1)
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

    fun onLoadFBNativeAdCatDailog(context: Context, dialog: Dialog) {
        nativeAdFB2 = NativeAd(context, Constants().getFbNativeDailog())
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
                nativeAdLayout = dialog.findViewById(R.id.native_ad_container_topic_dailog)
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

                val adChoicesContainer: LinearLayout =
                    dialog.findViewById(R.id.ad_choices_container)
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
        continentalViewModel?.reset()
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
            ContinentalFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onContinentalCardClick(item: List<String>) {
        continentalViewModel!!.fetchDialog(item.get(2))
        continentalViewModel!!.dialogData.observe(this, Observer { t ->
            dialogList!!.clear()
            dialogList!!.addAll(t!!)
            continentalDialogAdapter!!.notifyDataSetChanged()
        })
        onShowDialog(dialogList!!)
    }

    override fun onContinentalDialogClick(item: List<String>) {
        val bundle = Bundle()
        bundle.putString("title", item.get(1))
        bundle.putString("url", item.get(2))
        (activity as MainActivity?)!!.onUpdateLogEvent(bundle, "card_visited", true)

        val intent: Intent? = Intent(activity, WebActivity::class.java)
        intent?.putExtra("url", item.get(2))
        startActivity(intent)
    }
}