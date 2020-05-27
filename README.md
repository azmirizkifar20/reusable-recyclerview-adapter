# Reusable Recyclerview Adapter

An Android libs for recyclerview adapter including support filterable data for searchview or material search bar. So you don't need to create class adapter if want to use recyclerview.
<br><br>*Sebuah library Android untuk adapter recyclerview termasuk mendukung filterable data untuk penggunaan searchview atau material search bar. Jadi anda tidak perlu membuat class adapter jika ingin menggunakan recyclerview.*

## Support 
Support from Android 4.4 KitKat / Minimum API 19
<br>*Dukungan mulai Android versi 4.4 KitKat / Minimal API 19*

## Installing 
Add repository in build.gradle
<br>*Tambahkan repository di build.gradle*
```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```
And add dependencies
<br>*Dan tambahkan dependencies*
```gradle
dependencies {
    implementation 'androidx.recyclerview:recyclerview:1.1.0'
    implementation 'com.github.azmirizkifar20:reusable-recyclerview-adapter:1.0.0'
}
```

## Sample Code 
### #1 Create xml item
```item_negara.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="16dp"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tv_nama_negara"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Nama negara"
        android:textColor="@android:color/black"
        android:textSize="18sp" />

    <TextView
        android:id="@+id/tv_ibukota"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Ibukota"
        android:textSize="16sp" />

</LinearLayout>
```

### #2 Create xml view
```activity_main.xml
<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_negara"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:listitem="@layout/item_negara" />
```

### #3 Create data
```MainActivity.kt
val listNegara = mutableListOf(
    Negara("Indonesia", "jakarta"),
    Negara("Malaysia", "Kuala Lumpur"),
    Negara("Thailand", "Bangkok"),
    Negara("Vietnam", "Hanoi"),
    Negara("Filipina", "Manila")
)
```

### #4 Setup adapter callback
```MainActivity.kt
// create adapter callback for init component
val adapterCallback = object : AdapterCallback<Negara> {
    override fun initComponent(itemView: View, data: Negara, itemIndex: Int) {
        itemView.tv_nama_negara.text = data.nama_negara
        itemView.tv_ibukota.text = data.ibukota
    }

    override fun onItemClicked(itemView: View, data: Negara, itemIndex: Int) {
        Toast.makeText(this@MainActivity, data.nama_negara, Toast.LENGTH_SHORT).show()
    }
}
```

### #5 setup recyclerview & adapter
```MainActivity.kt
// create and set adapter on recyclerview
val recyclerview = rv_negara
recyclerview.apply {
    this.layoutManager = LinearLayoutManager(this@MainActivity)

    this.adapter = ReusableAdapter<Negara>(R.layout.item_negara).apply {
        this.addData(listNegara)
        this.adapterCallback = adapterCallback
    }

}
```
