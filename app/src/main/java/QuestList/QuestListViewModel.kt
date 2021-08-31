package QuestList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ua.sergeylevchenko.ret.QuestApi


class QuestListViewModel(application: Application) : AndroidViewModel(application) {

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()

        super.onCleared()
    }

    fun fetchQuestList(questApi: QuestApi) {
        questApi.let {
            compositeDisposable.add(questApi.getQuestList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {

                })
            )
        }


    }

}

