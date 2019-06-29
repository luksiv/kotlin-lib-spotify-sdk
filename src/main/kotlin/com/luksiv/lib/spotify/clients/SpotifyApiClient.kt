package com.luksiv.lib.spotify.clients

import com.luksiv.lib.spotify.retrofit.APIClient
import com.luksiv.lib.spotify.retrofit.APIFactory

class SpotifyApiClient(accessToken: String) {

    private lateinit var apiClient: APIClient

    init {
        initApiClient(accessToken)
    }

    // SPOTIFY API CLIENT

    fun updateAccessToken(accessToken: String) {
        initApiClient(accessToken)
    }

    private fun initApiClient(accessToken: String) {
        apiClient = APIFactory(accessToken).createClient()
    }

    // LIBRARY
    suspend fun getCurrentUserSavedTracks() = apiClient.getCurrentUserSavedTracks()

    // SEARCH
    suspend fun getSearchResults(query: String, market: String) = apiClient.getSearchResults(query, market = market)

    // TRACKS
    suspend fun getTrack(trackId: String) = apiClient.getTrack(trackId)

    // USERS
    suspend fun getCurrentUserProfile() = apiClient.getCurrentUserProfile()
    suspend fun getUserProfile(userId: String) = apiClient.getUserProfile(userId)

}