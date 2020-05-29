package org.marproject.reusablerecyclerviewadapter.interfaces

import androidx.recyclerview.widget.RecyclerView
import org.marproject.reusablerecyclerviewadapter.AdapterUtils
import org.marproject.reusablerecyclerviewadapter.ReusableAdapter

interface AdapterUtilsInterface<T> {

    // set adapter
    fun setAdapter(adapter: ReusableAdapter<T>): AdapterUtils<T>

    // set layout orientation
    fun isVerticalView(isVertical: Boolean): AdapterUtils<T>
    fun isHorizontalView(isHorizontal: Boolean): AdapterUtils<T>

    // build
    fun build(recyclerView: RecyclerView)
}