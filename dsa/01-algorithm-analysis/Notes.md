# Algorithm Analysis — Notes

## 1.1 Variables

A variable is a named location used to store data.

In mathematics:

x² + 2y - 1 = 2

Here, `x` and `y` represent values.

Similarly, in programming, variables are used to store and work with data.

---

## 1.2 Data Types

A data type defines what kind of value a variable can hold.

### System-defined / Primitive Data Types

These are data types provided by the programming language.

Examples in Java:

- `int`
- `float`
- `double`
- `char`
- `boolean`

### User-defined Data Types

These allow programmers to define their own types.

Examples:

- Classes
- Structures
- Interfaces

---

## 1.3 Data Structures

A data structure is a particular way of organizing and storing data so that it can be used efficiently.

### Types of Data Structures

#### Linear Data Structures

Elements are arranged/accessed in a sequential order.

Examples:

- Array
- Linked List
- Stack
- Queue

#### Non-Linear Data Structures

Elements are arranged/accessed in a non-sequential manner.

Examples:

- Tree
- Graph

---

## 1.4 Abstract Data Types (ADTs)

An Abstract Data Type combines:

1. Data
2. Operations that can be performed on that data

An ADT describes **what** operations are supported without necessarily specifying **how** those operations are implemented.

Examples:

- Stack
- Queue
- List

---

## 1.5 What is an Algorithm?

An algorithm is a step-by-step sequence of unambiguous instructions used to solve a given problem.

Example:

### ATM Withdrawal

1. Enter the ATM.
2. Insert the debit card.
3. Enter the PIN.
4. Enter the amount.
5. Collect the money.

The important idea is that the steps must be performed in a defined order.

---

## 1.6 Why Analyze Algorithms?

Different algorithms can solve the same problem, but they may require different amounts of time and memory.

Algorithm analysis helps us understand how efficiently an algorithm works.

---

## 1.7 Goal of Algorithm Analysis

The main goal is to understand the efficiency of an algorithm as the input size increases.

We mainly consider:

- Time required
- Memory/space required

These are commonly referred to as:

- Time Complexity
- Space Complexity

---

## 1.8 Running Time Analysis

Running time analysis studies how the execution time of an algorithm changes as the input size increases.

The input size is usually represented by `n`.

For example:

- Number of elements in an array
- Number of vertices in a graph
- Number of elements in a data structure

We express running time as a function of input size:

```text
T(n)
```
---
## 1.9 How to Compare Algorithms

Actual execution time depends on factors such as:

- Computer hardware
- Programming language
- Compiler
- Implementation

Therefore, instead of comparing actual execution time in seconds, we compare how the running time grows with the input size.

We represent this using a function such as:

```text
f(n)
```
---

## 1.10 Rate of Growth

Rate of growth describes how the running time of an algorithm increases as the input size `n` increases.

For example:

```text
n^4 + 2n^2 + 500n + 50
```

For large values of `n`, the highest-order term dominates:

```text
n^4
```

Therefore:

```text
T(n) = O(n^4)
```

The lower-order terms and constant factors are ignored when describing asymptotic growth.

---

## 1.11 Commonly Used Rates of Growth

- `O(1)` — Constant: Does not depend on input size.
- `O(log n)` — Logarithmic: Grows very slowly.
- `O(n)` — Linear: Grows proportionally with `n`.
- `O(n log n)` — Linearithmic: Common in efficient sorting algorithms.
- `O(n^2)` — Quadratic: Often produced by nested loops.
- `O(n^3)` — Cubic: Often produced by three nested loops.
- `O(2^n)` — Exponential: Grows very rapidly.
- `O(n!)` — Factorial: Extremely rapid growth.

### General Order of Growth

From slower growth to faster growth:

```text
O(1) < O(log n) < O(n) < O(n log n) < O(n^2) < O(n^3) < O(2^n) < O(n!)
```

### Key Idea

When analyzing an algorithm, we are mainly interested in how its resource requirements grow as `n` becomes large.

---

## 1.12 Big-O Notation

Big-O notation describes the asymptotic upper bound of an algorithm's running time.

It tells us how fast the running time can grow as the input size `n` becomes large.

We represent it as:

$$
f(n) = O(g(n))
$$

This means that, for sufficiently large values of `n`, `f(n)` grows no faster than a constant multiple of `g(n)`.

### Example 1

Consider:

$$
f(n) = n^4 + 10n^2 + 10n + 50
$$

For large values of `n`, the highest-order term dominates:

$$
f(n) \approx n^4
$$

Therefore:

$$
f(n) = O(n^4)
$$

### Example 2

Consider:

$$
f(n) = 3n + 8
$$

For sufficiently large `n`:

$$
3n + 8 \leq 4n
$$

Therefore:

$$
f(n) = O(n)
$$

### Example 3

Consider:

$$
f(n) = n^2 + 1
$$

For `n >= 1`:

$$
n^2 + 1 \leq 2n^2
$$

Therefore:

