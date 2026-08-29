# Mistakes & Confusions — DSA Algorithm Analysis

This file records the mistakes and confusion points that repeatedly appeared while solving Problems.

The goal is not to memorize answers, but to remember the reasoning process that leads to the right complexity.

---

## 1. `log(n/2)` vs `log n`

### Confusion
A recurrence such as:

```text
T(n) = T(n/2) + ...
```

does not mean the answer is `log(n/2)`.

The `n/2` describes the size of the next recursive problem, not the final answer itself.

If we repeatedly halve:

```text
n → n/2 → n/4 → n/8 → ... → 1
```

then the number of halvings is:

```text
log₂ n
```

So:

```text
T(n) = T(n/2) + 1
```

gives:

```text
Θ(log n)
```

---

## 2. Why `log log n` appears with `√n`

This was one of the major confusion points.

For:

```text
T(n) = T(√n) + 1
```

the input shrinks as:

```text
n → √n → n^(1/4) → n^(1/8) → ...
```

We stop when:

```text
n^(1/2^k) ≈ 2
```

Taking logs:

```text
(1/2^k) log n ≈ constant
```

Therefore:

```text
2^k ≈ log n
```

and:

```text
k ≈ log(log n)
```

So:

```text
T(n) = Θ(log log n)
```

---

## 3. Why Master Theorem uses `n^(log_b a)`

For:

```text
T(n) = aT(n/b) + f(n)
```

after `k` levels:

- Number of subproblems = `a^k`
- Size of each subproblem = `n / b^k`

The recursion reaches the base case when:

```text
n / b^k = 1
```

So:

```text
b^k = n
```

and:

```text
k = log_b n
```

Number of leaves:

```text
a^k = a^(log_b n)
```

Using the logarithm identity:

```text
a^(log_b n) = n^(log_b a)
```

That is why the comparison term is:

```text
n^(log_b a)
```

It is not an arbitrary exponent. It represents the work created by branching in the recursion tree.

---

## 4. Master Theorem Case 1 / 2 / 3

For:

```text
T(n) = aT(n/b) + f(n)
```

first calculate:

```text
g(n) = n^(log_b a)
```

Then compare `f(n)` with `g(n)`.

### Case 1
If `f(n)` is smaller, recursive work dominates.

Result:

```text
Θ(g(n))
```

### Case 2
If `f(n)` and `g(n)` are the same order, both contribute at every level.

Result:

```text
Θ(g(n) log n)
```

### Case 3
If `f(n)` is larger, the non-recursive work dominates.

Result:

```text
Θ(f(n))
```

---

## 5. Do not confuse `log n × log n` with `log log n`

These are different:

```text
(log n)^2
```

versus:

```text
log(log n)
```

Example for `n = 1,000,000`:

- `log₂ n` is about 20
- `(log₂ n)^2` is about 400
- `log₂(log₂ n)` is about 4–5

---

## 6. `1 + 2 + 4 + 8` is not automatically `log n`

If:

```text
j = 1
j = j * 2
```

then the values are:

```text
1, 2, 4, 8, ...
```

These are the values of `j`, not the number of iterations.

The number of iterations is logarithmic because:

```text
1, 2, 4, 8, ... 2^k ≈ n
```

So:

```text
k = log₂ n
```

Do not add the values unless the code is actually doing a summation.

---

## 7. Nested loops are not always simply multiplied

For:

```text
for i = 1 to n
    for j = 1 to n
```

multiplication works:

```text
n × n = n²
```

But if:

```text
for i = 1 to n
    for j = 1 to i²
```

then the inner loop depends on `i`.

So we should sum:

```text
1² + 2² + 3² + ... + n²
```

which gives:

```text
Θ(n³)
```

---

## 8. Problem 57 — `j < i²`

The mistake here was thinking the work was simply `n²` repeatedly.

For a fixed `i`, the number of `j` values is about:

```text
i²
```

Now, the inner loop runs up to `j`. If it only runs for values divisible by `i`, then the valid values are roughly:

```text
i, 2i, 3i, ..., i²
```

The total work for that `i` is:

```text
i + 2i + 3i + ... + i²
```

This is:

```text
Θ(i³)
```

Then summing over all `i` gives:

```text
Σ i³ = Θ(n⁴)
```

So the correct result is:

```text
Θ(n⁴)
```

---

## 9. Early return changes lower bounds

Prime checking:

```text
for i = 2 to sqrt(n)
    if n % i == 0:
        return
```

Worst case:

```text
√n
```

Best case:

```text
1
```

Therefore:

```text
O(√n) and Ω(1)
```

Do not automatically say `Ω(√n)`.

---

## 10. Worst case vs best case

When a question asks for worst-case complexity, choose the branch or path that performs the most work.

Example:

```text
if (...) {
    O(1)
} else {
    O(n)
}
```

For worst-case analysis, use:

```text
O(n)
```

---

## 11. Recursion: identify the base case first

Before solving:

```text
function(n)
```

ask:

### What stops recursion?

Example:

```text
if (n <= 1)
    return;
```

Then identify the recursive case:

```text
function(n/2)
```

Only after this should the recurrence be written.

---

## 12. Recursion does not mean exponential

