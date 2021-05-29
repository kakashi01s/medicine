package job.search.visa.global.check.migration.internship.news.usa.food.shop.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DataFactory {

//    HOME
    val URL_ALL_APPS = BASE_URL + "1zWx_2607By2MWLQQnVeb96qk_n3ekGUxw8TozoeVyzQ/values/Sheet1!A2:E/"
    val URL_CAROUSEL_IMAGES = BASE_URL + "1OkgCsFJDSbGXFJYTULENJvBLjG6jjBxOc8MO4mVlF38/values/Sheet1!A2:E/"
    val URL_TOP_INTERNATIONAL = BASE_URL + "1KwMRcmA7czztXROmgD-hpcJqh2gQCwojEeRzDA8uAkY/values/Sheet1!A2:E/"

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

    val URL_CONTINENTAL_CARD = BASE_URL + "1tp9ke_1ZmiLmtk1QEo8zXUAtmqO904sWqUpqJMYAQ5s/values/Sheet1!A2:D/"

    val URL_CARD_START = BASE_URL
    val URL_CARD_END = "/values/Sheet1!A2:E/"
//    VISA
    val URL_VISA = BASE_URL + "1uSSHhwbzUMwDSWewo0EizH5puLy6oDDs92iCu9r7igE/values/Sheet1!A2:E/"
    val URL_TRAVEL = BASE_URL + "1KsRKvUYkWVlV7ncxd1hRmhnRDMPMt5ueBplvVu7q4a0/values/Sheet1!A2:E/"
    val URL_CITIZENSHIP = BASE_URL + "1ptq-2-VFItR_GLRiJ6f3x9GeR3dYYAc4OCfmpLTagfs/values/Sheet1!A2:E/"
    val URL_MIGRATION = BASE_URL + "1CKTNcByzf-6o36L5bwvg-cqDOKTVvKlSsG3DlCtp7sI/values/Sheet1!A2:E/"
    val URL_NEWS = BASE_URL + "1dhDzgLIHZg1FZqjBLYqmT8YNOqav8QpHH0BsItMs12M/values/Sheet1!A2:E/"
    val URL_WEATHER = BASE_URL + "1odaLwWZkZi14OESX2TTHfJUx9thwIZwgUUo7wm0SmMA/values/Sheet1!A2:E/"
    val URL_GLOBALUNIVERSITY = BASE_URL + "1oDwWDDO1gAMKd1AJ5ugU57MyVwdQH-Ee_icQCrRXKy0/values/Sheet1!A2:E/"


//    TOOLS

    val URL_DEALS = BASE_URL + "1-lbC0nk0xSYMPDPVDkynxUEFvLDpDL06Lq2-AC98iqQ/values/Sheet1!A2:E/"
    val URL_SPORTS = BASE_URL + "1exDUxeV2mftXeyyrBw-A4syxr8FV_f-u5uV5h36dbmo/values/Sheet1!A2:E/"
    val URL_FOOD = BASE_URL + "1Nb-3_mA2dqQ4DnyKaGZHHl0RqFrhFa2uUPY7Z-U6W8M/values/Sheet1!A2:E/"
    val URL_GAMES = BASE_URL + "1CRax3ICXXrMhHeG2wfyakrmSDwPDruVvrTJ01JospQ0/values/Sheet1!A2:E/"
    val URL_SHOPPINGTOOLS = BASE_URL + "1LoZ0zxjSCpRMtIKTOe9OoDZ-O-v8JTxMH_BErVyuYcg/values/Sheet1!A2:E/"
    val URL_SOCIALMEDIA = BASE_URL + "1_WsMnRtAj9meo38TubXRFWQbOTWJaC-J-JAAFRi6iBk/values/Sheet1!A2:E/"
    val URL_MOSTUSEFULAPPS = BASE_URL + "1GBg0VGmeLj8bdW3RfzRui3poGCGPpi3H2sD4MseIt54/values/Sheet1!A2:E/"

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
