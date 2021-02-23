package edu.vtc.merc

import java.io.File
import org.antlr.v4.runtime._

class SyntaxSpec extends UnitSpec {

  "The syntax of the test files" should "be correct" in {
    val fileNames =
      Array("0001.mxdr", "0002.mxdr", "0003.mxdr", "0004.mxdr", "0005.mxdr",
            "0006.mxdr")

    for (fileName <- fileNames) {
      val fullName = "testData" + File.separator + "Syntax" + File.separator + fileName

      val codePointCharStream = CharStreams.fromFileName(fullName)
      val lexer  = new MercLexer(codePointCharStream)
      val tokens = new CommonTokenStream(lexer)
      val parser = new MercParser(tokens)
      val tree   = parser.specification()  // 'tree' is intentionally ignored.
    }
  }
}
