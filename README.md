# gilded-rose
[![Build Status](https://travis-ci.org/NightWolfRobot/gilded-rose.svg?branch=master)](https://travis-ci.org/NightWolfRobot/gilded-rose)
[![Coverage Status](https://coveralls.io/repos/github/NightWolfRobot/gilded-rose/badge.svg?branch=master)](https://coveralls.io/github/NightWolfRobot/gilded-rose?branch=master)

## Objectif
Le projet reprend les spécifications suivantes :
- https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt
- https://github.com/ledoyen/tp-java/tree/master/projet/4A_2018

## Architecture
![UML Guilded-rose](https://i.imgur.com/a6U9QJ9.png)

## Spring-boot
Pour le projet on a donc 3 adresses pour nous permettre d'effectuer les differentes tâches:
* `/buy_item`
* `/list_items`
* `/add_item`

## Exemple
### Add item
```
add_item?name=coquelicot&sellin=10&quality=40&quantity=5&price=5.77
```

Pour ajouter un item il faut préciser les paramètres suivants :
- name (nom de l'item)
- sellin (nombre de jour avant péremption)
- quality (qualité de l'item)
- quantity (quantité disponible)
- price (prix de l'item à l'unité)

> **Note:** Si on ajoute un produit avec le même nom qu'un déjà présent dans la base de donnée, cela incrémente juste la quantité du produit disponible.

> **Attention:** Tous les paramètres sont *OBLIGATOIRES*. Une page d'erreur est affichée s'ils ne sont pas tous présents.

### Buy item
```
buy_item?name=coquelicot&quantity=2
```

Pour acheter un item il suffit simplement de préciser le nom et la quantité voulue avec les paramètres suivants:
- name
- quantity
> **Note:** On ne peut pas acheter plus d'items que disponible.

### List items
```
list_items
```

Enfin pour observer la liste des différents items disponibles au format Json il suffit de se rendre sur l'adresse `list_items`.
> **Note:** Toutes les 15 min l'ensemble des produits est mis à jour.

## Scénario
On va successivement tester les fonctionnalités. (Il va s'agir de copier/coller les instructions suivantes dans le navigateur)
```
add_item?name=Coquelicot&sellin=10&quality=40&quantity=5&price=30.99
add_item?name=Aged%20Brie&sellin=20&quality=10&quantity=12&price=4.99
add_item?name=Sulfuras&sellin=20&quality=80&quantity=1&price=50000
add_item?name=Backstage&sellin=10&quality=20&quantity=5&price=50.55
```

On peut afficher ce que l'on vient d'ajouter avec ceci :
```
list_items
```

Ensuite on va ajouter de nouveau le même item ce qui aura pour effet d'ajouter la quantité précisé au premier.
```
add_item?name=Coquelicot&sellin=10&quality=40&quantity=5&price=30.99
list_items
```

On peut maintenant essayer d'acheter un item par exemple deux Coquelicots.
```
buy_item?name=Coquelicot&quantity=2
```

On là encore observer que le nombre diminue et si on répète l'opération, on pourra observer qu'il arrive un moment où l'on ne peut plus acheter. Il n'y a en effet plus de stock.
> **Note:** Il est possible d'observer des comportements spécifiques en agissant sur les items spéciaux qui ont surchargé les méthodes update().

## Membres du projet
* CHAFFOT Anthony ([NightWolfRobot](https://github.com/NightWolfRobot "NightWolfRobot"))
* LE HOLLOCO Jean Antoine ([LeHolloco](https://github.com/LeHolloco "LeHolloco"))
* OUMOURI ASSOUMANI Daroui Dine ([daroui27](https://github.com/daroui27 "daroui27"))
* PERRAULT William ([Timezer](https://github.com/Timezer "Timezer"))
* RASNER Amin ([AminRas](https://github.com/AminRas "AminRas"))
* Frank Pissochet
