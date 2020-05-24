package package_test_5

import java.util.*

fun main(agrs: Array<String>) = with(Scanner(System.`in`)) {
	
	var arr = Array<Int>(5, { 0 })
	
	for(i in 0..5) {
		arr = arr.plus(nextInt())
	}
	for(i in arr) {
		print("$i ")
	}
}
//----------------------------------
fun pretendedManFunc(){
	val pretendedMan = object: Superman() {
		override fun fly() = println("I'm not a real superman. I can't fly!")
	}
	pretendedMan.work()
	pretendedMan.talk()
	pretendedMan.fly()
}
open class Superman() {
	fun work() = println("Taking photos")
	fun talk() = println("Talking with people")
	open fun fly() = println("Flying in the air")
}