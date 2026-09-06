# Recursion Complexity

## 1. One Recursive Call

T(n) = T(n - 1) + O(1)

Time  = O(n)
Space = O(n)

## 2. Two Recursive Calls — n - 1

T(n) = 2T(n - 1) + O(1)

Time = O(2^n)
Space = O(n)

## 3. Two Recursive Calls — n / 2

T(n) = 2T(n / 2) + O(1)

Time = Θ(n)
Space = O(log n)

## 4. One Recursive Call — n / 2

T(n) = T(n / 2) + O(1)

Time = O(log n)
Space = O(log n)

## 5. Two Recursive Calls — n / 2 + Linear Work

T(n) = 2T(n / 2) + O(n)

Time = O(n log n)

## Master Theorem

T(n) = aT(n/b) + f(n)

Calculate:

n^(log_b a)

Then compare f(n) with n^(log_b a).

---

# Phase 3 : Recursion patterns

## Linear Recursion

A linear recursive function makes one recursive call per step.

Example:

f(n) = f(n - 1) + O(1)

Therefore:

Time = O(n)

Because there are approximately n recursive calls.

Space = O(n)

Because n function calls can remain on the recursion stack.

---

## Recursive Array Sum

Code pattern:

sum(arr, index)
    ↓
sum(arr, index + 1)

For an array of n elements:

T(n) = T(n - 1) + O(1)

Therefore:

Time Complexity = O(n)

Space Complexity = O(n)

The O(n) space comes from the recursion call stack.

---

## Recursive Maximum

Accumulator version:

max(arr, index, maxval)

Each recursive call advances the index by one.

For n elements:

T(n) = T(n - 1) + O(1)

Therefore:

Time Complexity = O(n)

Space Complexity = O(n)

---

## Linear Recursion Recognition

If each function call creates exactly one recursive call:

    f(n)
      ↓
    f(n-1)
      ↓
    f(n-2)
      ↓
    ...

Then:

Time is usually O(n) when the problem shrinks by one element.

Stack space is usually O(n).

---

## Important Distinction

Mathematical result ≠ number of operations.

For recursive sum:

1 + 2 + 3 + ... + n

is the mathematical result.

But the algorithm performs approximately one addition per recursive call.

Therefore the running time is:

O(n)

not:

O(n²).

---

## Accumulator Recursion

An accumulator carries the partial result between recursive calls.

Example:

maxval = maximum found so far

The recursive call performs the update before continuing.

Even though this looks similar to tail recursion:

return function(...)

Java does not generally perform tail-call optimization.

Therefore recursion stack space remains O(n).

## Check Sorted Array

At most `n - 1` adjacent pairs are checked.

```
Time = O(n)
Space = O(n)
```

Best case can be:

```
Time = O(1)
```

if the first pair is not sorted.

---

## Count Occurrences

Every element must be examined.

```
Time = O(n)
Space = O(n)
```

---

## First Occurrence

Worst case:

```
Time = O(n)
Space = O(n)
```

Best case:

```
Time = O(1)
```

if the first element matches.

---

## Last Occurrence — Right to Left

Worst case:

```
Time = O(n)
Space = O(n)
```

Best case:

```
Time = O(1)
```

if the last element matches.

---

# Multiple Recursion

Example:

```
fun(n - 1)
fun(n - 1)
```

Recurrence:

```
T(n) = 2T(n - 1) + O(1)
```

Time:

```
O(2^n)
```

Space:

```
O(n)
```

---

# Divide Recursion

Example:

```
fun(n / 2)
fun(n / 2)
```

Recurrence:

```
T(n) = 2T(n/2) + O(1)
```

Time:

```
O(n)
```

Space:

```
O(log n)
```

---

# Master Theorem Baseline

For:

```
T(n) = aT(n/b) + f(n)
```

the recursive-tree baseline is:

```
n^(log_b a)
```

Derivation:

```
number of nodes at level k = a^k
```

Stop when:

```
n / b^k = 1
```

Therefore:

```
k = log_b n
```

Leaves:

```
a^(log_b n)
=
n^(log_b a)
```

---

# String Reverse Using String Concatenation

The recursion itself makes `n` calls.

However, Java `String` is immutable.

Using:

```
revString += character;
```

creates new String objects and copies characters.

Therefore repeated concatenation can make the total character-copying work:

```
O(n²)
```

The recursion stack itself is:

```
O(n)
```

A `StringBuilder` implementation can reduce the string-building cost substantially and will be studied later.


# Pattern 2 — Divide & Conquer Complexity

## 1. T(n) = T(n/2) + 1

Expansion:

T(n)
= T(n/2) + 1
= T(n/4) + 2
= T(n/8) + 3
= ...
= T(n/2^k) + k

Base case:

n/2^k = 1

2^k = n

k = log₂n

Therefore:

T(n) = O(log n)

---

## 2. T(n) = 2T(n/2) + 1

Expansion:

T(n)
= 2T(n/2) + 1
= 4T(n/4) + 3
= 8T(n/8) + 7
= ...
= 2^kT(n/2^k) + (2^k - 1)

At the base case:

2^k = n

Therefore:

T(n) = nT(1) + n - 1

If T(1) = 1:

T(n) = 2n - 1

Therefore:

T(n) = O(n)

---

## 3. T(n) = 2T(n/2) + n

Expansion:

T(n)
= 2T(n/2) + n
= 4T(n/4) + 2n
= 8T(n/8) + 3n
= ...
= 2^kT(n/2^k) + kn

At the base case:

2^k = n

k = log₂n

Therefore:

T(n) = nT(1) + n log₂n

Therefore:

T(n) = O(n log n)

---

## 4. T(n - 2)

Recurrence:

T(n) = T(n - 2) + 1

Expansion:

T(n)
= T(n-2) + 1
= T(n-4) + 2
= T(n-6) + 3
= ...
= T(n-2k) + k

Base case:

n - 2k = 0

2k = n

k = n/2

Therefore:

T(n) = O(n)

Important:

The algorithm performs approximately n/2 operations, but:

O(n/2) = O(n)

because constant factors are ignored.

---

## 5. Binary Search

Recurrence:

T(n) = T(n/2) + O(1)

Therefore:

Time → O(log n)

Space → O(log n)

Best case → O(1)

Worst case → O(log n)