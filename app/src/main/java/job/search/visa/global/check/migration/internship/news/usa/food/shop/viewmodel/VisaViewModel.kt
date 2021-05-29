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

class VisaViewModel : ViewModel() {
    private var context: Context? = null
    var compositeDisposable: CompositeDisposable? = null

    var visastatusData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var travelData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var citizenshipData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var migrationData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var globaluniversitiesData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var weatherData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var newsData: MutableLiveData<List<List<String>>?> = MutableLiveData()

    fun loadData(){
        Log.d("TAG", "loadData: News")
        compositeDisposable = CompositeDisposable()
        fetchvisastatus()
        fetchtravel()
        fetchcitizenship()
        fetchmigration()
        fetchglobaluniversities()
        fetchweather()
        fetchnews()


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
                Log.d("TAG", "fetchdeals Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchdeals Response ${t.getValues()}")
                changeNewsDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun changeNewsDataSet(newsList: List<List<String>>?) {
        newsData.value = newsList
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
                Log.d("TAG", "fetchdeals Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchdeals Response ${t.getValues()}")
                changeWeatherDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun changeWeatherDataSet(weatherList: List<List<String>>?) {
        weatherData.value = weatherList
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
                Log.d("TAG", "fetchdeals Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchdeals Response ${t.getValues()}")
                changeGlobalUniversitiesDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun changeGlobalUniversitiesDataSet(globaluniversitiesList: List<List<String>>?) {
        globaluniversitiesData.value = globaluniversitiesList
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
                Log.d("TAG", "fetchdeals Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchdeals Response ${t.getValues()}")
                changeMigrationDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun changeMigrationDataSet(migrationList: List<List<String>>?) {
        migrationData.value = migrationList
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
                Log.d("TAG", "fetchdeals Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchdeals Response ${t.getValues()}")
                changeCitizenshipDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun changeCitizenshipDataSet(citizenshipList: List<List<String>>?) {
        citizenshipData.value = citizenshipList
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
                Log.d("TAG", "fetchdeals Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchdeals Response ${t.getValues()}")
                changeTravelDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun changeTravelDataSet(travelList: List<List<String>>?) {
        travelData.value = travelList
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
                Log.d("TAG", "fetchdeals Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchdeals Response ${t.getValues()}")
                changeVisaDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun changeVisaDataSet(visastatusList: List<List<String>>?) {
        visastatusData.value = visastatusList
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



