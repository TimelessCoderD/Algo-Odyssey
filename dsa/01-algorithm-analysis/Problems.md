# DSA Problems — Algorithm Analysis

> Problems and solutions from the current Algorithm Analysis practice.
> Java implementation is not required for these analysis-only problems.

---

## Problem 21 — Recurrence

### Question
Find the complexity of the following recurrence:

$$
T(n)=
\begin{cases}
3T(n-1), & n>0\\
1, & \text{otherwise}
\end{cases}
$$

### Solution
Start expanding:

$$
T(n)=3T(n-1)
$$

$$
T(n)=3[3T(n-2)]
$$

$$
T(n)=3^2T(n-2)
$$

$$
T(n)=3^3T(n-3)
$$

After $k$ expansions:

$$
T(n)=3^kT(n-k)
$$

At the base case:

$$
n-k=0
$$

Therefore:

$$
k=n
$$

So:

$$
T(n)=3^nT(0)
$$

Since $T(0)=1$:

$$
T(n)=3^n
$$

### Complexity

$$
\boxed{O(3^n)}
$$

---

## Problem 22 — Recurrence

### Question
Find the complexity of:

$$
T(n)=
\begin{cases}
2T(n-1)-1, & n>0\\
1, & \text{otherwise}
\end{cases}
$$

### Solution
Expand the recurrence:

$$
T(n)=2T(n-1)-1
$$

$$
T(n)=2[2T(n-2)-1]-1
$$

$$
T(n)=2^2T(n-2)-3
$$

Next:

$$
T(n)=2^3T(n-3)-7
$$

After $k$ expansions:

$$
T(n)=2^kT(n-k)-(2^k-1)
$$

At the base case:

$$
n-k=0
$$

Therefore:

$$
k=n
$$

Substitute:

$$
T(n)=2^nT(0)-(2^n-1)
$$

Since $T(0)=1$:

$$
T(n)=2^n-(2^n-1)
$$

$$
T(n)=1
$$

### Complexity

$$
\boxed{O(1)}
$$

### Key Insight
Although the recurrence contains $2T(n-1)$, the subtraction of $1$ cancels the exponential growth exactly.

---

## Problem 23 — While Loop with Increasing Sum

### Question
Find the complexity of the following function:

```java
void function(int n) {
    int i = 1, s = 1;

    while (s <= n) {
        i++;
        s = s + i;
        print("*");
    }
}
```

### Solution
The values of `s` grow as:

```text
i:  1   2   3   4   5   6   7 ...
s:  1   3   6   10  15  21  28 ...
```
The sum is:

$$
s = 1 + 2 + 3 + \cdots + i
$$

Using the sum of the first $i$ natural numbers:

$$
s = \frac{i(i+1)}{2}
$$

The loop stops when:

$$
\frac{i(i+1)}{2} > n
$$

For large $n$:

$$
i^2 \approx n
$$

Therefore:

$$
i \approx \sqrt{n}
$$

So the loop executes approximately $\sqrt{n}$ times.

### Complexity

$$
\boxed{O(\sqrt{n})}
$$

---

## Problem 24 — Square-Root Loop

### Question
Find the complexity of:

```java
void function(int n) {
    int i;

    while (i * i <= n) {
        System.out.println("x");
        i++;
    }
}
```

### Solution
The condition is:

$$
i^2 \le n
$$

Therefore:

$$
i \le \sqrt{n}
$$

So the loop executes approximately $\sqrt{n}$ times.

### Complexity

$$
\boxed{O(\sqrt{n})}
$$

---

## Problem 25 — Three Nested Loops

### Question
Find the complexity of:

```java
void function(int n) {
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            for (int k = 1; k <= n; k = k * 2) {
                System.out.println("x");
            }
        }
    }
}
```

### Solution

#### Outer loop

```text
i = 1, 2, 3, ..., n
```

So:

$$
O(n)
$$

#### Middle loop

```text
j = 1, 2, 3, ..., n
```

So:

$$
O(n)
$$

#### Inner loop

```text
k = 1, 2, 4, 8, ...
```

The values are powers of 2:

$$
2^0, 2^1, 2^2, \ldots, 2^k
$$

The loop stops when:

$$
2^k \le n
$$

Therefore:

$$
k \le \log_2 n
$$

So the inner loop is:

$$
O(\log n)
$$

Total:

$$
O(n) \times O(n) \times O(\log n)
$$

### Complexity

$$
\boxed{O(n^2\log n)}
$$

---

## Problem 26 — Three Logarithmic Loops

### Question
Find the complexity of:

```java
void function(int n) {
    for (int i = 1; i <= n; i = i * 2) {
        for (int j = 1; j <= n; j = j * 2) {
            for (int k = 1; k <= n; k = k * 2) {
                System.out.println("x");
            }
        }
    }
}
```

