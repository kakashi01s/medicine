package job.search.visa.global.check.migration.internship.news.usa.food.shop.data

import job.search.visa.global.check.migration.internship.news.usa.food.shop.model.AllAppsModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface DataService {
    @GET
    fun fetchAllApps(@Url url: String, @Query("key") key: String): Observable<AllAppsModel>

}