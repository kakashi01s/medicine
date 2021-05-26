package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.adapter

import android.content.Context
import android.view.ViewGroup
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.adapter.GenericRecyclerAdapter
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener.CookingItemClickListener
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder.CookingChannelsViewHolder
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R

class CookingChannelsAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, CookingItemClickListener<List<String>>, CookingChannelsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookingChannelsViewHolder {
        return CookingChannelsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}