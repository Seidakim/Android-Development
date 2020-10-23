package com.example.mailapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mails = ArrayList<Mail>()
        mails.add(Mail("Oliver","birthday in my house","September 15"))
        mails.add(Mail("Jake","party in University","June 27"))
        mails.add(Mail("Noah","preparation for exam","March 15"))
        mails.add(Mail("James","book your recommended","April 15"))
        mails.add(Mail("Jack","car your bought","July 4"))
        mails.add(Mail("Connor","English grammar lesson","December 25"))
        mails.add(Mail("Harry","She went to school","March 7"))
        mails.add(Mail("Jacob","Weather was sunny","February 18"))
        mails.add(Mail("Mason","Teacher sent assignment","July 12"))



        viewManager = LinearLayoutManager(this)
        viewAdapter = MailListAdapter(mails,this)

        recyclerView = findViewById<RecyclerView>(R.id.recycle_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }
}