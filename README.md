# Master Mind Game

A JavaScript implementation of the classic Master Mind board game.

## Description

Master Mind is a code-breaking game where one player (the computer) creates a secret code, and the other player (the user) tries to guess it within a limited number of attempts. After each guess, the game provides feedback indicating how many colors are correct and in the right position (black pegs) and how many colors are correct but in the wrong position (white pegs).

## Project Structure

```
mastermind-game/
├── src/
│   ├── js/
│   │   ├── main.js           # Entry point and game initialization
│   │   ├── game.js            # Game logic and state management
│   │   ├── ui.js              # User interface interactions
│   │   └── utils.js           # Utility functions
│   └── css/
│       └── styles.css         # Game styling
├── assets/
│   └── images/                # Game assets (if needed)
├── docs/                      # Documentation files
├── index.html                 # Main HTML file
├── .gitignore                 # Git ignore file
└── README.md                  # This file
```

## Features

- Classic Master Mind gameplay (4 pegs, 6 colors)
- Visual feedback with black and white indicators
- Attempt counter and game history
- Win/loss detection
- Responsive design for mobile and desktop

## Getting Started

### Prerequisites

- A modern web browser (Chrome, Firefox, Safari, Edge)
- Git installed on your machine
- A text editor or IDE (VS Code recommended)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/YOUR_USERNAME/mastermind-game.git
cd mastermind-game
```

2. Open the project:
```bash
# Open in VS Code (if installed)
code .

# Or open index.html directly in your browser
open index.html  # macOS
start index.html # Windows
xdg-open index.html # Linux
```

### Running the Game

Simply open `index.html` in your web browser. No build process or dependencies required for the basic version.

## Git Workflow Guide

### Initial Setup

```bash
# Configure your Git identity (first time only)
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# Clone the repository
git clone https://github.com/YOUR_USERNAME/mastermind-game.git
cd mastermind-game
```

### Basic Git Commands

#### Check Status
```bash
# See what files have been modified
git status
```

#### Stage Changes
```bash
# Stage specific files
git add src/js/game.js

# Stage all modified files
git add .

# Stage all files in a directory
git add src/
```

#### Commit Changes
```bash
# Commit with a message
git commit -m "Add game logic for secret code generation"

# Commit all modified tracked files
git commit -am "Update UI styling"
```

#### Push and Pull
```bash
# Push your commits to GitHub
git push origin main

# Pull latest changes from GitHub
git pull origin main

# Pull before starting work (recommended)
git pull
```

#### Branching
```bash
# Create a new branch
git branch feature/game-logic

# Switch to a branch
git checkout feature/game-logic

# Create and switch to a new branch (shorthand)
git checkout -b feature/ui-design

# List all branches
git branch

# Merge a branch into main
git checkout main
git merge feature/game-logic

# Delete a branch after merging
git branch -d feature/game-logic
```

### Recommended Workflow

1. **Before starting work:**
```bash
git pull origin main
```

2. **Create a feature branch:**
```bash
git checkout -b feature/your-feature-name
```

3. **Make your changes and commit regularly:**
```bash
git add .
git commit -m "Descriptive commit message"
```

4. **Push your branch to GitHub:**
```bash
git push -u origin feature/your-feature-name
```

5. **Create a Pull Request on GitHub** for team review

6. **After PR is merged, update your local main:**
```bash
git checkout main
git pull origin main
git branch -d feature/your-feature-name
```

### Common Issues and Solutions

#### Merge Conflicts
```bash
# When you encounter a conflict
# 1. Open the conflicted file(s)
# 2. Look for conflict markers: <<<<<<<, =======, >>>>>>>
# 3. Manually resolve the conflicts
# 4. Stage the resolved files
git add conflicted-file.js
git commit -m "Resolve merge conflict"
```

#### Undo Changes
```bash
# Discard changes in working directory
git checkout -- filename.js

# Unstage a file
git reset HEAD filename.js

# Undo last commit (keep changes)
git reset --soft HEAD~1

# Undo last commit (discard changes)
git reset --hard HEAD~1
```

#### View History
```bash
# View commit history
git log

# View compact history
git log --oneline

# View history with graph
git log --graph --oneline --all
```

## Commit Message Conventions

Follow these guidelines for clear commit messages:

- Use imperative mood: "Add feature" not "Added feature"
- Keep first line under 50 characters
- Add detailed description after a blank line if needed
- Reference issue numbers when applicable

Examples:
```
Add secret code generation function

Implement random code generation with configurable
number of pegs and available colors.
```

```
Fix validation bug in guess checking

Resolve issue where duplicate colors were not
handled correctly in the verification algorithm.
```

## Collaboration Guidelines

1. **Always pull before starting work** to avoid conflicts
2. **Use feature branches** for new features or bug fixes
3. **Commit often** with clear, descriptive messages
4. **Test your code** before pushing
5. **Review team members' Pull Requests** promptly
6. **Keep commits focused** on a single change or feature
7. **Communicate** with your team about what you're working on

## Team Members

- Pham - Game Logic
- Gowend - User Interface
- Etienne - Quality Assurance & Documentation

## Project Timeline

- Start Date: October 17, 2025
- Target Completion: December 31, 2025
- Presentation: End of December

## License

This project is developed as part of a course assignment.

## Resources

- [Git Documentation](https://git-scm.com/doc)
- [GitHub Guides](https://guides.github.com/)
- [JavaScript MDN Documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript)
- [Master Mind Rules](https://en.wikipedia.org/wiki/Mastermind_(board_game))
