# Jeu Master Mind

Une implémentation JavaScript du jeu de société classique Master Mind.

## Description

Master Mind est un jeu de décodage où un joueur (l'ordinateur) crée un code secret, et l'autre joueur (l'utilisateur) tente de le deviner en un nombre limité de tentatives. Après chaque essai, le jeu fournit un retour indiquant combien de couleurs sont correctes et bien placées (pions noirs) et combien de couleurs sont correctes mais mal placées (pions blancs).

## Structure du Projet

```
mastermind-game/
├── src/
│   ├── js/
│   │   ├── main.js           # Point d'entrée et initialisation du jeu
│   │   ├── game.js            # Logique du jeu et gestion de l'état
│   │   ├── ui.js              # Interactions de l'interface utilisateur
│   │   └── utils.js           # Fonctions utilitaires
│   └── css/
│       └── styles.css         # Styles du jeu
├── assets/
│   └── images/                # Ressources du jeu (si nécessaire)
├── docs/                      # Fichiers de documentation
├── index.html                 # Fichier HTML principal
├── .gitignore                 # Fichier d'exclusion Git
└── README.md                  # Ce fichier
```

## Fonctionnalités

- Jeu Master Mind classique (4 pions, 6 couleurs)
- Retour visuel avec indicateurs noirs et blancs
- Compteur de tentatives et historique du jeu
- Détection de victoire/défaite
- Design responsive pour mobile et bureau

## Démarrage

### Prérequis

- Un navigateur web moderne (Chrome, Firefox, Safari, Edge)
- Git installé sur votre machine
- Un éditeur de texte ou IDE (VS Code recommandé)

### Installation

1. Clonez le dépôt :
```bash
git clone https://github.com/EtienneDdI/mastermind-game.git
cd mastermind-game
```

2. Ouvrez le projet :
```bash
# Ouvrir dans VS Code (si installé)
code .

# Ou ouvrir index.html directement dans votre navigateur
open index.html  # macOS
start index.html # Windows
xdg-open index.html # Linux
```

### Lancer le Jeu

Ouvrez simplement `index.html` dans votre navigateur web. Aucun processus de build ou dépendances requis pour la version de base.

## Guide du Workflow Git

### Configuration Initiale

```bash
# Configurer votre identité Git (première fois seulement)
git config --global user.name "Votre Nom"
git config --global user.email "votre.email@exemple.com"

# Cloner le dépôt
git clone https://github.com/EtienneDdI/mastermind-game.git
cd mastermind-game
```

### Commandes Git de Base

#### Vérifier le Statut
```bash
# Voir quels fichiers ont été modifiés
git status
```

#### Préparer les Changements
```bash
# Préparer des fichiers spécifiques
git add src/js/game.js

# Préparer tous les fichiers modifiés
git add .

# Préparer tous les fichiers d'un répertoire
git add src/
```

#### Enregistrer les Changements
```bash
# Commit avec un message
git commit -m "Ajouter la logique de génération du code secret"

# Commit tous les fichiers suivis modifiés
git commit -am "Mettre à jour le style de l'interface"
```

#### Pousser et Tirer
```bash
# Pousser vos commits vers GitHub
git push origin main

# Récupérer les derniers changements depuis GitHub
git pull origin main

# Tirer avant de commencer à travailler (recommandé)
git pull
```

#### Branches
```bash
# Créer une nouvelle branche
git branch feature/logique-jeu

# Basculer vers une branche
git checkout feature/logique-jeu

# Créer et basculer vers une nouvelle branche (raccourci)
git checkout -b feature/design-ui

# Lister toutes les branches
git branch

# Fusionner une branche dans main
git checkout main
git merge feature/logique-jeu

# Supprimer une branche après fusion
git branch -d feature/logique-jeu
```

### Workflow Recommandé

1. **Avant de commencer à travailler :**
```bash
git pull origin main
```

2. **Créer une branche de fonctionnalité :**
```bash
git checkout -b feature/nom-de-votre-fonctionnalite
```

3. **Faire vos changements et committer régulièrement :**
```bash
git add .
git commit -m "Message de commit descriptif"
```

4. **Pousser votre branche vers GitHub :**
```bash
git push -u origin feature/nom-de-votre-fonctionnalite
```

5. **Créer une Pull Request sur GitHub** pour révision d'équipe

6. **Après fusion de la PR, mettre à jour votre main local :**
```bash
git checkout main
git pull origin main
git branch -d feature/nom-de-votre-fonctionnalite
```

### Problèmes Courants et Solutions

#### Conflits de Fusion
```bash
# Quand vous rencontrez un conflit
# 1. Ouvrir le(s) fichier(s) en conflit
# 2. Chercher les marqueurs de conflit : <<<<<<<, =======, >>>>>>>
# 3. Résoudre manuellement les conflits
# 4. Préparer les fichiers résolus
git add fichier-en-conflit.js
git commit -m "Résoudre le conflit de fusion"
```

#### Annuler les Changements
```bash
# Abandonner les changements dans le répertoire de travail
git checkout -- nomfichier.js

# Retirer un fichier de la préparation
git reset HEAD nomfichier.js

# Annuler le dernier commit (garder les changements)
git reset --soft HEAD~1

# Annuler le dernier commit (supprimer les changements)
git reset --hard HEAD~1
```

#### Voir l'Historique
```bash
# Voir l'historique des commits
git log

# Voir l'historique compact
git log --oneline

# Voir l'historique avec graphique
git log --graph --oneline --all
```

## Conventions de Messages de Commit

Suivez ces directives pour des messages de commit clairs :

- Utilisez l'impératif : "Ajouter fonctionnalité" et non "Ajouté fonctionnalité"
- Gardez la première ligne sous 50 caractères
- Ajoutez une description détaillée après une ligne vide si nécessaire
- Référencez les numéros d'issue si applicable

Exemples :
```
Ajouter la fonction de génération de code secret

Implémenter la génération de code aléatoire avec nombre
configurable de pions et couleurs disponibles.
```

```
Corriger le bug de validation lors de la vérification

Résoudre le problème où les couleurs dupliquées n'étaient pas
gérées correctement dans l'algorithme de vérification.
```

## Directives de Collaboration

1. **Toujours tirer avant de commencer à travailler** pour éviter les conflits
2. **Utiliser des branches de fonctionnalité** pour les nouvelles fonctionnalités ou corrections de bugs
3. **Committer souvent** avec des messages clairs et descriptifs
4. **Tester votre code** avant de pousser
5. **Réviser les Pull Requests** des membres de l'équipe rapidement
6. **Garder les commits focalisés** sur un seul changement ou fonctionnalité
7. **Communiquer** avec votre équipe sur ce sur quoi vous travaillez

## Membres de l'Équipe

- Pham - Logique du Jeu
- Gowend - Interface Utilisateur
- Etienne - Assurance Qualité & Documentation

## Calendrier du Projet

- Date de Début : 17 octobre 2025
- Achèvement Cible : 31 décembre 2025
- Présentation : Fin décembre

## Licence

Ce projet est développé dans le cadre d'un devoir de cours.

## Ressources

- [Documentation Git](https://git-scm.com/doc)
- [Guides GitHub](https://guides.github.com/)
- [Documentation JavaScript MDN](https://developer.mozilla.org/fr/docs/Web/JavaScript)
- [Règles du Master Mind](https://fr.wikipedia.org/wiki/Mastermind)
