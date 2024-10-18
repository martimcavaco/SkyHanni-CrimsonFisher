package at.hannibal2.skyhanni.data

import at.hannibal2.skyhanni.utils.LorenzRarity
import at.hannibal2.skyhanni.utils.NEUInternalName

data class PetData(
    val internalName: NEUInternalName = NEUInternalName.NONE,
    val cleanName: String = "",
    val rarity: LorenzRarity = LorenzRarity.ULTIMATE,
    val petItem: NEUInternalName? = null,
    val level: Int = 0,
    val xp: Double = 0.0,
    val rawPetName: String = "",
) {
    override fun equals(other: Any?): Boolean {
        if (other !is PetData) return false
        return this.internalName == other.internalName &&
            this.cleanName == other.cleanName &&
            this.rarity == other.rarity &&
            this.petItem == other.petItem &&
            this.level == other.level &&
            this.rawPetName == other.rawPetName
    }

    override fun hashCode(): Int {
        var result = cleanName.hashCode()
        result = 31 * result + rarity.hashCode()
        result = 31 * result + (petItem?.hashCode() ?: 0)
        result = 31 * result + level
        result = 31 * result + rawPetName.hashCode()
        return result
    }
}