# Clients With Contacts API
## Задание:
Спроектировать простую БД, обеспечивающую хранение информации о клиентах и их контактой информации.
Каждый клиент характеризуется именем.  
Каждому клиенту в соответствие может быть поставлена информация о его контактах: 0 и более телефонных номеров, 0 и более адресов электронной почты.
Разработать в Spring Framework API, обеспечивающее работу с данной БД.
API должно обеспечивать следующие функции:
* Добавление нового клиента
  > POST localhost:8080/client/add
* Добавление нового контакта клиента (телефон или email)
  > POST localhost:8080/client/{id}/contact
* Получение списка клиентов
  > GET localhost:8080/client/
* Получение информации по заданному клиенту (по id)
  > GET localhost:8080/client/{id}
* Получение списка контактов заданного клиента
  > GET localhost:8080/client/{id}/contacts
* Получение списка контактов заданного типа заданного клиента
  > GET localhost:8080/client/{id}/contacts?type=PHONE/EMAIL

## Для запуска:
* Указать параметры базы данных в application.properties
  >spring.datasource.url=
  
  >spring.datasource.username=
  
  >spring.datasource.password=
* Запустить ClietsWithContactsApplication
* Перейти по ссылке:
  >http://localhost:8080/swagger-ui/index.html#/
