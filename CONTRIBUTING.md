# Contributing to Master Mind Game

Thank you for contributing to this project! This document provides guidelines for team collaboration.

## Code Style Guidelines

### JavaScript

- Use camelCase for variable and function names
- Use descriptive names for variables and functions
- Add JSDoc comments for all functions
- Keep functions small and focused on a single task
- Use const for variables that won't be reassigned, let otherwise
- Avoid var

Example:
```javascript
/**
 * Calculate the sum of two numbers
 * @param {number} a - First number
 * @param {number} b - Second number
 * @returns {number} The sum
 */
function calculateSum(a, b) {
    return a + b;
}
```

### HTML

- Use semantic HTML5 elements
- Add appropriate ARIA labels for accessibility
- Keep consistent indentation (2 or 4 spaces)
- Use meaningful id and class names

### CSS

- Use CSS variables for colors and common values
- Follow BEM naming convention when appropriate
- Keep selectors simple and maintainable
- Group related properties together
- Add comments for complex sections

## Git Workflow

### Branch Naming

Use descriptive branch names with prefixes:
- `feature/` for new features: `feature/add-timer`
- `fix/` for bug fixes: `fix/validation-bug`
- `docs/` for documentation: `docs/update-readme`
- `refactor/` for code refactoring: `refactor/game-logic`

### Commit Messages

Write clear, concise commit messages:

**Format:**
```
<type>: <subject>

<body (optional)>
```

**Types:**
- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, missing semicolons, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

**Examples:**
```
feat: Add timer functionality to track game duration

Implemented a countdown timer that starts when the game begins
and stops when the player wins or loses.
```

```
fix: Correct duplicate color handling in validation

The validation algorithm now properly handles cases where the
secret code contains duplicate colors.
```

### Pull Request Process

1. Create a feature branch from `main`
2. Make your changes and commit regularly
3. Push your branch to GitHub
4. Create a Pull Request with a clear description
5. Wait for at least one team member to review
6. Address any feedback
7. Merge after approval

### Pull Request Template

```markdown
## Description
Brief description of changes

## Type of Change
- [ ] Bug fix
- [ ] New feature
- [ ] Documentation update
- [ ] Code refactoring

## Testing
Describe how you tested your changes

## Checklist
- [ ] Code follows project style guidelines
- [ ] Added/updated comments and documentation
- [ ] Tested in multiple browsers
- [ ] No console errors
- [ ] Ready for review
```

## Code Review Guidelines

When reviewing code:

1. Be constructive and respectful
2. Focus on the code, not the person
3. Explain why you're suggesting changes
4. Approve if changes look good, or request changes if needed
5. Test the changes locally if possible

## Testing

Before submitting a PR:

1. Test all functionality manually
2. Check in Chrome, Firefox, and Safari
3. Test on mobile devices or use browser dev tools
4. Verify no console errors
5. Test edge cases

## Communication

- Use GitHub Issues for bug reports and feature requests
- Use Pull Request comments for code discussions
- Keep team members informed of major changes
- Ask for help when stuck

## File Organization

- JavaScript files go in `src/js/`
- CSS files go in `src/css/`
- Images go in `assets/images/`
- Documentation goes in `docs/`

## Questions?

If you have questions about contributing, ask in the team chat or create an issue on GitHub.
