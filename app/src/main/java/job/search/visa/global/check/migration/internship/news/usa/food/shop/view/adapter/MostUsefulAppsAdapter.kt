package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.adapter

import android.content.Context
import android.view.ViewGroup
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.adapter.GenericRecyclerAdapter
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener.MostUsefulAppsItemClickListener
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder.MostUsefulAppsViewHolder
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R

class MostUsefulAppsAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, MostUsefulAppsItemClickListener<List<String>>, MostUsefulAppsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostUsefulAppsViewHolder {
        return MostUsefulAppsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}