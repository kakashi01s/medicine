package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R
import job.search.visa.global.check.migration.internship.news.usa.food.shop.base.viewholder.BaseViewHolder
import job.search.fantasy.hub.online.global.shopping.world.social.all.view.listener.Home.TopInternationalClickListener

class TopInternationalViewHolder(itemView: View?) :
    BaseViewHolder<List<String>, TopInternationalClickListener<List<String>>>(itemView) {

    var ivTrendingIcon: ImageView? = null
    var tvTrendingName: TextView? = null
    var tvTrendingDesc: TextView? = null
    var tvExplore: TextView? = null

    init {
        ivTrendingIcon = itemView?.findViewById(R.id.ivTrendingIcon)
        tvTrendingName = itemView?.findViewById(R.id.tvTrendingName)
        tvTrendingDesc = itemView?.findViewById(R.id.tvTrendingDesc)
        tvExplore = itemView?.findViewById(R.id.tvExplore)
    }

    override fun onBind(
        item: List<String>,
        listener: TopInternationalClickListener<List<String>>?
    ) {
        Glide.with(ivTrendingIcon!!.context)
            .load(item[4])
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(ivTrendingIcon!!)

        tvTrendingName!!.text = item[1]

        tvTrendingDesc!!.text = item[3]

        tvExplore!!.setOnClickListener {
            listener!!.onTopInernationalClickListener(item)
        }
    }

}