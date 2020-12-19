package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageClickListener
import com.synnapps.carouselview.ImageListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import kotlinx.android.synthetic.main.fragment_home.*
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.BaseFragment
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.MainActivity
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.WebActivity
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter.home.AllAppsAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter.home.TopInternationalAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.AllAppsItemClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.Home.TopInternationalClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.viewmodel.HomeViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment(), AllAppsItemClickListener<List<String>>,
    TopInternationalClickListener<List<String>> {
    // TODO: Rename and change types of parameters
    private var param1: Int? = null
    private var param2: String? = null

    var carouselView: CarouselView? = null

    var rvAllApps: RecyclerView? = null
    var allAppsAdapter: AllAppsAdapter? = null
    var homeViewModel: HomeViewModel? = null

    var rvTrending: RecyclerView? = null
    var topInternationalAdapter: TopInternationalAdapter? = null

    var firebaseRemoteConfig: FirebaseRemoteConfig? = null
    var firebaseAnalytics: FirebaseAnalytics? = null

    var carouselImagesList: ArrayList<List<String>>? = ArrayList()

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)

        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()

        setRecyclerView()

        homeViewModel = ViewModelProvider(activity!!).get(HomeViewModel::class.java)

        homeViewModel?.loadData()

        homeViewModel!!.allAppsLiveData.observe(this, Observer { t ->
            Log.d("TAG", "HomeFragment Live allAppsLiveData$t")
            allAppsAdapter?.setItems(t)
        })

        homeViewModel!!.carouselImagesLiveData.observe(this, Observer { t ->
            Log.d("TAG", "HomeFragment Live carousel $t")
            carouselImagesList!!.addAll(t!!)
            onLoadCarouselImages()
        })

        homeViewModel!!.topInternationalLiveData.observe(this, Observer { t ->
            Log.d("TAG", "HomeFragment Live topInternationalLiveData $t")
            topInternationalAdapter!!.setItems(t)
        })

    }

    fun initViews(view: View) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(activity!!)
        carouselView = view.findViewById(R.id.cvHome)
        rvAllApps = view.findViewById(R.id.rvAllApps)
        rvTrending = view.findViewById(R.id.rvTrending)
    }

    fun setRecyclerView() {
        allAppsAdapter = AllAppsAdapter(context)
        allAppsAdapter!!.setListener(this)
        rvAllApps.apply {
            rvAllApps?.layoutManager = GridLayoutManager(activity, 3)
            rvAllApps?.adapter = allAppsAdapter
        }

        topInternationalAdapter = TopInternationalAdapter(context)
        topInternationalAdapter!!.setListener(this)
        rvTrending.apply {
            rvTrending?.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            rvTrending?.adapter = topInternationalAdapter
        }

    }

    fun onLoadCarouselImages(){
        Log.d("TAG", "onLoadCarouselImages: " + carouselImagesList!!.size)

        carouselView!!.setImageListener(imageListener)

        carouselView!!.setImageClickListener(imageClickListener)

        carouselView!!.pageCount = carouselImagesList!!.size

    }

    var imageClickListener: ImageClickListener = ImageClickListener { position ->
        val intent: Intent? = Intent(activity, WebActivity::class.java)
            intent?.putExtra("title", carouselImagesList!![position][1])
            intent?.putExtra("url", carouselImagesList!![position][2])
            intent?.putExtra("app_icon", carouselImagesList!![position][4])

            val bundle = Bundle()
            bundle.putString("title", carouselImagesList!![position][1])
            bundle.putString("url", carouselImagesList!![position][2])

            (activity as MainActivity?)!!.onUpdateLogEvent(bundle, "carousel_images_visited", true)


            startActivity(intent)
    }


    var imageListener: ImageListener = ImageListener { position, imageView ->
        Log.d("TAG", "onLoadCarouselImages: position " + position +" data "+ carouselImagesList!![position][3])
        Glide.with(imageView.context)
            .load(carouselImagesList!![position][3])
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }

    override fun onDestroy() {
        homeViewModel?.reset()
        Log.d("TAG", "onDestroy: ")
        super.onDestroy()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentHome.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onAllCardClick(item: List<String>) {
        Log.d("TAG", "onAllCardClick: " + item.get(1))
        val intent: Intent? = Intent(activity, WebActivity::class.java)
        intent?.putExtra("title", item.get(1))
        intent?.putExtra("url", item.get(2))
        intent?.putExtra("app_icon", item.get(3))

        val bundle = Bundle()
        bundle.putString("title", item.get(1))
        bundle.putString("url", item.get(2))

        (activity as MainActivity?)!!.onUpdateLogEvent(bundle, "all_apps_visited", true)


        startActivity(intent)
    }

    override fun onTopInernationalClickListener(item: List<String>) {
        val intent: Intent? = Intent(activity, WebActivity::class.java)
        intent?.putExtra("title", item.get(1))
        intent?.putExtra("url", item.get(2))
        intent?.putExtra("app_icon", item.get(4))

        val bundle = Bundle()
        bundle.putString("title", item.get(1))
        bundle.putString("url", item.get(2))

        (activity as MainActivity?)!!.onUpdateLogEvent(bundle, "trending_visited", true)


        startActivity(intent)
    }
}
