# Contribuer au Jeu Master Mind

Merci de contribuer à ce projet ! Ce document fournit des directives pour la collaboration en équipe.

## Directives de Style de Code

### Java

- Utilisez camelCase pour les noms de variables et de fonctions
- Utilisez des noms descriptifs pour les variables et les fonctions
- Ajoutez des commentaires JSDoc pour toutes les fonctions
- Gardez les fonctions petites et focalisées sur une seule tâche
- Utilisez const pour les variables qui ne seront pas réassignées, let sinon
- Évitez var

Exemple :
```java
/**
 * Calculer la somme de deux nombres
 * @param {number} a - Premier nombre
 * @param {number} b - Deuxième nombre
 * @returns {number} La somme
 */
function calculerSomme(a, b) {
    return a + b;
}
```

### HTML

- Utilisez des éléments HTML5 sémantiques
- Ajoutez des labels ARIA appropriés pour l'accessibilité
- Gardez une indentation cohérente (2 ou 4 espaces)
- Utilisez des noms d'id et de class significatifs

### CSS

- Utilisez des variables CSS pour les couleurs et valeurs communes
- Suivez la convention de nommage BEM quand approprié
- Gardez les sélecteurs simples et maintenables
- Regroupez les propriétés connexes ensemble
- Ajoutez des commentaires pour les sections complexes

## Workflow Git

### Nommage des Branches

Utilisez des noms de branches descriptifs avec des préfixes :
- `feature/` pour les nouvelles fonctionnalités : `feature/ajouter-chrono`
- `fix/` pour les corrections de bugs : `fix/bug-validation`
- `docs/` pour la documentation : `docs/mise-a-jour-readme`
- `refactor/` pour le refactoring de code : `refactor/logique-jeu`

### Messages de Commit

Écrivez des messages de commit clairs et concis :

**Format :**
```
<type>: <sujet>

<corps (optionnel)>
```

**Types :**
- `feat`: Nouvelle fonctionnalité
- `fix`: Correction de bug
- `docs`: Modifications de documentation
- `style`: Modifications de style de code (formatage, points-virgules manquants, etc.)
- `refactor`: Refactoring de code
- `test`: Ajout ou mise à jour de tests
- `chore`: Tâches de maintenance

**Exemples :**
```
feat: Ajouter la fonctionnalité chronomètre

Implémentation d'un chronomètre à rebours qui démarre quand le jeu
commence et s'arrête quand le joueur gagne ou perd.
```

```
fix: Corriger la gestion des couleurs dupliquées dans la validation

L'algorithme de validation gère maintenant correctement les cas où
le code secret contient des couleurs dupliquées.
```

### Processus de Pull Request

1. Créer une branche de fonctionnalité depuis `main`
2. Faire vos modifications et committer régulièrement
3. Pousser votre branche vers GitHub
4. Créer une Pull Request avec une description claire
5. Attendre qu'au moins un membre de l'équipe révise
6. Traiter tous les retours
7. Fusionner après approbation

### Modèle de Pull Request

```markdown
## Description
Brève description des changements

## Type de Changement
- [ ] Correction de bug
- [ ] Nouvelle fonctionnalité
- [ ] Mise à jour de documentation
- [ ] Refactoring de code

## Tests
Décrivez comment vous avez testé vos changements

## Liste de Vérification
- [ ] Le code suit les directives de style du projet
- [ ] Ajout/mise à jour des commentaires et documentation
- [ ] Testé dans plusieurs navigateurs
- [ ] Aucune erreur de console
- [ ] Prêt pour révision
```

## Directives de Révision de Code

Lors de la révision de code :

1. Soyez constructif et respectueux
2. Concentrez-vous sur le code, pas sur la personne
3. Expliquez pourquoi vous suggérez des modifications
4. Approuvez si les changements semblent bons, ou demandez des modifications si nécessaire
5. Testez les changements localement si possible

## Tests

Avant de soumettre une PR :

1. Tester toutes les fonctionnalités manuellement
2. Vérifier dans Chrome, Firefox et Safari
3. Tester sur appareils mobiles ou utiliser les outils de développement du navigateur
4. Vérifier qu'il n'y a pas d'erreurs de console
5. Tester les cas limites

## Communication

- Utiliser les Issues GitHub pour les rapports de bugs et demandes de fonctionnalités
- Utiliser les commentaires de Pull Request pour les discussions de code
- Tenir les membres de l'équipe informés des changements majeurs
- Demander de l'aide quand vous êtes bloqué

## Organisation des Fichiers

- Les fichiers JavaScript vont dans `src/js/`
- Les fichiers CSS vont dans `src/css/`
- Les images vont dans `assets/images/`
- La documentation va dans `docs/`

## Questions ?

Si vous avez des questions sur comment contribuer, demandez dans le chat d'équipe ou créez une issue sur GitHub.
