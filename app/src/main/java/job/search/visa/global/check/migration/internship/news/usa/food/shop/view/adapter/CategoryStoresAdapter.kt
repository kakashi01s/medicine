package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.adapter

import android.content.Context
import android.view.ViewGroup
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.adapter.GenericRecyclerAdapter
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener.CategoryStoresItemClickListener
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder.CategoryStoresViewHolder
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R

class CategoryStoresAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, CategoryStoresItemClickListener<List<String>>, CategoryStoresViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryStoresViewHolder {
        return CategoryStoresViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}