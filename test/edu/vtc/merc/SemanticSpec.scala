package edu.vtc.merc

import java.io.File
import org.antlr.v4.runtime._

class SemanticSpec extends UnitSpec {

  case class TestCase(
    fileName        : String,
    expectedErrors  : Array[ExpectedMessage],
    expectedWarnings: Array[ExpectedMessage])

  "The sematics of the test files" should "have the indicated errors" in {
    val testCases = Array(
      TestCase("0001.mxdr",
        Array(ExpectedMessage(5, 22, "Invalid!: That Identifier already exists!")),
        Array()))

    for (testCase <- testCases) {
      val TestCase(fileName, expectedErrors, expectedWarnings) = testCase

      val fullName = "testData" + File.separator + "Semantics" + File.separator + fileName

      val input  = new ANTLRFileStream(fullName)
      val lexer  = new MercLexer(input)
      val tokens = new CommonTokenStream(lexer)
      val parser = new MercParser(tokens)
      val tree   = parser.specification()

      // Walk the tree created during the parse and analyze it for semantic errors.
      val symbolTable = new BasicSymbolTable
      val reporter    = new TestReporter(expectedErrors, expectedWarnings)
      val myTable     = new STPopulation(fileName, symbolTable, reporter)
      myTable.visit(tree)
      val myAnalyzer  = new SemanticAnalyzer(fileName, symbolTable, reporter)
      myAnalyzer.visit(tree)
    }
  }
}
