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

