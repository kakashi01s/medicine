package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.Home

import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.listener.BaseRecyclerListener

interface TopInternationalClickListener <T> : BaseRecyclerListener {
    fun onTopInernationalClickListener(item: T)
}