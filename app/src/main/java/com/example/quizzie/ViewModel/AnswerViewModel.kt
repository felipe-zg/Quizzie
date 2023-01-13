package com.example.quizzie.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.quizzie.Data.QuizzieDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnswerViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Answer>>
    private val repository: AnswerRepository

    init {
        val answerDao = QuizzieDatabase.getDatabase(application).answerDao()
        repository = AnswerRepository(answerDao)
        readAllData = repository.readAllData
    }

    fun addAnswer(answer: Answer) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAnswer(answer)
        }
    }
}