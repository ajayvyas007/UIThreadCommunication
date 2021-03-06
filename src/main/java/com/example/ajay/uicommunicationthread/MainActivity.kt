package com.example.ajay.uicommunicationthread

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var th:Thread;
    lateinit var handler: Handler;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler()

        th = Thread(Runnable {
            for (x in 1..10){
                showData(x)
                showProgress(x)
                Thread.sleep(1000)
            }
        })

        th.start()

    }

    fun showData(a:Int){
        runOnUiThread { textView.setText(Integer.toString(a)) }
    }

    fun showProgress(a:Int){
        handler.postDelayed(Runnable(){
            run { textView2.setText(Integer.toString(a)) }
        },100);
    }
}
