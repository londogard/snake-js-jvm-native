import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.*
import org.w3c.dom.events.KeyboardEvent

const val background = "#000000"
const val wall = "#aaaaaa"
const val apple = "#ff3232"
const val snake = "#00ff00"
const val snakeHead = "#2c7507"
const val snakeDeadHead = "#0000ff"
const val overlaybg = "#77777777"
const val overlaytext = "#ffffff"

fun main() {
    console.log("Hello, Kotlin/JS!")

    val canvas = document.getElementById("snake-canvas") as HTMLCanvasElement
    var game = Game(
        20, 10, snake = Snake(
            cells = listOf(Cell(4, 0), Cell(3, 0), Cell(2, 0), Cell(1, 0), Cell(0, 0)),
            direction = Direction.RIGHT
        )
    )

    render(canvas, game)
    var dir: Direction = game.snake.direction
    document.onkeydown = { onkeydown(it).also { dir = it } }
    window.setInterval({ game = game.update(dir); render(canvas, game) }, 200)
}

fun render(canvas: HTMLCanvasElement, game: Game) {
    val ctx = canvas.getContext("2d") as CanvasRenderingContext2D
    ctx.fillStyle = background
    ctx.fillRect(0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())

    val gridSizeX: Double = (canvas.width.toDouble() - 1) / game.width
    val gridSizeY: Double = (canvas.height.toDouble() - 1) / game.height

    fun drawSquare(cell: Cell) {
        ctx.fillRect(
            cell.x * gridSizeX + 1, cell.y * gridSizeY + 1,
            gridSizeX - 1, gridSizeY - 1
        )
    }

    ctx.fillStyle = apple
    game.apples.cells.forEach(::drawSquare)
    ctx.fillStyle = snake
    game.snake.tail.forEach(::drawSquare)
    ctx.fillStyle = if (game.isOver) snakeDeadHead else snakeHead
    drawSquare(game.snake.head)


    //if (game.isOver) {
    //    ctx.fillStyle = overlaybg
    //    ctx.fillRect(
    //        0.0, 0.0, canvas.width.toDouble(), canvas.height.toDouble())
//
    //    ctx.fillStyle = overlaytext
    //    ctx.textBaseline = CanvasTextBaseline.MIDDLE
    //    ctx.textAlign = CanvasTextAlign.CENTER
    //    ctx.font = (canvas.height * 0.07).toString() + "px sans-serif"
    //    ctx.fillText(
    //        "Score: ${game.snake.cells.size}.  Press SPACE.",
    //        canvas.width / 2.0,
    //        canvas.height / 2.0
    //    )
    //}
}

private fun onkeydown(e: KeyboardEvent): Direction = when (e.key) {
    "ArrowUp", "w", "i" -> Direction.UP
    "ArrowDown", "s", "k" -> Direction.DOWN
    "ArrowLeft", "a", "j" -> Direction.LEFT
    "ArrowRight", "d", "l" -> Direction.RIGHT
    else -> Direction.DOWN
}