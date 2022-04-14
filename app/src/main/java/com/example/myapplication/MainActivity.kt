package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    private var menu: Menu?=null;

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu,menu)
        this.menu=menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        var id:Int=item.itemId
        when(id)
        {
            R.id.action_translate ->
            {
                val translates = Intent(this, TranslateActivityJava::class.java);
                startActivity(translates);
            }
            R.id.action_help ->
            {
                val textView = findViewById<View>(R.id.text) as TextView
                textView.text = "I don't know why the Help button is needed"
            }

            R.id.action_about ->
            {
                val abouts = Intent(this, AboutActivity::class.java);
                startActivity(abouts);
            }

            R.id.action_quit->this.finish()
        }
        return super.onOptionsItemSelected(item)
    }

}