REM open with / text editor (editer contenu sous eclipse)
REM open with / system editor (lancer le .bat sous windows)

set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_101
set WSDL_URL=http://formation17:8080/serveurSoap/convertisseur?wsdl

REM cd /d "%~dp0" permet de ce placer dans le répertoire courant
REM ca fonctionne bien (même sous eclipse)

cd /d "%~dp0" 

REM le chemin main/java est ici en relatif par rapport
REM au repertoire courant src
"%JAVA_HOME%\bin\wsimport" -keep -d main/java %WSDL_URL%

REM le serveur doit fonctionner pour que l'url wsdl soit accessible
REM il faudra faire un "refresh" sur le projet eclipse pour voir le
REM code généré par wsimport

pause