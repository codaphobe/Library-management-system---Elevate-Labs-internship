## CLI based Library Management System

### Objectives :
The objective of this project is to implement a Command-Line Interface (CLI) Library Management System in Java.
The system allows the user to manage library users, books, and checkout transactions using object-oriented principles.

Key goals include practicing:

- Java OOP concepts (classes, constructors, getters/setters)
- Collections (ArrayList for storing users, books, and checkouts)
- Streams for searching and filtering
- CRUD operations in a modular, service-oriented design

### Implementation :

**User Fields:**
- `name`
- `email`
- ArrayList<Books> `borrowedBooks`
- double `due` 
- ArrayList<Checkout> `checkout`

**Books Fields:**

- String `bookId`
- String `bookName`
- String `bookAuthor`
- boolean `isAvailable`


**Checkout Fields:**

- User `user`
- String `checkoutId`
- String `borrowedBook`
- String `borrowedDate`
- String `endDate`
- double `rent`

### Logic Implementation:

**UserManagement :**
- Maintains a list of users (`ArrayList<User>`)
- Implements CRUD operations
- Checks for duplicate users by email

**BooksManagement :**
- Maintains a list of books (`ArrayList<Book>`)
- Implements CRUD operations
- Checks for duplicate books by book ID

**CheckManagement :**

- Handles checkout and return of books
- Updates both User and Books objects:
  - Adds borrowed books to the user’s list
  - Marks books as unavailable when checked out
  - Tracks rent and due amount for the user
- Maintains a global list of all checkout transactions
- Provides functions to view a user’s checkouts or all checkouts

### Problems Encountered :

- During development, one major problem encountered was a StackOverflowError caused by recursive printing between User and Checkout objects.

- Each User holds a list of Checkout objects.

- Each Checkout holds a reference to the User.

- Calling toString() on either object led to infinite recursion.

> Solution: Modified the toString() methods to print only identifiers or counts instead of full nested objects.