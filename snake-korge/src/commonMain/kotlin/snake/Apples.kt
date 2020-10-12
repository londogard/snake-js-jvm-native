import kotlin.random.Random

data class Apples(
    val width: Int,
    val height: Int,
    val cells: Set<Cell> = emptySet(),
    val growthSpeed: Int = 3,
    val random: Random = Random
) {
    fun grow(): Apples {
        if (random.nextInt(10) >= growthSpeed) return this
        return copy(cells = cells + Cell(random.nextInt(width), random.nextInt(height)))
    }
}