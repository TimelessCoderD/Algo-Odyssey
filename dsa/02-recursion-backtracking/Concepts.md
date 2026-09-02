# Recursion & Backtracking — Notes

## Chapter 2

This chapter focuses on understanding recursion deeply before moving to
recursion patterns and backtracking.

---

# Phase 1 — Understand Recursion

## 1. What is Recursion?

Recursion is a technique where a function calls itself to solve a smaller
version of the same problem.

A recursive function normally contains:

1. Base Case
2. Recursive Case

Example:

```java
static void fun(int n) {

    if (n == 0)
        return;

    System.out.print(n);
    fun(n - 1);
}
```

---

## 2. Base Case

The base case tells recursion when to stop.

```
if (n == 0)
    return;
```

Without a valid base case, the function can keep calling itself indefinitely

until the call stack is exhausted.

---

## 3. Recursive Case

The recursive case is where the function calls itself with a smaller or

simpler problem.

```
fun(n - 1);
```

The problem becomes:

```
n
n - 1
n - 2
n - 3
...
0
```

---

# 4. Recursion and the Call Stack

Every function call creates a stack frame.

For:

```
fun(4);
```

the calls happen like:

```
fun(4)
  ↓
fun(3)
  ↓
fun(2)
  ↓
fun(1)
  ↓
fun(0)
```

`fun(0)` reaches the base case and returns.

Then the previous calls return one by one.

The call stack therefore follows:

```
GOING DOWN
4
3
2
1
0

COMING BACK
0
1
2
3
4
```

In Java, these method call frames are associated with the thread's JVM

stack. Local variables and method-call information are stored in stack

frames.

---

# 5. Printing Before the Recursive Call

Example:

```
static void fun(int n) {

    if (n == 0)
        return;

    System.out.print(n);
    fun(n - 1);
}
```

For:

```
fun(4);
```

Output:

```
4321
```

Why?

The print happens before the recursive call.

```
fun(4) → print 4
          ↓
fun(3) → print 3
          ↓
fun(2) → print 2
          ↓
fun(1) → print 1
          ↓
fun(0) → return
```

---

# 6. Work Before vs Work After Recursion

Consider:

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
fun(4);
```

The first print happens while going down:

```
4 3 2 1
```

The second print happens while returning:

```
1 2 3 4
```

Therefore:

```
43211234
```

Important idea:

```
Before recursive call → going down
After recursive call  → coming back
```

---

# Phase 2 — Think Recursively

We are currently in Phase 2.

The goal is to learn how to think about a recursive problem rather than

simply memorizing recursive code.

---

# 7. Recursive Thinking

When solving a recursive problem, ask:

1. What is the smallest problem?
2. What is the base case?
3. How can I reduce the current problem?
4. What should the recursive call receive?
5. What work happens before the recursive call?
6. What work happens after the recursive call?
7. What is the recurrence T(n)?
8. What is the space complexity?

---

# 8. Recursive Sum

We can calculate:

```
1 + 2 + 3 + ... + n
```

using:

```
sum(n) = n + sum(n - 1)
```

Base case:

```
sum(0) = 0
```

Therefore:

```
static int sum(int n) {

    if (n == 0)
        return 0;

    return n + sum(n - 1);
}
```

For `sum(5)`:

```
sum(5)
 ↓
5 + sum(4)
      ↓
    4 + sum(3)
          ↓
        3 + sum(2)
              ↓
            2 + sum(1)
                  ↓
                1 + sum(0)
                        ↓
                        0
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

Answer:

```
15
```

---

# 9. Accumulator Style Recursion

Another way is to carry the current result as a parameter.

Example:

```
static int sum(int i, int total, int n) {

    if (i > n)
        return total;

    return sum(i + 1, total + i, n);
}
```

For `sum(1, 0, 5)`:

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

At this point:

```
i > n
```

so:

```
return 15
```

The important difference:

### Normal recursion

Calculation is completed while returning.

```
GO DOWN
      ↓
BASE CASE
      ↓
CALCULATE WHILE RETURNING
```

### Accumulator recursion

Calculation is performed before making the next call.

```
CALCULATE
    ↓
PASS RESULT
    ↓
NEXT CALL
    ↓
BASE CASE
    ↓
RETURN FINAL RESULT
```

---

# 10. Factorial

Factorial:

```
n! = n × (n - 1) × (n - 2) × ... × 1
```

Recursive definition:

```
0! = 1
n! = n × (n - 1)! 
```

Implementation:

```
static int fact(int n) {

    if (n == 0)
        return 1;

    return n * fact(n - 1);
}
```

For:

```
fact(4)
```

the calls are:

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
                     ↓
                     1
