package core_data.partyfinder_db.event

import core_data.DataSource
import core_data.exposed_db.Event
import core_data.exposed_db.EventType
import core_data.partyfinder_db.event.model.DataEvent
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.JoinType
import org.jetbrains.exposed.sql.Query
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class DbEventDataSource: DataSource<DataEvent> {

    override fun get(): List<DataEvent> {
        return transaction(
            Database.connect("jdbc:sqlite:./database/partyfinder.db", "org.sqlite.JDBC")
        ) {
            val query = Event
                .join(EventType, joinType = JoinType.INNER, additionalConstraint = { Event.idType eq EventType.idType })
                .slice(
                    Event.idEvent,
                    EventType.type,
                    Event.name,
                    Event.description,
                    Event.place,
                    Event.timeAndDate,
                )
                .selectAll()

            return@transaction QueryToDataEventList(query)
        }
    }

    override fun add(t: DataEvent) {
        TODO("Not yet implemented")
    }


}

object QueryToDataEventList {
    operator fun invoke(query: Query): List<DataEvent> {

        val list = mutableListOf<DataEvent>()

        for (row in query) {
            list.add(
                DataEvent(
                    id =  row.get(Event.idEvent),
                    type = row.get(EventType.type),
                    name = row.get(Event.name),
                    description = row.get(Event.description),
                    place = row.get(Event.place),
                    timeAndDate = row.get(Event.timeAndDate)
                )
            )
        }

        return list
    }
}