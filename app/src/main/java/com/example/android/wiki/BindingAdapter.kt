package com.example.android.wiki

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.wiki.network.ModelProperty
import com.example.android.wiki.overview.MyAdapter

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {

        // Загрузка изображения из Uri объекта в ImageView
        Glide.with(imgView.context)
            .load(imgUrl) // необходимо
            // необязательно
            .apply(
                RequestOptions()
                    // значок загрузки (анимация)
                .placeholder(R.drawable.loading_animation)
                    // значок ошибки
                .error(R.drawable.ic_broken_image))
            .into(imgView) // необходимо
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView : RecyclerView, data : List<ModelProperty>?) {
    val adapter = recyclerView.adapter as MyAdapter
    adapter.submitList(data) // обновили
}