### Solution
Each loop doubles its variable:

```text
1 → 2 → 4 → 8 → ...
```

For each loop:

$$
2^k \le n
$$

Therefore:

$$
k = O(\log n)
$$

There are three such loops:

$$
O(\log n) \times O(\log n) \times O(\log n)
$$

### Complexity

$$
\boxed{O((\log n)^3)}
$$

or:

$$
\boxed{O(\log^3 n)}
$$

---

## Problem 27 — Nested Loop with Break

### Question
Find the complexity of:

```java
void function(int n) {
    int i, j;

    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            if (i == j)
                break;

            print("x");
        }
    }
}
```

### Solution
The important point is that the inner loop does not always execute $n$ times.

For each value of `i`, the inner loop stops when:

$$
j=i
$$

So the number of iterations is approximately:

```text
i = 1 → 1 iteration
i = 2 → 2 iterations
i = 3 → 3 iterations
...
i = n → n iterations
```

Total:

$$
1 + 2 + 3 + \cdots + n
$$

Using the sum formula:

$$
\frac{n(n+1)}{2}
$$

Therefore:

$$
\frac{n(n+1)}{2} = O(n^2)
$$

### Complexity

$$
\boxed{O(n^2)}
$$

---

## Problem 28 — Divide and Conquer Recurrence

### Question
Find the complexity of:

$$
T(n)=
\begin{cases}
2T(n/2)+n, & n>1\\
1, & n=1
\end{cases}
$$

### Solution
Expand:

$$
T(n)=2T(n/2)+n
$$

$$
T(n/2)=2T(n/4)+n/2
$$

Substitute:

$$
T(n)=2[2T(n/4)+n/2]+n
$$

$$
T(n)=2^2T(n/4)+n+n
$$

$$
T(n)=2^2T(n/4)+2n
$$

Next:

$$
T(n)=2^3T(n/8)+3n
$$

After $k$ expansions:

$$
T(n)=2^kT(n/2^k)+kn
$$

At the base case:

$$
\frac{n}{2^k}=1
$$

Therefore:

$$
n=2^k
$$

$$
k=\log_2 n
$$

Substitute:

$$
T(n)=2^{\log n}T(1)+n\log n
$$

Since:

$$
2^{\log_2 n}=n
$$

we get:

$$
T(n)=n+n\log n
$$

The dominant term is:

$$
n\log n
$$

### Complexity

$$
\boxed{O(n\log n)}
$$

---

## Problem 29 — Divide and Conquer Recurrence

### Question
Find the complexity of:

$$
T(n)=2T(n/2)+1
$$

### Solution
Expand:

$$
T(n)=2T(n/2)+1
$$

$$
T(n)=2[2T(n/4)+1]+1
$$

$$
T(n)=2^2T(n/4)+3
$$

Next:

$$
T(n)=2^3T(n/8)+7
$$

After $k$ expansions:

$$
T(n)=2^kT(n/2^k)+(2^k-1)
$$

At the base case:

$$
\frac{n}{2^k}=1
$$

Therefore:

$$
k=\log_2 n
$$

So:

$$
T(n)=O(n)
$$

### Complexity

$$
\boxed{O(n)}
$$

---

## Problem 30 — Three Recursive Subproblems

### Question
Find the complexity of:

$$
T(n)=T(n/2)+T(n/4)+T(n/8)+n
$$

### Solution
Expand the first term:

$$
T(n/2)=T(n/4)+T(n/8)+T(n/16)+n/2
$$

Therefore:

$$
2T(n/4)+2T(n/8)+T(n/16)+n+n/2
$$

Continuing the expansion produces work of the form:

$$
n + \frac n2 + \frac n4 + \frac n8 + \cdots
$$

This is a geometric series:

$$
n\left(1+\frac12+\frac14+\frac18+\cdots\right)
$$

The infinite geometric series is bounded:

$$
1+\frac12+\frac14+\frac18+\cdots=2
$$

Therefore the total non-recursive work is bounded by:

$$
2n=O(n)
$$

The recursive subproblems do not increase the overall order beyond linear.

### Complexity

$$
\boxed{O(n)}
$$

---

## Problem 31 — Recurrence with Constant Work

### Question
Find the complexity of:

$$
T(n)=T(n/2)+7
$$

### Solution
Expand:

$$
T(n)=T(n/2)+7
$$

$$
T(n)=T(n/4)+7+7
$$

$$
T(n)=T(n/8)+7+7+7
$$

After $k$ expansions:

$$
T(n)=T(n/2^k)+7k
$$

At the base case:

$$
\frac{n}{2^k}=1
$$

Therefore:

$$
n=2^k
$$

$$
k=\log_2 n
$$

