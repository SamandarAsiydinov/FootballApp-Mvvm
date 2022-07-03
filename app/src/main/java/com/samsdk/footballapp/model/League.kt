package com.samsdk.footballapp.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

data class League(
    val `data`: List<Data>,
    val status: Boolean
)
@Parcelize
@Entity(tableName = "football")
data class Data(
    @PrimaryKey(autoGenerate = true)
    var _id: Int,
    val id: String,
    val abbr: String,
    @Embedded
    val logos: Logos,
    val name: String,
    val slug: String
): Parcelable
@Parcelize
data class Logos(
    val dark: String,
    val light: String
): Parcelable