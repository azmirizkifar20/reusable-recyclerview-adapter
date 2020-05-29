package org.marproject.reusablerecyclerviewadapter.interfaces

interface ReusableAdapterInterface<T> {

    // append data
    fun addData(items: List<T>)

    // realtime change
    fun updateData(item: T)

    // adapter callback
    fun adapterCallback(adapterCallback: AdapterCallback<T>)

}