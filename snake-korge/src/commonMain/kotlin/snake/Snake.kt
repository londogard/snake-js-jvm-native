data class Snake(
    val cells: List<Cell>,
    val direction: Direction,
    val eatenApples: Int = 0
) {
    val head: Cell = cells.first()
    val tail: List<Cell> = cells.drop(1)

    fun move(): Snake {
        val newHead = head.move(direction)
        val newTail = if (eatenApples == 0) cells.dropLast(1) else cells
        return copy(
            cells = listOf(newHead) + newTail,
            eatenApples = maxOf(0, eatenApples - 1)
        )
    }

    fun turn(newDirection: Direction?): Snake =
        if (newDirection == null || newDirection.isOppositeTo(direction)) this
        else copy(direction = newDirection)

    fun eat(apples: Apples): Pair<Snake, Apples> {
        if (head !in apples.cells) return Pair(this, apples)
        return Pair(
            copy(eatenApples = eatenApples + 1),
            apples.copy(cells = apples.cells - head)
        )
    }
}