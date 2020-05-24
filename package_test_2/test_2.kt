package package_test_2

//전역 변수
var global = 10

fun main(args: Array<String>) {
	val local1 = 20
	val local2 = 21
	//지역 함수	
	fun nestedFunc() {
		global++
		val local1 = 30 // 이 함수 안에서만 유지
		println("nestedFunc local1 = $local1")
		println("nestedFunc local2 = $local2")
		println("nestedFunc global = $global")
	}
	nestedFunc()
	outsideFunc()
	
	println("main local1 = $local1")
	println("main local2 = $local2")
	println("main global = $global")
}
fun outsideFunc() {
	global++
	val outVal = "outside" // 이 함수 안에서만 유지
	println("outsideFunc global = $global")
	println("outsideFunc outval = $outVal")
}
//---------------
fun test_1(){
	val source = "Hello World!"
	val target = "Kotlin"
	println(source.getLongString(target))
	
	//일반 표현법
	//val multi = 3.multiply(10)
	
	//중위 표현법
	val multi = 3 multiply 10
	println("multi : $multi")	
}
infix fun Int.multiply(x:Int):Int {
	return this * x
}
fun String.getLongString(target: String): String = if (this.length > target.length) this else target