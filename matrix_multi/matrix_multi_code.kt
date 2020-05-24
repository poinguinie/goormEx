package matrix_multi

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
	
	//var row, colomn = inputRC()
	print("Enter the (row colomn) Ex) 3 5 : ")

	val rowNumber = nextInt() 
	val columnNumber = nextInt()
	
	val mat1 = matrix(rowNumber,columnNumber)
	mat1.makeMatrix()
	mat1.printMatrix()
	/*print("Enter the (row colomn) Ex) 3 5 : ")
	
	val rowNumber = nextInt() 
	val columnNumber = nextInt()
	//You HAVE TO INPUT like this Ex) 3 5 (row : 3, column : 5)
	println("Your Input : row : $rowNumber column : $columnNumber")
	var rowArray = Array(rowNumber, {Array(columnNumber, { 0 })})
	for(i in 0..(rowNumber-1)) {
		var columnArray = Array(columnNumber, { 0 })
		print("Enter the just ONE row (Ex 2 4 6 8) : ")
		for (j in 0..(columnNumber-1)) {
			columnArray[j] = nextInt()
		}
		rowArray[i] = columnArray
	}
	for (i in 0..(rowNumber-1)) {
		for (j in 0..(columnNumber-1)) {
			print("${rowArray[i][j]} ")
		}
		println()
	}*/
}
class matrix (row:Int , column:Int) {
	var rowNumber: Int = row
	var columnNumber: Int = column
	var rowArray = Array(rowNumber, {Array(columnNumber, { 0 })})
	
	fun makeMatrix() {
		for(i in 0..(rowNumber-1)) {
			var columnArray = Array(columnNumber, { 0 })
			print("Enter the just ONE row (Ex 2 4 6 8) : ")
			for (j in 0..(columnNumber-1)) {
			columnArray[j] = nextInt()
			}
			rowArray[i] = columnArray
		}
		for (i in 0..(rowNumber-1)) {
			for (j in 0..(columnNumber-1)) {
				print("${rowArray[i][j]} ")
			}
			println()
		}
	}
	
	fun printMatrix() {
		for (i in 0..(rowNumber-1)) {
			for (j in 0..(columnNumber-1)) {
				print("${rowArray[i][j]} ")
			}
			println()
		}
	}
}
/*fun inputRC(): Int, Int {
	print("Enter the (row colomn) Ex) 3 5 : ")

	rowNumber = nextInt() 
	columnNumber = nextInt()
}*/