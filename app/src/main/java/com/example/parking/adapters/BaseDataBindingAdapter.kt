package com.example.parking.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.parking.callback.BaseAdapterHandler
import com.example.parking.databinding.ChargeItemBinding

abstract class BaseDataBindingAdapter<T>(diffCallback: DiffUtil.ItemCallback<T>) : ListAdapter<T, BaseDataBindingViewHolder<T>>(diffCallback), BaseAdapterHandler<T> {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseDataBindingViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ChargeItemBinding.inflate(layoutInflater, parent, false)
        return setViewHolder(binding)
    }

    override fun setViewHolder(binding: ChargeItemBinding): BaseDataBindingViewHolder<T> {
        return BaseDataBindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseDataBindingViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }
}