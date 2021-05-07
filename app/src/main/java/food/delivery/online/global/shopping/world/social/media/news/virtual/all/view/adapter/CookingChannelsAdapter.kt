package food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.adapter

import android.content.Context
import android.view.ViewGroup
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.base.adapter.GenericRecyclerAdapter
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.listener.CookingItemClickListener
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.viewholder.CookingChannelsViewHolder
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.R

class CookingChannelsAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, CookingItemClickListener<List<String>>, CookingChannelsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookingChannelsViewHolder {
        return CookingChannelsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}