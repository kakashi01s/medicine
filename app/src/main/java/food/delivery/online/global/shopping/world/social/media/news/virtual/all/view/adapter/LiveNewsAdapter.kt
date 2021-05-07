package food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.adapter

import android.content.Context
import android.view.ViewGroup
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.base.adapter.GenericRecyclerAdapter
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.listener.LiveNewsItemClickListener
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.viewholder.LiveNewsViewHolder
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.R

class LiveNewsAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, LiveNewsItemClickListener<List<String>>, LiveNewsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveNewsViewHolder {
        return LiveNewsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}