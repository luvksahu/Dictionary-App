package com.lks.dictionaryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvFind = findViewById<TextView>(R.id.tvFind);
        val btnFind = findViewById<Button>(R.id.btnFind);
        val tvOP = findViewById<TextView>(R.id.tvOP);
        val tvOutput = findViewById<TextView>(R.id.tvOutput);

        btnFind.setOnClickListener {
            val data = tvFind.text
            if(!Python.isStarted()){
                Python.start(AndroidPlatform(this))
                val py=Python.getInstance()
                val pyObj=py.getModule("dictionary")
                val obj=pyObj.callAttr("backEnd", data.toString())
                tvOutput.setText(obj.toString())
                tvOP.setText("You searched for: $data")
            }
            else{
                val py=Python.getInstance()
                val pyObj=py.getModule("dictionary")
                val obj=pyObj.callAttr("backEnd", data.toString())
                tvOutput.setText(obj.toString())
                tvOP.setText("You searched for: $data")
            }

        }
    }
}