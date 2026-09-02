# Recursion & Backtracking — Mistakes & Learnings

This file records mistakes, doubts, and important corrections made while
learning recursion.

---

# 1. Confusing Loop Work with Recursion Work

### Mistake

For a recursive function, assuming that the complexity should always be:

```text
n + (n - 1) + (n - 2) + ... + 1
```

### Correction

This depends on what the function does at each recursive call.

For:

```
fun(n - 1);
```

there is one recursive call at each level:

```
n
n - 1
n - 2
...
1
```

So there are `n` levels.

But for:

```
fun(n - 1);
fun(n - 1);
```

each call creates two more calls.

The recursion tree becomes:

```
1
2
4
8
...
```

Therefore the complexity becomes exponential.

---

# 2. Why We Do Not Always Add 1 + 2 + 3 + ... + n

In a normal loop:

```
for (int i = 1; i <= n; i++) {
    // work
}
```

If the work itself increases with `i`, then we may have:

```
1 + 2 + 3 + ... + n
```

But a simple loop with constant work has:

```
1 + 1 + 1 + ... + 1
```

which is:

```
O(n)
```

The same principle applies to recursion.

We must identify the amount of work performed at each call.

---

# 3. Confusing Number of Calls with Complexity

### Mistake

Thinking:

```
2 recursive calls = O(2^n)
```

This is not always true.

Compare:

```
T(n) = 2T(n - 1) + O(1)
```

and:

```
T(n) = 2T(n / 2) + O(1)
```

Both have two recursive calls.

But:

```
2T(n - 1) → O(2^n)

2T(n / 2) → O(n)
```

The size of the subproblem matters.

---

# 4. `n - 1` vs `n / 2`

This is one of the most important recursion lessons.

### `n - 1`

```
n → n - 1 → n - 2 → n - 3 → ... → 1
```

Number of levels:

```
n
```

### `n / 2`

```
n → n/2 → n/4 → n/8 → ... → 1
```

Number of levels:

```
log₂ n
```

Therefore they can have very different complexities.

---

# 5. Master Theorem Cannot Be Applied to Every Recurrence

### Mistake

Trying to use Master Theorem for:

```
T(n) = 2T(n - 1) + 1
```

### Correction

Master Theorem expects the general form:

```
T(n) = aT(n / b) + f(n)
```

Therefore:

```
2T(n - 1) → Master Theorem ❌

2T(n / 2) → Master Theorem ✅
```

For `2T(n - 1)`, use expansion or recursion-tree reasoning.

---

# 6. Understanding `2^(log₂ n)`

### Doubt

Why does:

```
2^(log₂ n)
```

become:

```
n
```

### Explanation

By definition:

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

2^4 = 16
```

---

# 7. Forgetting the Base Case

Every recursive function must have a condition that eventually stops
the recursion.

Example:

```
if (n == 0)
    return;
```

Without a valid stopping condition, recursion does not terminate normally.

---

# 8. Confusing Going Down and Coming Back

For:

```
fun(n) {

    if (n == 0)
        return;

    System.out.print(n);

    fun(n - 1);
}
```

The print occurs while going down.

For:

```
fun(n) {

    if (n == 0)
        return;

    fun(n - 1);

    System.out.print(n);
}
```

The print occurs while coming back.

Important:

```
Before recursive call → going down

After recursive call → returning
```

---

# 9. Confusing Normal Recursion with Accumulator Recursion

Normal recursive sum:

```
sum(n) = n + sum(n - 1)
```

The result is assembled while returning.

Accumulator recursion:

```
sum(i, total, n)
```

The result is accumulated before the next recursive call.

Example:

```
sum(1,0,5)
 ↓
sum(2,1,5)
 ↓
sum(3,3,5)
 ↓
sum(4,6,5)
 ↓
sum(5,10,5)
 ↓
sum(6,15,5)
```

There is no additional arithmetic needed while returning.

---

# 10. Recursion Space Complexity

Time complexity and recursion-stack space are different.

For:

```
fun(n - 1)
```

maximum depth is:

```
n
```

Therefore:

```
Space = O(n)
```

For:

```
fun(n / 2)
```

maximum depth is:

```
log₂ n
```

Therefore:

```
Space = O(log n)
```

Even when multiple recursive calls exist, space depends on the maximum

number of simultaneously active stack frames, not simply the total number

of calls created.

---


---

# 8. Confusing Going Down and Coming Back

---

# Phase 3 — Recursion Thinking

## 1. Repeating Already-Learned Problems

### Mistake

Revisiting Print N → 1 / Print 1 → N after those concepts had already been covered.

### Correction

Do not repeat completed concepts unnecessarily.

Current progression:

Phase 3 → Recursion Patterns

---

## 2. Confusing Mathematical Result With Time Complexity

### Doubt

For recursive sum:

1 + 2 + 3 + ... + n

Why isn't the time complexity O(n²)?

### Correction

The expression represents the mathematical result, not the number of operations.

The algorithm performs approximately one addition for each element.

Therefore:

Time = O(n)

---

## 3. Understanding Linear Recursion

### Important Rule

One recursive call per function invocation:

→ Linear recursion

Two or more recursive calls:

→ Multiple recursion

---

## 4. Accumulator-Based Maximum

### Learning

The maximum function was independently written using an accumulator:

max(arr, idx, maxval)

This was a correct solution.

### Important Detail

Initialize:

Integer.MIN_VALUE

This ensures the algorithm also works when all array elements are negative.

### Example

Array:

[-10, -30, -5, -20]

Starting with:

maxval = Integer.MIN_VALUE

allows -5 to correctly become the final maximum.

---

## 5. Tail Recursion Does Not Mean O(1) Stack in Java

The maximum solution ends with:

return max(arr, idx + 1, updatedMax);

There is no work after the recursive call, so it has the shape of tail recursion.

However, Java does not generally optimize tail calls.

Therefore:

Space = O(n)

not O(1).

# Important Lessons to Remember

1. Do not guess complexity.
2. Write T(n).
3. Identify the subproblem size.
4. Count recursion levels.
5. Build a recursion tree when useful.
6. `n - 1` and `n / 2` behave very differently.
7. Master Theorem requires the appropriate recurrence form.
8. Time complexity and recursion-stack space are separate concepts.


