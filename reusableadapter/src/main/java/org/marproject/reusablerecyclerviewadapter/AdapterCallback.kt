package org.marproject.reusablerecyclerviewadapter

import android.view.View

interface AdapterCallback<T> {

    // setup init component
    fun initComponent(itemView: View, data: T, itemIndex: Int)

    // onclick listener
    fun onItemClicked(itemView: View, data: T, itemIndex: Int)
}