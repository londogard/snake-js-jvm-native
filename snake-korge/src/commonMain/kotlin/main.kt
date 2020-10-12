import com.soywiz.klock.seconds
import com.soywiz.korev.Key
import com.soywiz.korge.*
import com.soywiz.korge.tween.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.format.*
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.degrees
import com.soywiz.korma.interpolation.Easing

import Direction.*
import com.soywiz.korim.color.RGBA
import com.soywiz.korma.geom.vector.rect
import com.soywiz.korma.geom.vector.roundRect

/**
 * fun main(): Unit = memScoped {
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
 */

suspend fun main() = Korge(width = 512, height = 512, bgcolor = Colors["#2b2b2b"]) {
    var game = Game(
            width = 20,
            height = 10,
            snake = Snake(
                    cells = listOf(Cell(4, 0), Cell(3, 0), Cell(2, 0), Cell(1, 0), Cell(0, 0)),
                    direction = RIGHT
            ))
    val cellSize = views.virtualWidth / 5.0

    val fieldSize = 50 + 4 * cellSize
    val leftIndent = (views.virtualWidth - fieldSize) / 2
    val topIndent = 15.0

    graphics {
        position(leftIndent, topIndent)
        fill(Colors["#cec0b2"]) {
            for (i in 0..3) {
                for (j in 0..3) {
                    rect(10 + (10 + cellSize) * i, 10 + (10 + cellSize) * j, cellSize, cellSize)
                }
            }
        }
    }
    // Snake sprite sheet is 64x64 px per item! -- https://rembound.com/articles/creating-a-snake-game-tutorial-with-html5
}