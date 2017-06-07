package com.example.jean.mytestproject

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.jean.mytestproject.domain.ForecastList
import com.example.jean.mytestproject.domain.RequestForecastCommand
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class ForecastActivity : Activity() {

    val forecastRecyclerView: RecyclerView by lazy { find<RecyclerView>(R.id.forecast_recycler_view) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        val dummyResult = ForecastList("", "", emptyList())
        forecastRecyclerView.layoutManager = LinearLayoutManager(this)
        forecastRecyclerView.adapter = ForecastRecyclerAdapter(dummyResult)

        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecastRecyclerView.adapter = ForecastRecyclerAdapter(result)
                forecastRecyclerView.adapter.notifyDataSetChanged()
            }
        }
    }
}
