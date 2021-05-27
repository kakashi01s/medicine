package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.adapter

import android.content.Context
import android.view.ViewGroup
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.adapter.GenericRecyclerAdapter
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.listener.DealsclickListener
import job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder.DealsViewHolder
class DealsAdapter (context: Context?) :
        GenericRecyclerAdapter<List<String> , DealsclickListener<List<String>> , DealsViewHolder> (context){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsViewHolder {
                return DealsViewHolder(inflate(R.layout.fragment_tools, parent))
        }
}