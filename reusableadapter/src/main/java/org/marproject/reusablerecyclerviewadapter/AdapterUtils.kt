package org.marproject.reusablerecyclerviewadapter

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.marproject.reusablerecyclerviewadapter.interfaces.AdapterUtilsInterface

class AdapterUtils<T>(private var context: Context) : AdapterUtilsInterface<T> {

    // utils
    private lateinit var adapter: ReusableAdapter<T>
    private lateinit var layoutManager: LinearLayoutManager

    override fun setAdapter(adapter: ReusableAdapter<T>): AdapterUtils<T> {
        this.adapter = adapter
        return this
    }

    override fun isVerticalView(isVertical: Boolean): AdapterUtils<T> {
        layoutManager = if (isVertical) {
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        } else {
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        return this
    }

    override fun isHorizontalView(isHorizontal: Boolean): AdapterUtils<T> {
        layoutManager = if (isHorizontal) {
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        } else {
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
        return this
    }

    override fun build(recyclerView: RecyclerView) {
        recyclerView.apply {
            this.adapter = this@AdapterUtils.adapter
            this.layoutManager = this@AdapterUtils.layoutManager
        }
    }
}