```

Returning:

```
fact(0) = 1
fact(1) = 1
fact(2) = 2
fact(3) = 6
fact(4) = 24
```

---

# 11. Factorial Time Complexity

There is one recursive call:

```
fact(n - 1)
```

Therefore:

```
T(n) = T(n - 1) + O(1)
```

Expand:

```
T(n)
= T(n - 1) + 1
= T(n - 2) + 2
= T(n - 3) + 3
...
```

The recursion depth is `n`.

Therefore:

```
Time Complexity  = O(n)
Space Complexity = O(n)
```

The O(n) space comes from the recursion call stack.

---

# 12. Power Recursion

Power can be defined as:

```
power(a, n) = a × power(a, n - 1)
```

Base case:

```
power(a, 0) = 1
```

Example:

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

Finally:

```
power(3, 0) = 1
```

and the result is:

```
81
```

The simple recursive version has:

```
T(n) = T(n - 1) + O(1)
```

Therefore:

```
Time Complexity  = O(n)
Space Complexity = O(n)
```

---

# 13. Multiple Recursive Calls

Until now, we mostly used one recursive call.

Now consider:

```
static void fun(int n) {

    if (n == 0)
        return;

    fun(n - 1);
    fun(n - 1);
}
```

Each call creates two new recursive calls.

For `fun(2)`:

```
              fun(2)
             /      \
        fun(1)      fun(1)
        /   \        /   \
     fun(0) fun(0) fun(0) fun(0)
```

Number of calls per level:

```
Level 0 → 1
Level 1 → 2
Level 2 → 4
```

Total:

```
1 + 2 + 4 = 7
```

For `fun(3)`:

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

At level `k`:

```
Number of calls = 2^k
```

The total number of calls is:

```
1 + 2 + 4 + ... + 2^n
```

Therefore:

```
Total calls = 2^(n + 1) - 1
```

So:

```
Time Complexity = O(2^n)
```

---

# 14. Recurrence for Multiple Recursion

For:

```
fun(n - 1);
fun(n - 1);
```

the recurrence is:

```
T(n) = 2T(n - 1) + O(1)
```

For simplicity:

```
T(n) = 2T(n - 1) + 1
```

Expand:

```
T(n)
= 2T(n - 1) + 1

= 2[2T(n - 2) + 1] + 1

= 4T(n - 2) + 3

= 8T(n - 3) + 7
```

General form:

```
T(n) = 2^k T(n - k) + (2^k - 1)
```

At:

```
k = n
```

we reach the base case.

Therefore:

```
T(n) = 2^n T(0) + (2^n - 1)
```

Hence:

```
T(n) = O(2^n)
```

---

# 15. Divide Recursion

Now consider:

```
static void fun(int n) {

    if (n <= 1)
        return;

    fun(n / 2);
    fun(n / 2);
}
```

The important difference is:

```
n → n / 2 → n / 4 → n / 8 → ...
```

instead of:

```
n → n - 1 → n - 2 → n - 3 → ...
```

For `fun(16)`:

```
Level 0 → 1
Level 1 → 2
Level 2 → 4
Level 3 → 8
Level 4 → 16
```

Total calls:

```
1 + 2 + 4 + 8 + 16 = 31
```

---

# 16. Recurrence for Divide Recursion

There are two recursive calls and each receives `n / 2`.

Therefore:

```
T(n) = 2T(n / 2) + O(1)
```

Using a constant for the non-recursive work:

```
T(n) = 2T(n / 2) + 1
```

Expand:

```
T(n)
= 2T(n / 2) + 1

= 2[2T(n / 4) + 1] + 1

= 4T(n / 4) + 3

= 8T(n / 8) + 7

...
```

After `k` levels:

```
T(n) = 2^k T(n / 2^k) + (2^k - 1)
```

---

# 17. Finding the Number of Levels

We stop when:

```
n / 2^k = 1
```

Therefore:

```
n = 2^k
```

Taking log base 2:

```
k = log₂ n
```

Substitute:

```
T(n)
= 2^k T(n / 2^k) + (2^k - 1)

= 2^(log₂ n) T(1) + (2^(log₂ n) - 1)
```

Using:

```
2^(log₂ n) = n
```

we get:

```
T(n) = nT(1) + (n - 1)
```

Since `T(1)` is constant:

```
T(n) = n + n - 1

T(n) = 2n - 1
```

Therefore:

```
Time Complexity = Θ(n)
```

and:

```
Space Complexity = O(log n)
```

because the maximum recursion depth is `log₂ n`.

---

# 18. Why 2^(log₂ n) = n

Definition of logarithm:

```
log₂ n = k
```

means:

```
2^k = n
```

Therefore:

```
2^(log₂ n) = n
```

Example:

```
log₂ 16 = 4

