package core_data.event.model

data class DataEvent(
    val id: Long,
    val id_type: Long = 0,
    val name: String,
    val description: String,
    val place: String,
    val timeAndDate: String
)