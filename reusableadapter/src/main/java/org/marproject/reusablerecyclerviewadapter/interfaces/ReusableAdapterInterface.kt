package org.marproject.reusablerecyclerviewadapter.interfaces

import androidx.recyclerview.widget.RecyclerView
import org.marproject.reusablerecyclerviewadapter.ReusableAdapter

interface ReusableAdapterInterface<T> {

    // set layout
    fun setLayout(layout: Int): ReusableAdapter<T>

    // filterable
    fun filterable(): ReusableAdapter<T>

    // append data
    fun addData(items: List<T>): ReusableAdapter<T>

    // realtime change
    fun updateData(item: T): ReusableAdapter<T>

    // adapter callback
    fun adapterCallback(adapterCallback: AdapterCallback<T>): ReusableAdapter<T>

    // layout orientation
    fun isVerticalView(isVertical: Boolean): ReusableAdapter<T>
    fun isHorizontalView(isHorizontal: Boolean): ReusableAdapter<T>

    // build view
    fun build(recyclerView: RecyclerView): ReusableAdapter<T>

}