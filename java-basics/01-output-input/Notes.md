# 01 - Output & Input

## 1. Output in Java

Java provides `System.out.print()` and `System.out.println()` for displaying output.

### `print()`

Prints the output without moving to a new line.

```java
System.out.print("Hello");
System.out.print("World");
```

Output:

```text
HelloWorld
```

### `println()`

Prints the output and moves the cursor to a new line.

```java
System.out.println("Hello");
System.out.println("World");
```

Output:

```text
Hello
World
```

---

## 2. Basic Arithmetic Operators

Java provides the following arithmetic operators:

| Operator | Meaning |
|----------|---------|
| `+` | Addition |
| `-` | Subtraction |
| `*` | Multiplication |
| `/` | Division |
| `%` | Modulus / Remainder |

Example:

```java
System.out.println(5 + 3);
System.out.println(5 - 3);
System.out.println(5 * 2);
System.out.println(10 / 2);
System.out.println(10 % 3);
```

---

## 3. Integer Division

When two integers are divided, the result is an integer.

```java
System.out.println(5 / 2);
```

Output:

```text
2
```

The decimal part is discarded.

To get a decimal result, at least one operand should be a floating-point value.

```java
System.out.println(5.0 / 2);
```

Output:

```text
2.5
```

---

## 4. Division by Zero

Integer division by zero causes a runtime error.

```java
System.out.println(5 / 0);
```

This results in:

```text
ArithmeticException: / by zero
```

---

## 5. Operator Precedence

Java follows operator precedence when evaluating expressions.

General order:

1. Parentheses `()`
2. Multiplication, division and modulus `* / %`
3. Addition and subtraction `+ -`

Operators with the same precedence are generally evaluated from left to right.

Example:

```java
System.out.println(5 * 6 + (6 - 2) / 3 + 7);
```

Evaluation:

```text
5 * 6 + 4 / 3 + 7
30 + 1 + 7
38
```

Output:

```text
38
```

---

## 6. String Concatenation

The `+` operator can concatenate strings.

```java
System.out.println("Hi " + "Dev");
```

Output:

```text
Hi Dev
```

If one operand is a `String`, `+` can perform string concatenation.

Example:

```java
System.out.println("Hi " + 7 * 7);
```

Output:

```text
Hi 49
```

Arithmetic operations are performed according to operator precedence before concatenation.

---

## 7. Taking Input Using Scanner

Java provides the `Scanner` class for reading input from the keyboard.

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
```

Common methods:

```java
sc.nextInt();      // integer
sc.nextLong();     // long
sc.nextFloat();    // float
sc.nextDouble();   // double
sc.next();         // one word
sc.nextLine();     // complete line
```

Example:

```java
int age = sc.nextInt();
System.out.println(age);
```

---

## 8. Input Mismatch

The input type should match the Scanner method being used.

For example:

```java
int age = sc.nextInt();
```

expects an integer.

Providing incompatible input can result in an input mismatch exception.

---

## Key Takeaways

- `print()` prints without a new line.
- `println()` prints and moves to a new line.
- Java supports arithmetic operators such as `+`, `-`, `*`, `/`, and `%`.
- Integer division removes the decimal portion.
- Division by zero causes a runtime error for integer division.
- Operator precedence determines the order of evaluation.
- `+` can perform string concatenation.
- `Scanner` is used to read input from the keyboard.
