package job.search.visa.global.check.migration.internship.news.usa.food.shop.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DataFactory {

//    HOME

    val URL_ALL_APPS = BASE_URL + "1FWSgjbRXtaT_batfkiU2P4xBcIi9o-MpRjldxvLI_-U/values/Sheet1!A2:E/"
    val URL_CAROUSEL_IMAGES = BASE_URL + "1AFbXhOp_Lax8KJeAnW9LMkGxybrRhNGyqPIUVrY8ORU/values/Sheet1!A2:E/"
    val URL_TOP_INTERNATIONAL = BASE_URL + "1mjvyFhJ50639BiecWE175bKq_dwTK_H-g6haNMdYeK0/values/Sheet1!A2:E/"

//    GLOBAL

    val URL_INDIA = BASE_URL + "1tSO3Xq0bwVbj4tHe0BzcypQqdnD9bdH27D4VMF-HrkA/values/Sheet1!A2:E/"
    val URL_USA = BASE_URL + "1X24kzf_Cj9UARWIlnwCByH6Jy4pBU_hrysk8hk0TKbQ/values/Sheet1!A2:E/"
    val URL_RUSSIA = BASE_URL + "1qQuUOMVdO_ZjcQdZUGPcIt6HsIZRrQbch7gInnkuBf8/values/Sheet1!A2:E/"
    val URL_PAKISTAN = BASE_URL + "1ffZPUvxkVB-Ndf5x1HlhOI6RVUEzI8wVoXBr-R2blWY/values/Sheet1!A2:E/"
    val URL_CHINA = BASE_URL + "1s38_fHXC18GM29Wf3-l73PdKrYzDEMkEa4XXI4y6X44/values/Sheet1!A2:E/"
    val URL_GERMANY = BASE_URL + "124dfricQC7b4WWv-y4YbPC1NL0I8XahGxz-f9DwQVvE/values/Sheet1!A2:E/"
    val URL_TURKEY = BASE_URL + "1bELcA-ShYjYiVtpv1MqXKL9FeybsqKJMEVVbcdwYlgE/values/Sheet1!A2:E/"
    val URL_UAE = BASE_URL + "16HOyYQCCeGRsAnTKXeYdluVqrYQQUyl_SAxdVIiQkRM/values/Sheet1!A2:E/"
    val URL_ITALY = BASE_URL + "1wb3V4S-L6_b3W3NimUFMdiUn7WM7rlCnwNnAefydb7E/values/Sheet1!A2:E/"
    val URL_SWITZERLAND = BASE_URL + "1HQb4R91zgi_r2XrPhzgFlpf5gOJNKHOZJSg6xhBinMw/values/Sheet1!A2:E/"
    val URL_CANADA = BASE_URL + "1e_pxzxFCXHvSRaGjL2JLNBNJUA2DkCpWzehFMIaUqso/values/Sheet1!A2:E/"
    val URL_SINGAPORE = BASE_URL + "10I7cFMSD-1_21am0frqh4RLtyrPIewcO6tAUAHLevzM/values/Sheet1!A2:E/"
    val URL_SOUTH_AFRICA = BASE_URL + "1ZgYSVCi1n7FkFDubZ_15mqGLAadVQxty-Xncgy-giAU/values/Sheet1!A2:E/"
    val URL_FRANCE = BASE_URL + "1_4MYYFHjB4S0jrJqZUwyESd1Be093vxKm-tRgotp3Uk/values/Sheet1!A2:E/"
    val URL_INDONECIA = BASE_URL + "1ZjeRUtWG2gRozyVeojV-BJaPe0CuMexM9Ya_-Q_nDFo/values/Sheet1!A2:E/"
    val URL_UK = BASE_URL + "1WO33rGqT3cOybo_P2DaVzWlKS9wmXBNbWW4FPGkCXK0/values/Sheet1!A2:E/"
    val URL_JAPAN = BASE_URL + "1XxWxhO4pQr8dhU7_4IYRVEvHuVhlB6oZ8a2RJkpRDGI/values/Sheet1!A2:E/"
    val URL_BRAZIL = BASE_URL + "1KMMC45_f2NILqBN0j8P7u3Vd9lSi6BNPex0r39VM750/values/Sheet1!A2:E/"
    val URL_NIGERIA = BASE_URL + "1qbxEnHyM3sGae3p8XvphHvW8ammzHdjKdgpZETXOo0E/values/Sheet1!A2:E/"
    val URL_PORTUGAL = BASE_URL + "1dWjMIfmykTs4J-0amzwe0RLn9GSu-yVyvoN4ZZ9NrNo/values/Sheet1!A2:E/"
    val URL_GREECE = BASE_URL + "1qq0LvuIgLT2BQLmfYuukoDG7auqcnfoBEm7IvUVx_5M/values/Sheet1!A2:E/"
    val URL_AUSTRALIA = BASE_URL + "15rWJc1eGnSeJgdI8qofZXZU40YvgO71Wf8h4i2PQ9O4/values/Sheet1!A2:E/"

//    CONTINENTS

//    val URL_ASIA = BASE_URL + "1SRMmi-t_jTCsyvQ_A_CGZWvBWfuS1cvLy1q2ol2roOM/values/Sheet1!A2:E/"
//    val URL_AFRICA = BASE_URL + "1X_ZteL3l19y4C9D6vp-3mqi8oVwKeC3v2Uun_WZMsIc/values/Sheet1!A2:E/"
//    val URL_EUROPE = BASE_URL + "16PTjneWB4928P-JCFw6_b-YtYOUWiflQSzFwZuPI7Bo/values/Sheet1!A2:E/"
//    val URL_NORTH_AMERICA = BASE_URL + "1lAQ7MBtoaW9aEpQ6bkNHmqC8gvREJT9iuADqLWiP0X4/values/Sheet1!A2:E/"
//    val URL_SOUTH_AMERICA = BASE_URL + "1aHU-Rf_a3_kq2kch4BH7IIrh97L-gvEbVBcQSGI6dtU/values/Sheet1!A2:E/"

    val URL_CONTINENTAL_CARD = BASE_URL + "1tp9ke_1ZmiLmtk1QEo8zXUAtmqO904sWqUpqJMYAQ5s/values/Sheet1!A2:D/"

    val URL_CARD_START = BASE_URL
    val URL_CARD_END = "/values/Sheet1!A2:E/"

//    TOOLS

    val URL_DEALS = BASE_URL + "1-lbC0nk0xSYMPDPVDkynxUEFvLDpDL06Lq2-AC98iqQ/values/Sheet1!A2:E/"
    val URL_SPORTS = BASE_URL + "1exDUxeV2mftXeyyrBw-A4syxr8FV_f-u5uV5h36dbmo/values/Sheet1!A2:E/"
    val URL_FOOD = BASE_URL + "1Nb-3_mA2dqQ4DnyKaGZHHl0RqFrhFa2uUPY7Z-U6W8M/values/Sheet1!A2:E/"
    val URL_GAMES = BASE_URL + "1CRax3ICXXrMhHeG2wfyakrmSDwPDruVvrTJ01JospQ0/values/Sheet1!A2:E/"
    val URL_SHOPPINGTOOLS = BASE_URL + "1LoZ0zxjSCpRMtIKTOe9OoDZ-O-v8JTxMH_BErVyuYcg/values/Sheet1!A2:E/"
    val URL_SOCIALMEDIA= BASE_URL + "1_WsMnRtAj9meo38TubXRFWQbOTWJaC-J-JAAFRi6iBk/values/Sheet1!A2:E/"

    val KEY = "AIzaSyB21bRVxi8IVsINBqyRDKwq3b6bWr4gRys"

    companion object{
        private val BASE_URL = "https://sheets.googleapis.com/v4/spreadsheets/"

        fun create(): DataService? {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(DataService::class.java)
        }
    }
}
