package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.viewpager
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.model.AllAppsModel
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.fragment.GlobalFragment
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.fragment.VisaFragment
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.fragment.HomeFragment
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.fragment.ToolsFragment

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
                return GlobalFragment.newInstance(position, "Global")
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
            title = "Lab Test"

        } else if (position == 1) {
            title = "Home"
        }
        else if (position == 2) {
            title = "Pregnancy"
        }
        else if (position == 3) {
            title = "Tools"
        }
        return title
    }
}