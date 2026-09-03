# Java Operators

## 1. What is an Operator?

An operator is a symbol that tells Java to perform an operation on one or more operands.

```java
int c = a + b;
```

- `+` → operator
- `a`, `b` → operands
- `a + b` → expression

---

## 2. Types of Operators

Java operators can be grouped into:

1. Arithmetic
2. Unary
3. Relational
4. Logical
5. Assignment
6. Bitwise
7. Shift
8. Ternary / Conditional

---

# 3. Arithmetic Operators

| Operator | Meaning |
|---|---|
| `+` | Addition |
| `-` | Subtraction |
| `*` | Multiplication |
| `/` | Division |
| `%` | Remainder / Modulus |

### Important: Integer Division

When both operands are integers, `/` performs integer division.

```java
int a = 10;
int b = 3;

System.out.println(a / b);   // 3
System.out.println(a % b);   // 1
```

If at least one operand is floating-point, the result is floating-point:

```java
double x = 10;
double y = 3;

System.out.println(x / y);   // 3.3333333333333335
```

---

# 4. Unary Operators

Unary operators work on one operand.

```text
++   Increment
--   Decrement
+    Unary plus
-    Unary minus
!    Logical NOT
~    Bitwise complement
```

### Pre-increment vs Post-increment

```java
int a = 10;

System.out.println(++a); // 11
System.out.println(a);   // 11
```

`++a` increments first, then uses the value.

```java
int b = 10;

System.out.println(b++); // 10
System.out.println(b);   // 11
```

`b++` uses the current value first, then increments.

---

# 5. Relational Operators

Relational operators compare two values and produce a `boolean`.

```text
>    Greater than
<    Less than
>=   Greater than or equal to
<=   Less than or equal to
==   Equal to
!=   Not equal to
```

Example:

```java
int a = 10;
int b = 20;

System.out.println(a < b);   // true
System.out.println(a == b);  // false
```

---

# 6. Logical Operators

Logical operators work with boolean expressions.

```text
&&   Logical AND
||   Logical OR
!    Logical NOT
```

## AND (`&&`)

Both conditions must be true.

| A | B | A && B |
|---|---|---|
| true | true | true |
| true | false | false |
| false | true | false |
| false | false | false |

## OR (`||`)

At least one condition must be true.

| A | B | A || B |
|---|---|---|
| true | true | true |
| true | false | true |
| false | true | true |
| false | false | false |

## NOT (`!`)

Reverses a boolean value.

```java
System.out.println(!true);   // false
System.out.println(!false);  // true
```

### Short-circuiting

`&&` and `||` are short-circuit operators.

```java
false && someCondition
```

The right side does not need to be evaluated because the final result is already known.

---

# 7. Assignment Operators

Basic assignment:

```java
int a = 10;
```

Compound assignment operators:

```text
+=
-=
*=
/=
%=
&=
|=
^=
<<=
>>=
>>>=
```

Example:

```java
int a = 10;

a += 5;   // a = a + 5
a -= 2;   // a = a - 2
a *= 2;   // a = a * 2
a /= 4;   // a = a / 4
a %= 3;   // a = a % 3
```

### Important

Compound assignment includes an implicit conversion.

```java
byte a = 10;
a += 5;       // valid
```

Conceptually:

```java
a = (byte)(a + 5);
```

But:

```java
byte a = 10;
a = a + 5;    // compilation error
```

because `a + 5` is promoted to `int`.

---

# 8. Type Promotion / Conversion in Expressions

Java performs numeric promotion during arithmetic operations.

### Basic rule

- `byte`, `short`, and `char` are generally promoted to `int` in arithmetic expressions.
- If one operand is `long`, the result is at least `long`.
- If one operand is `float`, the result is at least `float`.
- If one operand is `double`, the result is `double`.

Examples:

```text
int + double → double
int + float  → float
long + int   → long
```

### Decimal literals

```java
double d = 10.83;   // valid
float f = 10.83f;   // valid
```

