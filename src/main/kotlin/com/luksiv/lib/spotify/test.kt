package com.luksiv.lib.spotify

import com.luksiv.lib.spotify.retrofit.APIFactory
import kotlinx.coroutines.*

fun main(args: Array<String>) {
    val accessToken =
        "BQDPAxgJ0_sJzlItJx_Iel3j6rsgFncM0USrP71l6YMrQZkc2kH3-lQTyIVb5nMG_sJnaaK7KeelGxkxBCZlWvesWhUN_0urIf0mW9ae6ySgFcZhmoKsOP14tOO5oArZfuVLijl4eAyUcfv1qPS6mD__1qOyFUBSoK63MGpYB9kaO6FTHoSMBCSzzA1fcUlGXAPi91WhqyQ4BU2XEdGV3dlGmsm2CQNxORYvsXavgs5Ij9tnHtY85owbPGjJr3wzAaBJuoCOWeRf2Q"

    val spotifyApiClient = APIFactory(accessToken).createClient()

    runBlocking(Dispatchers.IO) {
        launch {
            val me = spotifyApiClient.getCurrentUserProfile()
            println(me.body())
            println(me.body()?.canStreamTracks())
            val him = spotifyApiClient.getUserProfile("gqx83p6xzf9qs4owq4b2sn6ob")
            println(him.body())
            val track = spotifyApiClient.getTrack("1hyHkv7jFVX2O7It9PDfcc")
            println(track.body())
            val searchResult = spotifyApiClient.getSearchResults("Andr", "LT")
            println(searchResult.body())
            searchResult.body()?.tracks?.items?.sortedBy { it.popularity }?.forEach {
                println("${it.artists.first().name} - ${it.name} (${it.popularity})")
            }
            val userLib = spotifyApiClient.getCurrentUserSavedTracks()
            userLib.body()?.items?.forEach {
                println("${it.track.artists.first().name} - ${it.track.name} (${it.track.popularity})")
            }
//            userLib.body()?.items?.map{ it.track }?.forEach {
//            }
        }
    }
}