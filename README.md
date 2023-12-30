Popis:
Aplikace by měla být schopna spravovat systém půjčovny vozidel a splnit tedy operace uvedené níže + všechny CRUD operace

Advanced dotaz:
Sešrotovani všech vozidel které si nikdo nikdy nezapůjčil -- tedy odstranění jejich záznamů z db

business operace:
V klientovi chceme přidat k zaměstnanci objednávku / obědnávku k zaměstnanci. Celkový součet cen všech objednávek které zaměstnanec zpracoval ale nesmí být větší než 100000. Tedy klient si nejdřív najde všechny objednávky připadající zaměstnanci. Pak si klient požádá o specifickou objednávku. Zkusí jí sečíst se zbytkem a porovná zda součet není větší než 100000. Pokud ano tak odmítne přidat objednávku. Pokud ne tak objednávku přidá. Tento check se děje pouze při přidávání objednávky k zaměstnanci a pouze v klientovi, tedy použitím čistě api to přidat lze, stejně tak lze v klientovi přidat objednávku s nižší cennou tu přidat zaměstnanci a následně cenu změnit klidně nad 100000 tímto způsobem se dá toto omezení obejít. Je to čiště pro splnění bodu v hodnocení, logické to úplně není, nicméně požadavek na vícenásobnou komunikaci mezi serverem a klientem je věřím splněn.

Popis spuštění:
nutné :
JDK 17
gradle

stačí spustit server ./gradlew bootRun (ten běží na adrese localhost a na portu 9000)
následně spustit klienta ./gradlew bootRun (ten běží na adrese localhost a na portu 8080)

Je také možnost spustit server i klienta pomocí dockeru.
(sudo) docker build -t server .
(sudo) docker build -t klient .
(vždy v kořenových adresářích projektu)

následně spustit jednotlivé kontejnery
(sudo) docker run -p 9000:9000 server
(sudo) docker run -p 8080:8080 klient
server by nyní měl běžet na localhost:9000
klient by nyní měl běžet na localhost:8080

komunikace mezi aplikacemi a mezi databází a serverem by měla být přípravena a nakonfigurována.
Používání čistě serveru pomocí api je zdokumentováno pomocí openAPI a je případně dostupné na adrese http://localhost:9000/swagger-ui/index.html

používání klienta:
klient nabízí 3 tabulky kde jsou zobrazeny všechny entity s kterými aplikace pracuje. Každý řádek navíc u sebe má možnosti pro smazání entity (koš) pro úpravu (tužka) a žluté tlačítko seznamu zobrazí entity se kterými má tento řádek nějakou vazbu - V případě zaměstnance zobrazí všechny objednávky které zaměstnanec zpracoval - V případě objednávky všechny zaměstnance kteří danou objednávku zpracovávali - V případě vozidla všechny objednávky ve kterých se vozidlo vyskytlo. U objednávky a zaměstnance lze zadat id druhé entity a tím ji přidat/odebrat (manipulace s M:N vazbou). V levo nahoře u každé tabulky je zelené tlačítko + které umožňuje přidat novou entitu. Při zakliknutí tabulky pro vozidla se dole objeví velké červené tlačítko které realizuje advanced dotaz. V poslední řadě nahoře v levo se nachazí tlačítko kterým je možné resetovat stav databáze a zároveň dojde k vložení ukázkových dat (pro snazší vyzkoušení aplikace). Případě je možné již pouze pomocí api zaslat DELETE na adresu localhost/database což smaže všechny záznamy ze všech tabulek (pro tuto akci se v klientovi tlačítko již nenachází).