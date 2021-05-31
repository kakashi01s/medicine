package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.data

import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.model.AllAppsModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface DataService {
    @GET
    fun fetchAllApps(@Url url: String, @Query("key") key: String): Observable<AllAppsModel>

}