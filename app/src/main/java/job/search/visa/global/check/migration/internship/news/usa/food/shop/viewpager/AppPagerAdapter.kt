package job.search.visa.global.check.migration.internship.news.usa.food.shop.viewpager
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import job.search.visa.global.check.migration.internship.news.usa.food.shop.model.AllAppsModel
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.fragment.CategoryFragment
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.fragment.VisaFragment
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.fragment.HomeFragment
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.fragment.ToolsFragment

class AppPagerAdapter(fragmentManager: FragmentManager,val homeFragmentData: AllAppsModel?) : FragmentPagerAdapter(fragmentManager) {

    val NUM_ITEMS = 4;

    override fun getCount(): Int {
        return NUM_ITEMS
    }

    override fun getItem(position: Int): Fragment {
        when (position){
            0 -> {
                return VisaFragment.newInstance(position, "Continent")
            }
            1 -> {
                Log.d("HOme", homeFragmentData.toString())
                return HomeFragment.newInstance(position, "Home",homeFragmentData!!)
            }
            2 -> {
                return CategoryFragment.newInstance(position, "Global")
            }
            3 -> {
                return ToolsFragment.newInstance(position, "News")
            }

            else -> return HomeFragment.newInstance(position, "Home",homeFragmentData!!)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title : String? = null;
        if (position == 0) {
            title = "Visa"
        } else if (position == 1) {
            title = "Home"
        }
        else if (position == 2) {
            title = "Global"
        }
        else if (position == 3) {
            title = "Tools"
        }
        return title
    }
}