So:

$$
T(n)=T(1)+7\log n
$$

### Complexity

$$
\boxed{O(\log n)}
$$

---

## Problem 32 — Multiplication Loop

### Question
Find the complexity of:

```java
void Read(int n) {
    int k = 1;

    while (k < n) {
        k = 3 * k;
    }
}
```

### Solution
The values of `k` are:

```text
1 → 3 → 9 → 27 → 81 → ...
```

After $m$ iterations:

$$
k=3^m
$$

The loop stops when:

$$
3^m \ge n
$$

Taking logarithm:

$$
m \ge \log_3 n
$$

Therefore the number of iterations is:

$$
O(\log n)
$$

### Complexity

$$
\boxed{O(\log n)}
$$

---

## Problem 33 — Recurrence with Quadratic Work

### Question
Find the complexity of:

$$
T(n)=
\begin{cases}
1, & n=1\\
T(n-2)+n(n-1), & n\ge2
\end{cases}
$$

### Solution
Expand:

$$
T(n)=T(n-2)+n(n-1)
$$

$$
T(n-2)=T(n-4)+(n-2)(n-3)
$$

Therefore:

$$
T(n)=T(n-4)+(n-2)(n-3)+n(n-1)
$$

Next:

$$
T(n)=T(n-6)+(n-4)(n-5)+(n-2)(n-3)+n(n-1)
$$

After $k$ expansions:

$$
T(n-2k) + \sum_{i=0}^{k-1}(n-2i)(n-2i-1)
$$

The base case is reached when:

$$
n-2k=1
$$

So:

$$
k\approx\frac n2
$$

There are $O(n)$ terms in the summation.

Each term is at most $O(n^2)$, giving the upper bound:

$$
O(n) \times O(n^2)=O(n^3)
$$

More precisely, because the terms decrease quadratically across the $O(n)$ levels, the sum of the terms is still cubic:

$$
n^2 + (n-2)^2 + (n-4)^2 + \cdots = O(n^3)
$$

### Complexity

$$
\boxed{O(n^3)}
$$

### Key Insight
The recurrence decreases $n$ by only $2$, so there are $O(n)$ recursive levels. At each level, the added work is $O(n^2)$ near the top, producing an overall cubic complexity.

---

## Problem 34 — Fibonacci Recursion

### Question
Find the complexity of the following recursive Fibonacci function:

```java
fib(n) {
    if (n == 0) return 0;
    else if (n == 1) return 1;
    else return fib(n - 1) + fib(n - 2);
}
```

### Solution
The recurrence is:

$$
T(n)=T(n-1)+T(n-2)+C
$$

The function creates a branching recursion tree.

At each level, the number of calls grows approximately like:

```text
Level 0 → 1
Level 1 → 2
Level 2 → 4
Level 3 → 8
...
```

So the number of calls grows exponentially.

A simple upper bound is:

$$
T(n)\le 2T(n-1)+C
$$

which gives exponential growth.

Therefore:

### Complexity

$$
\boxed{O(2^n)}
$$

### Key Insight
The Fibonacci recursion repeatedly recalculates the same subproblems. That repeated work is why the naive recursive implementation is exponential.

---

## Problem 35 — Nested Loop with Dependent Inner Loop

### Question
Find the complexity of:

```java
void function(int n) {
    int i, j;

    for (i = 1; i <= n; i++) {
        for (j = i; j <= n; j++) {
            System.out.println("x");
        }
    }
}
```

### Solution
The number of inner-loop iterations depends on `i`.

For each value of `i`:

```text
i = 1 → n iterations
i = 2 → n - 1 iterations
i = 3 → n - 2 iterations
...
i = n → 1 iteration
```

Therefore total iterations are:

$$
n + (n-1) + (n-2) + \cdots + 1
$$

Using the sum formula:

$$
\frac{n(n+1)}{2}
$$

Ignoring constants and lower-order terms:

$$
\frac{n(n+1)}{2}=O(n^2)
$$

### Complexity

$$
\boxed{O(n^2)}
$$

### Key Insight
Even though the inner loop does not always execute $(n)$ times, the total is still a quadratic sum.

---

## Problem 36 — Sum of Logarithms

### Question
Find the complexity of:

$$
\sum_{i=1}^{n}\log i
$$

### Solution
Expand:

$$
\log 1 + \log 2 + \log 3 + \cdots + \log n
$$

Using:

$$
\log a + \log b = \log(ab)
$$

we get:

$$
= \log(1\times2\times3\times\cdots\times n)
$$

$$
= \log(n!)
$$

Since:

$$
n! \le n^n
$$

we have:

$$
\log(n!) \le \log(n^n)
$$

$$
= n\log n
$$

Therefore:

