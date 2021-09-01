package ua.sergeylevchenko.ret

import com.google.gson.annotations.SerializedName

data class QuestListResponse(val items: List<QuestListItem>)


data class QuestListItem(
    @SerializedName("questId")
    val questId: String,

    @SerializedName("questName")
    val name: String,

    @SerializedName("questSubtitle")
    val subtitle: String,

    @SerializedName("questImage")
    val image: String,

    @SerializedName("questDescription")
    val items: List<RemoteListItem>


)