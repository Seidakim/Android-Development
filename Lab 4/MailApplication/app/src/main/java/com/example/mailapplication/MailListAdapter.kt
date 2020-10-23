package com.example.mailapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MailListAdapter(val mails: ArrayList<Mail>, val context: Context):
    RecyclerView.Adapter<MailListAdapter.MyViewHolder>() {
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var nameText: TextView = view.findViewById(R.id.name)
        var titleText: TextView = view.findViewById(R.id.title)
        var dataText: TextView = view.findViewById(R.id.data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mail: Mail = mails.get(position)
        holder.nameText.text = mail.name
        holder.titleText.text = mail.title
        holder.dataText.text = mail.data
    }

    override fun getItemCount(): Int {
        return mails.size
    }
}