$$
\boxed{O(n\log n)}
$$

In fact, using Stirling's approximation:

$$
\log(n!) = \Theta(n\log n)
$$

so the tight bound is:

$$
\boxed{\Theta(n\log n)}
$$

### Key Insight
A sum of $n$ logarithmic terms is generally $O(n\log n)$.

---

## Problem 37 — Three Recursive Calls on $(n/3)$

### Question
Find the complexity of:

```java
void function(int n) {
    if (n <= 1)
        return;

    for (int i = 1; i <= 3; i++) {
        function(n / 3);
    }
}
```

### Solution
The loop executes exactly 3 times, and each iteration makes a recursive call on $(n/3)$.

Therefore:

$$
T(n)=3T(n/3)+C
$$

Expand:

$$
T(n)=3[3T(n/9)+C]+C
$$

$$
=3^2T(n/9)+3C+C
$$

After $k$ levels:

$$
T(n)=3^kT(n/3^k)+C(3^{k-1}+\cdots+3+1)
$$

At the base case:

$$
\frac{n}{3^k}=1
$$

Therefore:

$$
n=3^k
$$

$$
k=\log_3 n
$$

Also:

$$
3^k=n
$$

Hence:

$$
T(n)=O(n)
$$

### Complexity

$$
\boxed{O(n)}
$$

### Key Insight
There are 3 recursive calls, but the input size becomes $(n/3)$. This balances the recursion so that the total number of calls is linear.

---

## Problem 38 — Three Recursive Calls on $(n-1)$

### Question
Find the complexity of:

```java
void function(int n) {
    if (n <= 1)
        return;

    for (int i = 1; i <= 3; i++) {
        function(n - 1);
    }
}
```

### Solution
The loop executes 3 times.

Each iteration calls the function with $(n-1)$.

Therefore:

$$
T(n)=3T(n-1)+C
$$

Expand:

$$
T(n)=3[3T(n-2)+C]+C
$$

$$
=3^2T(n-2)+3C+C
$$

Next:

$$
T(n)=3^3T(n-3)+3^2C+3C+C
$$

After $k$ levels:

$$
T(n)=3^kT(n-k)+C(3^{k-1}+\cdots+3+1)
$$

The base case is reached when:

$$
n-k=1
$$

Therefore:

$$
k=n-1
$$

So the dominant term is:

$$
3^{n-1}
$$

### Complexity

$$
\boxed{O(3^n)}
$$

### Key Insight
Compare this with Problem 37:

$$
3T(n/3)\rightarrow O(n)
$$

but:

$$
3T(n-1)\rightarrow O(3^n)
$$

The amount by which the input decreases is extremely important in recursive complexity.

---

## Problem 39 — Linear Loop + Constant-Factor Recursive Call

### Question
Find the complexity of:

```java
function(n) {
    if (n <= 1)
        return;

    for (int i = 1; i < n; i++) {
        print("x");
    }

    function(0.8n);
}
```

### Solution
The `for` loop runs approximately $n$ times:

$$
O(n)
$$

Then there is one recursive call on a problem of size $0.8n$:

$$
T(n)=T(0.8n)+O(n)
$$

This means the input shrinks by a constant factor at each recursive level.

Expanding the recurrence:

$$
T(n)=T(0.8n)+n
$$

$$
T(0.8n)=T(0.8^2n)+0.8n
$$

$$
T(0.8^2n)=T(0.8^3n)+0.8^2n
$$

So after several levels, the total work is:

$$
n + 0.8n + 0.8^2n + 0.8^3n + \cdots
$$

This is a geometric series with ratio $0.8$:

$$
\sum_{k=0}^{\infty}(0.8)^k n = \frac{n}{1-0.8} = 5n
$$

Therefore, the total work is still linear.

### Complexity

$$
\boxed{O(n)}
$$

### Key Insight
A recursive call that reduces the input by a constant fraction still gives a geometric total. Since $0.8^k$ decreases quickly, the sum of all levels remains linear.

---

## Problem 40 — $T(n) = 2T(\sqrt{n}) + \log n$

### Step 1: Convert it to Master Theorem form

The square root makes the recurrence unsuitable directly.

Let:

$$
n = 2^m
$$

Then:

$$
\sqrt{n} = 2^{m/2}
$$

Define:

$$
S(m) = T(2^m)
$$

So:

$$
S(m) = 2S(m/2) + m
$$

### Step 2: Master Theorem

- $a = 2$
- $b = 2$
- $f(m) = m$

Calculate:

$$
m^{\log_b a} = m^{\log_2 2} = m
$$

So $f(m)$ matches the comparison term.

This is Case 2 of the Master Theorem.

Therefore:

$$
S(m) = \Theta(m\log m)
$$

Now substitute $m = \log n$:

