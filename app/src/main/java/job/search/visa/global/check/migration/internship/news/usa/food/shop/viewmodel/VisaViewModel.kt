package job.search.visa.global.check.migration.internship.news.usa.food.shop.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import job.search.visa.global.check.migration.internship.news.usa.food.shop.gov
import job.search.visa.global.check.migration.internship.news.usa.food.shop.data.DataFactory
import job.search.visa.global.check.migration.internship.news.usa.food.shop.data.DataService
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener.LiveNewsItemClickListener

class VisaViewModel : ViewModel() {

    var visastatusData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var newsData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var travelData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var citizenshipData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var migrationData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var globaluniversitiesData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var weatherData: MutableLiveData<List<List<String>>?> = MutableLiveData()

    private var context: Context? = null
    var compositeDisposable: CompositeDisposable? = null

    fun loadData() {
        Log.d("TAG", "loadData: News")
        compositeDisposable = CompositeDisposable()
        fetchvisastatus()
        fetchnews()
        fetchmigration()
        fetchcitizenship()
        fetchweather()
        fetchglobaluniversities()
        fetchtravel()


    }

    private fun fetchvisastatus() {
        Log.d("TAG", "fetchAllApps: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_VISA, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchvisastatus Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchvisastatus Response ${t.getValues()}")
                changevisastatusDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchmigration() {
        Log.d("TAG", "fetchAllApps: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_MIGRATION, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchmigration Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchmigration Response ${t.getValues()}")
                changemigrationDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchcitizenship() {
        Log.d("TAG", "fetchAllApps: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_CITIZENSHIP, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchcitizenship Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchcitizenship Response ${t.getValues()}")
                changecitizenshipDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchtravel() {
        Log.d("TAG", "fetchAllApps: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_TRAVEL, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchtravel Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchtravel Response ${t.getValues()}")
                changetravelDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchglobaluniversities() {
        Log.d("TAG", "fetchAllApps: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_GLOBALUNIVERSITY, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchglobaluniversities Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchglobaluniversities Response ${t.getValues()}")
                changeglobaluniversitiesDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchweather() {
        Log.d("TAG", "fetchAllApps: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_WEATHER, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchweather Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchweather Response ${t.getValues()}")
                changeweatherDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchnews() {
        Log.d("TAG", "fetchAllApps: ")
        val gov: gov? = gov.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_NEWS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchnews Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchnews Response ${t.getValues()}")
                changenewsDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun changenewsDataSet(newsList:  List<List<String>>?) {
        newsData.value = newsList
    }


    private fun changecitizenshipDataSet(citizenshipList: List<List<String>>?) {
        citizenshipData.value = citizenshipList
    }

    private fun changeweatherDataSet(weatherList: List<List<String>>?) {
        weatherData.value = weatherList
    }

    private fun changevisastatusDataSet(visastatusList: List<List<String>>?) {
       visastatusData.value = visastatusList
    }

    private fun changeglobaluniversitiesDataSet(globaluniversitiesList: List<List<String>>?) {
        globaluniversitiesData.value = globaluniversitiesList
    }

    private fun changetravelDataSet(travelList: List<List<String>>?) {
        travelData.value = travelList
    }

    private fun changemigrationDataSet(migrationList: List<List<String>>?) {
        migrationData.value = migrationList
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



