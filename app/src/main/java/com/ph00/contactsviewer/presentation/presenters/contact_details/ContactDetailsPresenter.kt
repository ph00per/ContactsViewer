package com.ph00.contactsviewer.presentation.presenters.contact_details

import com.ph00.contactsviewer.domain.usecases.GetContactDetailsUseCase
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import timber.log.Timber

@InjectViewState
class ContactDetailsPresenter(
    private val contactId: Int,
    private val getContactDetailsUseCase: GetContactDetailsUseCase,
    private val router: Router
) : MvpPresenter<ContactDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getContactDetailsUseCase
            .execute(contactId)
            .doOnSuccess { viewState.setContact(it) }
            .subscribe()
    }

    fun onBackPressed() {
        router.exit()
    }

}