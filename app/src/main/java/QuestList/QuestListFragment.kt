package QuestList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import ua.sergeylevchenko.ret.QuestApp
import ua.sergeylevchenko.ret.R


class QuestListFragment: Fragment(R.layout.fragment_quest_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questListViewModel = ViewModelProvider.of().get(QuestListViewModel::class.java)
        questListViewModel.fetchQuestList((activity?.application as? QuestApp)?.questApi)
    }

}


