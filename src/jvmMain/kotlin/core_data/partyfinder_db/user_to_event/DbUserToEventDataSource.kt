package core_data.partyfinder_db

import core_data.exposed_db.Event
import core_data.exposed_db.User
import core_data.exposed_db.UserToEvent
import core_data.partyfinder_db.event.model.DataEvent
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.JoinType
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class DbUserToEventDataSource {

    fun getUserToEvent()/*: List<DataEvent>*/ {
        transaction(
            Database.connect("jdbc:sqlite:./database/partyfinder.db", "org.sqlite.JDBC")
        ) {
            val joidRes = UserToEvent
                .join(User, JoinType.LEFT, additionalConstraint = { UserToEvent.idUser eq User.idUser })
                .join(Event, JoinType.LEFT, additionalConstraint = { UserToEvent.idEvent eq Event.idEvent })
                .slice(Event.name, User.firstName, User.lastName, User.email)
                .selectAll()

            joidRes.forEach {
                println("${it.get(User.firstName)} ${it.get(User.lastName)}")
            }
        }
    }
}