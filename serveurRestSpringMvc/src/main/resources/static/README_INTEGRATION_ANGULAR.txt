après avoir lancé "ng build --prod" , le fichier dist/angular-app/index.html
a été (exceptionnellment pour ce TP)
renommé index-angular.html pour ne pas entrer en conflit avec l'ancien index.html
de l'application spring-boot

L'ancienne partie (sans-angular , avec jquery) a été déplacée dans 
un nouveau sous répertoire "sans-angular" 
(sachant que sur un vrai projet c'est souvent avec que angular ou bien sans angular)
 
L'ensemble du contenu du répertoire dist/angular-app (*.html , *.js , assets/* , ...)
a été recopié dans src/main/resources/static

... et le tout fonctionne bien ensemble avec les mêmes chemins relatifs et
le même comportement que via "ng serve --proxy-config proxy.conf.json"
(front-end "angular" + back-end WEB-service REST java/spring-mvc) .