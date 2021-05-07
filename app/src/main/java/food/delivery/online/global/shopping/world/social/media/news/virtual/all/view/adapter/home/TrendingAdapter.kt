package food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.adapter.home

import android.content.Context
import android.view.ViewGroup
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.base.adapter.GenericRecyclerAdapter
import food.delivery.fantasy.hub.online.global.shopping.world.social.all.view.listener.Home.TopInternationalClickListener
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.viewholder.TopInternationalViewHolder
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.R


class TopInternationalAdapter (context: Context?) :
    GenericRecyclerAdapter<List<String>, TopInternationalClickListener<List<String>>, TopInternationalViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopInternationalViewHolder {
        return TopInternationalViewHolder(inflate(R.layout.card_trending_layout,parent))
    }
}