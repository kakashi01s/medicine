package food.delivery.online.global.shopping.world.social.media.news.virtual.all.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.Singleton
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.data.DataFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class ToolsViewModel : ViewModel() {
    private var context: Context? = null
    var compositeDisposable: CompositeDisposable? = null

    var currencyData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var mostUsefulAppsData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var cookingChannelsData: MutableLiveData<List<List<String>>?> = MutableLiveData()

    fun loadData(){
        Log.d("TAG", "loadData: News ")
        compositeDisposable = CompositeDisposable()
        fetchLiveNews()
        fetchMostUsefulApps()
        fetchCookingChannels()
    }

    private fun fetchLiveNews(){
        Log.d("TAG", "fetchAllApps: ")
        val singleton: Singleton? = Singleton.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_CURRENCY, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchLiveNews Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchLiveNews Response ${t.getValues()}")
                changeLiveNewsDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchMostUsefulApps(){
        Log.d("TAG", "fetchMostUsefullApps: ")
        val singleton: Singleton? = Singleton.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_MOST_USEFUL_APPS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchMostUsefulApps Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchMostUsefulApps Response ${t.getValues()}")
                changeMostUsefulAppsSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchCookingChannels(){
        Log.d("TAG", "fetchCookingChannels: ")
        val singleton: Singleton? = Singleton.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_COOKING_CHANNELS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchMostUsefulApps Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                changeCookingChannelsSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    fun changeCookingChannelsSet(liveNewsList: List<List<String>>?){
        cookingChannelsData.value = liveNewsList
    }

    fun changeLiveNewsDataSet(liveNewsList: List<List<String>>?){
        currencyData.value = liveNewsList
    }

    fun changeMostUsefulAppsSet(mostUsefulAppsList: List<List<String>>?){
        mostUsefulAppsData.value = mostUsefulAppsList
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