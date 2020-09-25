/** 
    Requires width, height, snake, apples
    Requires method `isOver` which returns if game is done
    Requires method `update` which updates the game state
    Snake & Apples should have x,y and tail should be available.
 */

data class GameImpl(
    val width: Int,
    val height: Int,
    val snake: Snake,
    val apples: Apples = Apples(width, height)
) {
    val isOver = false
    val score = 0

    fun update(): GameImpl = this
}