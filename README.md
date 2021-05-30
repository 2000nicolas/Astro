# Astro
Api des astres connus

Cette application utilise l'API REST "api.le-systeme-solaire" à l'adresse : "https://api.le-systeme-solaire.net/rest".
Elle est composé de deux écrans d'affichage :
  
  •L'affichage d'une liste des astres connus :

Cette liste est affiché à l'aide d'une recycler view et d'un adapter pour lesquels le text est appelé depuis l'API. Elle implémente aussi une image cependant, l'API ne possédant pas d'image des différents astres, une jolie image prise sur internet à été implémenté.

  •L'affichage des propriétés des astres :
  
L'affichage des propriétés des astres se fait elle aussi à l'aide d'un appel à l'API "api.le-systeme-solaire". Elle affiche différents éléments des planetes tel que leur masse ou leur nom.
Un bouton de retour en arriere est disponible sur cette page afin de retourner sur l'écran principal.




L'application implémente les architecture NVVM et Singleton et une mise en cache
  
  
