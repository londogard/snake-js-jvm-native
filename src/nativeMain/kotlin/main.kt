import kotlinx.cinterop.memScoped
import ncurses.*
import Direction.*
import kotlinx.cinterop.CPointer


fun main(): Unit = memScoped {
    initscr()

    defer { endwin() }
    noecho()
    curs_set(0)
    halfdelay(2)

    var game = Game(
        width = 20,
        height = 10,
        snake = Snake(
            cells = listOf(Cell(4, 0), Cell(3, 0), Cell(2, 0), Cell(1, 0), Cell(0, 0)),
            direction = RIGHT
        )
    )

    val window = newwin(game.height + 2, game.width + 2, 0, 0)!!
    defer { delwin(window) }

    var input = 0
    while (input.toChar() != 'q') {
        window.draw(game)

        input = wgetch(window)
        val direction = when (input.toChar()) {
            'i'  -> UP
            'j'  -> LEFT
            'k'  -> DOWN
            'l'  -> RIGHT
            else -> null
        }

        game = game.update(direction)
    }
}

private fun CPointer<WINDOW>.draw(game: Game) {
    wclear(this)
    box(this, 0u, 0u)

    game.apples.cells.forEach { mvwprintw(this, it.y + 1, it.x + 1, ".") }
    game.snake.tail.forEach { mvwprintw(this, it.y + 1, it.x + 1, "o") }
    game.snake.head.let { mvwprintw(this, it.y + 1, it.x + 1, "Q") }

    if (game.isOver) {
        mvwprintw(this, 0, 6, "Game Over")
        mvwprintw(this, 1, 3, "Your score is ${game.score}")
    }

    wrefresh(this)
}