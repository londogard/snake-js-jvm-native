import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.*
import org.w3c.dom.events.KeyboardEvent

const val background = "#000000"
const val apple = "#ff3232"
const val snake = "#00ff00"
const val snakeHead = "#2c7507"

fun main() {
    val canvas = document.getElementById("snake-canvas") as HTMLCanvasElement
    var game = Game(
        20, 10, snake = Snake(
            cells = listOf(Cell(4, 0), Cell(3, 0), Cell(2, 0), Cell(1, 0), Cell(0, 0)),
            direction = Direction.RIGHT
        ),
        apples = Apples(20, 10)
    )

    render(canvas, game)
    var dir: Direction = game.snake.direction
    document.onkeydown = { event -> onkeydown(event).also { keyDir -> dir = keyDir } }
    window.setInterval({ game = game.update(dir); render(canvas, game) }, 200)
}

fun CanvasRenderingContext2D.renderCell(color: String, cells: Iterable<Cell>, gridSizeX: Double, gridSizeY: Double) {
    fillStyle = color
    cells.forEach { cell ->
        fillRect(cell.x * gridSizeX + 1, cell.y * gridSizeY + 1, gridSizeX - 1, gridSizeY - 1)
    }
}

fun render(canvas: HTMLCanvasElement, game: Game) {
    val gridSizeX: Double = (canvas.width.toDouble() - 1) / game.width
    val gridSizeY: Double = (canvas.height.toDouble() - 1) / game.height
    val ctx = canvas.getContext("2d") as CanvasRenderingContext2D

    ctx.fillStyle = background
    ctx.fillRect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())
    ctx.renderCell(apple, game.apples.cells, gridSizeX, gridSizeY)
    ctx.renderCell(snake, game.snake.tail, gridSizeX, gridSizeY)
    ctx.renderCell(snakeHead, listOf(game.snake.head), gridSizeX, gridSizeY)
}

private fun onkeydown(e: KeyboardEvent): Direction = when (e.key) {
    "ArrowUp", "w", "i" -> Direction.UP
    "ArrowDown", "s", "k" -> Direction.DOWN
    "ArrowLeft", "a", "j" -> Direction.LEFT
    "ArrowRight", "d", "l" -> Direction.RIGHT
    else -> Direction.DOWN
}