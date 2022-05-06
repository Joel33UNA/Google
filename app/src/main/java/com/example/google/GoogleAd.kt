package com.example.google

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class GoogleAd : AppCompatActivity() {
    lateinit var mAdView : AdView
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_ad)

        val btnMapView : Button = findViewById<Button>(R.id.btnMapView)
        btnMapView.setOnClickListener{ showInterstitialAd() }

        loadBannerAd()
        loadInterstitialAd()
    }

    private fun loadBannerAd(){
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Toast.makeText(this@GoogleAd, "onAdLoaded()", Toast.LENGTH_SHORT).show()
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
                Toast.makeText(this@GoogleAd, "onAdFailedToLoad()", Toast.LENGTH_SHORT).show()
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Toast.makeText(this@GoogleAd, "onAdOpened()", Toast.LENGTH_SHORT).show()
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Toast.makeText(this@GoogleAd, "onAdClicked()", Toast.LENGTH_SHORT).show()
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Toast.makeText(this@GoogleAd, "onAdClosed()", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadInterstitialAd(){
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }
        })
    }

    private fun showInterstitialAd(){
        if(mInterstitialAd != null){
            mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback(){
                override fun onAdClicked() {
                    super.onAdClicked()
                    Toast.makeText(this@GoogleAd, "onAdClicked()", Toast.LENGTH_SHORT).show()
                }

                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()
                    Toast.makeText(this@GoogleAd, "onAdDismissedFullScreenContent()", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@GoogleAd, GoogleMaps::class.java))
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    super.onAdFailedToShowFullScreenContent(p0)
                    Toast.makeText(this@GoogleAd, "onAdFailedToShowFullScreenContent()", Toast.LENGTH_SHORT).show()
                }

                override fun onAdImpression() {
                    Toast.makeText(this@GoogleAd, "onAdImpression()", Toast.LENGTH_SHORT).show()
                    super.onAdImpression()
                }

                override fun onAdShowedFullScreenContent() {
                    Toast.makeText(this@GoogleAd, "onAdShowedFullScreenContent()", Toast.LENGTH_SHORT).show()
                    super.onAdShowedFullScreenContent()
                }
            }
            mInterstitialAd?.show(this)
        }
        else{
            startActivity(Intent(this, GoogleMaps::class.java))
        }
    }
}