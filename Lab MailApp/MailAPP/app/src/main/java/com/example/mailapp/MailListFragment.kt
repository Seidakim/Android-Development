package com.example.mailapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

interface ClickListener {
    fun onClickListener(mail: Mail)
}

class MailListFragment : Fragment(),ClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mails = ArrayList<Mail>()

        mails.add(Mail("Oliver","birthday in my house","September 15","Happy birthday! Today, I would advise you to be nice to your kids. Remember, the older you get, the closer you get to having them choose a nursing home."))
        mails.add(Mail("Jake","party in University","June 27","Happy birthday! Today, I would advise you to be nice to your kids. Remember, the older you get, the closer you get to having them choose a nursing home."))
        mails.add(Mail("Noah","preparation for exam","March 15","Happy birthday! Today, I would advise you to be nice to your kids. Remember, the older you get, the closer you get to having them choose a nursing home."))
        mails.add(Mail("James","book your recommended","April 15","Happy birthday! Today, I would advise you to be nice to your kids. Remember, the older you get, the closer you get to having them choose a nursing home."))
        mails.add(Mail("Jack","car your bought","July 4","Happy birthday! Today, I would advise you to be nice to your kids. Remember, the older you get, the closer you get to having them choose a nursing home."))
        mails.add(Mail("Connor","English grammar lesson","December 25","Happy birthday! Today, I would advise you to be nice to your kids. Remember, the older you get, the closer you get to having them choose a nursing home."))
        mails.add(Mail("Harry","She went to school","March 7",":Happy birthday! Today, I would advise you to be nice to your kids. Remember, the older you get, the closer you get to having them choose a nursing home."))
        mails.add(Mail("Jacob","Weather was sunny","February 18","Happy birthday! Today, I would advise you to be nice to your kids. Remember, the older you get, the closer you get to having them choose a nursing home."))
        mails.add(Mail("Mason","Teacher sent assignment","July 12","Happy birthday! Today, I would advise you to be nice to your kids. Remember, the older you get, the closer you get to having them choose a nursing home."))

        val view = inflater.inflate(R.layout.fragment_mail_list, container, false)

        val recycleView = view.findViewById<RecyclerView>(R.id.recycle_view)
        recycleView.adapter = MailListAdapter(mails, view.context, this)
        recycleView.layoutManager = LinearLayoutManager(view.context)

        return view
    }



    override fun onClickListener(mail: Mail) {
        this.activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.container, MailDetailFragment(mail))
            .addToBackStack(null)
            .commit()
    }

}