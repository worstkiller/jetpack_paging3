package com.vikas.paging3.view.room.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.vikas.paging3.R
import com.vikas.paging3.model.DoggoImageModel

class RoomDoggoImageAdapter :
    PagingDataAdapter<DoggoImageModel, RoomDoggoImageAdapter.DoggoImageViewHolder>(REPO_COMPARATOR) {

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<DoggoImageModel>() {
            override fun areItemsTheSame(oldItem: DoggoImageModel, newItem: DoggoImageModel) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: DoggoImageModel, newItem: DoggoImageModel) =
                oldItem.id == newItem.id
        }
    }

    override fun onBindViewHolder(holder: DoggoImageViewHolder, position: Int) {
        holder.bind(item = getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoggoImageViewHolder {
        return DoggoImageViewHolder.getInstance(parent)
    }

    /**
     * view holder class for doggo item
     */
    class DoggoImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        companion object {
            //get instance of the DoggoImageViewHolder
            fun getInstance(parent: ViewGroup): DoggoImageViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.item_doggo_image_view, parent, false)
                return DoggoImageViewHolder(view)
            }
        }

        var ivDoggoMain: ImageView = view.findViewById(R.id.ivDoggoMain)

        fun bind(item: DoggoImageModel?) {
            //loads image from network using coil extension function
            ivDoggoMain.load(item?.url) { placeholder(R.drawable.doggo_placeholder) }
        }
    }

}