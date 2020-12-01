package com.example.mailapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class MailDetailFragment(val mail: Mail) : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_mail_detail, container, false)

        (view.findViewById(R.id.name) as TextView).text = mail.name
        (view.findViewById(R.id.title) as TextView).text = mail.title
        (view.findViewById(R.id.data) as TextView).text = mail.data
        (view.findViewById(R.id.message) as TextView).text = mail.message

        return view
    }


}