package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.firebase.analytics.FirebaseAnalytics
import com.onesignal.OneSignal
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.BuildConfig
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.BaseActivity
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.model.AllAppsModel
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.utils.CustomViewPager
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.utils.ForceUpdateChecker
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.viewmodel.GlobalViewModel
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.viewmodel.HomeViewModel
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.viewmodel.VisaViewModel
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.viewpager.AppPagerAdapter
import java.io.*

class MainActivity : BaseActivity(), ForceUpdateChecker.OnUpdateNeededListener {
    private val ONESIGNAL_APP_ID ="285284f8-5bc8-4f11-ad58-30ebde4dbec3"
    var viewPager: CustomViewPager? = null
    var viewPagerTab: TabLayout? =null
    var fragmentPagerAdapter: FragmentPagerAdapter ?= null
    var homeViewModel: HomeViewModel? = null
    var visaViewModel: VisaViewModel? = null
    var globalViewModel: GlobalViewModel? = null
    var firebaseAnalytics: FirebaseAnalytics? = null
    override val bindingVariable: Int
        get() = 0
    override val layoutId: Int
        get() = 0
    var homeFragmentData: AllAppsModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        homeFragmentData = read(this, "home.json")
        setupViewPager()

//        ForceUpdateChecker().with(this)!!.onUpdateNeeded(this).check()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        visaViewModel = ViewModelProvider(this).get(VisaViewModel::class.java)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        globalViewModel = ViewModelProvider(this).get(GlobalViewModel::class.java)
        updateJson()

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
    fun updateJson() {
        homeViewModel!!.loadData()
        homeViewModel!!.allAppsLiveData.observe(this, Observer { t ->
            val fos: FileOutputStream = this.openFileOutput("home.json", MODE_PRIVATE)
            val os = ObjectOutputStream(fos)
            os.flush()
            os.writeObject(t)
            os.close()
            fos.close()
        })
        Log.d("File", "Storage file is updated successfully")
    }


    fun initViews(){
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        viewPager = findViewById(R.id.vpPager)
        viewPagerTab = findViewById(R.id.view_pager_tab)
    }

    fun setupViewPager(){
        fragmentPagerAdapter = AppPagerAdapter(supportFragmentManager,homeFragmentData)
        viewPager!!.adapter = fragmentPagerAdapter
        val limit = if ((fragmentPagerAdapter as AppPagerAdapter).getCount() > 1) (fragmentPagerAdapter as AppPagerAdapter).getCount() - 1 else 1
        viewPager!!.offscreenPageLimit = limit;
        viewPager!!.currentItem = 1;

        viewPager!!.setSwipePagingEnabled(false)

        viewPagerTab!!.setupWithViewPager(viewPager)

    }
    private fun read(context: Context, fileName: String): AllAppsModel?{
        return try {
            val fis = context.openFileInput(fileName)
            val `is` = ObjectInputStream(fis)
            val allAppsModel: AllAppsModel = `is`.readObject() as AllAppsModel
            `is`.close()
            fis.close()
            return allAppsModel
        }
        catch (fileNotFound: FileNotFoundException) {
            null
        } catch (ioException: IOException) {
            null
        }
    }

    override fun onDestroy() {
        homeViewModel?.reset()
        visaViewModel?.reset()
        globalViewModel?.reset()
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
