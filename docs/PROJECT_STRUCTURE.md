# Documentation de la Structure du Projet

Ce document explique l'organisation et le but de chaque fichier dans le projet Master Mind.

## Structure des Répertoires

```
mastermind-game/
├── src/                    # Répertoire du code source
│   ├── js/                 # Fichiers JavaScript
│   │   ├── main.js         # Point d'entrée de l'application
│   │   ├── game.js         # Logique et état du jeu
│   │   ├── ui.js           # Gestion de l'interface utilisateur
│   │   └── utils.js        # Fonctions utilitaires
│   └── css/                # Feuilles de style
│       └── styles.css      # Feuille de style principale
├── assets/                 # Ressources statiques
│   └── images/             # Fichiers image
├── docs/                   # Documentation
│   └── PROJECT_STRUCTURE.md # Ce fichier
├── index.html              # Fichier HTML principal
├── .gitignore              # Règles d'exclusion Git
├── README.md               # Documentation du projet
└── CONTRIBUTING.md         # Directives de contribution
```

## Descriptions des Fichiers

### Fichiers Racine

#### index.html
Le fichier HTML principal qui sert de point d'entrée pour l'application. Il contient :
- La structure HTML de base
- Les liens vers les fichiers CSS et JavaScript
- La disposition du plateau de jeu
- La palette de couleurs et les contrôles

#### README.md
Documentation complète du projet incluant :
- Description du projet
- Instructions d'installation
- Guide du workflow Git
- Informations de l'équipe

#### CONTRIBUTING.md
Directives pour contribuer au projet, incluant :
- Directives de style de code
- Workflow Git
- Processus de Pull Request
- Directives de révision de code

#### .gitignore
Spécifie quels fichiers et répertoires Git doit ignorer, incluant :
- Fichiers du système d'exploitation
- Fichiers de configuration IDE
- Modules Node (si ajoutés plus tard)
- Sorties de build

### Fichiers Source (src/)

#### src/js/main.js
**But :** Initialisation et coordination de l'application

**Responsabilités :**
- Initialiser le jeu quand le DOM est chargé
- Configurer les écouteurs d'événements
- Coordonner entre la logique du jeu et l'interface

**Fonctions Clés :**
- `initializeGame()` : Initialiser l'état du jeu
- `setupEventListeners()` : Configurer tous les gestionnaires d'événements

#### src/js/game.js
**But :** Logique et gestion de l'état du jeu

**Responsabilités :**
- Générer des codes secrets
- Valider les tentatives
- Suivre l'état du jeu
- Déterminer les conditions de victoire/défaite

**Composants Clés :**
- `generateSecretCode()` : Créer un code secret aléatoire
- `checkGuess()` : Comparer la tentative avec le code secret
- Objet `gameState` : Gérer l'état du jeu

**Propriétés de l'État du Jeu :**
- `secretCode` : Le code à deviner
- `attempts` : Historique de toutes les tentatives
- `maxAttempts` : Nombre maximum de tentatives autorisées
- `currentAttempt` : Numéro de la tentative actuelle
- `gameStatus` : Statut actuel du jeu (en cours/gagné/perdu)

#### src/js/ui.js
**But :** Gestion de l'interface utilisateur

**Responsabilités :**
- Rendre les éléments du jeu
- Gérer les interactions utilisateur
- Afficher les retours
- Mettre à jour l'état visuel

**Fonctions Clés :**
- `renderColorPalette()` : Afficher les boutons de sélection de couleur
- `renderGuessSlots()` : Créer les emplacements de pions pour les tentatives
- `selectColor()` : Gérer la sélection de couleur
- `displayGuessInHistory()` : Montrer les tentatives précédentes
- `updateAttemptsCounter()` : Mettre à jour les tentatives restantes
- `displayGameResult()` : Afficher le message de victoire/défaite
- `resetUI()` : Réinitialiser l'interface pour une nouvelle partie

#### src/js/utils.js
**But :** Fonctions utilitaires réutilisables

**Responsabilités :**
- Validation d'entrée
- Manipulation de tableaux
- Gestion du stockage local
- Fonctions d'aide

**Fonctions Clés :**
- `validateGuess()` : Valider l'entrée utilisateur
- `shuffleArray()` : Randomiser les éléments du tableau
- `saveToLocalStorage()` : Sauvegarder les données localement
- `loadFromLocalStorage()` : Charger les données sauvegardées
- `formatTime()` : Formater l'affichage du temps
- `debounce()` : Limiter la fréquence d'appel de fonction

#### src/css/styles.css
**But :** Style visuel et mise en page

**Responsabilités :**
- Définir le schéma de couleurs et le thème
- Disposer les composants
- Design responsive
- Animations et transitions

**Sections Clés :**
- Variables CSS pour les couleurs du thème
- Styles de base et reset
- Styles des composants (pions, boutons, etc.)
- Requêtes média responsive
- Fonctionnalités d'accessibilité

## Flux de Données

```
Interaction Utilisateur
    ↓
Couche Interface (ui.js)
    ↓
Validation (utils.js)
    ↓
Logique du Jeu (game.js)
    ↓
Mise à Jour de l'État
    ↓
Mise à Jour Interface (ui.js)
    ↓
Retour Visuel
```

## Dépendances des Modules

- `main.js` dépend de : `game.js`, `ui.js`, `utils.js`
- `ui.js` dépend de : `utils.js`
- `game.js` dépend de : `utils.js`
- `utils.js` n'a pas de dépendances

## Ajouter de Nouvelles Fonctionnalités

Lors de l'ajout de nouvelles fonctionnalités :

1. Déterminer quel module devrait gérer la fonctionnalité
2. Ajouter les fonctions nécessaires au fichier approprié
3. Mettre à jour cette documentation
4. Ajouter des commentaires pour expliquer la logique complexe
5. Tester minutieusement

## Bonnes Pratiques

- Garder les fonctions petites et focalisées
- Séparer les préoccupations entre modules
- Utiliser des noms de variables et fonctions significatifs
- Ajouter des commentaires JSDoc pour toutes les fonctions
- Suivre le style de code existant
- Tester les changements avant de committer
