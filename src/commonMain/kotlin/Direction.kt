enum class Direction(val dx: Int, val dy: Int) {
    // -->
    // |
    // v
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    fun isOppositeTo(that: Direction) =
        dx + that.dx == 0 && dy + that.dy == 0
}