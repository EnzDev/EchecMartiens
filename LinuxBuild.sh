#!/bin/bash
clear
rm -rf out 2> /dev/null
mkdir out

echo "Compilation du package clavier"
javac src/clavier/* -d out/

echo -e "\n"
echo "Compilation du package liste"
javac src/liste/* -d out/

echo -e "\n"
echo "Compilation du jeu (encodage UTF-8 pour l'affichage du plateau)"
javac src/jeu/* -d out/ -cp out/ -encoding UTF8
javac src/testJeu.java -d out/ -cp out/

echo -e "\n"
echo "Lancer le jeu avec :"
echo "\$ cd out"
echo "\$ java testJeu"

echo -e "\n"
echo "Fin de la compilation..."
