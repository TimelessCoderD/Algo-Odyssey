# 02 - Data Types

## 1. What is a Data Type?

A data type defines what kind of value a variable can store.

Example:

```java
int age = 35;
double salary = 50000.50;
char grade = 'A';
boolean isActive = true;
```

---

## 2. Primitive Data Types

Java has eight primitive data types:

- `byte`
- `short`
- `int`
- `long`
- `float`
- `double`
- `char`
- `boolean`

---

## 3. Integer Data Types

| Type | Size | Approximate Range |
|------|------|-------------------|
| `byte` | 8-bit | -128 to 127 |
| `short` | 16-bit | -32,768 to 32,767 |
| `int` | 32-bit | -2³¹ to 2³¹ - 1 |
| `long` | 64-bit | -2⁶³ to 2⁶³ - 1 |

Example:

```java
byte b = 100;
short s = 10000;
int i = 100000;
long l = 10000000000L;
```

A large `long` literal should use the `L` suffix.

---

## 4. Floating-Point Data Types

Java provides:

- `float`
- `double`

`double` provides greater precision than `float` and is the default type for decimal literals.

Example:

```java
float f = 10.05f;
double d = 10.05;
```

A `float` literal normally requires the `f` suffix.

---

## 5. Character and Boolean

### `char`

Stores a single character.

```java
char grade = 'A';
```

### `boolean`

Stores either:

```java
true
```

or

```java
false
```

Example:

```java
boolean isPassed = true;
```

---

## 6. Type Casting

Type casting means converting a value from one data type to another.

There are two common forms:

### Widening Conversion

A smaller compatible type can be converted to a larger type automatically.

```java
int a = 40000;
long b = a;
```

This is also called implicit conversion.

---

### Narrowing Conversion

A larger type can be explicitly converted to a smaller type.

```java
long a = 1000L;
int b = (int) a;
```

This is called explicit casting.

Narrowing conversion can result in data loss if the value is outside the target type's range.

Example:

```java
long a = 10000000000L;
int b = (int) a;
```

The result may not be the original value because `int` cannot represent the full `long` value.

---

## Key Takeaways

- Data types define the kind of values variables can store.
- Java has eight primitive data types.
- `byte`, `short`, `int`, and `long` store integer values.
- `float` and `double` store decimal values.
- `char` stores a single character.
- `boolean` stores `true` or `false`.
- Widening conversion can happen automatically.
- Narrowing conversion usually requires explicit casting.
- Narrowing conversion can cause data loss.