`10.83` is a `double` literal by default.

`10.83f` is a `float` literal.

---

# 9. Explicit Casting

When a larger/narrower conversion is not implicit, explicit casting can be used.

```java
long n = 60000;

int a = (int)n;
System.out.println(a);
```

If the value does not fit into the target type, data can be lost:

```java
long n = 1_000_000_000_000L;

int a = (int)n;
System.out.println(a);   // truncated/overflowed result
```

### Correct way to avoid integer overflow

This is a very important rule:

```java
int a = 100_000;
int b = 400_000;

long c = (long)a * b;
```

Do **not** rely on:

```java
long c = a * b;
```

because `a * b` is evaluated as `int * int` first. The overflow can happen before the result is assigned to `long`.

---

# 10. char and Numeric Conversion

`char` is a 16-bit unsigned integer type.

A `char` can be promoted to `int`:

```java
char ch = 'B';

int n = ch;
System.out.println(n);   // 66
```

But converting an `int` to `char` requires explicit casting:

```java
int n = 66;

char ch = (char)n;
System.out.println(ch);  // B
```

---

# 11. Bitwise Operators

Bitwise operators operate on individual bits of integral values.

```text
&   AND
|   OR
^   XOR
~   Complement
```

Example:

```java
int a = 5;   // 0101
int b = 3;   // 0011

System.out.println(a & b); // 1
System.out.println(a | b); // 7
System.out.println(a ^ b); // 6
```

`~` flips every bit.

---

# 12. Shift Operators

```text
<<    Left shift
>>    Signed right shift
>>>   Unsigned right shift
```

Example:

```java
int a = 8;

System.out.println(a << 1);  // 16
System.out.println(a >> 1);  // 4
```

For positive integers, shifting left by one is equivalent to multiplying by 2 when no overflow occurs.

---

# 13. Ternary Operator

The ternary operator is a compact form of `if-else`.

```java
condition ? valueIfTrue : valueIfFalse
```

Example:

```java
int a = 10;
int b = 20;

int max = a > b ? a : b;

System.out.println(max); // 20
```

---

# 14. Operator Precedence

When multiple operators appear in one expression, Java follows precedence rules.

A useful simplified order is:

```text
()
++ -- ! ~
* / %
+ -
< > <= >= instanceof
== !=
&
^
|
&&
||
?:
= += -= *= /= ...
```

When in doubt, use parentheses:

```java
int result = (a + b) * c;
```

---

# 15. Important Pitfalls

### Pitfall 1 — Integer division

```java
System.out.println(10 / 3);    // 3
System.out.println(10.0 / 3);  // 3.333...
```

### Pitfall 2 — Integer overflow before assignment

```java
int a = 100_000;
int b = 400_000;

long c = a * b;          // WRONG for this calculation
long d = (long)a * b;    // CORRECT
```

### Pitfall 3 — Floating-point literal

```java
float f = 10.83;   // compilation error
float g = 10.83f;  // correct
```

### Pitfall 4 — `10 / 0`

For integer arithmetic:

```java
int x = 10 / 0;
```

causes `ArithmeticException` at runtime.

But floating-point division behaves differently:

```java
System.out.println(10.0 / 0.0); // Infinity
System.out.println(0.0 / 0.0);  // NaN
```

### Pitfall 5 — `&&` vs `&`

`&&` is logical AND and short-circuits.

`&` can be bitwise AND for integers and logical AND for booleans, but it does not short-circuit.

---

# 16. Key Takeaways for DSA

For DSA, pay special attention to:

1. Integer division
2. `%` for remainder
3. Pre-increment vs post-increment
4. Integer overflow
5. Type promotion
6. Explicit casting
7. `&&` vs `&`
8. `||` vs `|`
9. Bitwise and shift operators
10. Operator precedence

The most important practical rule:

```java
long result = (long)a * b;
```

when `a` and `b` are `int` values but their multiplication may exceed the `int` range.
