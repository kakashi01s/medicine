package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.adapter.home

import android.content.Context
import android.view.ViewGroup
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.adapter.GenericRecyclerAdapter
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.Home.TopInternationalClickListener
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.viewholder.TopInternationalViewHolder



class TopInternationalAdapter (context: Context?) :
    GenericRecyclerAdapter<List<String>, TopInternationalClickListener<List<String>>, TopInternationalViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopInternationalViewHolder {
        return TopInternationalViewHolder(inflate(R.layout.card_trending_layout,parent))
    }
}