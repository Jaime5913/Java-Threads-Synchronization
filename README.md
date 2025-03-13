# Java-Threads-Synchronization

## Notes
- The system ensures that the number of characters produced equals the number consumed
- Special tracking is done for consonants (non-vowel uppercase letters)
- The buffer implementation prevents race conditions and deadlocks
- Timestamping is adjusted to provide consistent output
## Overview
This project implements the classic Producer-Consumer problem using Java threads and synchronization. The program creates a set of Generator threads (producers) and Consumer threads (consumers) that share a bounded buffer for character data. Generators produce random uppercase letters and insert them into the buffer, while Consumers remove and process these characters. The implementation focuses on thread synchronization, buffer management, and character processing.

## Project Components

### Buffer.java
- Implements a circular buffer for character data with synchronized access
- Provides thread-safe methods for character insertion and removal
- Uses wait/notify mechanism to handle full or empty buffer conditions
- Maintains pointers for insertion and removal positions

### Generator.java (Producer)
- Extends Java's Thread class
- Generates random uppercase letters (A-Z)
- Inserts characters into the shared buffer
- Tracks the number of consonants generated
- Displays timestamped information about insertions

### Consumer.java
- Extends Java's Thread class
- Removes characters from the shared buffer
- Identifies and counts consonants (non-vowels)
- Displays timestamped information about consumed characters

### Coordinator.java
- Main class that initializes and coordinates the entire system
- Takes seed values as command-line arguments
- Randomly determines system parameters:
  - Buffer size (10-15)
  - Number of items to produce (20-40)
  - Number of Generator threads (3-7)
  - Number of Consumer threads (3-7)
- Creates and manages Generator and Consumer threads
- Verifies data consistency by comparing consonant counts
- Provides a timestamp utility for logging purposes

### Makefile
- Simplifies compilation and execution of the program
- Provides targets for building, running, cleaning, and creating tarballs

## How It Works
1. The Coordinator initializes the system with randomized parameters based on seed values
2. A shared Buffer is created with the specified size
3. Multiple Generator threads produce random uppercase letters and insert them into the buffer
4. Multiple Consumer threads remove characters from the buffer and process them
5. Generators track the number of consonants they produce
6. Consumers track the number of consonants they consume
7. The system verifies data integrity by comparing the total consonants produced and consumed
8. All operations are logged with timestamps for analysis

## Thread Synchronization
The implementation demonstrates several key concepts in concurrent programming:
- Mutex protection using Java's `synchronized` keyword
- Condition variables using `wait()` and `notify()`
- Thread coordination with `join()`
- Safe termination of multiple threads
- Resource sharing with bounded buffer

## Usage
```bash
# Compile all Java files
make

# Run with two seed values (for main randomization and alphabet generation)
java Coordinator <seed1> <seed2>

# Clean up compiled classes
make clean

# Create a distribution tarball
make tar
```

## Example Output
```
[Coordinator] Buffer Size: 12
[Coordinator] Total Items: 35
[Coordinator] No. of Generators: 5
[Coordinator] No. of Consumers: 4
[Generator 1]: inserted D at index 0 at time 2023-11-15 12:34:56.789
[Consumer 1]: consumed D at index 0 at time 2023-11-15 12:34:56.790
...
The generated & consumed numbers of consonants are the same as shown: 27
```

