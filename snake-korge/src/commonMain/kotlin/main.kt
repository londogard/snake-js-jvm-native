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

suspend fun main() = Korge(width = 512, height = 512, bgcolor = Colors["#2b2b2b"]) {
    //var game = Game(
    //        width = 20,
    //        height = 10,
    //        snake = Snake(
    //                cells = listOf(Cell(4, 0), Cell(3, 0), Cell(2, 0), Cell(1, 0), Cell(0, 0)),
    //                direction = RIGHT
    //        ))
    //val cellSize = views.virtualWidth / 5.0
//
    //val fieldSize = 50 + 4 * cellSize
    //val leftIndent = (views.virtualWidth - fieldSize) / 2
    //val topIndent = 15.0
//
    //graphics {
    //    position(leftIndent, topIndent)
    //    fill(Colors["#cec0b2"]) {
    //        for (i in 0..3) {
    //            for (j in 0..3) {
    //                rect(10 + (10 + cellSize) * i, 10 + (10 + cellSize) * j, cellSize, cellSize)
    //            }
    //        }
    //    }
    //}
}