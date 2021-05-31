package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R


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