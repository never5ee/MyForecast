package com.example.myforecast.ui.forecast

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myforecast.R
import com.example.myforecast.adapter.CitiesAdapter
import com.example.myforecast.adapter.OnItemClickCallback
import com.example.myforecast.api.model.cities.Cities
import com.example.myforecast.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnItemClickCallback {

    private lateinit var cities: MutableList<Cities>
    private var citiesAdapter: CitiesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cities = MyCitiesList
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerCities)
        citiesAdapter = CitiesAdapter(cities, this)
        recyclerView.adapter = citiesAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(name: String) {
        startActivity(
            Intent(this, ForecastActivity::class.java)
                .apply {
                    putExtra(Constants.EXTRA_NAME, name)
                }
        )
    }

    val MyCitiesList: MutableList<Cities> = mutableListOf(
        Cities("Ivanovo" , R.drawable.baseline_cloud),
        Cities("Kalach" , R.drawable.baseline_cloud),
        Cities("Kaluga" , R.drawable.baseline_cloud),
        Cities("Lakinsk" , R.drawable.baseline_cloud),
        Cities("Leninogorsk" , R.drawable.baseline_cloud),
        Cities("Moscow" , R.drawable.baseline_cloud),
        Cities("Murmansk" , R.drawable.baseline_cloud),
        Cities("Navashino" , R.drawable.baseline_cloud),
        Cities("Pavlovsky Posad" , R.drawable.baseline_cloud),
        Cities("Penza" , R.drawable.baseline_cloud),
        Cities("Plyos" , R.drawable.baseline_cloud),
        Cities("Podolsk" , R.drawable.baseline_cloud),
        Cities("Primorsk" , R.drawable.baseline_cloud),
        Cities("Rostov-on-Don" , R.drawable.baseline_cloud),
        Cities("Shakhty" , R.drawable.baseline_cloud),
    )
}