package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.adapter

import android.content.Context
import android.view.ViewGroup
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.adapter.GenericRecyclerAdapter
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener.ToolsstoresClickListener import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder.ToolsstoresViewHolder

class ToolsstoresAdapter(context: Context?) :GenericRecyclerAdapter<List<String> , ToolsstoresClickListener<List<String>> , ToolsstoresViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolsstoresViewHolder {
        return ToolsstoresViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}
