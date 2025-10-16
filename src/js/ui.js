/**
 * User Interface management for Master Mind
 * Handles DOM manipulation and user interactions
 */

/**
 * Available colors for the game
 */
const COLORS = ['red', 'blue', 'green', 'yellow', 'purple', 'orange'];

/**
 * Current guess array
 */
let currentGuess = [];

/**
 * Render the color palette
 */
function renderColorPalette() {
    const colorsContainer = document.getElementById('colors');
    colorsContainer.innerHTML = '';

    COLORS.forEach(color => {
        const button = document.createElement('button');
        button.className = 'color-btn';
        button.style.backgroundColor = color;
        button.setAttribute('data-color', color);
        button.setAttribute('aria-label', `Select ${color}`);
        button.addEventListener('click', () => selectColor(color));
        colorsContainer.appendChild(button);
    });
}

/**
 * Render the guess slots
 */
function renderGuessSlots() {
    const slotsContainer = document.getElementById('guess-slots');
    slotsContainer.innerHTML = '';

    for (let i = 0; i < 4; i++) {
        const slot = document.createElement('div');
        slot.className = 'peg-slot';
        slot.setAttribute('data-index', i);
        slot.addEventListener('click', () => clearSlot(i));
        slotsContainer.appendChild(slot);
    }
}

/**
 * Select a color and add it to the current guess
 * @param {string} color - The selected color
 */
function selectColor(color) {
    if (currentGuess.length < 4) {
        currentGuess.push(color);
        updateGuessDisplay();
    }
}

/**
 * Clear a specific slot
 * @param {number} index - The index of the slot to clear
 */
function clearSlot(index) {
    if (index < currentGuess.length) {
        currentGuess.splice(index, 1);
        updateGuessDisplay();
    }
}

/**
 * Update the visual display of the current guess
 */
function updateGuessDisplay() {
    const slots = document.querySelectorAll('.peg-slot');
    slots.forEach((slot, index) => {
        if (index < currentGuess.length) {
            slot.style.backgroundColor = currentGuess[index];
            slot.classList.add('filled');
        } else {
            slot.style.backgroundColor = 'transparent';
            slot.classList.remove('filled');
        }
    });
}

/**
 * Display a guess in the history
 * @param {string[]} guess - The guess to display
 * @param {Object} result - The result with exact and misplaced counts
 * @param {number} attemptNumber - The attempt number
 */
function displayGuessInHistory(guess, result, attemptNumber) {
    const historyContainer = document.getElementById('history');
    const attemptDiv = document.createElement('div');
    attemptDiv.className = 'attempt';

    // Create attempt number
    const attemptLabel = document.createElement('span');
    attemptLabel.className = 'attempt-number';
    attemptLabel.textContent = `#${attemptNumber}`;

    // Create pegs container
    const pegsContainer = document.createElement('div');
    pegsContainer.className = 'peg-container';
    guess.forEach(color => {
        const peg = document.createElement('div');
        peg.className = 'peg';
        peg.style.backgroundColor = color;
        pegsContainer.appendChild(peg);
    });

    // Create feedback
    const feedbackContainer = document.createElement('div');
    feedbackContainer.className = 'feedback';
    feedbackContainer.innerHTML = `
        <span class="exact">Bien placés: ${result.exact}</span>
        <span class="misplaced">Mal placés: ${result.misplaced}</span>
    `;

    attemptDiv.appendChild(attemptLabel);
    attemptDiv.appendChild(pegsContainer);
    attemptDiv.appendChild(feedbackContainer);
    historyContainer.prepend(attemptDiv);
}

/**
 * Update the remaining attempts counter
 * @param {number} remaining - Number of remaining attempts
 */
function updateAttemptsCounter(remaining) {
    document.getElementById('remaining-attempts').textContent = remaining;
}

/**
 * Display game result
 * @param {boolean} won - Whether the player won
 * @param {string[]} secretCode - The secret code
 */
function displayGameResult(won, secretCode) {
    const resultSection = document.getElementById('game-result');
    const resultMessage = document.getElementById('result-message');
    const secretCodeReveal = document.getElementById('secret-code-reveal');

    resultMessage.textContent = won
        ? 'Félicitations ! Vous avez trouvé la combinaison !'
        : 'Perdu ! Vous avez épuisé toutes vos tentatives.';

    resultMessage.className = won ? 'success-message' : 'failure-message';

    // Display secret code
    secretCodeReveal.innerHTML = '<p>La combinaison secrète était:</p>';
    const codeContainer = document.createElement('div');
    codeContainer.className = 'peg-container';
    secretCode.forEach(color => {
        const peg = document.createElement('div');
        peg.className = 'peg';
        peg.style.backgroundColor = color;
        codeContainer.appendChild(peg);
    });
    secretCodeReveal.appendChild(codeContainer);

    resultSection.classList.remove('hidden');
}

/**
 * Hide game result
 */
function hideGameResult() {
    document.getElementById('game-result').classList.add('hidden');
}

/**
 * Clear the game history
 */
function clearHistory() {
    document.getElementById('history').innerHTML = '';
}

/**
 * Reset the UI for a new game
 */
function resetUI() {
    currentGuess = [];
    updateGuessDisplay();
    clearHistory();
    hideGameResult();
    updateAttemptsCounter(10);
}

/**
 * Display an error message
 * @param {string} message - The error message
 */
function displayError(message) {
    alert(message);
}
