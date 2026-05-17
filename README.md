# 🎯 Smart Guessing Game

A robust, crash-proof console-based number guessing game built in Java. The application dynamically generates a secret number between 1 and 100, then challenges the user to guess it within 5 attempts. It features real-time proximity math feedback ("Super Warm" vs. "Freezing Cold") and smart defensive code design.

---

## ✨ Features

- **Object-Oriented Architecture:** The project is cleanly separated into three distinct modules (Main, GameEngine, and InputValidator) following proper Separation of Concerns (SoC).
- **Crash-Proof Input Validation:** Employs proactive scanner buffer validation (`hasNextInt()`) to intercept typos, letters, or blanks. Invalid input is flushed out gracefully without breaking the game or costing the user an attempt.
- **Dynamic Range Bounds:** Validates that user entries are strictly between 1 and 100 before passing them to the game loop.
- **Proximity & Directional Intelligence:** Uses absolute mathematical distance (`Math.abs()`) to give the player an intuitive sense of how close they are, alongside traditional higher/lower hints.

---

## 🛠️ Project Architecture

The codebase splits responsibilities cleanly across three classes:

```text
├── Main.java           # The application entry point; handles resource initialization and cleanup.
├── GameEngine.java     # The core controller; manages state tracking, game loops, and game logic.
└── InputValidator.java # The dedicated gatekeeper; validates input types and boundary constraints.
```
---

## 🚀 How to Run the Application

Prerequisites
Make sure you have the Java Development Kit (JDK) installed on your system.

Compilation & Execution
1. Open your terminal or command prompt in the root directory of the project.

2. Compile all Java source files:
```
javac src/*.java
```
3. Run the compiled application:
```
java -cp src Main
```

---

## 📸 Sample Gameplay Output
```
=========================================
🎯 WELCOME TO THE SMART GUESSING GAME 🎯
=========================================
I have chosen a number between 1 and 100.
Can you beat the system in 5 attempts?

Enter your guess (Attempt 1/5): 87
❄️ You're freezing cold! Try a lower number.

Enter your guess (Attempt 2/5): 23
❄️ You're freezing cold! Try a higher number.

Enter your guess (Attempt 3/5): 57
❄️ You're freezing cold! Try a lower number.

Enter your guess (Attempt 4/5): 41
🔥 You're super warm! Try a higher number.

Enter your guess (Attempt 5/5): 45
🔥 You're super warm! Try a lower number.

💀 GAME OVER! You ran out of attempts.
The correct secret number was: 42
```
---

