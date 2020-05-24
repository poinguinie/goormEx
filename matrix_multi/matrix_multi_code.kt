package matrix_multi

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {

	print("Enter the (low colonm) Ex) 3 5 : ")
	
	val rowNumber = nextInt() 
	val columnNumber = nextInt()
	//You HAVE TO INPUT like this Ex) 3 5 (row : 3, column : 5)
	//println("row : $rowNumber column : $columnNumber")
	var rowArray = Array(rowNumber, { 0 })
	for(i in 0..(rowNumber-1)) {
		var columnArray = Array(columnNumber, { 0 })
		print("Enter the just ONE row : ")
		for (j in 0..(columnNumber-1)) {
			columnArray[j] = nextInt()
		}
		rowArray = rowArray.plus(columnArray)
		//for (j in 0..(columnNumber-1)) {
		//	row = row.plus(val tmp = nextInt())
		//}
		//rowArray = rowArray.plus(row)
	}
	for (i in rowArray) {
		println("$i ")
		/*for (j in i) {
			print("$j ")
		}
		println()*/
	}
}