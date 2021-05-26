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

    val URL_INDIA = BASE_URL + "1wcUzdb8NZjJNErZ5rzTgPt0E-J69vmLyy0H5XGpilBA/values/Sheet1!A2:E/"
    val URL_USA = BASE_URL + "1Dzru7d8G2SrQag_kHOaLvZSMRoYwRZ0VW26ol5QJAoA/values/Sheet1!A2:E/"
    val URL_RUSSIA = BASE_URL + "19hdD2CmpR8RyH2P9pCb8nerOPl_-NsJnYSyBW-vHTno/values/Sheet1!A2:E/"
    val URL_PAKISTAN = BASE_URL + "1gNoBCsNnz1i7IZi5gCoPRyOsP5edTbVAq-cbgrgzFIA/values/Sheet1!A2:E/"
    val URL_CHINA = BASE_URL + "15SzOuDAqLiP4KveraYspdDYDxds1Lb4BCrSF21I_mTk/values/Sheet1!A2:E/"
    val URL_GERMANY = BASE_URL + "124dfricQC7b4WWv-y4YbPC1NL0I8XahGxz-f9DwQVvE/values/Sheet1!A2:E/"
    val URL_TURKEY = BASE_URL + "1LpIuQJMF-KCkz9G-MD-P2Fll7itk4TJ9f54PciCkIQg/values/Sheet1!A2:E/"
    val URL_UAE = BASE_URL + "1oxY5Cuyp7Bgm1zwLNgDCfqzbwmdkvGSkAat-mQ6_XsI/values/Sheet1!A2:E/"
    val URL_ITALY = BASE_URL + "1_AC5nwdbq_kYbjB4-MpZoUhW4gTVaxwomE16WTkBNaA/values/Sheet1!A2:E/"
    val URL_SWITZERLAND = BASE_URL + "1DMg_JtaqypxJMEPR_CQhqgxtfTQnUavlnxTqOzqBsig/values/Sheet1!A2:E/"
    val URL_CANADA = BASE_URL + "15dsUSK4j4N5KsEWvZFJ9wYTT_xqdpLhuWs58iCA9qCo/values/Sheet1!A2:E/"
    val URL_SINGAPORE = BASE_URL + "1IhE9VNu--XMRArOhUyyrqFZfz74YUpxBgWGr0ksEAHI/values/Sheet1!A2:E/"
    val URL_SOUTH_AFRICA = BASE_URL + "1cwfn4BNOH7GiEkvV_1pga43oZRAAcX9cvkMO6r4Yyvs/values/Sheet1!A2:E/"
    val URL_FRANCE = BASE_URL + "1tEXVhQ4gbqnwmXNhW8RKs_-2c6wTUKct5LoKlwhuuAU/values/Sheet1!A2:E/"
    val URL_INDONECIA = BASE_URL + "1N7k8eXTY6wQ2yicQD_LQS_KCwTLbhxLVcS_3xiLFZkA/values/Sheet1!A2:E/"
    val URL_UK = BASE_URL + "1K3g1c-RABQj_3n008Pu7z_okD0UKE_lBK9UwH3D_5dE/values/Sheet1!A2:E/"
    val URL_JAPAN = BASE_URL + "1A98JMccc1LGINgstMu_Q9I-CXpyX4gf_2ayhxXjcLfQ/values/Sheet1!A2:E/"
    val URL_BRAZIL = BASE_URL + "1LG2WkOHRYpmNOe9jC3YP_bTHzrUpNs-ry8wtsgUkT0U/values/Sheet1!A2:E/"
    val URL_NIGERIA = BASE_URL + "1iEwQIFZDdd3Qj_yM27j-L8Gwv5GRAYbm8GuywXClwnE/values/Sheet1!A2:E/"
    val URL_PORTUGAL = BASE_URL + "1GLW8THEyf1N9IFzdcVh_zC9tbl6JOdmLxk-U7jOMuWg/values/Sheet1!A2:E/"
    val URL_GREECE = BASE_URL + "1CZnAjgaHk7gUS_c5SYpbEkErbvMSErcT0AZQGjHIFio/values/Sheet1!A2:E/"
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

    val URL_CURRENCY = BASE_URL + "1E2v__TgKGG6Fplyg2NntT9gvS-Otej3Fi9aV8yL9aTg/values/Sheet1!A2:E/"
    val URL_COOKING_CHANNELS = BASE_URL + "1OdCtZzvGoK5X0QUOZaTIc7t6Vl0ct63inQDzx5sPfrk/values/Sheet1!A2:E/"
    val URL_MOST_USEFUL_APPS = BASE_URL + "1cbygA6rvbwt3ANLNIUuuZVea9azX-C7x6TkvzUY5yo0/values/Sheet1!A2:E/"

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
