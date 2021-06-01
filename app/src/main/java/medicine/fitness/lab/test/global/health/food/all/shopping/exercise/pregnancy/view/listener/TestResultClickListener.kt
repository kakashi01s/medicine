package medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.view.listener

import medicine.fitness.lab.test.global.health.food.all.shopping.exercise.pregnancy.base.listener.BaseRecyclerListener

interface TestResultClickListener<T> : BaseRecyclerListener {
    fun onTestResultCardClick(item: T)
}