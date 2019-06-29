package com.luksiv.lib.spotify.entities

/**
 * @property id The Spotify ID for the album.
 * @property artists The artists of the album. Each artist object includes a link in href to more detailed information about the artist.
 * @property images The cover art for the album in various sizes, widest first.
 * @property name The name of the album. In case of an album takedown, the value may be an empty string.
 * @property tracks The tracks of the album wrapped in a PagingObject.
 * @property uri The Spotify URI for the album.
 */
data class AlbumObject(
    val id: String,
    val artists: List<ArtistObject>,
    val images: List<ImageObject>,
    val name: String,
    val uri: String
)