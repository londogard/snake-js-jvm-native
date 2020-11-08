import java.awt.*
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.event.KeyEvent.*
import javax.swing.JFrame
import javax.swing.JPanel
import kotlin.concurrent.fixedRateTimer

class Board: JPanel() {
    var dir: Direction = Direction.RIGHT
    private var game: Game = Game(
        20,
        30,
        Snake(listOf(Cell(2,3),Cell(2,4),Cell(2,5),), dir),
        Apples(20, 30, setOf(Cell(4,5)))
    )
    init {
        addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent?) {
                dir = when (e?.keyCode) {
                    VK_I, VK_UP, VK_W -> Direction.UP
                    VK_J, VK_LEFT, VK_A -> Direction.LEFT
                    VK_K, VK_DOWN, VK_S -> Direction.DOWN
                    VK_L, VK_RIGHT, VK_D -> Direction.RIGHT
                    else -> dir
                }
            }
        })
        fixedRateTimer(initialDelay = 2000, period = 1000/5) {
            game = game.update(dir)
            repaint()
        }
        background = Color.black
        isFocusable = true
        preferredSize = Dimension(200, 300)
    }

    fun Graphics2D.renderCells(color: Color, cells: Iterable<Cell>) {
        this.color = color
        cells.forEach { cell -> fill(Rectangle(cell.x, cell.y, 1, 1)) }
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        val g2d = g as? Graphics2D ?: return
        g2d.scale(20.0, 20.0)

        g2d.renderCells(Color.RED, game.apples.cells)
        g2d.renderCells(Color.GREEN, game.snake.tail)
        g2d.renderCells(Color.YELLOW, listOf(game.snake.head))
    }
}

class GUI: JFrame() {
    init {
        title = "Snake"
        isVisible = true
        isResizable = false
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        add(Board())
        pack()
    }
}

fun main() {
    EventQueue.invokeLater { GUI() }
}