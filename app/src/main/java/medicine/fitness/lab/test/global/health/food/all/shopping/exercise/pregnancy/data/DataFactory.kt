package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DataFactory {

//    HOME
    val URL_ALL_APPS = BASE_URL + "1zWx_2607By2MWLQQnVeb96qk_n3ekGUxw8TozoeVyzQ/values/Sheet1!A2:E/"
    val URL_CAROUSEL_IMAGES = BASE_URL + "1OkgCsFJDSbGXFJYTULENJvBLjG6jjBxOc8MO4mVlF38/values/Sheet1!A2:E/"
    val URL_TOP_INTERNATIONAL = BASE_URL + "1KwMRcmA7czztXROmgD-hpcJqh2gQCwojEeRzDA8uAkY/values/Sheet1!A2:E/"

//    GLOBAL
    val URL_WEIGHT = BASE_URL + "1xo-dgBKr--VwRxTmaEMwXIJPw9Njn0KGLqt4958EB3Q/values/Sheet1!A2:E/"
    val URL_TEST = BASE_URL + "1BWJqfLtS7Rp5yyy3t9xnJdi8AGCYRo-_VQ1siXsu83k/values/Sheet1!A2:E/"
    val URL_SYMPTOMS = BASE_URL + "1npZ9KptW-6mnXN96XlCXHDETSieDrFIENcY8qpTyjQg/values/Sheet1!A2:E/"
    val URL_PREGNANCY_CALENDER = BASE_URL + "10tQK2GCZP1lWbeul-7QVnrWUoCsWaKIh0AyvTWx5QhE/values/Sheet1!A2:E/"
    val URL_PRECAUTIONS = BASE_URL + "1CqMG94ipgUDgeRXBfeFn3ws_EJ6AafGthceQLfdVmf8/values/Sheet1!A2:E/"
    val URL_MISCARRIAGE = BASE_URL + "1i_cI9XqOBnIwAuI8qBg6g3DSC_o65CuMU8JxwC9zsPI/values/Sheet1!A2:E/"
    val URL_EXERCIES = BASE_URL + "1fW45GI95Se9_Dwtabf8bSg9wUYSlr7LfcYJmqHun3Ro/values/Sheet1!A2:E/"
    val URL_DUEDATE = BASE_URL + "1oFapDs461a1cwa4S7hMl4gpR-D50b6LWAVHYrRwZLL8/values/Sheet1!A2:E/"
    val URL_DIET = BASE_URL + "1L73hrbhGKyw0uOoYLrGbqT3SSHoQqpQ9xLF5ClZijTk/values/Sheet1!A2:E/"
    val URL_CALCULATOR = BASE_URL + "1Ioe81i4B5-ASx2HpRxKbog0IYd5W2U5ZHvOOOYvC4tQ/values/Sheet1!A2:E/"
    val URL_AFTER = BASE_URL + "1d3i0u1oF0UixklFJEZtU6LJ6pBpgP4fl7jI6brMqhos/values/Sheet1!A2:E/"
    val URL_ADVICE = BASE_URL + "1Y1d599EdzIm8BQRZIiUEdgsn9LvrzUJqR1JNlLXGRnI/values/Sheet1!A2:E/"


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

    val URL_MEDICINE = BASE_URL + "1Qo31dfuPUmNa-Pd5vWMaxcidDSMRbhtE03wc8Z6ApoQ/values/Sheet1!A2:E/"
    val URL_HEALTH = BASE_URL + "1Jm6nChQHXH6zE9x7afocawOHEDeRIbjsI9f975-a2jg/values/Sheet1!A2:E/"
    val URL_FITNESS = BASE_URL + "1tpf4sZastciSSD9aOkOfAgS8XS_OKC6D0ENRPT-YxSs/values/Sheet1!A2:E/"
    val URL_HEALTHYFOOD = BASE_URL + "1kykyy8nh8Z72udd6qanWSFeA3TlIoZWpvpD6QXru0Qo/values/Sheet1!A2:E/"
    val URL_MOSTUSEFULAPPS = BASE_URL + "1cyp9bLtxqdbe_9zCvd8Igwnids4DffpMqo3M9ssRtgk/values/Sheet1!A2:E/"

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
