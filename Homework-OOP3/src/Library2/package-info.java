/**
 Напишете класове, които представят работа с 
 библиотека. Библиотеката има име, адрес и
работно време (текстови полета).
Библиотеката има и списък с издания, които
могат да бъдат наемани.
Изданията може да бъдат книги или вестници.
Книгите имат име, автор, година на издаване.
Вестниците имат име и дата на издаване.
За книга или вестник може да се отбелязва
дали са свободни.

Изданията (класът, който описва изданията)
имат метод book(), който отбелязва изданието
като заето (т.е. не свободно) и return(), който
го отбелязва като свободно. Метод getDetails()
връща информация за изданието (име и автор
за книгите; име и дата за вестниците).

a) Напишете класове за: библиотека, издания,
книга, вестник. Нека тези класове имат
връзки помежду си, атрибути и методи, както
е описано в условието.
b) Напишете метод на класа Библиотека,
който да приема като параметър обект
издание. В метода се обхожда списъка с
издания на библиотеката и ако описанието на
подаденото издание съвпада с някое от
списъка, да отбелязва това в списъка като
заето.

c) Направете клас TestLibrary с main метод, в
който създайте няколко книги и вестници.
Създайте и една библиотека и ѝ добавете
създадените издания.
Изведете в конзолата списък с описанията на
всички издания от създадената библиотека.
Ако сте направили подточка b), тествайте
метода от нея.
 */
package Library2;