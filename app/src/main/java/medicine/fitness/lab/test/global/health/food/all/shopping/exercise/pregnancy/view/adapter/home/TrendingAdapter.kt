package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.adapter.home

import android.content.Context
import android.view.ViewGroup
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.adapter.GenericRecyclerAdapter
import medicine.fitness.fantasy.hub.online.global.shopping.world.social.all.view.listener.Home.TopInternationalClickListener
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.viewholder.TopInternationalViewHolder
import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.R


class TopInternationalAdapter (context: Context?) :
    GenericRecyclerAdapter<List<String>, TopInternationalClickListener<List<String>>, TopInternationalViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopInternationalViewHolder {
        return TopInternationalViewHolder(inflate(R.layout.card_trending_layout,parent))
    }
}