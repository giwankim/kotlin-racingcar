package calculator

sealed interface Expr

@JvmInline
value class Literal(
    val value: Int,
) : Expr

data class Binary(
    val left: Expr,
    val operator: Operator,
    val right: Expr,
) : Expr

fun Expr.evaluate(): Int =
    when (this) {
        is Literal -> this.value
        is Binary -> this.operator.apply(left.evaluate(), right.evaluate())
    }
