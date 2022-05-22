# dz4_configs и dz5_events
Домашка 4:  
Создать 3 профиля - dev - [application.properties](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/resources/application.properties), test - [application-test.properties](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/resources/application-test.properties), prod - [application-prod.properties](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/resources/application-test.properties), каждый из которых будет включать в себя:  
* конфиг с листом из нескольких значений (application.version во всех файлах)
* название приложения (application.name)
* конфиг с переменной окружения, по дефолту значение - default (listeners.createDatabaseListener)

3 бина:  
* один создается, только если профиль test - [UserCreationListener.java](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/java/com/example/configs/listeners/UserCreationListener.java),  
* другой, если существует первый бин - [AsyncUserCreationListener.java](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/java/com/example/configs/listeners/AsyncUserCreationListener.java),  
* третий, если в конфиге с не “default” (тут в идеале со скриншотом) - [DatabaseChangesListener.java](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/java/com/example/configs/listeners/DatabaseChangesListener.java)
![](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/screenshots/abobus.png)

ДЗ 5:
	
Создать три EventListener’a (обычный - [UserCreationListener.java](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/java/com/example/configs/listeners/UserCreationListener.java), Async - [AsyncUserCreationListener.java](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/java/com/example/configs/listeners/AsyncUserCreationListener.java) и Transactional - [DatabaseChangesListener.java](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/java/com/example/configs/listeners/DatabaseChangesListener.java))
		
* Для каждого из них порождать событие - [UserController.java](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/java/com/example/configs/controllers/UserController.java)
	
* Для TransactionalEventListener порождать два события так, чтобы одно обрабатывалось, а другое нет - [DatabaseChangesListener.java:17-20](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/java/com/example/configs/listeners/DatabaseChangesListener.java) и [DatabaseChangesListener.java:22-25](https://github.com/shiriaeva/dz4_configs/blob/main/dz4_configs/src/main/java/com/example/configs/listeners/DatabaseChangesListener.java), который в отличие от первого срабатывает при публикации событий
	
* Логировать моменты порождения и обработки событий (во всех [listeners](https://github.com/shiriaeva/dz4_configs/tree/main/dz4_configs/src/main/java/com/example/configs/listeners) есть вывод информации о событии)
