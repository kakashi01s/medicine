package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view

import android.os.Bundle
import android.os.Handler
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.BaseActivity

class SplashActivity : BaseActivity() {
    override val bindingVariable: Int
        get() = 0
    override val layoutId: Int
        get() = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            openActivity(null, MainActivity::class.java)
            finish()
        }, 3000)


    }
}