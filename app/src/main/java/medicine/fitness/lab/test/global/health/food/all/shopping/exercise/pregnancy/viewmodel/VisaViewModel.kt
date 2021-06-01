package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.viewmodel


import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.data.DataFactory
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.doctor


class VisaViewModel : ViewModel() {
    private var context: Context? = null
    var compositeDisposable: CompositeDisposable? = null

    var BookLabData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var TestResultData: MutableLiveData<List<List<String>>?> = MutableLiveData()


    fun loadData(){
        Log.d("TAG", "loadData: News ")
        compositeDisposable = CompositeDisposable()
        fetchBookLab()
        fetchTestResult()

    }

    private fun fetchBookLab(){
        Log.d("TAG", "fetchAllApps: ")
        val doctor: doctor? = doctor.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_BOOKLAB, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchLiveNews Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchLiveNews Response ${t.getValues()}")
                changeBookLabDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    private fun fetchTestResult(){
        Log.d("TAG", "fetchMostUsefullApps: ")
        val doctor: doctor? = doctor.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_TESTRESULT, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchMostUsefulApps Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchMostUsefulApps Response ${t.getValues()}")
                changeTestResultDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }



    fun changeBookLabDataSet(liveNewsList: List<List<String>>?){
        BookLabData.value = liveNewsList
    }

    fun changeTestResultDataSet(liveNewsList: List<List<String>>?){
        TestResultData.value = liveNewsList
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