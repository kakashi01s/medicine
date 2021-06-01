package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.adapter

import android.content.Context
import android.view.ViewGroup
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.adapter.GenericRecyclerAdapter
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.listener.BookLabClickListener
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.viewholder.LiveNewsViewHolder

class BookLabAdapter(context: Context?) :
    GenericRecyclerAdapter<List<String>, BookLabClickListener<List<String>>, LiveNewsViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveNewsViewHolder {
        return LiveNewsViewHolder(inflate(R.layout.card_all_apps_portal_layout,parent))
    }
}