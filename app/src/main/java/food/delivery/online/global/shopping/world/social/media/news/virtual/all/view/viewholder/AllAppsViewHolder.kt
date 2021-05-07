package food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.R


class AllAppsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var ivAllAppsPortal: ImageView? = null
    var tvPortalName: TextView? = null
    var cvPortal: CardView? = null

    init {
        ivAllAppsPortal = itemView?.findViewById(R.id.ivAllAppsPortal)
        tvPortalName = itemView?.findViewById(R.id.tvPortalName)
        cvPortal = itemView?.findViewById(R.id.cvAllAppsPortal)
    }
}