package feature_add.domain.model

data class DomainItem (
    val idItem: Int = 0,
    val name: String,
    val quantity: String,
    val costPerOne: Int,
    val currency: String
): DomainEntity