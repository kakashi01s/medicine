package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener

import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.listener.BaseRecyclerListener

interface CategoryStoresItemClickListener<T> : BaseRecyclerListener {
    fun CategoryStoresCardClick(item: T)
}