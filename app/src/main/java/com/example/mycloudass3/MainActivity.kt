package com.example.mycloudass3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.widget.Button
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

private lateinit var analytics: FirebaseAnalytics
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        analytics = Firebase.analytics

        btn1.setOnClickListener{

            selectcontentEvent("image1","ImageView","image")

        }


        btn2.setOnClickListener{

            trackscreenEvent()

        }


    }


    fun selectcontentEvent(id:String,name:String,contentType:String){

        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){
            param(FirebaseAnalytics.Param.ITEM_ID,id)
            param(FirebaseAnalytics.Param.ITEM_NAME,name)
            param(FirebaseAnalytics.Param.CONTENT_TYPE,contentType)
        }
    }

    fun trackscreenEvent(){

        analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){
            param(FirebaseAnalytics.Param.SCREEN_NAME,"main")
            param(FirebaseAnalytics.Param.SCREEN_CLASS,"mainActivity")
        }
    }






}