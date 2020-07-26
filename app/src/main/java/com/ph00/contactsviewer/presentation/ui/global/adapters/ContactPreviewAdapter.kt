package com.ph00.contactsviewer.presentation.ui.global.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ph00.contactsviewer.R
import com.ph00.contactsviewer.presentation.models.ContactPreview
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_contact_preview.view.*
import timber.log.Timber

class ContactPreviewAdapter(private val picasso: Picasso) :
    RecyclerView.Adapter<ContactPreviewAdapter.ContactPreviewViewHolder>() {

    var dataList = mutableListOf<ContactPreview>()
    var onItemClick: ((Int) -> Unit)? = null

    inner class ContactPreviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(dataList[adapterPosition].id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactPreviewViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_contact_preview,
                parent,
                false
            )
        )

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: ContactPreviewViewHolder, position: Int) {
        holder.apply {
            itemView.contact_name.text = dataList[position].name
            picasso
                .load(dataList[position].imageUri)
                .placeholder(R.drawable.default_user_img)
                .into(itemView.contact_img)
        }
    }

    fun setData(list: List<ContactPreview>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }

}