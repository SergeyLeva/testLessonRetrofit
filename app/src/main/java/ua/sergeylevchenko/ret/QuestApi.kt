package ua.sergeylevchenko.ret

import retrofit2.http.GET
import  io.reactivex.Single

interface QuestApi {

    @GET("./getQuestList")
    fun getQuestList(): Single<QuestListResponse>
}