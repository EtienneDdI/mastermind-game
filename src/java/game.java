/**
 * Game logic for Master Mind
 * Handles game state, secret code generation, and guess verification
 */

/**
 * Generate a random secret code
 * @param {number} length - Number of pegs in the code (default: 4)
 * @param {string[]} colors - Available colors (default: 6 colors)
 * @returns {string[]} The secret code
 */
function generateSecretCode(length = 4, colors = ['red', 'blue', 'green', 'yellow', 'purple', 'orange']) {
    // TODO: Implement secret code generation
    const code = [];
    for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * colors.length);
        code.push(colors[randomIndex]);
    }
    return code;
}

/**
 * Check the player's guess against the secret code
 * @param {string[]} secretCode - The secret code
 * @param {string[]} playerGuess - The player's guess
 * @returns {Object} Feedback with exact and misplaced counts
 */
function checkGuess(secretCode, playerGuess) {
    // TODO: Implement guess verification algorithm
    let exact = 0;
    let misplaced = 0;

    // Create copies to avoid modifying originals
    const secretCopy = [...secretCode];
    const guessCopy = [...playerGuess];

    // First pass: count exact matches
    for (let i = 0; i < secretCopy.length; i++) {
        if (guessCopy[i] === secretCopy[i]) {
            exact++;
            secretCopy[i] = null;
            guessCopy[i] = null;
        }
    }

    // Second pass: count misplaced
    for (let i = 0; i < guessCopy.length; i++) {
        if (guessCopy[i] !== null) {
            const index = secretCopy.indexOf(guessCopy[i]);
            if (index !== -1) {
                misplaced++;
                secretCopy[index] = null;
            }
        }
    }

    return { exact, misplaced };
}

/**
 * Game state object
 */
const gameState = {
    secretCode: [],
    attempts: [],
    maxAttempts: 10,
    currentAttempt: 0,
    gameStatus: 'playing', // 'playing', 'won', 'lost'

    /**
     * Start a new game
     */
    startNewGame() {
        this.secretCode = generateSecretCode();
        this.attempts = [];
        this.currentAttempt = 0;
        this.gameStatus = 'playing';
        console.log('New game started');
    },

    /**
     * Submit a guess
     * @param {string[]} guess - The player's guess
     * @returns {Object} The result of the guess
     */
    submitGuess(guess) {
        if (this.gameStatus !== 'playing') {
            return { error: 'Game is not in progress' };
        }

        const result = checkGuess(this.secretCode, guess);
        this.attempts.push({ guess, result });
        this.currentAttempt++;

        // Check win condition
        if (result.exact === this.secretCode.length) {
            this.gameStatus = 'won';
        }
        // Check loss condition
        else if (this.currentAttempt >= this.maxAttempts) {
            this.gameStatus = 'lost';
        }

        return result;
    },

    /**
     * Check if the game is over
     * @returns {boolean}
     */
    isGameOver() {
        return this.gameStatus === 'won' || this.gameStatus === 'lost';
    },

    /**
     * Check if the player has won
     * @returns {boolean}
     */
    hasWon() {
        return this.gameStatus === 'won';
    },

    /**
     * Get remaining attempts
     * @returns {number}
     */
    getRemainingAttempts() {
        return this.maxAttempts - this.currentAttempt;
    }
};
