package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener

import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.listener.BaseRecyclerListener

interface VisaClickListener<T> : BaseRecyclerListener {
    fun onVisaCardClickClickListener(item : T)
}