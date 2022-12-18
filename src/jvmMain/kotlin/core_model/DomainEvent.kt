package feature_add.domain.model

data class DomainEvent(
    val id: Int,
    val type: String = "",
    val name: String,
    val description: String,
    val place: String,
    val timeAndDate: String
): DomainEntity
