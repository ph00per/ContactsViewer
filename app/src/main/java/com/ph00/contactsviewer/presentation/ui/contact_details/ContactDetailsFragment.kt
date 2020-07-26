package com.ph00.contactsviewer.presentation.ui.contact_details

import android.os.Bundle
import com.ph00.contactsviewer.R
import com.ph00.contactsviewer.presentation.models.Contact
import com.ph00.contactsviewer.presentation.presenters.contact_details.ContactDetailsPresenter
import com.ph00.contactsviewer.presentation.presenters.contact_details.ContactDetailsView
import com.ph00.contactsviewer.presentation.ui.global.BaseFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_contact_details.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ContactDetailsFragment : BaseFragment(),
    ContactDetailsView {

    @InjectPresenter
    lateinit var presenter: ContactDetailsPresenter

    @ProvidePresenter
    fun providePresenter(): ContactDetailsPresenter =
        get { parametersOf(requireArguments().getInt(ARG_CONTACT_ID)) }

    private val picasso: Picasso by inject()

    override val layoutRes = R.layout.fragment_contact_details

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        back_btn.setOnClickListener { presenter.onBackPressed() }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun setContact(contact: Contact) {
        picasso.load(contact.imgUri)
            .placeholder(R.drawable.default_user_img)
            .into(contact_img)
        name.text = contact.name
        phone.text = contact.phone
        email.text = contact.email
    }

    companion object {
        private const val ARG_CONTACT_ID = "arg_contact_id"
        fun create(contactId: Int) =
            ContactDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_CONTACT_ID, contactId)
                }
            }
    }
}