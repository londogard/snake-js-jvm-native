enum class Direction(val dx: Int, val dy: Int) {
    // -->
    // |
    // v
    up(0, -1),
    down(0, 1),
    left(-1, 0),
    right(1, 0);

    fun isOppositeTo(that: Direction) =
        dx + that.dx == 0 && dy + that.dy == 0
}