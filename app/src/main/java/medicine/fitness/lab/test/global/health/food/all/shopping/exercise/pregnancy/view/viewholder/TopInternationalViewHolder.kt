package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.viewholder.BaseViewHolder
import medicine.fitness.fantasy.hub.online.global.shopping.world.social.all.view.listener.Home.TopInternationalClickListener

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
            .load(item[3])
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(ivTrendingIcon!!)

        tvTrendingName!!.text = item[1]

        tvTrendingDesc!!.text = item[3]

        tvExplore!!.setOnClickListener {
            listener!!.onTopInernationalClickListener(item)
        }
    }

}