This was a major misconception.

One recursive call:

```text
T(n) = T(n/2) + O(1)
```

is logarithmic.

Two recursive calls:

```text
T(n) = 2T(n/2) + O(1)
```

is linear.

Three recursive calls:

```text
T(n) = 3T(n/2) + O(1)
```

is polynomial.

The number of recursive calls and the reduction in problem size both matter.

---

## 13. Recursion tree: calculate work per level

For:

```text
T(n) = T(n/2) + T(2n/3) + n²
```

Level 0 work:

```text
n²
```

Level 1 work:

```text
(n/2)² + (2n/3)²
```

which is:

```text
25n²/36
```

The next level is smaller again.

So total work is:

```text
n² + 25n²/36 + ...
```

This is a geometric series.

Therefore:

```text
Θ(n²)
```

The important thing is the sum of work across all nodes at the same level.

---

## 14. `2^(log n)` must be simplified

If the logarithm base is 2:

```text
2^(log₂ n) = n
```

So this is not exponential anymore.

It is:

```text
Θ(n)
```

Always simplify before ranking growth.

---

## 15. Same-base exponent comparison

Compare:

```text
3^(n^0.75) and 3^n
```

Since:

```text
n^0.75 < n
```

we get:

```text
3^(n^0.75) < 3^n
```

Therefore:

```text
3^(n^0.75) = O(3^n)
```

---

## 16. `2^(3n)` is NOT `O(2^n)`

Simplify:

```text
2^(3n) = 8^n
```

Since `8^n` grows faster than `2^n`:

```text
2^(3n) ≠ O(2^n)
```

The correct relation is:

```text
2^n = O(2^(3n))
```

---

## 17. Recurrence expansion is a learning tool

When recursion is difficult to visualize:

Start with:

```text
T(n)
```

Then write:

```text
T(n/2)
```

Then:

```text
T(n/4)
```

Then:

```text
T(n/8)
```

Do not jump directly to the final answer.

The goal is to see:

- how many calls appear,
- how the input changes,
- what work happens at each level,
- where the recursion stops.

---

## Problem 56 — Master Theorem

For:

```text
T(n) = 2T(n/2) + n
```

do not stop after identifying `f(n) = n`.

Calculate:

```text
n^(log₂ 2) = n
```

Since both are the same order, this is Case 2:

```text
Θ(n log n)
```

---

## Problem 57 — `j < i²`

### Mistake
Simply multiplying and claiming `O(n⁵)` without checking the dependency between loops.

### Correct reasoning
The inner loop runs only for values satisfying:

```text
j % i == 0
```

For fixed `i`, valid values are roughly:

```text
i, 2i, 3i, ..., i²
```

So inner work is:

```text
i + 2i + 3i + ... + i² = Θ(i³)
```

Then:

```text
Σ i³ = Θ(n⁴)
```

Correct result:

```text
Θ(n⁴)
```

---

## Problem 58 vs Problem 59

### Problem 58
Repeatedly multiply by 9:

```text
9 × 9 × 9 × ...
```

Number of operations:

```text
Θ(n)
```

### Problem 59
Exponentiation by squaring:

```text
n → n/2 → n/4 → ...
```

Number of levels:

```text
Θ(log n)
```

### Core idea
If the input is reduced by a constant factor each step, think logarithmic.

---

## Problem 60 — Master Theorem not always directly applicable

```text
T(n) = T(n/2) + T(n/4) + n
```

does not match `aT(n/b) + f(n)` directly because the recursive calls have different sizes.

Use a recursion-tree / geometric-series argument instead.

At the first level:

```text
n/2 + n/4 = 3n/4
```

Since the total recursive size shrinks by a constant factor each level, the total work is:

```text
Θ(n)
```

---

## Problem 61 — Worst case matters

If one branch costs `O(1)` and another costs `O(n)`, then:

- best case may be `O(1)`
- worst case may be `O(n)`
- if the branch itself is nested, worst-case may become `O(n²)`

For worst-case analysis, always choose the branch that performs more work.

---

## Problem 62 — Simplify before comparing

Examples:

```text
2^(log₂ n) = n
3^n + n² + 20n = Θ(3^n)
n·3^n is larger than 3^n
```

Never compare complicated expressions before simplifying them.

---

## Problem 63 — Same base

For:

```text
3^(n^0.75) vs 3^n
```

compare:

```text
n^0.75 vs n
```

Since:

```text
n^0.75 < n
```

we get:

```text
3^(n^0.75) = O(3^n)
```

---

## Problem 64 — Do not compare exponents incorrectly

```text
2^(3n) = 8^n
```

This is not the same asymptotic order as `2^n`.

The correct direction is:

```text
2^n = O(2^(3n))
```

but:

```text
2^(3n) ≠ O(2^n)
```

---

# Personal rule for future recursion problems

When stuck, write only these five things:

```text
1. Base case
2. Recursive call(s)
3. Recurrence
4. Work at one level
5. Final complexity
```

If the recurrence is:

```text
T(n) = aT(n/b) + f(n)
```

then immediately calculate:

```text
n^(log_b a)
```

and compare it with `f(n)`.

Do not memorize answers. Memorize the process.