$$
T(n) = \Theta(\log n \cdot \log \log n)
$$

### Final

$$
\boxed{\Theta(\log n \log \log n)}
$$

### Key lesson

For square-root recurrences, a logarithmic change of variable can convert the problem into a normal Master Theorem recurrence.

---

## Problem 41 — $T(n) = T(\sqrt{n}) + 1$

Use the same transformation:

$$
n = 2^m
$$

Then:

$$
S(m) = S(m/2) + 1
$$

Master Theorem:

- $a = 1$
- $b = 2$
- $f(m) = 1$
- $m^{\log_2 1} = 1$

This is Case 2.

Therefore:

$$
S(m) = \Theta(\log m)
$$

Since $m = \log n$:

### Final

$$
\boxed{\Theta(\log \log n)}
$$

---

## Problem 42 — $T(n) = 2T(\sqrt{n}) + 1$

Let:

$$
n = 2^m
$$

Then:

$$
S(m) = 2S(m/2) + 1
$$

Here:

- $a = 2$
- $b = 2$
- $f(m) = 1$
- $m^{\log_2 2} = m$

Since $1$ is polynomially smaller than $m$, this is Case 1:

$$
S(m) = \Theta(m)
$$

Therefore:

### Final

$$
\boxed{\Theta(\log n)}
$$

---

## Problem 43 — Recursive square-root function

Typical structure:

```text
function(n):
    if n <= 2:
        return
    return function(floor(sqrt(n))) + 1
```

The recurrence is:

$$
T(n) = T(\sqrt{n}) + 1
$$

This is the same recurrence as Problem 41.

### Final

$$
\boxed{\Theta(\log \log n)}
$$

### Important

`floor(sqrt(n)) + 1` does not change the asymptotic result.

---

## Problem 44 — $T(n) = 8T(n/2) + n^3 + 1$

Master Theorem:

$$
T(n) = aT(n/b) + f(n)
$$

Therefore:

- $a = 8$
- $b = 2$
- $f(n) = \Theta(n^3)$

Calculate the comparison term:

$$
n^{\log_b a} = n^{\log_2 8} = n^3
$$

So:

$$
f(n) = \Theta(n^{\log_b a})
$$

This is Case 2.

Therefore:

$$
T(n) = \Theta(n^3 \log n)
$$

### Final

$$
\boxed{\Theta(n^3 \log n)}
$$

### Why Case 2?

Because the non-recursive work $n^3$ is exactly the same order as the Master Theorem comparison term $n^3$.

---

## Problem 45 — Repeated halving

```text
temp = 1
repeat
    for i = 1 to n
        temp = temp + 1

    n = n/2
until n = 2
```

At each level the loop costs the current value of $n$:

$$
n + \frac{n}{2} + \frac{n}{4} + \frac{n}{8} + \cdots
$$

This is a geometric series.

Factor $n$:

$$
n\left(1 + \frac{1}{2} + \frac{1}{4} + \frac{1}{8} + \cdots\right)
$$

The series sums to a constant.

### Final

$$
\boxed{\Theta(n)}
$$

### Recurrence view

$$
T(n) = T(n/2) + n
$$

Master Theorem gives the same result.

---

## Problem 46 — Outer $n$, inner logarithmic loop

The important pattern is:

```text
for i = 1 to n
    for j = 1 to n
        j = 2j
```

- Outer loop: $n$
- Inner loop: $\log n$

Therefore:

$$
n \times \log n
$$

### Final

$$
\boxed{O(n \log n)}
$$

### Key lesson

A loop where the variable doubles or halves each iteration is logarithmic.

---

## Problem 47 — Nested linear loops

The structure has two loops whose total work is proportional to:

$$
n \times n
$$

Therefore:

### Final

$$
\boxed{O(n^2)}
$$

### Key lesson

Two independent linear loops nested inside one another generally give $n^2$.

---

## Problem 48 — Recursive function

The important step is to write the recurrence before trying to solve it.

For the function in the book, the recurrence reduces to a divide-and-conquer recurrence whose final bound is:

### Final

$$
\boxed{O(n)}
$$

### Lesson

Do not start by guessing the answer. First count:

1. Number of recursive calls.
2. Size of each recursive subproblem.
3. Work outside the recursive calls.

---

## Problem 49 — Two logarithmic loops

The pattern contains:

- One logarithmic loop.
- Inside it, another logarithmic loop.

So:

$$
\log n \times \log n
$$

### Final

$$
\boxed{O((\log n)^2)}
$$

### Important

Do not confuse:

$$
\log n \times \log n
$$

with:

$$
\log(\log n)
$$

They are completely different.

---

## Problem 50 — Summation of $O(n)$

Given:

$$
\sum_{k=1}^{n} O(n)
$$

