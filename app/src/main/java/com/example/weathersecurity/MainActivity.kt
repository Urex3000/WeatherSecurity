package com.example.weathersecurity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isNotEmpty
import androidx.viewpager2.widget.ViewPager2
import com.example.weathersecurity.Fragments.Adapter.Adapter
import com.example.weathersecurity.Fragments.FullDailyData
import com.example.weathersecurity.Fragments.MainFragment
import com.example.weathersecurity.Fragments.ViewModels.MainViewModel
import com.example.weathersecurity.Fragments.ViewModels.Repo
import com.example.weathersecurity.databinding.ActivityMainBinding
val myViewModel: MainViewModel = MainViewModel(repo = Repo())
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //ViewPager start
        val myViewPager2: ViewPager2 = findViewById(R.id.main_vp)
        val myAdapter = Adapter(getSupportFragmentManager(), lifecycle);
        myAdapter.addFragment(MainFragment());
        myAdapter.addFragment(FullDailyData());
        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        myViewPager2.setAdapter(myAdapter);
        //ViewPager end


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        val menuItem = menu?.findItem(R.id.bar_search)
        val searchView = menuItem?.actionView as SearchView
        searchView.queryHint = "Введите город..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (searchView.isNotEmpty()) {
                    if (query != null) {

                        myViewModel.loadData(query)

                    }
                    println("AAAAAAA $query")
                } else {
                    Toast.makeText(this@MainActivity, "Пустой запрос", Toast.LENGTH_LONG).show()
                }
                return true
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        return true     //(super.onCreateOptionsMenu(menu))
    }
}


//supportFragmentManager.beginTransaction().add(R.id.container, MainFragment(), "MainFragment").commit()
