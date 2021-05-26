package job.search.visa.global.check.migration.internship.news.usa.food.shop.utils

import job.search.visa.global.check.migration.internship.news.usa.food.shop.BuildConfig


class Constants {

    val SHOW_ADS = "show_ads"




    val FB_ADS_TEST = "VID_HD_9_16_39S_APP_INSTALL#YOUR_PLACEMENT_ID"
    val FB_BANNER_TEST = "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID"
    val FB_NATIVE_HOME_1 = "2960593130851961_2960594644185143"
    val FB_NATIVE_HOME_2 = "2960593130851961_2960596004185007"
    val FB_NATIVE_TOOL_1 = "2960593130851961_2960630357514905"
    val FB_NATIVE_TOOL_2 = "2960593130851961_2960630677514873"
    val FB_NATIVE_CAT_1 = "2960593130851961_2960596304184977"
    val FB_NATIVE_CAT_2 = "2960593130851961_2960596554184952"
    val FB_NATIVE_CAT_3 = "2960593130851961_2960596874184920"
       val FB_NATIVE_DAILOG = "2960593130851961_2960597260851548"
    val FB_NATIVE_CONTINENTAL_1 = "2960593130851961_3003511659893441"
    val FB_BANNER_WEB = "2960593130851961_2960598894184718"
    val FB_INTERSTITIAL_WEB_EXIT = "2960593130851961_2960599650851309"

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


    fun getFbNativeDailog(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_NATIVE_DAILOG
    }
    fun getFbBannerWeb(): String {
        return if (BuildConfig.DEBUG)
            FB_BANNER_TEST
        else
            FB_BANNER_WEB
    }

    fun getFbInterstitialWebExit(): String {
        return if (BuildConfig.DEBUG)
            FB_ADS_TEST
        else
            FB_INTERSTITIAL_WEB_EXIT
    }


}