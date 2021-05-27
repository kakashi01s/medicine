package job.search.visa.global.check.migration.internship.news.usa.food.shop.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import job.search.visa.global.check.migration.internship.news.usa.food.shop.gov
import job.search.visa.global.check.migration.internship.news.usa.food.shop.data.DataFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class ToolsViewModel : ViewModel() {
    private var context: Context? = null
    var compositeDisposable: CompositeDisposable? = null

    var dealsData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var socialmediaData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var shoppingtoolsData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var foodData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var sportsData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var gamesData: MutableLiveData<List<List<String>>?> = MutableLiveData()


    fun loadData(){
        Log.d("TAG", "loadData: News")
        compositeDisposable = CompositeDisposable()
        fetchdeals()
        fetchsports()
        fetchgames()
        fetchshoppingtools()
        fetchfood()
        fetchsocialmedia()


    }

    private fun fetchdeals(){
        Log.d("TAG", "fetchAllApps: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_DEALS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchdeals Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchdeals Response ${t.getValues()}")
                changeDealsDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }



    private fun fetchsocialmedia(){
        Log.d("TAG", "fetchsocialmedia: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_SOCIALMEDIA, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchsocialmedia Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchsocialmedia Response ${t.getValues()}")
                changesocialmediaDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }



    private fun fetchshoppingtools(){
        Log.d("TAG", "fetchshoppingtools: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_SHOPPINGTOOLS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchshoppingtools Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchshoppingtools Response ${t.getValues()}")
                changeshoppingtoolsDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }



    private fun fetchfood(){
        Log.d("TAG", "fetchfood: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_FOOD, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchfood Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchfood Response ${t.getValues()}")
                changefoodDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }



    private fun fetchsports(){
        Log.d("TAG", "fetchsports: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_SPORTS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchsports Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchMostsports Response ${t.getValues()}")
                changesportsDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }



    private fun fetchgames(){
        Log.d("TAG", "fetchgames: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_GAMES, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchgames Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                changegamesDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }
    private fun changegamesDataSet(gamesList: List<List<String>>?) {
        gamesData.value = gamesList
    }
    private fun changeDealsDataSet(Dealslist: List<List<String>>?) {
        dealsData.value = Dealslist
    }
    private fun changesocialmediaDataSet(socialmedialist: List<List<String>>?) {
        socialmediaData.value = socialmedialist
    }
    private fun changeshoppingtoolsDataSet(shoppingtoolslist: List<List<String>>?) {
        shoppingtoolsData.value = shoppingtoolslist
    }
    private fun changefoodDataSet(foodlist: List<List<String>>?) {
        foodData.value = foodlist
    }
    private fun changesportsDataSet(sportslist: List<List<String>>?) {
        sportsData.value = sportslist
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