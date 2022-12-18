package core_data.event.exposed_db

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class SQLiteDatabase() {
    fun invoke() {
        Database.connect("jdbc:sqlite:./database/partyfinder.db", "org.sqlite.JDBC")

        transaction {
            // print sql to std-out
            addLogger(StdOutSqlLogger)

//            val joidRes = Debt.join(Item, JoinType.LEFT, additionalConstraint = {Debt.idItem eq Item.idItem})
//                .slice(Debt.bringIn, Item.name, Item.quantity)
//                .selectAll()
//                .groupBy(Item.name)

            val joidRes = UserToEvent
                .join(User, JoinType.LEFT, additionalConstraint = { UserToEvent.idUser eq User.idUser })
                .join(Event, JoinType.LEFT, additionalConstraint = { UserToEvent.idEvent eq Event.idEvent })
                .slice(Event.name, User.firstName, User.lastName, User.email)
                .selectAll()

            joidRes.forEach {
                println("${it.get(User.firstName)} ${it.get(User.lastName)}")
            }

            val listFromSql = EventType.selectAll().toList()
        }
    }
}


object EventType : Table(name = "event_type") {
    val idType: Column<Int> = integer("id_type").autoIncrement()
    val type: Column<String> = text("type")
    override val primaryKey = PrimaryKey(idType)
}

object Company : Table(name = "company") {
    val idCompany: Column<Int> = integer("id_company").autoIncrement()
    val name: Column<String> = text("name")
    val description: Column<String> = text("description")
    val usersNumber: Column<Int> = integer("users_number").check { it.between(0, 100) }
    override val primaryKey = PrimaryKey(idCompany)
}

object RoleType : Table(name = "role_type") {
    val idRole: Column<Int> = integer("id_role")
    val name: Column<String> = text("name")
    override val primaryKey = PrimaryKey(idRole)
}

object User : Table(name = "user") {
    val idUser: Column<Int> = integer("id_user")
    val firstName: Column<String> = text("first_name")
    val lastName: Column<String> = text("last_name")
    val nickname: Column<String> = text("nickname").uniqueIndex()
    val phone: Column<String> = text("phone").uniqueIndex()
    val email: Column<String> = text("email").uniqueIndex()
    val vkLink: Column<String> = text("VK_link")
    val telegramLink: Column<String> = text("Telegram_link")
    val twitterLink: Column<String> = text("Twitter_link")
    val password: Column<String> = text("password")
    override val primaryKey = PrimaryKey(idUser)
}

object UserToCompany : Table(name = "user_to_company") {
    val idUser: Column<Int> = integer("id_user").references(User.idUser)
    val idCompany: Column<Int> = integer("id_company").references(Company.idCompany)
    val idRole: Column<Int> = integer("id_role").references(RoleType.idRole)
}

object Event : Table(name = "event") {
    val idEvent: Column<Int> = integer("id_event").autoIncrement()
    val name: Column<String> = text("name")
    val description: Column<String> = text("description")
    val place: Column<String> = text("place")
    val timeAndDate: Column<String> = text("time_and_date")
    val idType: Column<Int> = integer("id_type").references(EventType.idType)
    override val primaryKey = PrimaryKey(idEvent)
}

object Item : Table(name = "item") {
    val idItem: Column<Int> = integer("id_item").autoIncrement()
    val name: Column<String> = text("name")
    val quantity: Column<String> = text("quantity")
    val costPerOne: Column<Int> = integer("cost_per_one")
    val currency: Column<Int> = integer("currency")
    override val primaryKey = PrimaryKey(idItem)
}

object Debt : Table(name = "debt") {
    val idDebt: Column<Int> = integer("id_debt").autoIncrement()
    val bringIn: Column<Int> = integer("bring_in")
    val idItem: Column<Int> = integer("id_item").references(Item.idItem)
    override val primaryKey = PrimaryKey(idDebt)
}

object UserToEvent : Table(name = "user_to_event") {
    val idUser: Column<Int> = integer("id_user").references(User.idUser)
    val idEvent: Column<Int> = integer("id_event").references(Event.idEvent)
    val idDebt: Column<Int> = integer("id_debt").references(Debt.idDebt)
    val idItem: Column<Int> = integer("id_item").references(Item.idItem)
}