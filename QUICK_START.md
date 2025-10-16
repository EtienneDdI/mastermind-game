# Guide de Démarrage Rapide

Ce guide vous aidera à démarrer rapidement avec le projet Master Mind.

## Configuration Première Fois

### 1. Créer le Dépôt GitHub

1. Aller sur [GitHub](https://github.com)
2. Cliquer sur l'icône "+" en haut à droite et sélectionner "New repository"
3. Nommer : `mastermind-game`
4. Description : "Une implémentation JavaScript du jeu de société classique Master Mind"
5. Le garder Public ou Privé (votre choix)
6. NE PAS initialiser avec README, .gitignore, ou licence (nous les avons déjà)
7. Cliquer sur "Create repository"

### 2. Connecter le Dépôt Local à GitHub

Après avoir créé le dépôt sur GitHub, exécuter ces commandes :

```bash
# Naviguer vers le répertoire du projet
cd /Users/catherine/mastermind-game

# Ajouter tous les fichiers à git
git add .

# Créer le commit initial
git commit -m "Initial commit: Structure de projet et fichiers de base"

# Ajouter le dépôt distant
git remote add origin https://github.com/EtienneDdI/mastermind-game.git

# Pousser vers GitHub
git push -u origin main
```

Si vous obtenez une erreur sur le nom de la branche, exécuter :
```bash
git branch -M main
git push -u origin main
```

### 3. Inviter les Membres de l'Équipe

1. Aller sur votre dépôt sur GitHub
2. Cliquer sur l'onglet "Settings"
3. Cliquer sur "Collaborators" dans la barre latérale gauche
4. Cliquer sur "Add people"
5. Rechercher et ajouter vos membres d'équipe (Pham, Gowend, Etienne)

### 4. Cloner le Dépôt (Pour les Membres de l'Équipe)

Les membres de l'équipe doivent cloner le dépôt :

```bash
# Cloner le dépôt
git clone https://github.com/EtienneDdI/mastermind-game.git

# Naviguer dans le projet
cd mastermind-game

# Vérifier que tout est là
ls
```

## Workflow Quotidien

### Commencer à Travailler

```bash
# 1. Assurez-vous d'être sur la branche main
git checkout main

# 2. Récupérer les derniers changements
git pull origin main

# 3. Créer une branche de fonctionnalité
git checkout -b feature/nom-de-votre-fonctionnalite
```

### Pendant le Travail

```bash
# Vérifier quels fichiers vous avez modifiés
git status

# Ajouter des fichiers à la préparation
git add nomfichier.js
# Ou ajouter tous les fichiers
git add .

# Committer vos changements
git commit -m "Description de la fonctionnalité"

# Pousser vers GitHub
git push -u origin feature/nom-de-votre-fonctionnalite
```

### Terminer le Travail

1. Pousser votre branche de fonctionnalité vers GitHub
2. Aller sur GitHub et créer une Pull Request
3. Demander à un membre de l'équipe de réviser
4. Après approbation, fusionner la Pull Request
5. Supprimer la branche de fonctionnalité sur GitHub
6. Mettre à jour votre main local :

```bash
git checkout main
git pull origin main
git branch -d feature/nom-de-votre-fonctionnalite
```

## Référence des Commandes Courantes

```bash
# Voir la branche actuelle
git branch

# Basculer vers une branche existante
git checkout nom-branche

# Créer et basculer vers une nouvelle branche
git checkout -b nom-nouvelle-branche

# Voir ce qui a changé
git status
git diff

# Voir l'historique des commits
git log --oneline

# Annuler les changements dans un fichier (avant préparation)
git checkout -- nomfichier.js

# Retirer un fichier de la préparation (avant commit)
git reset HEAD nomfichier.js
```

## Tester Vos Changements

Avant de committer :

1. Ouvrir `index.html` dans votre navigateur
2. Tester toutes les fonctionnalités
3. Vérifier la console du navigateur pour les erreurs (F12)
4. Tester sur différents navigateurs si possible
5. Tester le design responsive (redimensionner la fenêtre du navigateur)

## Obtenir de l'Aide

- Lire le [README.md](README.md) pour la documentation détaillée
- Lire le [CONTRIBUTING.md](CONTRIBUTING.md) pour les directives de code
- Consulter [docs/PROJECT_STRUCTURE.md](docs/PROJECT_STRUCTURE.md) pour l'organisation des fichiers
- Demander aux membres de l'équipe dans le chat de groupe
- Rechercher dans les Issues GitHub pour des problèmes similaires
- Créer une nouvelle Issue si vous trouvez un bug

## Dépannage

### "Permission denied" lors du push

Vous devrez peut-être configurer des clés SSH ou utiliser un Token d'Accès Personnel. Voir :
- [Guide de Clé SSH GitHub](https://docs.github.com/fr/authentication/connecting-to-github-with-ssh)
- [Guide de Token d'Accès Personnel](https://docs.github.com/fr/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)

### Conflits de fusion

1. Ouvrir le fichier en conflit
2. Chercher les marqueurs `<<<<<<<`, `=======`, et `>>>>>>>`
3. Éditer manuellement pour garder le bon code
4. Retirer les marqueurs de conflit
5. Sauvegarder le fichier
6. Ajouter et committer :
```bash
git add fichier-en-conflit.js
git commit -m "Résoudre le conflit de fusion"
```

### "Already up to date" mais les fichiers sont différents

```bash
# Réinitialiser à la version distante
git fetch origin
git reset --hard origin/main
```

### Commit accidentel sur main au lieu d'une branche

```bash
# Créer une nouvelle branche avec les changements actuels
git branch feature/votre-fonctionnalite
git reset --hard origin/main
git checkout feature/votre-fonctionnalite
```

## Bonnes Pratiques

1. Toujours tirer avant de commencer à travailler
2. Committer fréquemment avec des messages clairs
3. Pousser votre branche quotidiennement
4. Garder les branches de courte durée (fusionner en quelques jours)
5. Réviser vos changements avant de committer
6. Tester avant de pousser
7. Communiquer avec votre équipe
8. Ne pas committer d'informations sensibles
9. Ne pas committer de fichiers générés
10. Garder les commits focalisés sur un changement

## Prochaines Étapes

1. Lire le code pour comprendre la structure
2. Consulter le tableau Notion pour vos tâches assignées
3. Créer une branche de fonctionnalité pour votre première tâche
4. Commencer à coder !

Bonne chance avec le projet !
