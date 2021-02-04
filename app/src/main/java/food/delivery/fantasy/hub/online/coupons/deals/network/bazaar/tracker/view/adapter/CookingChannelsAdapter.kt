package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter

import android.content.Context
import android.view.ViewGroup
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.adapter.GenericRecyclerAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.CookingItemClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.MostUsefulAppsItemClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.viewholder.CookingChannelsViewHolder
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.viewholder.MostUsefulAppsViewHolder

class CookingChannelsAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>,CookingItemClickListener<List<String>>,CookingChannelsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookingChannelsViewHolder {
        return CookingChannelsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}