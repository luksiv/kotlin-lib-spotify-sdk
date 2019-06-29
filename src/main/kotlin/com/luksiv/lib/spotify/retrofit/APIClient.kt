package com.luksiv.lib.spotify.retrofit

import com.luksiv.lib.spotify.entities.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIClient {

    // LIBRARY
    @GET("v1/me/tracks")
    suspend fun getCurrentUserSavedTracks(
        @Query("limit") limit: Int = 50
    ): Response<PagingObject<UserSavedTrack>>

    // SEARCH
    @GET("/v1/search/")
    suspend fun getSearchResults(
        @Query("q") query: String,
        @Query("type") type: String = "track",
        @Query("market") market: String = "US",
        @Query("limit") limit: Int = 50
    ): Response<SearchResponseObject>

    // TRACKS
    @GET("/v1/tracks/{id}")
    suspend fun getTrack(@Path("id") trackId: String): Response<TrackObject>


    // USER
    @GET("/v1/me")
    suspend fun getCurrentUserProfile(): Response<PrivateUserObject>

    @GET("/v1/users/{user_id}")
    suspend fun getUserProfile(@Path("user_id") userId: String): Response<PublicUserObject>
}
