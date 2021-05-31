package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.doctor
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.data.DataFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class ToolsViewModel : ViewModel() {
    private var context: Context? = null
    var compositeDisposable: CompositeDisposable? = null

    var medicinesData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var healthData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var healthyfoodData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var fitnessData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var mostusefulappsData: MutableLiveData<List<List<String>>?> = MutableLiveData()


    fun loadData(){
        Log.d("TAG", "loadData: News")
        compositeDisposable = CompositeDisposable()
        fetchmedicine()
        fetchhealth()
        fetchhealthyfood()
        fetchfitness()
        fetchmostusefulapps()

    }

    private fun fetchhealthyfood() {
        Log.d("KAKA", "fetchhealthyfood: ")
        val doctor: doctor? = doctor.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_HEALTHYFOOD, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("KAKA", "fetchhealthyfood Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("KAKA", "fetchhealthyfood Response ${t.getValues()}")
                changehealthyfoodDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }

    }

    private fun fetchmostusefulapps() { Log.d("TAG", "fetchAllApps: ")
        val doctor: doctor? = doctor.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_MOSTUSEFULAPPS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchdeals Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchdeals Response ${t.getValues()}")
                changemostusefulappsDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }


    }



    private fun fetchmedicine(){
        Log.d("TAG", "fetchmedicine: ")
        val doctor: doctor? = doctor.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_MEDICINE, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchmedicine Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchmedicine Response ${t.getValues()}")
                changemedicineDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }



    private fun fetchhealth(){
        Log.d("TAG", "fetchhealth: ")
        val doctor: doctor? = doctor.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_HEALTH, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchhealth Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchshealth Response ${t.getValues()}")
                changehealthDataDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }




    private fun fetchfitness(){
        Log.d("TAG", "fetchfitness: ")
        val doctor: doctor? = doctor.get()

        val dataService by lazy {
            DataFactory.create()
        }

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_FITNESS, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchfitness Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchfitness Response ${t.getValues()}")
                changefitnessDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }




    private fun changemedicineDataSet(gamesList: List<List<String>>?) {
        medicinesData.value = gamesList
    }
    private fun changehealthDataDataSet(Dealslist: List<List<String>>?) {
        healthData.value = Dealslist
    }
    private fun changehealthyfoodDataSet(socialmedialist: List<List<String>>?) {
        healthyfoodData.value = socialmedialist
    }
    private fun changefitnessDataSet(shoppingtoolslist: List<List<String>>?) {
        fitnessData.value = shoppingtoolslist
    }
    private fun changemostusefulappsDataSet(mostusefulappsList: List<List<String>>?) {
        mostusefulappsData.value = mostusefulappsList
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