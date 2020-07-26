package com.ph00.contactsviewer.presentation.ui.contact_list

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ph00.contactsviewer.R
import com.ph00.contactsviewer.presentation.models.ContactPreview
import com.ph00.contactsviewer.presentation.presenters.contact_list.ContactListPresenter
import com.ph00.contactsviewer.presentation.presenters.contact_list.ContactListView
import com.ph00.contactsviewer.presentation.ui.global.BaseFragment
import com.ph00.contactsviewer.presentation.ui.global.adapters.ContactPreviewAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_contact_list.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class ContactListFragment : BaseFragment(),
    ContactListView {

    @InjectPresenter
    lateinit var presenter: ContactListPresenter

    @ProvidePresenter
    fun providePresenter(): ContactListPresenter = get()

    private val contactPreviewAdapter: ContactPreviewAdapter by inject()

    override val layoutRes = R.layout.fragment_contact_list

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        recycler.apply {
            adapter = contactPreviewAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        contactPreviewAdapter.onItemClick = {
            presenter.itemClicked(it)
        }
    }

    override fun setContacts(list: List<ContactPreview>) {
        contactPreviewAdapter.setData(list)
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }
}
