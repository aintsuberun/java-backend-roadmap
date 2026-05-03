# Java Learning Journey

This repository contains my Java learning progress and backend preparation roadmap.

I am rebuilding my Java knowledge after university and previous experience with C, C++, C#, and Java.

The goal of this repository is to document my progress from Java fundamentals to backend development and junior-level projects.

---

## Current Goal

- Rebuild Java Core knowledge
- Learn Object-Oriented Programming deeply
- Learn SQL and backend basics
- Build portfolio projects
- Prepare for junior backend developer roles

---

## Progress Roadmap

### Day 1–2
Topics:
- Variables
- Primitive types
- Classes and Objects
- Constructors
- this keyword
- Object creation

Practice:
- Created Person class
- Added constructor
- Added object methods
- Created multiple instances

---

### Day 3
Topics:
- Encapsulation
- private fields
- Getters and Setters
- Validation logic

Practice:
- Created Student class
- Added data validation
- Implemented setters/getters
- Protected object state

---

### Day 4
Topics:
- Constructor Overloading
- Multiple constructors
- Object initialization
- Default values
- Object creation scenarios

Practice:
- Created Book class
- Added multiple constructors
- Implemented constructor overload
- Created objects with different parameter sets
- Practiced object modeling

---

### Day 5
Topics:
- Static fields and methods
- Shared class state
- Constructor chaining
- Automatic ID generation
- Object identity

Practice:
- Created Book system
- Implemented totalBooks counter
- Built automatic ID assignment
- Used constructor delegation
- Added discount validation
- Improved object architecture

---

Day 6 — Collections & Library System

Topics covered:
- ArrayList (Java Collections Framework)
- Object storage in collections
- Iterating over objects
- Searching elements in a list
- Removing elements by ID
- Filtering data in collections

What I built:
- Library system with Book objects
- Added books dynamically using ArrayList
- Implemented:
    - addBook()
    - showAllBooks()
    - countBooks()
    - findBookByTitle()
    - removeBookById()
    - showExpensiveBooks()

Key concepts learned:
- Difference between arrays and ArrayList
- Object management inside collections
- Using equals() for string comparison
- Working with object references in lists

Next step:
- User input with Scanner
- Console-based interactive application

---

# Day 7 — Console Application Architecture

Topics Covered
- Scanner input
- Console menu system
- While loop
- Application flow
- Separation of concerns
- OOP architecture

Features Implemented
- Menu class for user interaction
- Library system improvements
- Empty library validation
- Search by title
- Remove by ID
- Expensive books filter

Key Concepts Learned
- Main/Menu controls application flow
- Library manages objects
- Book stores data
- Collections store object references
- While loop keeps app running
- Scanner should exist once

Important Architecture
Book → stores data  
Library → manages books  
Menu/Main → handles user interaction

 Progress
- Better understanding of object interaction
- Stronger OOP structure
- Transition from exercises to application building

---

 Day 8 — Initial implementation
 What was done:

- Created `Book` class
- Created `Library` class
- Implemented basic ArrayList storage
- Added ability to add and display books

Key learning:
- How objects are stored in collections
- Basic OOP structure in Java

Problem:
- Everything was placed inside a single class (no separation of logic)
---

Day 9 — Input handling & Menu system

What was added:
- `InputHelper` for safe user input
- `Menu` class for user interface
- `MenuChoice` enum (replacing magic numbers)

Key learning:
- Input validation is necessary to avoid runtime errors
- Enums improve code readability and safety

Problem:
- Business logic was still mixed with UI logic

---

Day 10 — First architecture split

What was changed:
- Introduced layered architecture:
  - Controller (AppController)
  - Service (LibraryService)
  - Repository (LibraryRepository)

Key learning:
- Separation of concerns is critical
- Controller should not contain business logic
- Repository should only store data
- Service handles all logic

Problem:
- Confusion about responsibility boundaries between Service and Repository

---

Day 11 — Optional and safer search logic
What was added:
- `Optional<Book>` usage in search methods
- Safer handling of missing values

Key learning:
- Avoid using null when possible
- Optional makes code more explicit and safer

Problem:
- Still adjusting architecture consistency

---

Day 12 — Architecture stabilization

What was improved:
- Fully structured layered architecture:
  - Controller → user interaction
  - Service → business logic
  - Repository → data storage

Features implemented:
- Sorting books by price
- Filtering books
- Statistical calculations (average, min, max price)
- Improved search logic

Key learning:
- Clear separation between layers improves maintainability
- Service layer is the core of application logic

---

## Current limitations
- No database (in-memory only)
- No persistence after restart
- No Spring Boot integration yet

---

## Next steps
- Improve Optional usage consistency
- Introduce Stream API
- Refactor service layer
- Start Spring Boot transition

## Learning Notes

I track:
- Java syntax recovery
- OOP understanding
- Backend concepts
- Daily coding consistency
- Project building

---

## Technologies

- Java
- IntelliJ IDEA
- Git
- GitHub

---

## Long-Term Goal

Become a backend developer and build a strong portfolio for relocation and international job opportunities.
