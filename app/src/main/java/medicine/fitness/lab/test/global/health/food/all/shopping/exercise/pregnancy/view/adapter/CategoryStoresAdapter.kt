package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.adapter

import android.content.Context
import android.view.ViewGroup
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.adapter.GenericRecyclerAdapter
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.listener.GlobalStoresItemClickListener
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.viewholder.GlobalStoresViewHolder
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R

class CategoryStoresAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, GlobalStoresItemClickListener<List<String>>, GlobalStoresViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GlobalStoresViewHolder {
        return GlobalStoresViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}