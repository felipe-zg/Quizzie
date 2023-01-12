package com.example.quizzie.Data

import androidx.room.TypeConverter
import com.google.gson.Gson

class ArrayListConverter {
    @TypeConverter
    fun fromAnswerArrayList(value: ArrayList<Answer>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toAnswerArrayList(value: Answer): ArrayList<Answer> {
        return try {
            Gson().fromJson<ArrayList<Answer>>(value) //using extension function
        } catch (e: Exception) {
            arrayListOf()
        }
    }
}