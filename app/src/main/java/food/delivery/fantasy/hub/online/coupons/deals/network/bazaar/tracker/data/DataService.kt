package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.data

import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.model.AllAppsModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface DataService {
    @GET
    fun fetchAllApps(@Url url: String, @Query("key") key: String): Observable<AllAppsModel>

}