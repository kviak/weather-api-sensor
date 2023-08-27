# weather-api-sensor
Описывается адрес API, данные которые передаются при запросе на
этот адрес и тот функционал, который должен предоставляться в
результате запроса на этот адрес
•POST /sensors/registration
Регистрирует новый сенсор в системе. Другими словами, просто добавляет новый
сенсор в таблицу сенсоров в БД. Как видно из JSON'а - у сенсоров есть только одно
поле - название.
Вы должны помнить о правилах хорошего кода и использовать DTO для входящего
объекта - сенсора.
Также, вы должны валидировать то, что сенсора с таким названием еще нет в БД
(вспоминайте Spring Validator). Если сенсор с таким названием есть в БД - возвращать
клиенту сообщение с ошибкой (вспоминайте урок про это).
Также, если название сенсора пустое или содержит менее 3 или более 30 символов, 
клиенту должно возвращаться сообщение с ошибкой.
•POST /measurements/add
Добавляет новое измерение. Это тот адрес, куда настоящий сенсор посылал бы свои данные. 
Вещественное поле "value" содержит значение температуры воздуха, булево поле "raining" содержит
значение true/false в зависимости от того, зарегистрировал ли сенсор дождь или нет. Помимо этого, в
этом запросе передается сам объект сенсора, который получил и отправляет эти "измерения".
Значения температуры воздуха, дождя должны сохранятся в таблице в БД. Также, в каждой строке этой
таблицы должно содержаться название того сенсора, который прислал эти измерения. То есть
сущность "Измерение" имеет связь с сущностью "Сенсор" (вспоминайте отношения в БД и как их
выстраивать в Java классах с помощью Hibernate).
Все поля у измерения должны валидироваться.
Значение "value" должно быть не пустым и находиться в диапазоне от -100 до 100.
Значение "raining" должно быть не пустым.
Значение "sensor" должно быть не пустым. При этом, название сенсора должно валидироваться в БД. 
Сенсор с таким названием должен быть зарегистрирован в системе (должен быть в БД).
Если такого сенсора нет в БД - выдавать ошибку. Также, не забывайте про DTO.
На сервере, у измерения должно выставляться текущее время, оно должно сохраняться в БД.
•GET /measurements
Возвращает все измерения из БД
•GET /measurements/rainyDaysCount
Возвращает количество дождливых дней из БД
