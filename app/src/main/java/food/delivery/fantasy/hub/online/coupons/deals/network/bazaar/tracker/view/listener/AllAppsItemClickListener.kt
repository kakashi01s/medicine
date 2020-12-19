package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener

import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.listener.BaseRecyclerListener

interface AllAppsItemClickListener<T> : BaseRecyclerListener {
    fun onAllCardClick(item: T)
}