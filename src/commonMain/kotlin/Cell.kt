data class Cell(val x: Int, val y: Int) {
    fun move(direction: Direction) =
        Cell(x + direction.dx, y + direction.dy)
}