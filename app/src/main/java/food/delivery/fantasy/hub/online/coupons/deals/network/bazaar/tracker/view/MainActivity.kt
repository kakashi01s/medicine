package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.firebase.analytics.FirebaseAnalytics
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.BuildConfig
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.BaseActivity
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.utils.CustomViewPager
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.utils.ForceUpdateChecker
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.viewmodel.CategoryViewModel
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.viewmodel.HomeViewModel
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.viewmodel.ContinentalViewModel
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.viewpager.AppPagerAdapter

class MainActivity : BaseActivity(), ForceUpdateChecker.OnUpdateNeededListener {

    var viewPager: CustomViewPager? = null
    var viewPagerTab: TabLayout? =null
    var fragmentPagerAdapter: FragmentPagerAdapter ?= null
    var homeViewModel: HomeViewModel? = null
    var continentalViewModel: ContinentalViewModel? = null
    var categoryViewModel: CategoryViewModel? = null
    var firebaseAnalytics: FirebaseAnalytics? = null
    override val bindingVariable: Int
        get() = 0
    override val layoutId: Int
        get() = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupViewPager()

//        ForceUpdateChecker().with(this)!!.onUpdateNeeded(this).check()

        continentalViewModel = ViewModelProvider(this).get(ContinentalViewModel::class.java)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        viewPagerTab!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                Log.d("TAG", "onTabSelected: " + tab.position)
                val bundleAppUsage = Bundle()
                bundleAppUsage.putString("tab_click", tab.text.toString())
                onUpdateLogEvent(bundleAppUsage,"app_usage",false)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }

    fun initViews(){
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        viewPager = findViewById(R.id.vpPager)
        viewPagerTab = findViewById(R.id.view_pager_tab)
    }

    fun setupViewPager(){
        fragmentPagerAdapter = AppPagerAdapter(supportFragmentManager)
        viewPager!!.adapter = fragmentPagerAdapter
        val limit = if ((fragmentPagerAdapter as AppPagerAdapter).getCount() > 1) (fragmentPagerAdapter as AppPagerAdapter).getCount() - 1 else 1
        viewPager!!.offscreenPageLimit = limit;
        viewPager!!.currentItem = 1;

        viewPager!!.setSwipePagingEnabled(false)

        viewPagerTab!!.setupWithViewPager(viewPager)

    }

    override fun onDestroy() {
        homeViewModel?.reset()
        continentalViewModel?.reset()
        categoryViewModel?.reset()
        super.onDestroy()
    }

    override fun onUpdateNeeded(updateUrl: String?) {
        val dialog = AlertDialog.Builder(this)
            .setTitle("New version available")
            .setMessage("Please, update app to new version to continue viewing live news.")
            .setPositiveButton(
                "Update"
            ) { dialog, which -> redirectStore(updateUrl!!) }.setNegativeButton(
                "No, thanks"
            ) { dialog, which -> finish() }.create()
        dialog.show()
    }

    private fun redirectStore(updateUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(updateUrl))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    fun onUpdateLogEvent(bundle: Bundle, eventName: String, isUrlVisited: Boolean){
        Log.d("TAG", "onUpdateLogEvent: ")
        if(BuildConfig.DEBUG){
            return
        }
        else{
            if(isUrlVisited){
                firebaseAnalytics!!.logEvent(eventName, bundle)
                firebaseAnalytics!!.logEvent("url_visited", bundle)
            }
            else
                firebaseAnalytics!!.logEvent(eventName, bundle)
        }
    }
}
