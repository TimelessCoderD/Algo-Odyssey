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

