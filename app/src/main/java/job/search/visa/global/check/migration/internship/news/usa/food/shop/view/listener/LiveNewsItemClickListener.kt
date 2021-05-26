package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener

import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.listener.BaseRecyclerListener

interface LiveNewsItemClickListener<T> : BaseRecyclerListener {
    fun onLiveNewsCardClick(item: T)
}