package package_test_4

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
	
	val user1 = User(1,"Kildong",30)
	// user1.id = 2
	user1.age = 35 // setter
	println("user1.age = ${user1.age}") // getter
	println()
	
	val myDamas = CarModel("Damas 2010", VanImpl("100마력"))
	val my350z = CarModel("350z 2008", SportImpl("350마력"))
	
	myDamas.carInfo()
	my350z.carInfo()
	
	/*val user2 = User(2)
	print("Enter the your Name : ")
	var name: String? = readLine()
	print("Enter the your Age : ")
	var age: Int = readLine()!!.toInt()
	user2.name = name
	user2.age = age	
	println()*/
	
	
}
//DeligationOfBy
interface Car {
	fun go(): String
}
class VanImpl(val power: String): Car {
	override fun go() = "은 짐을 적재하며 ${power}을 가집니다."
}
class SportImpl(val power: String): Car {
	override fun go() = "은 경주용에 사용되며 ${power}을 가집니다."
}
class CarModel(val model: String, impl: Car): Car by impl {
	fun carInfo() {
		println("$model ${go()}")
	}
}

//getter & setter
class User(_id: Int, _name: String = "None", _age: Int = 0) {
	// property
	private var tmp: String?= null
	val id: Int = _id
		get() = field
	var name: String? = _name
		get() = field
		set(tmp) {
			if (tmp!!.length >= 10) {
				println("Too Long!")
				return
			}
			field = tmp
		}
	
	var age: Int = _age
		get() = field
		set(value) {
			field = value
		}
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