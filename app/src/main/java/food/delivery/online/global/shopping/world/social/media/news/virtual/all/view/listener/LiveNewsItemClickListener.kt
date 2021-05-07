package food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.listener

import food.delivery.online.global.shopping.world.social.media.news.virtual.all.base.listener.BaseRecyclerListener

interface LiveNewsItemClickListener<T> : BaseRecyclerListener {
    fun onLiveNewsCardClick(item: T)
}