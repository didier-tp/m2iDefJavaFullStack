cd /d "%~dp0"
REM instructions qui vont bien
set URL1=http://localhost:8080/serveurRestSpringMvc/rest/client?nom=B.*
curl %URL1%

set URL2=http://localhost:8080/serveurRestSpringMvc/rest/client
REM mode POST si option -d
curl %URL2% -H "Content-Type: application/json" -d @nouveau-client.json

REM appel en GET pour verifier l'ajout
curl %URL2%
pause