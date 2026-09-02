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