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

class ContinentalViewModel : ViewModel() {

    var continentalCardsData: MutableLiveData<List<List<String>>?> = MutableLiveData()
    var dialogData: MutableLiveData<List<List<String>>?> = MutableLiveData()

    private var context: Context? = null
    var compositeDisposable: CompositeDisposable? = null

    fun loadData(){
        Log.d("TAG", "loadData: ")
        compositeDisposable = CompositeDisposable()
        fetchContinentalCards()
    }

    private fun fetchContinentalCards(){
        val gov: gov? = gov.get()
        val dataService: DataService? = gov!!.getDataService()
        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_CONTINENTAL_CARD, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
            })
            ?.subscribe(Consumer { t ->
                changeContinentalCardsDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    fun changeContinentalCardsDataSet(allAppsList: List<List<String>>?){
        continentalCardsData.value = allAppsList
    }

    fun fetchDialog(String: String) {
        Log.d("TAG", "fetchLatest Dialog: ")
        val gov: gov? = gov.get()
        val dataService: DataService? = gov!!.getDataService()

        val disposable: Disposable?
        disposable = dataService?.fetchAllApps(DataFactory().URL_CARD_START + String + DataFactory().URL_CARD_END, DataFactory().KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnError(Consumer { t ->
                Log.d("TAG", "fetchLatest Dialog Error ${t.localizedMessage}")
            })
            ?.subscribe(Consumer { t ->
                Log.d("TAG", "fetchLatest Dialog Response ${t.getValues()}")
                changeDialogDataSet(t.getValues())
            })

        if (disposable != null) {
            compositeDisposable?.add(disposable)
        }
    }

    fun changeDialogDataSet(List: List<List<String>>?){
        dialogData.value = List
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