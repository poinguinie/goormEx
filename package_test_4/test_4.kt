package package_test_3

fun main(args: Array<String>) {
	val sean = Developer("Sean")
	println()
	val p1 = PersonByOther("홍길동",30)
	println()
	val p2 = PersonByOther("둘리")
	println()
	val c1 = Child()
	c1.Inside().test()
	println()
	
}
//createInnerClass
open class Base {
	open val x: Int = 1
	open fun f() = println("Base Class f()")
}
class Child : Base() {
	override val x: Int = super.x + 1
	override fun f() = println("Child Class f()")
	
	inner class Inside {
		fun f() = println("Inside Class f()")
		fun test() {
			f()
			Child().f()
			super@Child.f()
			println("[Inside] super@Child.x: ${super@Child.x}")
		}
	}
} 

//createPersonClassAboutConstructor
class PersonByOther(firstName:String, out: Unit = println("[Primary Constructor] Parameter")) { // 주 생성자
	val fName = println("[Property] Person fName: $firstName") // 프로퍼티 할당
	init {
		println("[init] Person init block") // 초기화 블록
	}
	
	// 부 생성자
	constructor(firstName: String, age: Int, out : Unit = println("[Secondary Constructor] Parameter")) : this(firstName) {
		println("[Secondary Constructor] Body: $firstName, $age") // 부 생성자 본문
	}
}

//createPersonClass
open class Person {
	constructor(firstName: String) {
		println("[Person] firstName: $firstName")
	}
	constructor(firstName: String, age: Int) {
		println("[Person] firstName: $firstName, $age")
	}
}
class Developer: Person {
	constructor(firstName: String): this(firstName,10) {
		println("[Developer] $firstName")
	}
	constructor(firstName: String, age: Int): super(firstName,age) {
		println("[Developer] $firstName, $age")
	}
}

//createBirdClass
fun createBird(){
	val coco = Bird("coco",2,"short","blue")
	
	println("coco.color : ${coco.color}")
	coco.fly()
	coco.sing(3)
	println()
	
	val harry = Parrot("harry",2,"long","red","korean")
	harry.sing(4)
	harry.speak()
}
open class Bird (var name: String, var wing: Int = 2, var beak: String, var color: String){ // 클래스 정의 (주 생성자) , 파생 클래스
	init { // 초기화 블럭
		println("initializing...")
	}
	// 메서드 (함수)
	fun fly() = println("Fly wing: $wing")
	fun sing(vol : Int) = println("Sing vol: $vol")
}
class Parrot : Bird{
	var language: String
	constructor(_name: String, _wing: Int = 2, _beak: String, _color: String, _language: String) : super(_name,_wing,_beak,_color) { // 생성자
		language = _language
	}
	init {
		println("parrot's initializing...")
	}
	
	fun speak() = println("Speak! $language")
}