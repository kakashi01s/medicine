package food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.listener.ContinentalCardsListener
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.view.viewholder.ContinentalCardsViewHolder
import food.delivery.online.global.shopping.world.social.media.news.virtual.all.R

class ContinentalCardsAdapter(val context: Context?, val cardsList: List<List<String>>, val continentalCardsListener: ContinentalCardsListener) : RecyclerView.Adapter<ContinentalCardsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentalCardsViewHolder {
        return ContinentalCardsViewHolder(LayoutInflater.from(context).inflate(R.layout.card_continental_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ContinentalCardsViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: "+cardsList.size)
        Glide.with(context!!)
                .load(cardsList.get(position).get(3))
                .into(holder.ivCardIcon)

        holder.tvCardName.text = cardsList.get(position).get(1)

        holder.ivCardIcon.setOnClickListener{
            continentalCardsListener.onContinentalCardClick(cardsList.get(position))
        }
        holder.ivCardIcon.setOnClickListener{
            continentalCardsListener.onContinentalCardClick(cardsList.get(position))
        }
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }
}