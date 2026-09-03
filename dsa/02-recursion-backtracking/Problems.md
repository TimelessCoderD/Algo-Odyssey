# Recursion & Backtracking — Problems

This file contains the recursion problems and exercises completed so far.

---

# Problem 1 — Print Numbers Using Recursion

## Problem

Print numbers from `n` down to `1` using recursion.

Example:

```text
Input:
4

Output:
4 3 2 1
```

## Recursive Idea

Print the current number and then solve the smaller problem:

```
print(n)
print(n - 1)
...
```

## Base Case

```
n == 0
```

## Complexity

```
Time  = O(n)
Space = O(n)
```

---

# Problem 2 — Understand Print During Return

## Problem

Understand the difference between printing before and after the recursive

call.

Example:

```
static void fun(int n) {

    if (n == 0)
        return;

    System.out.print(n);

    fun(n - 1);

    System.out.print(n);
}
```

For:

```
fun(4)
```

Output:

```
43211234
```

## Key Learning

First print:

```
4 3 2 1
```

happens while going down.

Second print:

```
1 2 3 4
```

happens while returning.

---

# Problem 3 — Sum of 1 to N

## Problem

Calculate:

```
1 + 2 + 3 + ... + n
```

## Recursive Definition

```
sum(n) = n + sum(n - 1)

sum(0) = 0
```

## Example

```
sum(5)
```

Trace:

```
sum(5)
 ↓
sum(4)
 ↓
sum(3)
 ↓
sum(2)
 ↓
sum(1)
 ↓
sum(0)
```

Returning:

```
0
1
3
6
10
15
```

## Complexity

```
Time  = O(n)
Space = O(n)
```

---

# Problem 4 — Sum Using an Accumulator

## Problem

Calculate the sum from `1` to `n` by carrying the current result as a

parameter.

## Example

```
sum(1, 0, 5)
```

Trace:

```
sum(1, 0, 5)
       ↓
sum(2, 1, 5)
       ↓
sum(3, 3, 5)
       ↓
sum(4, 6, 5)
       ↓
sum(5, 10, 5)
       ↓
sum(6, 15, 5)
```

Base case:

```
6 > 5
```

Return:

```
15
```

## Key Learning

The calculation happens before making the next recursive call.

## Complexity

```
Time  = O(n)
Space = O(n)
```

---

# Problem 5 — Factorial

## Problem

Calculate:

```
n!
```

where:

```
n! = n × (n - 1) × ... × 1
```

## Base Case

```
0! = 1
```

## Recursive Definition

```
fact(n) = n × fact(n - 1)
```

## Example

```
fact(4)
```

Trace:

```
fact(4)
 ↓
4 × fact(3)
       ↓
     3 × fact(2)
           ↓
         2 × fact(1)
               ↓
             1 × fact(0)
```

Returning:

```
1
1
2
6
24
```

## Recurrence

```
T(n) = T(n - 1) + O(1)
```

## Complexity

```
Time  = O(n)
Space = O(n)
```

---

# Problem 6 — Power

## Problem

Calculate:

```
a^n
```

using recursion.

## Recursive Definition

```
power(a, n) = a × power(a, n - 1)
```

## Base Case

```
power(a, 0) = 1
```

## Example

```
power(3, 4)
```

Conceptually:

```
3 × power(3, 3)
       ↓
     3 × power(3, 2)
            ↓
          3 × power(3, 1)
                 ↓
               3 × power(3, 0)
```

Result:

```
81
```

## Complexity

For the simple recursive implementation:

```
Time  = O(n)
Space = O(n)
```

---

# Problem 7 — Multiple Recursive Calls

## Problem

Understand a function that makes two recursive calls:

```
static void fun(int n) {

    if (n == 0)
        return;

    fun(n - 1);
    fun(n - 1);
}
```

## Recursion Tree for `fun(2)`

```
              fun(2)
             /      \
        fun(1)      fun(1)
        /   \        /   \
     fun(0) fun(0) fun(0) fun(0)
```

Calls per level:

```
Level 0 → 1
Level 1 → 2
Level 2 → 4
```

Total:

