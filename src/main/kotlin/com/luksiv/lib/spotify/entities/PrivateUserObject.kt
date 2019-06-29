package com.luksiv.lib.spotify.entities

data class PrivateUserObject(
    val id: String,
    val displayName: String,
    val email: String,
    val images: List<ImageObject>,
    val product: String,
    val uri: String
) {
    fun canStreamTracks() = product == "premium"
}