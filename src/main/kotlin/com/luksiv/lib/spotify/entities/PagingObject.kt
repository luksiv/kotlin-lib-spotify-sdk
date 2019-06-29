package com.luksiv.lib.spotify.entities

data class SearchResponseObject(
    val tracks: PagingObject<TrackObject>,
    val artists: PagingObject<ArtistObject>,
    val albums: PagingObject<AlbumObject>
)

data class PagingObject<T>(
    val items: List<T>
)

data class UserSavedTrack(
    val addedAt: String,
    val track: TrackObject
)