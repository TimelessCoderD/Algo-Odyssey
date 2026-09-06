# Recursion Algorithms

## 1. Print N to 1
- Idea
- Java implementation
- Example
- When to use

## 2. Print 1 to N
- Idea
- Java implementation
- Example

## 3. Sum 1 to N
- Recursive approach
- Accumulator approach

## 4. Factorial
- Recursive definition
- Java implementation

## 5. Power
- Simple recursive power

## 6. Multiple Recursion
- Two recursive calls
- Recursion tree

## 7. Divide Recursion
- n → n/2
- Multiple calls

---

# Phase 3 : Recursion patterns

## 1. Linear Recursion

### Pattern

A recursive function that makes exactly one recursive call.

General structure:

function(state):
    if base_condition:
        return result

    process current state
    return function(smaller_state)

### Example

For an array:

function(arr, index):
    if index == arr.length:
        return base_result

    process arr[index]
    return function(arr, index + 1)

### Key idea

Linear recursion creates a single chain of function calls:

f(0)
  ↓
f(1)
  ↓
f(2)
  ↓
...
  ↓
f(n)

There are no branching recursive calls.

---

## 2. Recursive Array Sum

### Problem

Find the sum of all elements in an array using recursion.

### Function meaning

sum(arr, index)

means:

"Return the sum of all elements from index to the end of the array."

### Recursive relationship

sum(arr, index)
=
arr[index] + sum(arr, index + 1)

### Base case

When:

index == arr.length

return 0.

### Algorithm

1. Start from index 0.
2. If index reaches arr.length, return 0.
3. Add the current element to the result of the remaining array.
4. Move to index + 1.

---

## 3. Recursive Maximum Using Accumulator

### Problem

Find the maximum element in an array using recursion.

### Function meaning

max(arr, index, maxval)

means:

"Process the array from index onward while carrying the maximum value found so far in maxval."

### Recursive relationship

max(arr, index, maxval)
=
max(
    arr,
    index + 1,
    max(maxval, arr[index])
)

### Base case

When:

index == arr.length

return maxval.

### Algorithm

1. Start at index 0.
2. Initialize maxval with Integer.MIN_VALUE.
3. Compare maxval with the current array element.
4. Store the larger value in maxval.
5. Recursively move to index + 1.
6. When index reaches arr.length, return maxval.

### Example

Array:

[10, 40, 25, 70, 30]

State changes:

maxval = MIN_VALUE
maxval = 10
maxval = 40
maxval = 40
maxval = 70
maxval = 70

Final answer = 70

# 4. Recursive Search

### Algorithm

1. Start from index 0.
2. If index reaches the end, return false.
3. Compare current element with target.
4. If equal, return true.
5. Otherwise recursively search the next index.

### Pattern

```
if arr[index] == target
    return true

return search(arr, index + 1, target)
```

---

# 5. Check Array is Sorted

### Algorithm

1. Start from index 0.
2. Stop at the last element.
3. Compare current element with the next element.
4. If `arr[index] > arr[index + 1]`, return false.
5. Otherwise recursively check the next position.
6. If all pairs pass, return true.

### Pattern

```
arr[index] <= arr[index + 1]
AND
isSorted(index + 1)
```

---

# 6. Count Occurrences

### Algorithm

1. Start from index 0.
2. If index reaches the end, return 0.
3. If current element equals target, contribute 1.
4. Otherwise contribute 0.
5. Recursively count the remaining elements.
6. Add the current contribution to the recursive result.

### Pattern

```
(condition ? 1 : 0)
+
count(arr, index + 1, target)
```

---

# 7. First Occurrence

### Algorithm

1. Start from index 0.
2. If index reaches the end, return -1.
3. If current element equals target, return current index.
4. Otherwise recursively search the next index.

### Pattern

```
if arr[index] == target
    return index

return firstIndex(arr, index + 1, target)
```

---

# 8. Last Occurrence — Right to Left

### Algorithm

1. Start from `arr.length - 1`.
2. If index becomes less than 0, return -1.
3. If current element equals target, return index.
4. Otherwise move to `index - 1`.
5. The first match found from the right is the last occurrence.

### Pattern

```
if arr[index] == target
    return index

return lastIndex(arr, index - 1, target)
```

---

# 9. Reverse String — Accumulator

### Algorithm

1. Start from the last character.
2. If index becomes -1, return the accumulated string.
3. Add the current character to `revString`.
4. Move to the previous index.
5. Continue recursively.

### Pattern

```
revString += text.charAt(index)

return reverse(text, index - 1, revString)
```

---

# General Linear Recursion Pattern

```
current state
  ↓
process current state
  ↓
move toward base case
  ↓
one recursive call
  ↓
repeat
```

Key recognition:

```
Exactly one recursive call → Linear recursion

# Pattern 2 — Divide & Conquer Algorithms

## Algorithm 1 — Divide Recursion

```text
FUNCTION divide(n)

  IF n <= 1
    RETURN

  process(n)

  divide(n / 2)
```

Complexity:

Time → O(log n)

Space → O(log n)

---

## Algorithm 2 — Two Half-Sized Recursive Calls

```
FUNCTION divide(n)

  IF n <= 1
    RETURN

  process(n)

  divide(n / 2)
  divide(n / 2)
```

Recurrence:

T(n) = 2T(n/2) + O(1)

Complexity:

Time → O(n)

Space → O(log n)

---

## Algorithm 3 — Binary Search

```
FUNCTION binarySearch(arr, left, right, target)

  IF left > right
    RETURN -1

  mid = (left + right) / 2

  IF arr[mid] == target
    RETURN mid

  IF target < arr[mid]
    RETURN binarySearch(arr, left, mid - 1, target)

  RETURN binarySearch(arr, mid + 1, right, target)
```

Requirements:

- Array must be sorted.
- Search range is represented by left and right indexes.

Complexity:

Best Time → O(1)

Worst Time → O(log n)

Space → O(log n)
```