$$
f(n) = O(n^2)
$$

### Example 4

Consider:

$$
f(n) = 4n
$$

Since the constant `4` does not affect the growth rate:

$$
4n = O(n)
$$

### Example 5

Consider:

$$
f(n) = 2n^3 - 2n^2
$$

For `n >= 1`:

$$
2n^3 - 2n^2 \leq 2n^3
$$

Therefore:

$$
f(n) = O(n^3)
$$

### Key Idea

For Big-O analysis:

1. Ignore constant factors.
2. Ignore lower-order terms.
3. Keep the fastest-growing term.

For example:

$$
5n^3 + 10n^2 + 20n + 100
$$

becomes:

$$
O(n^3)
$$

---

## 1.13 Omega (Ω) Notation

Omega notation describes the asymptotic lower bound of an algorithm.

It tells us the minimum growth rate of a function for sufficiently large `n`.

We represent it as:

$$
f(n) = \Omega(g(n))
$$

In simple terms:

> Big-O gives an upper bound, while Omega gives a lower bound.

### Example

If:

$$
f(n) = n^2 + 10n + 5
$$

then the dominant term is `n^2`.

Therefore:

$$
f(n) = \Omega(n^2)
$$

---

## 1.14 Theta (Θ) Notation

Theta notation gives a tight asymptotic bound.

It means that the function grows at the same asymptotic rate as the given function.

We represent it as:

$$
f(n) = \Theta(g(n))
$$

If both an upper bound and a lower bound are the same:

$$
f(n) = O(g(n))
$$

and

$$
f(n) = \Omega(g(n))
$$

then:

$$
f(n) = \Theta(g(n))
$$

### Example

Consider:

$$
f(n) = 3n^2 + 10n + 5
$$

The dominant term is:

$$
n^2
$$

Therefore:

$$
f(n) = \Theta(n^2)
$$

### Relationship

```text
O(g(n))       → Upper Bound
Ω(g(n))       → Lower Bound
Θ(g(n))       → Tight Bound
```

---

## 1.15 Asymptotic Analysis

Asymptotic analysis studies the behavior of an algorithm as the input size `n` becomes very large.

We are mainly interested in the growth rate rather than the exact execution time.

For example:

$$
f(n) = n^2 + 10n + 100
$$

For large `n`, the `n^2` term dominates.

Therefore:

$$
f(n) = \Theta(n^2)
$$

The function `n^2` acts as the asymptotic growth function for `f(n)`.

### Why Ignore Constants?

Suppose two algorithms have:

$$
T_1(n) = 5n
$$

and

$$
T_2(n) = 100n
$$

Both grow linearly with `n`.

Therefore:

$$
T_1(n) = O(n)
$$

and

$$
T_2(n) = O(n)
$$

The constant factor does not change the growth category.

---

## 1.16 Types of Analysis

There are three common ways to analyze an algorithm.

### Worst Case

The worst case determines the input for which the algorithm takes the longest amount of time.

It answers:

> What is the maximum amount of time this algorithm may take?

Example:

Searching for an element in an array when the element is at the last position.

---

### Best Case

The best case determines the input for which the algorithm takes the least amount of time.

It answers:

> What is the minimum amount of time this algorithm may take?

Example:

Searching for an element in an array when the element is at the first position.

---

### Average Case

Average-case analysis provides an estimate of the running time over different possible inputs.

It answers:

> What running time should we expect for a typical input?

---

## 1.17 Guidelines for Asymptotic Analysis

When analyzing the complexity of an algorithm, look at the structure of the code.

### 1. Single Loop

Consider:

```java
for (int i = 1; i <= n; i++) {
    operation();
}
```

The loop executes `n` times.

Therefore:

$$
T(n) = c \times n
$$

Ignoring the constant `c`:

$$
T(n) = O(n)
$$

---

### 2. Nested Loops

Consider:

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
        operation();
    }
}
```

The outer loop executes `n` times.

For every outer-loop iteration, the inner loop also executes `n` times.

Therefore:

$$
T(n) = n \times n
$$

$$
T(n) = n^2
$$

Hence:

$$
T(n) = O(n^2)
$$

---

### 3. If-Else Statement

Consider:

```java
if (condition) {
    operation1();
} else {
    operation2();
}
```

If both branches contain constant-time operations:

$$
T(n) = O(1)
$$

If a loop exists inside one branch, analyze the branch with the larger growth rate.

For example:

```java
if (condition) {
    operation();
} else {
    for (int i = 1; i <= n; i++) {
        operation();
    }
}
```

The complexity is:

$$
O(n)
$$

because the linear branch dominates the constant-time branch.

---

## 1.18 Logarithmic Complexity

A loop is logarithmic when the value changes by multiplication or division rather than by a constant addition.

Example:

```java
for (int i = 1; i <= n; i = i * 2) {
    operation();
}
```

The values of `i` are:

```text
1 → 2 → 4 → 8 → 16 → 32 → ...
```

After `k` iterations:

$$
i = 2^k
$$

The loop stops when:

$$
2^k \geq n
$$

Taking logarithm:

$$
k \geq \log_2 n
$$

Therefore:

$$
T(n) = O(\log n)
$$

### Important Pattern

```text
i = i + 1   → O(n)

