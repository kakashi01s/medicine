package food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.adapter

import android.content.Context
import android.view.ViewGroup
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.base.adapter.GenericRecyclerAdapter
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.listener.CategoryStoresItemClickListener
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.viewholder.CategoryStoresViewHolder
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.R

class CategoryStoresAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, CategoryStoresItemClickListener<List<String>>, CategoryStoresViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryStoresViewHolder {
        return CategoryStoresViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}