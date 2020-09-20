data class Game(
    val width: Int,
    val height: Int,
    val snake: Snake,
    val apples: Apples = Apples(width, height)
) {
    val score = snake.cells.size
    val isOver =
        snake.tail.contains(snake.head) ||
                snake.cells.any {
                    it.x !in 0.until(width) || it.y !in 0.until(height)
                }

    fun update(direction: Direction?): Game {
        if (isOver) return this

        val (newSnake, newApples) = snake
            .turn(direction)
            .move()
            .eat(apples.grow())

        return copy(snake = newSnake, apples = newApples)
    }
}

