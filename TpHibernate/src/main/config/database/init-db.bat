cd /d "%~dp0"
REM cd /d "%~dp0" permet de se placer dans le répertoire courant
REM set MYSQL_HOME=C:\Program Files\MySQL\MySQL Server 5.6
set MYSQL_HOME=C:\Program Files\MariaDB 10.3

"%MYSQL_HOME%\bin\mysql" --port 3307 -u root -p < init.sql
REM option -p pour inviter l'utilisateur à saisir le mot de passe

pause

REM open with / text editor pour lire ou ecrire ce fichier sous eclipse
REM open with / system editor pour lancer le script ".bat" depuis eclipse