```
1 + 2 + 4 = 7
```

## For `fun(3)`

```
Level 0 → 1
Level 1 → 2
Level 2 → 4
Level 3 → 8
```

Total:

```
1 + 2 + 4 + 8 = 15
```

## Recurrence

```
T(n) = 2T(n - 1) + O(1)
```

## Complexity

```
Time = O(2^n)
```

---

# Problem 8 — Divide Recursion

## Problem

Understand a function that makes two recursive calls on half the input:

```
static void fun(int n) {

    if (n <= 1)
        return;

    fun(n / 2);
    fun(n / 2);
}
```

## Example

For:

```
fun(16)
```

Recursion levels:

```
Level 0 → 1
Level 1 → 2
Level 2 → 4
Level 3 → 8
Level 4 → 16
```

Total calls:

```
1 + 2 + 4 + 8 + 16
= 31
```

## Recurrence

```
T(n) = 2T(n / 2) + O(1)
```

Using constant work:

```
T(n) = 2T(n / 2) + 1
```

Expansion:

```
T(n)
= 2T(n / 2) + 1

= 4T(n / 4) + 3

= 8T(n / 8) + 7

...

= 2^k T(n / 2^k) + (2^k - 1)
```

Stop when:

```
n / 2^k = 1
```

Therefore:

```
k = log₂ n
```

Then:

```
T(n)
= 2^(log₂ n)T(1) + (2^(log₂ n) - 1)

= nT(1) + n - 1

= 2n - 1
```

Therefore:

```
Time Complexity = Θ(n)
Space Complexity = O(log n)
```

---

# Phase 3 — Recursive Thinking

### 10. Recursive Array Sum

Find the sum of an array using linear recursion.

Example:

[10, 20, 30, 40, 50]

Answer:

150

Status: Solved

Complexity:

Time: O(n)
Space: O(n)

---

### 11. Recursive Array Maximum

Find the maximum element using linear recursion.

Example:

[10, 40, 25, 70, 30]

Answer:

70

Status: Solved

Approach used:

Accumulator / state parameter

Function:

max(arr, idx, maxval)

Complexity:

Time: O(n)
Space: O(n)

---

### 12. Recursive Search

Determine whether a target exists in an array.

Example:

```
[10, 25, 40, 70, 90]
target = 40
```

Answer:

```
true
```

Status: Solved

---

### 13. Check Array is Sorted

Determine whether an array is sorted in ascending order.

Example:

```
[10, 20, 30, 40]
```

Answer:

```
true
```

Status: Solved

---

### 14. Count Occurrences

Count how many times a target appears in an array.

Example:

```
[10, 20, 10, 30, 10]
target = 10
```

Answer:

```
3
```

Status: Solved

---

### 15. First Occurrence

Find the first index of a target.

Example:

```
[10, 20, 30, 20, 40]
target = 20
```

Answer:

```
1
```

Status: Solved

---

### 16. Last Occurrence

Find the last index of a target.

Approach used:

Search from right to left.

Example:

```
[10, 20, 30, 20, 40]
target = 20
```

Answer:

```
3
```

Status: Solved

---

### 17. Reverse String

Reverse a string recursively using an accumulator.

Example:

```
"hello"
```

Answer:

```
"olleh"
```

Status: Solved

---

# Complexity Summary

| Problem | Recurrence | Time | Space |
| --- | --- | --- | --- |
| Print `n` to `1` | `T(n - 1) + O(1)` | `O(n)` | `O(n)` |
| Recursive Sum | `T(n - 1) + O(1)` | `O(n)` | `O(n)` |
| Accumulator Sum | `T(n - 1) + O(1)` | `O(n)` | `O(n)` |
| Factorial | `T(n - 1) + O(1)` | `O(n)` | `O(n)` |
| Power | `T(n - 1) + O(1)` | `O(n)` | `O(n)` |
| Two calls with `n - 1` | `2T(n - 1) + O(1)` | `O(2^n)` | `O(n)` |
| Two calls with `n / 2` | `2T(n / 2) + O(1)` | `Θ(n)` | `O(log n)` |

---

#
