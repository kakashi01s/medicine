package job.search.fantasy.hub.online.global.shopping.world.social.all.view

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.BaseActivity
import job.search.visa.global.check.migration.internship.news.usa.food.shop.model.AllAppsModel
import job.search.visa.global.check.migration.internship.news.usa.food.shop.viewmodel.HomeViewModel
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.MainActivity
import java.io.*

class SplashActivity : BaseActivity() {
    override val bindingVariable: Int
        get() = 0
    override val layoutId: Int
        get() = 0
    var homeViewModel: HomeViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel!!.loadData()
        Handler().postDelayed({
            val isFilePresent: Boolean = isFilePresent(this, "home.json")

            if (isFilePresent) {

//                  Intent to MainActivity
                openActivity(null, MainActivity::class.java)
                finish()

            } else {
                homeViewModel!!.allAppsLiveData.observe(this, Observer { t ->
                    val isFileCreated: Boolean = create(this, t!!,"home.json")
                    if (isFileCreated) {

//                      Intent to MainActivity
                        openActivity(null, MainActivity::class.java)
                        finish()
                    }
                    else{
                        Toast.makeText(applicationContext, "Network error, Please try again.", Toast.LENGTH_SHORT).show()
                    }
                })

            }

        }, 3000)


    }
    fun create(context: Context, allAppsModel: AllAppsModel, fileName: String): Boolean{
        return try {
            val fos: FileOutputStream = context.openFileOutput(fileName, MODE_PRIVATE)
            val os = ObjectOutputStream(fos)
            os.writeObject(allAppsModel)
            os.close()
            fos.close()
            true
        } catch (fileNotFound: FileNotFoundException) {
            false
        } catch (ioException: IOException) {
            false
        }
    }

    fun isFilePresent(context: Context, fileName: String): Boolean {
        val path = context.filesDir.absolutePath + "/" + fileName
        val file = File(path)
        return file.exists()
    }
}