package food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.adapter

import android.content.Context
import android.view.ViewGroup
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.base.adapter.GenericRecyclerAdapter
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.listener.MostUsefulAppsItemClickListener
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.viewholder.MostUsefulAppsViewHolder
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.R

class MostUsefulAppsAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, MostUsefulAppsItemClickListener<List<String>>, MostUsefulAppsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostUsefulAppsViewHolder {
        return MostUsefulAppsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}