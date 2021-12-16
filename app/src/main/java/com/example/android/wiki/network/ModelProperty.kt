package com.example.android.wiki.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 *  Класс данных Kotlin для хранения проанализированных данных JSON
 *  каждая из переменных соответствует имени ключа в объекте JSON
 */
@Parcelize
data class ModelProperty (
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String) : Parcelable
//    val image: String) //: Parcelable
{

}