package org.marproject.reusablerecyclerviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class ReusableAdapter<T>(
    private var layout: Int,
    private var filterable: Boolean = false
) : RecyclerView.Adapter<ReusableAdapter<T>.ViewHolder>(), Filterable {

    // utils
    var listData = mutableListOf<T>()
    var currentList = mutableListOf<T>()
    var adapterCallback: AdapterCallback<T>? = null

    // append data
    fun addData(items: List<T>) {
        listData = items as MutableList<T>
        currentList = listData
        notifyDataSetChanged()
    }

    // realtime change
    fun updateData(item: T) {
        if (!listData.contains(item)) {
            listData.add(item)
        } else {
            val index = listData.indexOf(item)
            listData[index] = item
        }

        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return if (filterable) currentList.size
        else listData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(this.layout, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (filterable) {
            adapterCallback?.initComponent(holder.itemView, currentList[position], position)
            holder.itemView.setOnClickListener {
                adapterCallback?.onItemClicked(it, currentList[position], position)
            }
        } else {
            adapterCallback?.initComponent(holder.itemView, listData[position], position)
            holder.itemView.setOnClickListener {
                adapterCallback?.onItemClicked(it, listData[position], position)
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val search = constraint?.toString()

                search?.let {
                    val resultList = mutableListOf<T>()
                    for (row in listData) {
                        if (row.toString().toLowerCase(Locale.ROOT).contains(search.toLowerCase(
                                Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    currentList = resultList
                } ?: run {
                    currentList = listData
                }

                val filterResults = FilterResults()
                filterResults.values = currentList

                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                currentList = results?.values as MutableList<T>
                notifyDataSetChanged()
            }

        }
    }
}