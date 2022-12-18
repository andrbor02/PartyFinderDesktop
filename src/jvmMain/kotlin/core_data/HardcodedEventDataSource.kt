package core_data.partyfinder_db.event.impl

import core_data.partyfinder_db.event.model.DataEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class HardcodedEventDataSource {

    private val eventList = listOf<DataEvent>(
        DataEvent(
            id = 0,
            name = "First",
            description = "First description",
            place = "43.20.45-42.26.55",
            timeAndDate = "23:00 16.12.2022"
        ),
        DataEvent(
            id = 1,
            name = "Second",
            description = "Second description",
            place = "44.25.45-42.26.55",
            timeAndDate = "22:00 17.12.2022"
        ),
        DataEvent(
            id = 3,
            name = "Third",
            description = "Third description",
            place = "45.20.45-42.26.55",
            timeAndDate = "21:00 16.12.2022"
        )
    )

    fun get(): List<DataEvent> {
        return eventList
    }
}