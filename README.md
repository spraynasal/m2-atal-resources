# Industrialisation de prototypes ML / NLP

## Gestion de ressources avec uimaFit

### Prérequis

- Java8
- Gradle
- Un IDE

### Installation

`git clone https://github.com/spraynasal/m2-atal-resources`
`gradle build`

## Exercices

### 1. Translator en MD5

L'implémentation du ITranslator et du Locator se trouve dans le package _core_.
Les Analysis Engine se trouvent dans le package _processing_.
L'exécution de la chaîne se trouve dans _SimplePipelineRunner_

Exécuter SimplePipelineRunner avec le fichier `config.yml`

### 2. Choix du hachage en paramètre dans le fichier de configuration

L'implémentation du ITranslator et du Locator se trouve dans le package _core.ex2_.

Exécuter SimplePipelineRunner2 avec le fichier `config2.yml`

### 3. Traduction par décalage de 1

Exécuter SimplePipelineRunner3 avec le fichier `config3.yml`

### 4. Décalage par numéro de version (entier) dans le fichier de configuration

Exécuter SimplePipelineRunner4 avec le fichier `config4.yml`

#### 5. Choix du Locator et des paramètres dans le fichier de config

TODO

#### 6. Utiliser des instances de ITranslator persistées dans des fichiers

TODO
Les instances sont identifiées par un numéro de version.
Utiliser `ObjectOutputStream` / `ObjectInputStream` pour la lecture écriture des objets.

#### 7. Utiliser des instances configurables par langue

TODO
Idem que ci-dessus mais gérer des ressources différentes en fonction de la langue.