There are $n$ terms.

Each term costs $O(n)$.

Therefore:

$$
n \times O(n) = O(n^2)
$$

### Final

$$
\boxed{O(n^2)}
$$

---

## Problem 51 — Asymptotic claims

### Claim I

$$
(n + k)^m = \Theta(n^m)
$$

when $k$ and $m$ are constants.

Correct.

The constant shift $+k$ does not change the dominant polynomial order.

### Claim II

$$
2^{n+1} = 2 \times 2^n = O(2^n)
$$

Correct.

The factor $2$ is a constant.

### Claim III

$$
2^{2n+1} = O(2^n)
$$

False.

Because:

$$
2^{2n+1} = 2 \times 4^n
$$

which grows much faster than $2^n$.

### Final

**I and II are correct.**

---

## Problem 52 — Compare $2^n$, $n!$, and $n \log n$

Given:

- $f(n) = 2^n$
- $g(n) = n!$
- $h(n) = n^{\log n}$

Growth order:

$$
n^{\log n} < 2^n < n!
$$

Therefore:

- $h(n) = O(f(n))$
- $g(n) = \Omega(f(n))$

### Final

**Option D**

### Useful technique

When comparing very large functions, taking logarithms often makes the comparison easier.

---

## Problem 53 — Loop where $j$ doubles

Typical structure:

```text
j = 1
while j <= n
    j = j * 2
```

After $k$ iterations:

$$
j = 2^k
$$

The loop stops when:

$$
2^k > n
$$

Taking logarithms:

$$
k > \log_2 n
$$

So the number of iterations is logarithmic.

Because the loop condition is checked once more when it exits:

### Final

$$
\boxed{\lceil \log_2 n \rceil + 1 \text{ comparisons}}
$$

### Key lesson

Do not add $1 + 2 + 4 + 8$.

Those are the values of $j$, not the number of iterations.

---

## Problem 54 — Prime-check loop

```text
for i = 2 to sqrt(n)
    if n % i == 0:
        return
```

Maximum iterations:

$$
\sqrt{n}
$$

But if a divisor is found immediately, it can terminate after constant work.

Therefore:

- Upper bound: $O(\sqrt{n})$
- Lower bound: $\Omega(1)$

### Final

$$
\boxed{O(\sqrt{n}) \text{ and } \Omega(1)}
$$

### Key lesson

For early-return algorithms, best-case and worst-case bounds can be very different.

---

## Problem 55 — Euclidean GCD recursion

```text
gcd(n, m):
    if n % m == 0:
        return m

    n = n % m
    return gcd(m, n)
```

The number of recursive calls is not represented correctly by any of the given choices in the book's question.

A useful observation from the book's solution is:

For $m = 2$ and $n = 2^i$, the first call can terminate immediately.

Therefore, there cannot be one universal tight lower bound matching the listed choices.

### Final

**No listed option is correct.**

### Key lesson

Never assume that every recursive GCD call automatically takes $\Theta(\log n)$ calls. The exact input matters.

---

## Problem 56 — $T(n) = 2T(n/2) + n$

### Given

$$
T(n) = 2T(n/2) + n
$$

with:

$$
T(0) = T(1) = 1
$$

### Master Theorem

Compare with:

$$
T(n) = aT(n/b) + f(n)
$$

So:

- $a = 2$
- $b = 2$
- $f(n) = n$

Calculate:

$$
n^{\log_b a} = n^{\log_2 2} = n
$$

Therefore:

$$
f(n) = \Theta(n)
$$

This is Master Theorem Case 2.

Hence:

$$
T(n) = \Theta(n\log n)
$$

### Final

$$
\boxed{\Theta(n\log n)}
$$

### Mistake to avoid

Do not write $O(n)$ just because $f(n)=n$.

The recursive calls also contribute significant work.

---

## Problem 57 — Nested loops with $j < i^2$

### Code pattern

```text
void fun(int n) {
    for (i = 0; i < n; i++) {
        for (j = 1; j < i*i; j++) {
            if (j % i == 0) {
                for (k = 0; k < j; k++)
                    print("*");
            }
        }
    }
}
```

### Step 1 — Outer loop

```text
i = 0 ... n-1
```

So:

$$
O(n)
$$

### Step 2 — Middle loop

For a fixed $i$:

$$
j < i^2
$$

Therefore approximately:

$$
O(i^2)
$$

### Step 3 — Inner loop

The inner loop runs up to $j$.

The important point is that the `if` condition restricts it to values of $j$ divisible by $i$.

Those values are approximately:

$$
i, 2i, 3i, \ldots
$$

up to $i^2$.

So the total inner work for one fixed $i$ is:

$$
i + 2i + 3i + \cdots + i^2
$$

There are approximately $i$ terms.

