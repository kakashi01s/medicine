package food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.viewholder

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.R
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.base.viewholder.BaseViewHolder
import food.delivery.fantasy.hub.online.coupons.deals.network.bazaar.tracker.view.listener.AllAppsItemClickListener

class AllAppsViewHolder(itemView: View?) :
    BaseViewHolder<List<String>, AllAppsItemClickListener<List<String>>>(itemView) {

    var ivAllAppsPortal: ImageView? = null
    var tvPortalName: TextView? = null
    var cvPortal: CardView? = null

    init {
        ivAllAppsPortal = itemView?.findViewById(R.id.ivAllAppsPortal)
        tvPortalName = itemView?.findViewById(R.id.tvPortalName)
        cvPortal = itemView?.findViewById(R.id.cvAllAppsPortal)
    }

    override fun onBind(item: List<String>, listener: AllAppsItemClickListener<List<String>>?) {

        Glide.with(ivAllAppsPortal!!.context)
            .load(item[3])
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(ivAllAppsPortal!!)

        tvPortalName?.setText(item.get(1))

        cvPortal?.setOnClickListener {
            Log.d("TAG", "onAllCardClick: "+item.get(1))
            listener?.onAllCardClick(item)
        }
    }
}