i = i * 2   → O(log n)

i = i / 2   → O(log n)
```

---

## 1.19 Logarithm Basics for Algorithm Analysis

Some useful logarithm rules:

### Rule 1

$$
\log(xy) = \log x + \log y
$$

### Rule 2

$$
\log\left(\frac{x}{y}\right) = \log x - \log y
$$

### Rule 3

$$
\log(x^k) = k\log x
$$

### Rule 4

If:

$$
2^k = n
$$

then:

$$
k = \log_2 n
$$

In Big-O analysis, the base of the logarithm is usually ignored because different bases differ only by a constant factor.

Therefore:

$$
O(\log_2 n) = O(\log n)
$$

---

## 1.20 Common Summations

Understanding common mathematical series is useful when calculating algorithm complexity.

### Arithmetic Series

The sum:

$$
1 + 2 + 3 + \cdots + n
$$

is:

$$
\frac{n(n+1)}{2}
$$

Therefore:

$$
1 + 2 + 3 + \cdots + n = O(n^2)
$$

---

### Geometric Series

Consider:

$$
1 + 2 + 4 + 8 + \cdots + 2^k
$$

The sum of a geometric series is:

$$
1 + 2 + 4 + \cdots + 2^k = 2^{k+1} - 1
$$

If:

$$
2^k = n
$$

then:

$$
2^{k+1} = 2n
$$

Therefore:

$$
1 + 2 + 4 + \cdots + n = O(n)
$$

---

### Harmonic Series

Consider:

$$
1 + \frac{1}{2} + \frac{1}{3} + \frac{1}{4} + \cdots + \frac{1}{n}
$$

This is the harmonic series.

Its growth is:

$$
O(\log n)
$$

Therefore:

$$
\sum_{i=1}^{n} \frac{1}{i} = O(\log n)
$$

---

### Sum of Logarithms

Consider:

$$
\sum_{i=1}^{n} \log i
$$

Using the logarithm property:

$$
\log a + \log b = \log(ab)
$$

we get:

$$
\sum_{i=1}^{n} \log i = \log(1 \times 2 \times 3 \times \cdots \times n) = \log(n!)
$$

Since:

$$
\log(n!) = O(n\log n)
$$

we get:

$$
\sum_{i=1}^{n} \log i = O(n\log n)
$$

---

## 1.21 Common Loop Patterns

### Pattern 1 — Linear

```java
for (int i = 1; i <= n; i++) {
    operation();
}
```

Complexity:

$$
O(n)
$$

---

### Pattern 2 — Quadratic

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
        operation();
    }
}
```

Complexity:

$$
O(n^2)
$$

---

### Pattern 3 — Logarithmic

```java
for (int i = 1; i <= n; i = i * 2) {
    operation();
}
```

Complexity:

$$
O(\log n)
$$

---

### Pattern 4 — Linearithmic

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j = j * 2) {
        operation();
    }
}
```

Outer loop:

$$
O(n)
$$

Inner loop:

$$
O(\log n)
$$

Therefore:

$$
O(n\log n)
$$

---

## 1.22 Recurrence Relations — Introduction

A recurrence relation describes the running time of a recursive algorithm in terms of the running time of a smaller input.

For example:

$$
T(n) = 2T\left(\frac{n}{2}\right) + O(n)
$$

This means:

- The problem creates `2` smaller recursive problems.
- Each recursive problem has size `n/2`.
- `O(n)` additional work is performed outside the recursive calls.

Another example:

$$
T(n) = 3T(n-1) + O(1)
$$

This means:

- There are `3` recursive calls.
- Each call works on a problem of size `n-1`.
- There is constant additional work.

### Basic Components

A recurrence can generally be viewed as:

$$
T(n) = \text{recursive work} + \text{additional work}
$$

For example:

$$
T(n) = 2T\left(\frac{n}{2}\right) + n
$$

where:

```text
2T(n/2) → recursive work
n       → additional work
```

We will solve recurrence relations separately while studying recursive algorithms.

---

## 1.23 Master Theorem — Preview

The Master Theorem is used to solve certain recurrence relations that arise from divide and conquer algorithms.

A common form is:

$$
T(n) = aT\left(\frac{n}{b}\right) + f(n)
$$

where:

- `a` = number of recursive subproblems
- `n/b` = size of each subproblem
- `f(n)` = additional work required to divide and combine

Example:

$$
T(n) = 2T\left(\frac{n}{2}\right) + O(n)
$$

Here:

```text
a = 2
b = 2
f(n) = O(n)
```

The Master Theorem can then be used to determine the asymptotic complexity.

> Note: Detailed divide and conquer and Master Theorem problems will be covered later. For now, focus on understanding how to identify the recursive structure.


