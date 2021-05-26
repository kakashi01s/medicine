package job.search.visa.global.check.migration.internship.news.usa.food.shop.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import job.search.visa.global.check.migration.internship.news.usa.food.shop.R


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