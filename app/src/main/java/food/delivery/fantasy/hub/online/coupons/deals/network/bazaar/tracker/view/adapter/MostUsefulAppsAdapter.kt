package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter

import android.content.Context
import android.view.ViewGroup
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.adapter.GenericRecyclerAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.MostUsefulAppsItemClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.viewholder.MostUsefulAppsViewHolder

class MostUsefulAppsAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, MostUsefulAppsItemClickListener<List<String>>, MostUsefulAppsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostUsefulAppsViewHolder {
        return MostUsefulAppsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}