package com.samsdk.footballapp.model

data class Club(
    val `data`: DataClub,
    val status: Boolean
)
data class DataClub(
    val abbreviation: String,
    val name: String,
    val season: Int,
    val seasonDisplay: String,
    val standings: List<Standing>
)
data class Logo(
    val alt: String,
    val height: Int,
    val href: String,
    val lastUpdated: String,
    val rel: List<String>,
    val width: Int
)
data class Standing(
    val note: Note,
    val stats: List<Stat>,
    val team: Team
)
data class Stat(
    val abbreviation: String,
    val description: String,
    val displayName: String,
    val displayValue: String,
    val id: String,
    val name: String,
    val shortDisplayName: String,
    val summary: String,
    val type: String,
    val value: Int
)
data class Team(
    val abbreviation: String,
    val displayName: String,
    val id: String,
    val isActive: Boolean,
    val location: String,
    val logos: List<Logo>,
    val name: String,
    val shortDisplayName: String,
    val uid: String
)
data class Note(
    val color: String,
    val description: String,
    val rank: Int
)