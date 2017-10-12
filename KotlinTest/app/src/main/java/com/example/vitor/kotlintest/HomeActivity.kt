package com.example.vitor.kotlintest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.example.vitor.kotlintest.Models.ItemLista
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.toast

class HomeActivity : AppCompatActivity() {
    private var adapter: ListAdapter? = null
    private var itens: ArrayList<ItemLista> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadData()
        adapter = ListAdapter(itens, this)

        listaItens.setOnCreateContextMenuListener(this)
        listaItens.adapter = adapter

        listaItens.setOnItemClickListener { parent, view, position, id ->
            val it = Intent(this, DetailsActivity::class.java)
            it.putExtra("name", (listaItens.getItemAtPosition(position) as ItemLista).name)
            it.putExtra("description", (listaItens.getItemAtPosition(position) as ItemLista).description)
            startActivity(it)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menu?.add(Menu.NONE, 1, Menu.NONE, "Menu contexto")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        var t = item?.menuInfo as AdapterView.AdapterContextMenuInfo

        toast((listaItens?.getItemAtPosition(t.position) as ItemLista).name)
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        toast("tst" + item.toString())
        return super.onOptionsItemSelected(item)
    }

    private fun loadData() {
        val it1 = ItemLista();
        it1.name = "Item teste 1"
        it1.description = "Descrição de teste do item 1"
        it1.imageUrl = "https://avatars0.githubusercontent.com/u/1446536?v=4&s=400"
        itens.add(it1)

        val it2 = ItemLista();
        it2.name = "Item teste 2"
        it2.description = "Descrição de teste do item 2"
        it2.imageUrl = "https://avatars0.githubusercontent.com/u/1446536?v=4&s=400"
        itens.add(it2)

        val it3 = ItemLista();
        it3.name = "Item teste 3"
        it3.description = "Descrição de teste do item 3"
        it3.imageUrl = "https://avatars0.githubusercontent.com/u/1446536?v=4&s=400"
        itens.add(it3)

        val it4 = ItemLista();
        it4.name = "Item teste 4"
        it4.description = "Descrição de teste do item 4"
        it4.imageUrl = "https://avatars0.githubusercontent.com/u/1446536?v=4&s=400"
        itens.add(it4)

        val it5 = ItemLista();
        it5.name = "Item teste 5"
        it5.description = "Descrição de teste do item 5"
        it5.imageUrl = "https://avatars0.githubusercontent.com/u/1446536?v=4&s=400"
        itens.add(it5)
    }
}
