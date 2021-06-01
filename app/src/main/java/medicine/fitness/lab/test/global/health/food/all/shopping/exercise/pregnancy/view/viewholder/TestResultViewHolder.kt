package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.viewholder

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.viewholder.BaseViewHolder
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.listener.BookLabClickListener
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.listener.TestResultClickListener

class TestResultViewHolder(itemView: View): BaseViewHolder<List<String>, TestResultClickListener<List<String>>>(itemView) {

    var ivPortalImage: ImageView? = null
    var tvPortalName: TextView? = null
    var cvPortal: CardView? = null

    init {
        ivPortalImage = itemView.findViewById(R.id.ivAllAppsPortal)
        tvPortalName = itemView.findViewById(R.id.tvPortalName)
        cvPortal = itemView.findViewById(R.id.cvAllAppsPortal)
    }


    override fun onBind(item: List<String>, listener: TestResultClickListener<List<String>>?) {

        Glide.with(ivPortalImage!!.context)
            .load(item.get(3))
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(ivPortalImage!!)

        tvPortalName?.setText(item.get(1))

        cvPortal?.setOnClickListener {
            Log.d("TAG", "onAllCardClick: "+item.get(1))
            listener?.onTestResultCardClick(item)
        }

    }
}