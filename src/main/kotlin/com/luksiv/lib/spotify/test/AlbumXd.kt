package com.luksiv.lib.spotify.test


import com.google.gson.annotations.SerializedName

data class AlbumXd(
    @SerializedName("album_type")
    val albumType: String,
    val artists: List<Artist>,
    @SerializedName("available_markets")
    val availableMarkets: List<String>,
    val copyrights: List<Copyright>,
    @SerializedName("external_ids")
    val externalIds: ExternalIds,
    @SerializedName("external_urls")
    val externalUrls: ExternalUrls,
    val genres: List<Any>,
    val href: String,
    val id: String,
    val images: List<Image>,
    val name: String,
    val popularity: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("release_date_precision")
    val releaseDatePrecision: String,
    val tracks: Tracks,
    val type: String,
    val uri: String
) {
    data class Artist(
        @SerializedName("external_urls")
        val externalUrls: ExternalUrls,
        val href: String,
        val id: String,
        val name: String,
        val type: String,
        val uri: String
    ) {
        data class ExternalUrls(
            val spotify: String
        )
    }

    data class Copyright(
        val text: String,
        val type: String
    )

    data class ExternalIds(
        val upc: String
    )

    data class ExternalUrls(
        val spotify: String
    )

    data class Image(
        val height: Int,
        val url: String,
        val width: Int
    )

    data class Tracks(
        val href: String,
        val items: List<Item>,
        val limit: Int,
        val next: Any?,
        val offset: Int,
        val previous: Any?,
        val total: Int
    ) {
        data class Item(
            val artists: List<Artist>,
            @SerializedName("available_markets")
            val availableMarkets: List<String>,
            @SerializedName("disc_number")
            val discNumber: Int,
            @SerializedName("duration_ms")
            val durationMs: Int,
            val explicit: Boolean,
            @SerializedName("external_urls")
            val externalUrls: ExternalUrls,
            val href: String,
            val id: String,
            val name: String,
            @SerializedName("preview_url")
            val previewUrl: String,
            @SerializedName("track_number")
            val trackNumber: Int,
            val type: String,
            val uri: String
        ) {
            data class Artist(
                @SerializedName("external_urls")
                val externalUrls: ExternalUrls,
                val href: String,
                val id: String,
                val name: String,
                val type: String,
                val uri: String
            ) {
                data class ExternalUrls(
                    val spotify: String
                )
            }

            data class ExternalUrls(
                val spotify: String
            )
        }
    }
}