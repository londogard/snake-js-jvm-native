import java.awt.Color
import java.awt.Dimension
import java.awt.EventQueue
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JFrame
import javax.swing.JPanel

class Board : JPanel(), ActionListener {
    init {
        var game = Game(20,10, Snake(cells = listOf(Cell(4, 0), Cell(3, 0), Cell(2, 0), Cell(1, 0), Cell(0, 0)),
            direction = Direction.RIGHT
        ))
        addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent?) {
                when (e?.keyChar) {
                    'i' -> Direction.UP
                    'j'  -> Direction.LEFT
                    'k'  -> Direction.DOWN
                    'l'  -> Direction.RIGHT
                    else -> null
                }
            }
        })
        background = Color.black
        isFocusable = true

        preferredSize = Dimension(game.width, game.height)
    }

    override fun actionPerformed(e: ActionEvent?) {
        TODO("Not yet implemented")
    }

}

class GUI: JFrame() {
    init {
        title = "Snake"
        isResizable = false

        pack()
        add(Board())

        setLocationRelativeTo(null)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        val ex = GUI()
        ex.isVisible = true
    }

}