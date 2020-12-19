package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener

import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.listener.BaseRecyclerListener

interface MostUsefulAppsItemClickListener <T> : BaseRecyclerListener {
    fun onMostUsefulAppsCardClick(item: T)
    fun onCookingChannelsCardClick(item: T)
}