Therefore:

$$
i(1 + 2 + \cdots + i)
$$

$$
= i \times O(i^2)
$$

$$
= O(i^3)
$$

### Step 4 — Sum over $i$

Total:

$$
\sum_{i=1}^{n} O(i^3)
$$

Using:

$$
\sum i^3 = \Theta(n^4)
$$

### Final

$$
\boxed{\Theta(n^4)}
$$

### Key lesson

The middle loop is $i^2$, but the conditional inner work must be summed over the values of $j$ that satisfy $j \bmod i = 0$.

---

## Problem 58 — Calculate $9^n$

### Basic algorithm

```text
result = 1

for i = 1 to n-1
    result = result * 9

return result
```

There are $n-1$ multiplications.

Therefore:

$$
T(n) = \Theta(n)
$$

### Final

$$
\boxed{\Theta(n)}
$$

---

## Problem 59 — Improve the complexity of Problem 58

Instead of multiplying by $9$ $n$ times, use divide and conquer / exponentiation by squaring.

### Algorithm

```text
power(a, n):

    if n == 0
        return 1

    temp = power(a, n/2)

    if n % 2 == 0
        return temp * temp
    else
        return a * temp * temp
```

For $9^n$:

```text
power(9, n)
```

### Why is it faster?

At every recursive call:

$$
n \rightarrow n/2 \rightarrow n/4 \rightarrow n/8 \rightarrow \cdots \rightarrow 1
$$

The number of levels is:

$$
\log_2 n
$$

Each level performs constant extra work.

Therefore:

$$
T(n) = T(n/2) + O(1)
$$

### Final

$$
\boxed{\Theta(\log n)}
$$

### Key lesson

When the exponent is repeatedly halved, the algorithm becomes logarithmic.

---

## Problem 60 — $T(n) = T(n/2) + T(n/4) + n$

### Given

$$
T(n) = T(n/2) + T(n/4) + n
$$

This is not directly in standard Master Theorem form because the recursive subproblem sizes are different.

### Recursion-tree idea

At the root:

$$
n
$$

At the next level:

$$
\frac{n}{2} + \frac{n}{4} = \frac{3n}{4}
$$

At the next level, the total work is again at most:

$$
\left(\frac{3}{4}\right) \times \text{previous level}
$$

So the total work is bounded by:

$$
n + \frac{3n}{4} + \left(\frac{3}{4}\right)^2 n + \cdots
$$

This is a geometric series.

Since:

$$
0 < \frac{3}{4} < 1
$$

the series sums to a constant multiple of $n$.

Therefore:

### Final

$$
\boxed{\Theta(n)}
$$

### Key lesson

When recursive calls have different fractions such as $n/2$ and $n/4$, look at the total problem size at each recursion-tree level.

---

## Problem 61 — Nested loops with conditional branch

### Code pattern

```text
void fun(int n) {
    int sum = 0;

    for (i = 0; i < n; i++) {
        if (condition) {
            sum = sum + 1;
        }
        else {
            for (k = 0; k < n; k++)
                sum = sum - 1;
        }
    }
}
```

### Outer loop

Runs $n$ times:

$$
O(n)
$$

### Inner loop

In the worst case, the `else` branch executes and the inner loop runs $n$ times.

So:

$$
O(n) \times O(n) = O(n^2)
$$

### Final

$$
\boxed{O(n^2)}
$$

### Important

The `if` branch is only $O(1)$, but worst-case complexity considers the branch that can perform the most work.

---

## Problem 62 — Order functions by growth

The functions shown are ordered from fastest growth to slowest growth as:

```text
(n+1)!
>
n!
>
4^n
>
n·3^n
>
3^n + n^2 + 20n
>
(3/2)^n
>
4n^2
>
n log n
>
n^2 + 200
>
20n + 500
>
2^(log n)
>
n^(2/3)
>
1
```

### Important simplifications

$$
2^{\log_2 n} = n
$$

Therefore:

$$
2^{\log_2 n}
$$

has the same asymptotic growth as:

$$
n
$$

Also:

$$
3^n + n^2 + 20n = \Theta(3^n)
$$

because $3^n$ dominates the polynomial terms.

And:

$$
n\cdot 3^n
$$

grows faster than:

$$
3^n
$$

by an additional factor of $n$.

### General growth hierarchy

For typical positive constants:

```text
1
<
log n
<
n^a
<
n^a \log^b n
<
c^n
<
n!
```

### Key lesson

**Simplify each function first, then compare growth.**

---

## Problem 63 — Can we say $3^{n^{0.75}} = O(3^n)$?

### Given

$$
3^{n^{0.75}}
$$

and:

$$
3^n
$$

Since:

$$
n^{0.75} = n^{3/4}
$$

