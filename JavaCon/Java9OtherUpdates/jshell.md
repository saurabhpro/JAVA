__Run JShell__

Running JShell is just... typing jshell in your Terminal. Let's try it:


```java
$ jshell
|  Welcome to JShell -- Version 9-ea
|  For an introduction type: /help intro
jshell>
```

Cool.

__Step 3: Get Help__

Type /help to get a list of things you can do with JShell:
```java
jshell> /help
|  Type a Java language expression, statement, or declaration.
|  Or type one of the following commands:
|  /list [<name or id>|-all|-start]
|  list the source you have typed
|  /edit <name or id>
|  edit a source entry referenced by name or id
|  /drop <name or id>
|  delete a source entry referenced by name or id
|  /save [-all|-history|-start] <file>
|  Save snippet source to a file.
|  /open <file>
|  open a file as source input
|  /vars [<name or id>|-all|-start]
|  list the declared variables and their values
|  /methods [<name or id>|-all|-start]
|  list the declared methods and their signatures
|  /types [<name or id>|-all|-start]
|  list the declared types
|  /imports 
|  list the imported items
```



One of the interesting commands above is /imports. Let's see if we have some by default:

```java
jshell> /imports
|    import java.io.*
|    import java.math.*
|    import java.net.*
|    import java.nio.file.*
|    import java.util.*
|    import java.util.concurrent.*
|    import java.util.function.*
|    import java.util.prefs.*
|    import java.util.regex.*
|    import java.util.stream.*
```

Yes, we do: some regexp, math, and io. Cool.

__Step 4: Basic Calculations__

Let’s try out some basic calculations and see how our shell works as a nice little calculator (you can uninstall the one you have):
```java
jshell> 1+1
$1 ==> 2
jshell> 5%7
$2 ==> 5
jshell> 13%3
$3 ==> 1
jshell> $2
$2 ==> 5
jshell> $2 // we got variable number two!
$2 ==> 5
```



So every result was placed in a numeric var starting with $.

__Step 5: Let’s Code a Function__

Let's define a small function that takes an int and doubles it. Then let's call it.
```java
jshell> int doubleThis(int i) { return i*2; }
|  created method doubleThis(int)
jshell> doubleThis(5)
$7 ==> 10
```



Amazing, so we are able to quickly define functions and use them from within the shell. In general, everything looks so smooth.