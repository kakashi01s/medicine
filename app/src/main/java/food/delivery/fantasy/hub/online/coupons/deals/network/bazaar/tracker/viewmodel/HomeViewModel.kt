package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.Singleton
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.data.DataFactory
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.data.DataService
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.model.AllAppsModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {

    var allAppsLiveData: MutableLiveData<AllAppsModel> = MutableLiveData()
    var carouselImagesLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var topInternationalLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    private var context: Context? = null
    var compositeDisposable: CompositeDisposable? = null

    fun loadData(){
        Log.d("TAG", "loadData: ")
        compositeDisposable = CompositeDisposable()
        fetchCarouselImages()
        fetchInternationalData()
        fetchAllApps()
    }

    private fun fetchAllApps(){
        Log.d("TAG", "fetchAllApps: ")
        val singleton: Singleton? = Singleton.get()
        val dataService: DataService? = singleton!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_ALL_APPS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchAllApps Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchAllApps Response ${t.getValues()}")
                changeAllAppsDataSet(t)
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchCarouselImages(){
        Log.d("TAG", "fetchCarouselImages: ")

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_CAROUSEL_IMAGES, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchCarouselImages Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchCarouselImages Response ${t.getValues()}")
                changeCarouselDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchInternationalData(){
        Log.d("TAG", "fetchInternationalData: ")

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_TOP_INTERNATIONAL, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchInternationalData Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchInternationalData Response ${t.getValues()}")
                changeTopInternationalDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }


    fun changeAllAppsDataSet(allAppsList:  AllAppsModel){
        allAppsLiveData.value = allAppsList
    }

    fun changeCarouselDataSet(carouselList: List<List<String>>?){
        carouselImagesLiveData.value = carouselList
    }

    fun changeTopInternationalDataSet(trendingList: List<List<String>>?){
        topInternationalLiveData.value = trendingList
    }


    private fun unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable!!.isDisposed) {
            compositeDisposable!!.dispose()
        }
    }

    fun reset() {
        unSubscribeFromObservable()
        compositeDisposable = null
        context = null
    }

}