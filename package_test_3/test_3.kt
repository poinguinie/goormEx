package package_test_3

class InvalidNameException(message: String) : Exception(message)

fun main(args: Array<String>) {
	//forFunc()
	//try_catch_finally()	
	exceptionForUserNameinNumber()
}
//-----------
fun exceptionForUserNameinNumber() {
	var name = "Kildong123" //숫자가 포함된 이름
	try {
		validateName(name)
	} catch (e : InvalidNameException) { // 숫자가 포함된 예외처리
		println(e.message)
	} catch (e : Exception) {
		println(e.message)
	}
}
fun validateName(name : String) {
	if(name.matches(Regex(".*\\d+.*"))) {  // 이름에 숫자가 있으면 예외 발생
		throw InvalidNameException("Your name : $name : contains numerals.")
	} 
	
}
//-----------
fun try_catch_finally(){ // 예외 처리 함수
	val a = 6
	val b = 0
	val c : Int
	
	try {
		 c = a/b
	} catch(e : Exception) {
		println("Exception is handled")
	} finally {
		println("finally 블럭은 반드시 항상 실행됨")
	}
}
//-------------
fun forFunc(){ // For 문 사용 함수
	for(x in 1..5) { // downTo & step 이란 것도 존재 
		println(x)
	}
	print("Enter the Lines : ")
	val n = readLine()!!.toInt() // 콘솔로부터 입력
	
	for (line in 1..n) {
		for (space in 1..(n-line)) print(" ")
		for (star in 1..(2 * line - 1)) print("*")
		println()
	}
}