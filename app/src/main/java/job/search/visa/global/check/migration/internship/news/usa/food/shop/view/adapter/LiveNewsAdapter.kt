package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.adapter

import android.content.Context
import android.view.ViewGroup
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.adapter.GenericRecyclerAdapter
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener.LiveNewsItemClickListener
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder.LiveNewsViewHolder
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R

class LiveNewsAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, LiveNewsItemClickListener<List<String>>, LiveNewsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveNewsViewHolder {
        return LiveNewsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}