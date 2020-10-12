import java.awt.*
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.event.KeyEvent.*
import javax.swing.JFrame
import javax.swing.JPanel
import kotlin.concurrent.fixedRateTimer

class Board : JPanel() {
    private val scalingFactor = 20.0
    var game: Game
    var dir: Direction? = Direction.RIGHT
    init {
        game = Game(
            20, 10, Snake(
                cells = listOf(Cell(4, 0), Cell(3, 0), Cell(2, 0), Cell(1, 0), Cell(0, 0)),
                direction = dir ?: Direction.RIGHT
            )
        )

        fixedRateTimer(initialDelay = 2000, period = 1000/5) {
            game = game.update(dir)
            repaint()
        }

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

        repaint()
        background = Color.black
        isFocusable = true
        preferredSize = Dimension(game.width * scalingFactor.toInt(), game.height * scalingFactor.toInt())
    }

    override fun paintComponent(g: Graphics?) {
        super.paintComponent(g)
        val g2d = g as Graphics2D
        g2d.scale(scalingFactor, scalingFactor)

        g2d.color = Color.RED
        game.apples.cells.forEach { g2d.fill(Rectangle(it.x, it.y, 1, 1)) }

        g2d.color = Color.GREEN
        game.snake.tail.forEach { g2d.fill(Rectangle(it.x, it.y,1, 1)) }

        g2d.color = Color.YELLOW
        game.snake.head.let { g2d.fill(Rectangle(it.x, it.y, 1, 1)) }
    }
}

class GUI: JFrame() {
    init {
        title = "Snake"
        isResizable = false

        add(Board())
        pack()
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        val ex = GUI()
        ex.isVisible = true
    }
}