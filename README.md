## Task

[Coding challenge instructions](./CHALLENGE.md)

## Design Decisions & Issues

This Palindrome coding solution has a standard Scala project layout:

* `src/main/scala/Palindrome.scala` contains implementation based on tail recursive functions

* `src/test/scala/PalindromeSpec.scala` contains standard specification and unit tests (Specs2)

* `src/test/scala/PalindromePropSpec.scala` contains simple property based test (ScalaCheck)

The algorithm consists of a function `findPalindromes` which searches for palindromes
starting from the length of the input string, and then recursively repeating
the search for shorter palindromes. It uses a helper function `findPalindromesWithLength`,
which recursively searches for unique palindromes of a given length.

Another function `isPalindrome` evaluates if a string is a palindrome. In this evaluation
it ignores some punctuation, capital letters and white spaces, so that strings like `No 'x' in Nixon`
are valid palindromes in my programme.


## How To Compile

`sbt compile`

## How To Test

`sbt test`

## How To Run

`sbt "run <input_string>"`

For example:

`sbt "run sqrrqabccbatudefggfedvwhijkllkjihxymnnmzpop"`

`sbt "run \"No 'x' in Nixon\""`


