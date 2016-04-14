# EchecMartiens [![Build Status](https://travis-ci.org/EnzDev/EchecMartiens.svg?branch=master)](https://travis-ci.org/EnzDev/EchecMartiens)
## Lancement
Allez jetter un oeil dans les releases ! 
L'encodage UTF8 pour la classe Plateau est nécéssaire pour afficher proprement le plateau.
Sinon, pour lancer le jeu placer vous dans le dossier echecMartiens et lancer le fichier de build qui correspond a votre système :  
__Linux__
```sh
$ git clone https://github.com/EnzDev/EchecMartiens.git
$ cd EchecMartien
$ chmod a+x LinuxBuild.sh
$ ./LinuxBuild.sh
$ cd ./out && java testJeu
```

__Windows__
```bash
$ git clone https://github.com/EnzDev/EchecMartiens.git
$ cd EchecMartien
$ ./WindowsBuild.bat
$ cd out
$ java testJeu
```

__Manuellement__
```sh
$ git clone https://github.com/EnzDev/EchecMartiens.git
$ cd EchecMartien
$ mkdir out
$ javac src/clavier/* -d out/
$ javac src/liste/* -d out/
$ javac src/jeu/* -d out/ -cp out/ -encoding UTF8
$ javac src/testJeu.java -d out/ -cp out/
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



