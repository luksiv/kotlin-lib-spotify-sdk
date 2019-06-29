package com.luksiv.lib.spotify.entities

/**
 *
 *
 * @property id	The Spotify ID for the artist.
 * @property name The name of the artist
 * @property type The object type: "artist"
 * @property uri The Spotify URI for the artist.
 * @property href A link to the Web API endpoint providing full details of the artist.
 * @property externalUrls Known external URLs for this artist.
 */
data class ArtistObject(
    val id: String,
    val name: String
)