2^(log₂ 16)
= 2^4
= 16
```

General rule:

```
a^(logₐ x) = x
```

---

# 19. Master Theorem

Master Theorem is used for recurrences of the form:

```
T(n) = aT(n / b) + f(n)
```

Where:

```
a = number of recursive calls
b = factor by which the input size is reduced
f(n) = work outside recursive calls
```

Example:

```
T(n) = 2T(n / 2) + O(1)
```

Therefore:

```
a = 2
b = 2
f(n) = O(1)
```

Calculate:

```
n^(log_b a)

= n^(log₂ 2)

= n
```

Since:

```
f(n) = O(1)
```

is smaller than:

```
n
```

Master Theorem Case 1 applies.

Therefore:

```
T(n) = Θ(n)
```

---

# 20. Master Theorem — Important Limitation

Master Theorem does NOT directly apply to:

```
T(n) = 2T(n - 1) + O(1)
```

because the recursive problem is:

```
n - 1
```

rather than:

```
n / b
```

Master Theorem is designed for:

```
T(n) = aT(n / b) + f(n)
```

Therefore:

```
2T(n - 1)  → Master Theorem ❌
2T(n / 2)  → Master Theorem ✅
```

---

# 21. Important Comparison

## Case 1

```
T(n) = 2T(n - 1) + O(1)
```

Levels:

```
n → n - 1 → n - 2 → ... → 1
```

Number of levels:

```
O(n)
```

Number of nodes grows:

```
1 → 2 → 4 → 8 → ...
```

Therefore:

```
Time = O(2^n)
```

---

## Case 2

```
T(n) = 2T(n / 2) + O(1)
```

Levels:

```
n → n/2 → n/4 → n/8 → ... → 1
```

Number of levels:

```
O(log n)
```

Nodes at the final level:

```
n
```

Total:

```
1 + 2 + 4 + ... + n
= 2n - 1
```

Therefore:

```
Time = Θ(n)
```

---

# 22. General Recursion Complexity Checklist

When analyzing recursion:

1. Count the recursive calls.
2. Identify the size of each recursive subproblem.
3. Determine the base case.
4. Write T(n).
5. Expand T(n) if required.
6. Find the number of levels.
7. Calculate the total work.
8. Analyze recursion-stack space.

Do NOT decide complexity only by looking at the number of recursive calls.

For example:

```
2T(n - 1)
```

and:

```
2T(n / 2)
```

have two recursive calls each, but their complexities are different:

```
2T(n - 1) → O(2^n)

2T(n / 2) → O(n)
```
---

# Phase 3 — Recursion Patterns

### Pattern 1 — Linear Recursion

Linear recursion occurs when every function invocation makes exactly one recursive call.

Example:

f(n)
    ↓
f(n-1)
    ↓
f(n-2)
    ↓
...

There is only one path and no branching.

### Linear vs Multiple Recursion

Linear recursion:

f(n)
    ↓
f(n-1)

Multiple recursion:

f(n)
   / \
f(n-1) f(n-1)

Therefore:

1 recursive call → Linear recursion

2 or more recursive calls → Multiple recursion

---

## Recursive Array Pattern

For array problems, an index is commonly used to represent the current position.

Example:

sum(arr, index)

The index moves forward:

index → index + 1

The recursive function processes the current element and recursively processes the remaining elements.

General pattern:

current element
+
recursive solution for remaining elements

---

## Recursive Array Sum

Function:

sum(arr, index)

Meaning:

"Return the sum of all elements from index to the end."

Recursive case:

arr[index] + sum(arr, index + 1)

Base case:

index == arr.length

Return:

0

Why return 0?

Because 0 is the identity value for addition:

x + 0 = x

---

## Recursive Maximum

Function:

max(arr, index, maxval)

Meaning:

"Process the array from index onward while carrying the maximum value found so far."

At every step:

maxval = max(maxval, arr[index])

Then move forward:

index + 1

Base case:

index == arr.length

Return:

maxval

---

## Accumulator / State Parameter

An accumulator stores the partial answer while recursion moves forward.

Examples:

Sum:

total = total + arr[index]

Maximum:

maxval = max(maxval, arr[index])

The accumulator allows the function to carry information from one recursive call to the next.

---

## Important Recursive Thinking

When solving a recursive problem, ask:

1. What does my function mean?
2. What is the smaller version of the same problem?
3. What information must be carried to the smaller problem?
4. What is the base case?
5. How does the current state change?

Do not start by writing code.

First define the meaning of the function.

---

## Key Insight From Today's Work

The important improvement today was moving from:

"How do I write this particular recursion?"

to:

"What pattern does this problem follow?"

Array sum and array maximum have the same linear-recursion structure.

Only the operation being performed changes.