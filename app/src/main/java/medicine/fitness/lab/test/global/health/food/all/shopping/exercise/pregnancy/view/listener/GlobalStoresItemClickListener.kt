package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.listener

import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.listener.BaseRecyclerListener

interface GlobalStoresItemClickListener<T> : BaseRecyclerListener {
    fun CategoryStoresCardClick(item: T)
}