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

---

## 6. Ternary Operator With `return`

### Mistake

Trying:

```java
condition ? return true : return recursiveCall();
```

### Why it fails

The ternary operator expects expressions or values:

```
condition ? value1 : value2
```

`return` is a statement and cannot be placed directly inside the two ternary branches.

### Correct

```
return condition ? true : recursiveCall();
```

Or, preferably while learning:

```
if (condition)
    return true;

return recursiveCall();
```

---

## 7. Incorrect Base Case While Checking Sorted Array

### Mistake

Using a condition that stops recursion too early.

### Correction

When comparing:

```
arr[idx]
```

with:

```
arr[idx + 1]
```

we must stop at:

```
idx == arr.length - 1
```

because the last element has no next element.

### General Lesson

Always check which indexes the recursive step accesses before deciding the base case.

---

## 8. String Reverse — Duplicate Character

### Mistake

Adding the current character to `revString` and then adding it again in the return statement.

Example:

```
revString += text.charAt(idx);

return text.charAt(idx) + reverse(...);
```

### Why it fails

The current character is added twice.

### Correction

If the accumulator already contains the current character:

```
revString += text.charAt(idx);

return reverse(text, idx - 1, revString);
```

---

## 9. String Index vs String Length

### Mistake

Calling:

```
reverse(text, text.length(), "");
```

### Why it fails

For a string of length `n`, valid indexes are:

```
0 ... n - 1
```

Therefore the last valid index is:

```
text.length() - 1
```

### Correct

```
reverse(text, text.length() - 1, "");
```

---

## 10. Array Index vs Array Length

Important distinction:

```
length = number of elements
last index = length - 1
```

Example:

```
Array: [10, 20, 30, 40]

length = 4

indexes:
0  1  2  3
         ↑
      last index
```

---

## 11. First vs Last Occurrence

### First occurrence

Search from:

```
left → right
```

The first match can immediately be returned.

### Last occurrence

One simple approach is:

```
right → left
```

The first match found is the last occurrence.

---

## 12. Tail Recursion and Java Stack

A recursive call such as:

```
return function(...);
```

has the shape of tail recursion because there is no work after the recursive call.

However, Java does not generally optimize tail recursion.

Therefore the recursion stack remains proportional to the number of recursive calls.

---

# Phase 3 — Pattern 2 Mistakes & Corrections

## 1. Confusing n/2 with log n

Mistake:

Thinking that n/2 operations means O(log n).

Correction:

n/2 is still linear.

O(n/2) = O(n)

log n comes from repeatedly dividing the problem size:

n → n/2 → n/4 → n/8 → ...

---

## 2. T(n-2) vs T(n/2)

T(n-2):

n → n-2 → n-4 → ...

Approximately n/2 levels.

Complexity → O(n)

T(n/2):

n → n/2 → n/4 → ...

Approximately log₂n levels.

Complexity → O(log n)

---

## 3. Binary Search — Including mid again

Incorrect:

```java
binarySearch(arr, left, mid, target);
```

or:

```
binarySearch(arr, mid, right, target);
```

After checking arr[mid], mid is already processed.

Correct:

```
binarySearch(arr, left, mid - 1, target);
```

or:

```
binarySearch(arr, mid + 1, right, target);
```

---

## 4. Binary Search — Incorrect base case

Instead of checking whether mid is at index 0 or the last index, check whether the search range has become invalid.

Correct:

```
if (left > right)
    return -1;
```

This directly represents:

"No elements remain to search."

---

## 5. Binary Search — Comparing unnecessary boundaries

The recursive algorithm does not need to separately check:

```
arr[left]
arr[right]
```

The important comparison is:

```
arr[mid]
```

Then choose the appropriate half.

---

## 6. Middle Index Calculation

Basic version:

```
int mid = (left + right) / 2;
```

Safer version for very large indexes:

```
int mid = left + (right - left) / 2;
```

The second version avoids possible integer overflow in `left + right`.

# General Debugging Lesson

When recursion gives the wrong result, check in this order:

1. What does the function mean?
2. Is the base case correct?
3. Does every recursive call move toward the base case?
4. Are array/string indexes valid?
5. Is the current value being processed correctly?
6. Is the recursive result being returned correctly?

# Important Lessons to Remember

1. Do not guess complexity.
2. Write T(n).
3. Identify the subproblem size.
4. Count recursion levels.
5. Build a recursion tree when useful.
6. `n - 1` and `n / 2` behave very differently.
7. Master Theorem requires the appropriate recurrence form.
8. Time complexity and recursion-stack space are separate concepts.




