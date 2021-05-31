package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.viewmodel

import android.content.Context
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.doctor
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.data.DataFactory
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.data.DataService

class GlobalViewModel : ViewModel() {


    var AdviceLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var AfterLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var CalculatorLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var DietLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var DuedateLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var ExerciesLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var MiscarriageLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var PrecautionLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var SymptomsLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var PregnancyCalenderLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var TestLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var WeightLiveData: MutableLiveData<List<List<String>>?> = MutableLiveData()

    private var context: Context? = null
    var compositeDisposable: CompositeDisposable? = null

    fun loadData(){
        Log.d("TAG", "loadData: ")
        compositeDisposable = CompositeDisposable()
        fetchadvice()
        fetchafter()
        fetchcalculator()
        fetchdiet()
        fetchduedate()
        fetchexercies()
        fetchmiscarriage()
        fetchprecaution()
        fetchsymptoms()
        fetchpregnancycalender()
        fetchtest()
        fetchweight()

    }



    private fun fetchadvice(){
        Log.d("TAG", "fetchUsa: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_ADVICE, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchUsa Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchUsa Response ${t.getValues()}")
                changeAdviceDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun  fetchafter(){
        Log.d("TAG", "fetchRussia: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_AFTER, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchRussia Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchRussia Response ${t.getValues()}")
                changeAfterDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchcalculator(){
        Log.d("TAG", "fetchPakistan: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_CALCULATOR, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchPaistan Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchPakistan Response ${t.getValues()}")
                changecalculatorDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchdiet(){
        Log.d("TAG", "fetchChina: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_DIET, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchChina Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchChina Response ${t.getValues()}")
                changedietDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchduedate(){
        Log.d("TAG", "fetchGermany: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_DUEDATE, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchGermany Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchGermany Response ${t.getValues()}")
                changeduedateDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchexercies(){
        Log.d("TAG", "fetchTurkey: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_EXERCIES, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchTurkey Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchTurkey Response ${t.getValues()}")
                changeexerciesDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchprecaution(){
        Log.d("TAG", "fetchUae: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(
            DataFactory().URL_PRECAUTIONS,
            DataFactory().KEY
        )
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchUae Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchUae Response ${t.getValues()}")
                changeprecautionDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchmiscarriage(){
        Log.d("TAG", "fetchItaly: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_MISCARRIAGE, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchItaly Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchItaly Response ${t.getValues()}")
                changemiscarriageDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchsymptoms(){
        Log.d("TAG", "fetchSwitzerland: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_SYMPTOMS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchSwitzerland Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchSwitzerland Response ${t.getValues()}")
                changeSymptomsDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchpregnancycalender(){
        Log.d("TAG", "fetchCanada: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_PREGNANCY_CALENDER, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchCanada Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchCanada Response ${t.getValues()}")
                changepregnancycalenderDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchweight(){
        Log.d("TAG", "fetchSingapore: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_WEIGHT, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchSingapore Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchSingapore Response ${t.getValues()}")
                changeweightDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchtest(){
        Log.d("TAG", "fetchFrance: ")

        val doctor: doctor? = doctor.get()
        val dataService: DataService? = doctor!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_TEST, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchFrance Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchFrance Response ${t.getValues()}")
                changetestDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }



    fun changeAdviceDataSet(allAppsList: List<List<String>>?){
        AdviceLiveData.value = allAppsList
    }

    fun changeAfterDataSet(allAppsList: List<List<String>>?){
        AfterLiveData.value = allAppsList
    }

    fun changecalculatorDataSet(allAppsList: List<List<String>>?){
        CalculatorLiveData.value = allAppsList
    }

    fun changedietDataSet(allAppsList: List<List<String>>?){
        DietLiveData.value = allAppsList
    }

    fun changeduedateDataSet(allAppsList: List<List<String>>?){
        DuedateLiveData.value = allAppsList
    }

    fun changeexerciesDataSet(allAppsList: List<List<String>>?){
        ExerciesLiveData.value = allAppsList
    }

    fun changeprecautionDataSet(allAppsList: List<List<String>>?){
        PrecautionLiveData.value = allAppsList
    }

    fun changemiscarriageDataSet(allAppsList: List<List<String>>?){
        MiscarriageLiveData.value = allAppsList
    }

    fun changeSymptomsDataSet(allAppsList: List<List<String>>?){
        SymptomsLiveData.value = allAppsList
    }

    fun changepregnancycalenderDataSet(allAppsList: List<List<String>>?){
        PregnancyCalenderLiveData.value = allAppsList
    }
    fun changeweightDataSet(allAppsList: List<List<String>>?){
        WeightLiveData.value = allAppsList
    }

    fun changetestDataSet(allAppsList: List<List<String>>?){
        TestLiveData.value = allAppsList
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