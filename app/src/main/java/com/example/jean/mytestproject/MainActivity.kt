package com.example.jean.mytestproject

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : Activity() {

    val adView: AdView by lazy { find<AdView>(R.id.adView) }
    val adRequest: AdRequest
        get() = AdRequest.Builder().build()
    val interstitialAd: InterstitialAd by lazy { InterstitialAd(this) }

    val button: Button by lazy { find<Button>(R.id.button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adView.loadAd(adRequest)
        interstitialAd.adUnitId = resources.getString(R.string.banner_ad_unit_id)
        interstitialAd.loadAd(AdRequest.Builder().build())

        button.setOnClickListener {
            if (interstitialAd.isLoaded) interstitialAd.show() else toast("not loaded")
        }
    }
}
