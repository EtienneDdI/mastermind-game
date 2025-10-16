# Quick Start Guide

This guide will help you get started with the Master Mind project quickly.

## First Time Setup

### 1. Create GitHub Repository

1. Go to [GitHub](https://github.com)
2. Click the "+" icon in the top right and select "New repository"
3. Name it: `mastermind-game`
4. Description: "A JavaScript implementation of the classic Master Mind board game"
5. Keep it Public or Private (your choice)
6. Do NOT initialize with README, .gitignore, or license (we already have these)
7. Click "Create repository"

### 2. Connect Local Repository to GitHub

After creating the repository on GitHub, run these commands:

```bash
# Navigate to the project directory
cd /Users/catherine/mastermind-game

# Add all files to git
git add .

# Create initial commit
git commit -m "Initial commit: Project structure and base files"

# Add remote repository (replace YOUR_USERNAME with your GitHub username)
git remote add origin https://github.com/YOUR_USERNAME/mastermind-game.git

# Push to GitHub
git push -u origin main
```

If you get an error about the branch name, run:
```bash
git branch -M main
git push -u origin main
```

### 3. Invite Team Members

1. Go to your repository on GitHub
2. Click "Settings" tab
3. Click "Collaborators" in the left sidebar
4. Click "Add people"
5. Search for and add your team members (Pham, Gowend, Etienne)

### 4. Clone the Repository (For Team Members)

Team members should clone the repository:

```bash
# Clone the repository (replace YOUR_USERNAME)
git clone https://github.com/YOUR_USERNAME/mastermind-game.git

# Navigate into the project
cd mastermind-game

# Verify everything is there
ls
```

## Daily Workflow

### Starting Work

```bash
# 1. Make sure you're on the main branch
git checkout main

# 2. Pull latest changes
git pull origin main

# 3. Create a feature branch
git checkout -b feature/your-feature-name
```

### While Working

```bash
# Check what files you've modified
git status

# Add files to staging
git add filename.js
# Or add all files
git add .

# Commit your changes
git commit -m "Add feature description"

# Push to GitHub
git push -u origin feature/your-feature-name
```

### Finishing Work

1. Push your feature branch to GitHub
2. Go to GitHub and create a Pull Request
3. Ask a team member to review
4. After approval, merge the Pull Request
5. Delete the feature branch on GitHub
6. Update your local main:

```bash
git checkout main
git pull origin main
git branch -d feature/your-feature-name
```

## Common Commands Reference

```bash
# See current branch
git branch

# Switch to existing branch
git checkout branch-name

# Create and switch to new branch
git checkout -b new-branch-name

# See what changed
git status
git diff

# View commit history
git log --oneline

# Undo changes in a file (before staging)
git checkout -- filename.js

# Remove file from staging (before commit)
git reset HEAD filename.js
```

## Testing Your Changes

Before committing:

1. Open `index.html` in your browser
2. Test all functionality
3. Check the browser console for errors (F12)
4. Test on different browsers if possible
5. Test responsive design (resize browser window)

## Getting Help

- Read the [README.md](README.md) for detailed documentation
- Read the [CONTRIBUTING.md](CONTRIBUTING.md) for code guidelines
- Check [docs/PROJECT_STRUCTURE.md](docs/PROJECT_STRUCTURE.md) for file organization
- Ask team members in your group chat
- Search GitHub Issues for similar problems
- Create a new Issue if you find a bug

## Troubleshooting

### "Permission denied" when pushing

You may need to set up SSH keys or use a Personal Access Token. See:
- [GitHub SSH Key Guide](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)
- [Personal Access Token Guide](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)

### Merge conflicts

1. Open the conflicted file
2. Look for `<<<<<<<`, `=======`, and `>>>>>>>` markers
3. Manually edit to keep the correct code
4. Remove the conflict markers
5. Save the file
6. Add and commit:
```bash
git add conflicted-file.js
git commit -m "Resolve merge conflict"
```

### "Already up to date" but files are different

```bash
# Reset to remote version
git fetch origin
git reset --hard origin/main
```

### Accidentally committed to main instead of a branch

```bash
# Create a new branch with current changes
git branch feature/your-feature
git reset --hard origin/main
git checkout feature/your-feature
```

## Best Practices

1. Always pull before starting work
2. Commit frequently with clear messages
3. Push your branch daily
4. Keep branches short-lived (merge within a few days)
5. Review your changes before committing
6. Test before pushing
7. Communicate with your team
8. Don't commit sensitive information
9. Don't commit generated files
10. Keep commits focused on one change

## Next Steps

1. Read through the codebase to understand the structure
2. Check the Notion board for your assigned tasks
3. Create a feature branch for your first task
4. Start coding!

Good luck with the project!
