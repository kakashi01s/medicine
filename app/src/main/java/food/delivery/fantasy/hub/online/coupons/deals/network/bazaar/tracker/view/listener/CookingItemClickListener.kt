package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener

import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.listener.BaseRecyclerListener

interface CookingItemClickListener <T> : BaseRecyclerListener {

    fun onCookingChannelsCardClick(item: T)
}