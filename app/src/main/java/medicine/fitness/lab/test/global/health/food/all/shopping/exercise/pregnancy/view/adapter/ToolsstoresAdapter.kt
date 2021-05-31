package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.adapter

import android.content.Context
import android.view.ViewGroup
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.adapter.GenericRecyclerAdapter
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.listener.ToolsstoresClickListener import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.viewholder.ToolsstoresViewHolder

class ToolsstoresAdapter(context: Context?) :GenericRecyclerAdapter<List<String> , ToolsstoresClickListener<List<String>> , ToolsstoresViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolsstoresViewHolder {
        return ToolsstoresViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}
