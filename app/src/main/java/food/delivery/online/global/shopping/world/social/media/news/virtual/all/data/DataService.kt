package food.delivery.online.global.shopping.world.social.media.news.virtual.all.data

import food.delivery.online.global.shopping.world.social.media.news.virtual.all.model.AllAppsModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface DataService {
    @GET
    fun fetchAllApps(@Url url: String, @Query("key") key: String): Observable<AllAppsModel>

}