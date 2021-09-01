package QuestList

import android.app.Application
import android.content.ClipData
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ua.sergeylevchenko.ret.QuestApi


class QuestListViewModel(application: Application) : AndroidViewModel(application) {

    val selected = MutableLiveData<ClipData.Item>()

    fun select(item: ClipData.Item) {
        selected.value = item
    }

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()

        super.onCleared()
    }

    fun fetchQuestList(questApi: QuestApi) {
        questApi.let {
            compositeDisposable.add(
                questApi.getQuestList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({

                    }, {

                    })
            )
        }


    }

}