and for sufficiently large $n$:

$$
n^{3/4} < n
$$

therefore:

$$
3^{n^{3/4}} < 3^n
$$

because the base $3 > 1$.

Hence:

### Final

**Yes.**

$$
3^{n^{0.75}} = O(3^n)
$$

### Key lesson

For the same base greater than $1$, compare the exponents.

---

## Problem 64 — Can we say $2^{3n} = O(2^n)$?

### Given

$$
2^{3n}
$$

Using:

$$
a^{bc} = (a^b)^c
$$

we get:

$$
2^{3n} = (2^3)^n = 8^n
$$

Now compare:

$$
8^n \text{ with } 2^n
$$

Since $8^n$ grows faster:

$$
2^{3n}
$$

is **not**:

$$
O(2^n)
$$

Another way:

$$
\frac{2^{3n}}{2^n} = 2^{2n} = 4^n
$$

which tends to infinity.

### Final

**No.**

The correct relationship is:

$$
2^n = O(2^{3n})
$$

but:

$$
2^{3n} \ne O(2^n)
$$

---

# Quick Revision Table

| Problem | Pattern | Complexity |
|---|---|---|
| 21 | $3T(n-1)$ | $O(3^n)$ |
| 22 | $2T(n-1)-1$ | $O(1)$ |
| 23 | Increasing sum | $O(\sqrt n)$ |
| 24 | $i^2 \le n$ | $O(\sqrt n)$ |
| 25 | $n \times n \times \log n$ | $O(n^2\log n)$ |
| 26 | $\log n \times \log n \times \log n$ | $O(\log^3 n)$ |
| 27 | Nested loop + break | $O(n^2)$ |
| 28 | $2T(n/2)+n$ | $O(n\log n)$ |
| 29 | $2T(n/2)+1$ | $O(n)$ |
| 30 | $T(n/2)+T(n/4)+T(n/8)+n$ | $O(n)$ |
| 31 | $T(n/2)+7$ | $O(\log n)$ |
| 32 | $k = 3k$ | $O(\log n)$ |
| 33 | $T(n-2)+n(n-1)$ | $O(n^3)$ |
| 34 | Fibonacci recursion | $O(2^n)$ |
| 35 | Dependent nested loop | $O(n^2)$ |
| 36 | Sum of logarithms | $\Theta(n\log n)$ |
| 37 | $3T(n/3)+C$ | $O(n)$ |
| 38 | $3T(n-1)+C$ | $O(3^n)$ |
| 39 | $T(0.8n)+O(n)$ | $O(n)$ |
| 40 | $2T(\sqrt{n}) + \log n$ | $\Theta(\log n \log \log n)$ |
| 41 | $T(\sqrt{n}) + 1$ | $\Theta(\log \log n)$ |
| 42 | $2T(\sqrt{n}) + 1$ | $\Theta(\log n)$ |
| 43 | Recursive square-root function | $\Theta(\log \log n)$ |
| 44 | $8T(n/2)+n^3+1$ | $\Theta(n^3\log n)$ |
| 45 | Repeated halving | $\Theta(n)$ |
| 46 | Outer $n$, inner logarithmic loop | $O(n\log n)$ |
| 47 | Nested linear loops | $O(n^2)$ |
| 48 | Recursive function | $O(n)$ |
| 49 | Two logarithmic loops | $O((\log n)^2)$ |
| 50 | Summation of $O(n)$ | $O(n^2)$ |
| 51 | Asymptotic claims | I and II correct |
| 52 | Compare $2^n$, $n!$, $n^{\log n}$ | Option D |
| 53 | Loop with doubling | $\lceil \log_2 n \rceil + 1$ |
| 54 | Prime-check loop | $O(\sqrt n)$ and $\Omega(1)$ |
| 55 | Euclidean GCD recursion | No listed option |
| 56 | $2T(n/2)+n$ | $\Theta(n\log n)$ |
| 57 | Conditional nested loops | $\Theta(n^4)$ |
| 58 | Repeated multiplication | $\Theta(n)$ |
| 59 | Exponentiation by squaring | $\Theta(\log n)$ |
| 60 | Unequal recursive fractions | $\Theta(n)$ |
| 61 | Nested loop + worst-case branch | $O(n^2)$ |
| 62 | Growth-order comparison | Order comparison |
| 63 | Compare exponents | Yes, $O(3^n)$ |
| 64 | Exponential comparison | No, not $O(2^n)$ |

---

## Important Notes

- These problems are primarily for algorithm-analysis practice, so separate Java files are not required.
- Write Java implementations when the exercise is about implementing an actual data structure or algorithm.
- For recurrence problems, focus on expansion → pattern → base case → complexity.
- For loop problems, focus on how the loop variable changes and how many iterations occur.

