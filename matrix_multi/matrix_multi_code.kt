package matrix_multi

import java.util.*

fun main(args: Array<String>) {
	val mat1 = Matrix()
	mat1.makeMatrix()
	mat1.printMatrix()
	
	val mat2 = Matrix()
	mat2.makeMatrix()
	mat2.printMatrix()
	
	println("Plus Operator...")
	val matPlus = mat1 + mat2
	matPlus.printMatrix()
	
	println("Minus Operator...")
	val matMinus = mat1 - mat2
	matMinus.printMatrix()
	
	println("Times Operator...")
	val matTimes = mat1 * mat2
	matTimes.printMatrix()
	
}



class Matrix (_row : Int = 0, _column: Int = 0) {
	// Property (All Privated)
	private var rowNumber: Int = _row
	private var columnNumber: Int = _column
	private var rowArray: Array<Array<Int>> = Array(rowNumber, {Array(columnNumber, { 0 })})
	private val reader = Scanner(System.`in`)
	// Initializing
	init {
		println("Matrix creates...")
		if(rowNumber == 0 && columnNumber == 0) {
			print("Enter the (row colomn) Ex) 3 5 : ")
			rowNumber = reader.nextInt()
			columnNumber = reader.nextInt()
			rowArray = Array(rowNumber, {Array(columnNumber, { 0 })})
		}
	}
	/* Constructor
	constructor(): this(row, column) {
		if (row != rowNumber && column != columnNumber) {
			print("Enter the (row colomn) Ex) 3 5 : ")
			rowNumber = reader.nextInt()
			columnNumber = reader.nextInt()
			rowArray = Array(rowNumber, {Array(columnNumber, { 0 })})
		}
		
	}*/
	// Input the Matrix Data
	fun makeMatrix() {
		for(i in 0..(rowNumber-1)) {
			var columnArray = Array(columnNumber, { 0 })
			print("Enter the just ONE row (Ex 2 4 6 8) : ")
			for (j in 0..(columnNumber-1)) {
				columnArray[j] = reader.nextInt()
			}
			rowArray[i] = columnArray
		}
	}
	// Print the Matrix Data
	fun printMatrix() {
		for (i in 0..(rowNumber-1)) {
			for (j in 0..(columnNumber-1)) {
				print("${rowArray[i][j]} ")
			}
			println()
		}
		println()
	}
	// Plus Operator
	operator fun plus(m: Matrix) : Matrix {
		if(rowNumber != m.rowNumber || columnNumber != m.columnNumber) return this
		else {
			var res = Matrix(rowNumber,columnNumber)
			for(i in 0..(rowNumber-1)) {
				for(j in 0..(columnNumber-1)) {
					res.rowArray[i][j] = rowArray[i][j] + m.rowArray[i][j]
				}
			}
			return res
		}
	}
	// Minus Operator
	operator fun minus(m: Matrix) : Matrix {
		if(rowNumber != m.rowNumber || columnNumber != m.columnNumber) return this
		else {
			var res = Matrix(rowNumber,columnNumber)
			for(i in 0..(rowNumber-1)) {
				for(j in 0..(columnNumber-1)) {
					res.rowArray[i][j] = rowArray[i][j] - m.rowArray[i][j]
				}
			}
			return res
		}
	}
	// Times Operator
	operator fun times(m: Matrix) : Matrix {
		if(columnNumber != m.rowNumber) return this
		else {
			var res = Matrix(rowNumber,columnNumber)
			for(i in 0..(rowNumber-1)) {
				for(j in 0..(m.columnNumber-1)) {
					var tmp: Int = 0
					for(k in 0..(m.rowNumber-1)) {
						tmp += rowArray[i][k] * m.rowArray[k][j]
					}
					res.rowArray[i][j] = tmp
				}
			}
			return res
		}
	}
 }