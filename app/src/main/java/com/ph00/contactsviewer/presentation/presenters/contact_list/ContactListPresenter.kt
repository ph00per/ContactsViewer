package com.ph00.contactsviewer.presentation.presenters.contact_list

import com.ph00.contactsviewer.domain.usecases.GetContactListUseCase
import com.ph00.contactsviewer.presentation.presenters.contact_list.ContactListView
import com.ph00.contactsviewer.presentation.ui.utils.Screens
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import timber.log.Timber

@InjectViewState
class ContactListPresenter(
    private val getContactListUseCase: GetContactListUseCase,
    private val router: Router
) : MvpPresenter<ContactListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getContactListUseCase
            .execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { viewState.setContacts(it) }
            .subscribe()
    }

    fun itemClicked(id: Int) {
        router.navigateTo(Screens.ContactDetails(id))
    }

    fun onBackPressed() {
        router.exit()
    }

}