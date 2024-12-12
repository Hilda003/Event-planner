package com.example.eventplanner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Event(
    val name: String,
    val date: String,
    val location: String,
//    val description: String,
    val image: Int
) : Parcelable
