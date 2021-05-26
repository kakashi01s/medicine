package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.adapter.home

import android.content.Context
import android.view.ViewGroup
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.adapter.GenericRecyclerAdapter
import job.search.fantasy.hub.online.global.shopping.world.social.all.view.listener.Home.TopInternationalClickListener
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder.TopInternationalViewHolder
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R


class TopInternationalAdapter (context: Context?) :
    GenericRecyclerAdapter<List<String>, TopInternationalClickListener<List<String>>, TopInternationalViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopInternationalViewHolder {
        return TopInternationalViewHolder(inflate(R.layout.card_trending_layout,parent))
    }
}