package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.adapter

import android.content.Context
import android.view.ViewGroup
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.adapter.GenericRecyclerAdapter
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener.VisaClickListener
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder.VisaViewHolder

class VisaAdapter(context: Context?) :GenericRecyclerAdapter<List<String>, VisaClickListener<List<String>>, VisaViewHolder>(context)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisaViewHolder {
        return VisaViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}