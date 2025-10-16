# Project Structure Documentation

This document explains the organization and purpose of each file in the Master Mind project.

## Directory Structure

```
mastermind-game/
├── src/                    # Source code directory
│   ├── js/                 # JavaScript files
│   │   ├── main.js         # Application entry point
│   │   ├── game.js         # Game logic and state
│   │   ├── ui.js           # User interface management
│   │   └── utils.js        # Utility functions
│   └── css/                # Stylesheets
│       └── styles.css      # Main stylesheet
├── assets/                 # Static assets
│   └── images/             # Image files
├── docs/                   # Documentation
│   └── PROJECT_STRUCTURE.md # This file
├── index.html              # Main HTML file
├── .gitignore              # Git ignore rules
├── README.md               # Project documentation
└── CONTRIBUTING.md         # Contribution guidelines
```

## File Descriptions

### Root Files

#### index.html
The main HTML file that serves as the entry point for the application. It contains:
- The basic HTML structure
- Links to CSS and JavaScript files
- The game board layout
- Color palette and controls

#### README.md
Comprehensive project documentation including:
- Project description
- Installation instructions
- Git workflow guide
- Team information

#### CONTRIBUTING.md
Guidelines for contributing to the project, including:
- Code style guidelines
- Git workflow
- Pull request process
- Code review guidelines

#### .gitignore
Specifies which files and directories Git should ignore, including:
- Operating system files
- IDE configuration files
- Node modules (if added later)
- Build outputs

### Source Files (src/)

#### src/js/main.js
**Purpose:** Application initialization and coordination

**Responsibilities:**
- Initialize the game when DOM is loaded
- Set up event listeners
- Coordinate between game logic and UI

**Key Functions:**
- `initializeGame()`: Initialize game state
- `setupEventListeners()`: Set up all event handlers

#### src/js/game.js
**Purpose:** Game logic and state management

**Responsibilities:**
- Generate secret codes
- Validate guesses
- Track game state
- Determine win/loss conditions

**Key Components:**
- `generateSecretCode()`: Create random secret code
- `checkGuess()`: Compare guess with secret code
- `gameState` object: Manage game state

**Game State Properties:**
- `secretCode`: The code to guess
- `attempts`: History of all guesses
- `maxAttempts`: Maximum allowed attempts
- `currentAttempt`: Current attempt number
- `gameStatus`: Current game status (playing/won/lost)

#### src/js/ui.js
**Purpose:** User interface management

**Responsibilities:**
- Render game elements
- Handle user interactions
- Display feedback
- Update visual state

**Key Functions:**
- `renderColorPalette()`: Display color selection buttons
- `renderGuessSlots()`: Create peg slots for guesses
- `selectColor()`: Handle color selection
- `displayGuessInHistory()`: Show previous attempts
- `updateAttemptsCounter()`: Update remaining attempts
- `displayGameResult()`: Show win/loss message
- `resetUI()`: Reset interface for new game

#### src/js/utils.js
**Purpose:** Reusable utility functions

**Responsibilities:**
- Input validation
- Array manipulation
- Local storage management
- Helper functions

**Key Functions:**
- `validateGuess()`: Validate user input
- `shuffleArray()`: Randomize array elements
- `saveToLocalStorage()`: Save data locally
- `loadFromLocalStorage()`: Load saved data
- `formatTime()`: Format time display
- `debounce()`: Limit function call frequency

#### src/css/styles.css
**Purpose:** Visual styling and layout

**Responsibilities:**
- Define color scheme and theme
- Layout components
- Responsive design
- Animations and transitions

**Key Sections:**
- CSS variables for theme colors
- Base styles and reset
- Component styles (pegs, buttons, etc.)
- Responsive media queries
- Accessibility features

## Data Flow

```
User Interaction
    ↓
UI Layer (ui.js)
    ↓
Validation (utils.js)
    ↓
Game Logic (game.js)
    ↓
State Update
    ↓
UI Update (ui.js)
    ↓
Visual Feedback
```

## Module Dependencies

- `main.js` depends on: `game.js`, `ui.js`, `utils.js`
- `ui.js` depends on: `utils.js`
- `game.js` depends on: `utils.js`
- `utils.js` has no dependencies

## Adding New Features

When adding new features:

1. Determine which module should handle the feature
2. Add necessary functions to the appropriate file
3. Update this documentation
4. Add comments to explain complex logic
5. Test thoroughly

## Best Practices

- Keep functions small and focused
- Separate concerns between modules
- Use meaningful variable and function names
- Add JSDoc comments for all functions
- Follow existing code style
- Test changes before committing
