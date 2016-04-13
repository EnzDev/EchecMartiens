REM ASSUME LE FAIT QUE LE JDK SOIT DANS LE PATH
@echo off
cls
rmdir out /S /Q 2> NUL
mkdir out

echo Compilation du package clavier
javac src/clavier/clavier.java -d out/

echo.
echo Compilation du package liste
javac src/liste/liste.java -d out/

echo.
echo Compilation du jeu (encodage UTF-8 pour l'affichage du plateau)
javac src/jeu/* -d out/ -cp out/ -encoding UTF8
javac src/testJeu.java -d out/ -cp out/

echo.
echo Lancer le jeu avec :
echo $ cd out
echo $ java testJeu

echo.
echo Fin de la compilation...
pause>nul

@echo on