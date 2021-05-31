package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.adapter

import android.content.Context
import android.view.ViewGroup
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.adapter.GenericRecyclerAdapter
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.listener.VisaClickListener
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.viewholder.VisaViewHolder

class VisaAdapter(context: Context?) :GenericRecyclerAdapter<List<String>, VisaClickListener<List<String>>, VisaViewHolder>(context)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VisaViewHolder {
        return VisaViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}