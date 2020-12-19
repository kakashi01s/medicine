package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter.home

import android.content.Context
import android.view.ViewGroup
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.adapter.GenericRecyclerAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.AllAppsItemClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.viewholder.AllAppsViewHolder

class AllAppsAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, AllAppsItemClickListener<List<String>>, AllAppsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllAppsViewHolder {
        return AllAppsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}