# Java If-Else Statements

## 1. What is a Conditional Statement?

A conditional statement allows a program to make a decision based on whether a condition is `true` or `false`.

In Java, the main conditional forms are:

1. `if`
2. `if-else`
3. `else-if` ladder
4. Nested `if-else`
5. Ternary operator `?:` (covered separately under operators)

---

# 2. if Statement

Use `if` when an action should happen only when a condition is true.

### Syntax

```java
if (condition) {
    statement;
}
```

### Example

```java
int age = 20;

if (age >= 18) {
    System.out.println("You can vote");
}
```

If the condition is `true`, the body executes.

If the condition is `false`, the body is skipped.

### Important rule

The condition inside `if` must evaluate to a `boolean`.

```java
if (age >= 18) { }     // correct

if (age) { }           // compilation error in Java
```

Java does not treat `int`, `0`, or `1` as boolean values.

---

# 3. if-else Statement

Use `if-else` when exactly one of two paths should execute.

### Syntax

```java
if (condition) {
    statement1;
} else {
    statement2;
}
```

- If condition is `true` → `if` block executes.
- If condition is `false` → `else` block executes.

### Example: Even or Odd

```java
int num = 10;

if (num % 2 == 0) {
    System.out.println("Number is even");
} else {
    System.out.println("Number is odd");
}
```

---

# 4. else-if Ladder

Use an `else-if` ladder when there are multiple mutually exclusive conditions.

### Syntax

```java
if (condition1) {
    statement1;
} else if (condition2) {
    statement2;
} else if (condition3) {
    statement3;
} else {
    defaultStatement;
}
```

Java checks conditions from top to bottom.

**The first true condition wins.**

### Example: Positive / Negative / Zero

```java
int num = -5;

if (num > 0) {
    System.out.println("Positive");
} else if (num < 0) {
    System.out.println("Negative");
} else {
    System.out.println("Zero");
}
```

---

# 5. Nested if

A nested `if` means an `if` statement inside another `if` or `else` block.

### Syntax

```java
if (condition1) {
    if (condition2) {
        statement;
    }
} else {
    statement;
}
```

### Example

```java
int age = 25;
boolean hasId = true;

if (age >= 18) {
    if (hasId) {
        System.out.println("Entry allowed");
    } else {
        System.out.println("ID required");
    }
} else {
    System.out.println("Not eligible");
}
```

Nested conditions are useful when the second decision should only be considered after the first condition succeeds.

---

# 6. Multiple Statements in a Block

Use `{}` when multiple statements belong to the condition.

```java
if (age >= 18) {
    System.out.println("Eligible");
    System.out.println("You can vote");
}
```

Without braces, only the immediately following statement belongs to the `if`.

### Recommended practice

Always use braces, even for a single statement.

---

# 7. Scope of a Variable

A variable declared inside `{}` normally exists only inside that block.

```java
if (true) {
    int a = 20;
    System.out.println(a); // valid
}

// System.out.println(a); // compilation error
```

The variable `a` is local to the `if` block.

### Nested scope

```java
int a = 10;

{
    int b = 20;
    System.out.println(a); // valid
    System.out.println(b); // valid
}

// b is not accessible here
```

An outer variable can generally be accessed from an inner block, but an inner-block variable cannot be accessed after leaving that block.

---

# 8. `if-else` vs `else-if`

### if-else

Best when there are two alternatives:

```java
if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

### else-if ladder

Best when there are multiple alternatives:

```java
if (marks >= 90) {
    System.out.println("A");
} else if (marks >= 75) {
    System.out.println("B");
} else if (marks >= 60) {
    System.out.println("C");
} else {
    System.out.println("D");
}
```

---

# 9. Important: Condition Must Be Boolean

Java requires the condition to be `boolean`.

```java
if (10 > 5) {
    System.out.println("true");
}
```

Correct:

```java
if (num % 2 == 0) {
}
```

Incorrect:

```java
if (num % 2) {
}
```

The expression `num % 2` produces an integer, not a boolean.

---

# 10. Common Mistake: `=` vs `==`

`=` is assignment.

`==` is equality comparison.

```java
int a = 10;       // assignment

if (a == 10) {    // comparison
    System.out.println("a is 10");
}
```

Do not confuse them.

---

# 11. Dangling `else`

An `else` belongs to the nearest unmatched `if`.

Avoid confusing code like:

```java
if (a > 0)
    if (b > 0)
        System.out.println("Both positive");
    else
        System.out.println("b is not positive");
```

Use braces to make the intended structure obvious.

---

# 12. Logical Operators with Conditions

Conditions can be combined using `&&`, `||`, and `!`.

### AND

```java
if (age >= 18 && hasId) {
    System.out.println("Allowed");
}
```

Both conditions must be true.

### OR

```java
if (day == 6 || day == 7) {
    System.out.println("Weekend");
}
```

At least one condition must be true.

### NOT

```java
if (!isLoggedIn) {
    System.out.println("Please login");
}
```

---

# 13. Practical Examples to Know

For Java + DSA fundamentals, practice these patterns:

1. Check whether a person can vote.
2. Check even or odd.
3. Check positive, negative, or zero.
4. Find the greater of two numbers.
5. Find the greatest of three numbers.
6. Classify a triangle: equilateral, isosceles, or scalene.
7. Assign grade based on marks.
8. Check leap year.
9. Check eligibility using multiple conditions.
10. Demonstrate variable scope inside a block.

---

# 14. DSA Connection

`if-else` is fundamental to DSA.

You will use it for:

- Array boundary checks
- Searching
- Sorting decisions
- Binary search
- Two-pointer problems
- Sliding window
- Recursion base cases
- Tree traversal decisions
- Graph traversal conditions
- Dynamic programming transitions

The key mental model is:

```text
Condition
   |
   +-- true  → execute path A
   |
   +-- false → execute path B
```

---

# 15. Complexity

An `if-else` statement itself is generally:

**Time:** `O(1)`

**Space:** `O(1)`

For an `else-if` ladder with `n` conditions:

**Worst-case time:** `O(n)`

because Java may need to evaluate conditions from the beginning until it finds a true condition.

If every condition is a constant-time comparison, the work is proportional to the number of conditions.

---

# 16. Key Takeaways

Remember these rules:

- `if` executes its block only when the condition is `true`.
- `if-else` chooses between two paths.
- `else-if` handles multiple conditions.
- Only the first true branch in an `else-if` ladder executes.
- `else` is optional.
- Conditions must be `boolean`.
- `{}` defines a block and affects variable scope.
- Variables declared inside a block cannot normally be used outside that block.
- Use `==` for comparison and `=` for assignment.
- Prefer braces for readable and safe code.
- `&&` and `||` can combine multiple conditions.
