# EchecMartiens [![Build Status](https://travis-ci.org/EnzDev/EchecMartiens.svg?branch=master)](https://travis-ci.org/EnzDev/EchecMartiens)
## Lancement


Pour lancer le jeu placer vous dans le dossier echecMartiens et lancer le fichier de buil qui correspond a votre système :  
__linux__
```sh
$ git clone https://github.com/EnzDev/EchecMartiens.git
$ cd EchecMartien
$ chmod a+x LinuxBuild.sh
$ ./LinuxBuild.sh
$ cd ./out && java testJeu
```

__windows__
```bash
$ git clone https://github.com/EnzDev/EchecMartiens.git
$ cd EchecMartien
$ ./WindowsBuild.bat
$ cd out
$ java testJeu
```
Il vous est demandé de rentrer le nom des deux joueurs.  
Leurs score est affiché a chaque tour.

## Deroulement du jeu
Selectionner un pion en rentrant dabord son numéro de colone puis son numéro de ligne.
Selectionner la case vers laquelle vous souhaiter le déplacer en rentrant dabord son numéro de colone puis son numéro de ligne.
Si vous avez un doute sur les règles vous pouvez les retrouvez sur [ici](http://jeuxstrategieter.free.fr/Echecs_martiens_complet.php)

## Fin
La partie s'arrète automatiquement si l'un des deux joueurs ne peut plus jouer son tour.



