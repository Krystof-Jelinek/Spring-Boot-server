Popis:
Aplikace by měla být schopna spravovat systém půjčovny vozidel a splnit tedy operace uvedené níže.

Advanced dotaz:
Sešrotovani všech vozidel které si nikdo nezapůjčil déle než 1 rok -- tedy odstranění jejich záznamů z db
(bude potreba odstranit i zaznamy z objednavek ?? nerozbije to databazi ? )

business operace:
V klientovi chceme přidat k zaměstnanci objednávku. Celkový součet cen všech objednávek které zaměstnanec zpracoval ale nesmí být větší než 100000. Tedy klient nejdřív si najde všechny objednávky připadající zaměstnanci. Pak si client požádá o specifickou objednávku. Zkusí jí sečíst se zbytkem a porovná zda součet není větší než 100000. Pokud ano tak odmítne přidat objednávku. Pokud ne tak objednávku přidá.