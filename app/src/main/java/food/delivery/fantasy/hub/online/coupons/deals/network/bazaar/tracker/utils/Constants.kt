package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.utils

import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.BuildConfig


class Constants {

    val SHOW_ADS = "show_ads"

    val ADMOB_NATIVE_TEST = "ca-app-pub-3940256099942544/2247696110"
    val ADMOB_BANNER_TEST = "ca-app-pub-3940256099942544/6300978111"
    val ADMOB_INTERSTITIAL_TEST = "ca-app-pub-3940256099942544/1033173712"
    val ADMOB_NATIVE_HOME_1 = "ca-app-pub-9928966600221551/1829042715"
    val ADMOB_NATIVE_HOME_2 = "ca-app-pub-9928966600221551/4263634363"
    val ADMOB_NATIVE_CAT_1 = "ca-app-pub-9928966600221551/1637471027"
    val ADMOB_NATIVE_CAT_2 = "ca-app-pub-9928966600221551/4072062671"
    val ADMOB_BANNER_WEB = "ca-app-pub-9928966600221551/5550162854"
    val ADMOB_INTERSTITIAL_WEB_EXIT = "ca-app-pub-9928966600221551/4366564381"



    val FB_ADS_TEST = "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID"
    val FB_BANNER_TEST = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID"
    val FB_NATIVE_HOME_1 = "828299311359097_828300171359011"
    val FB_NATIVE_HOME_2 = "828299311359097_828300171359011"
    val FB_NATIVE_TOOL_1 = "828299311359097_828300171359011"
    val FB_NATIVE_TOOL_2 = "828299311359097_828300171359011"
    val FB_NATIVE_TOOL_3 = "828299311359097_828300171359011"
    val FB_NATIVE_CAT_1 = "828299311359097_828300171359011"
    val FB_NATIVE_CAT_2 = "828299311359097_828300171359011"
    val FB_NATIVE_CAT_3 = "828299311359097_828300171359011"
    val FB_NATIVE_CAT_4 = "828299311359097_828300171359011"

    val FB_NATIVE_CONTINENTAL_1 = "2779097785741248_2779099615741065"

    fun getNativeHome1(): String{
        return if (BuildConfig.DEBUG)
            ADMOB_NATIVE_TEST
        else
            ADMOB_NATIVE_HOME_1
    }

    fun getNativeHome2(): String{
        return if (BuildConfig.DEBUG)
            ADMOB_NATIVE_TEST
        else
            ADMOB_NATIVE_HOME_2
    }

    fun getNativeCat1(): String{
        return if (BuildConfig.DEBUG)
            ADMOB_NATIVE_TEST
        else
            ADMOB_NATIVE_CAT_1
    }

    fun getNativeCat2(): String{
        return if (BuildConfig.DEBUG)
            ADMOB_NATIVE_TEST
        else
            ADMOB_NATIVE_CAT_2
    }

    fun getBannerWeb(): String{
        return if (BuildConfig.DEBUG)
            ADMOB_BANNER_TEST
        else
            ADMOB_BANNER_WEB
    }

    fun getInterstitialWebExit(): String{
        return if (BuildConfig.DEBUG)
            ADMOB_INTERSTITIAL_TEST
        else
            ADMOB_INTERSTITIAL_WEB_EXIT
    }
    fun getFbNativeHome1(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_HOME_1
    }

    fun getFbNativeHome2(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_HOME_2
    }

    fun getFbNativeContinental(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_CONTINENTAL_1
    }
    fun getFbNativeTool1(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_TOOL_1
    }

    fun getFbNativeTool2(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_TOOL_2
    }
    fun getFbNativeTool3(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_TOOL_3
    }

    fun getFbNativeCat1(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_CAT_1
    }

    fun getFbNativeCat2(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_CAT_2
    }
    fun getFbNativeCat3(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_CAT_3
    }

    fun getFbNativeCat4(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_CAT_4
    }



}