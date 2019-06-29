package com.luksiv.lib.spotify.entities

data class PublicUserObject(
    val id: String,
    val displayName: String?,
    val images: List<ImageObject>,
    val uri: String
)