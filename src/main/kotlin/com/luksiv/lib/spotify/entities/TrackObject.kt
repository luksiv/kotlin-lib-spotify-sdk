package com.luksiv.lib.spotify.entities

data class TrackObject(
    val id: String,
    val album: AlbumObject,
    val artists: List<ArtistObject>,
    val durationMs: Int,
    val explicit: Boolean,
    val name: String,
    val popularity: Int,
    val uri: String
)