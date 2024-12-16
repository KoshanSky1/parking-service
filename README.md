# parking-service

## Функционал программы:
Приложение, в котором есть 2 типа пользователей: ADMIN и USER.
Пользователь с ролью USER может просматривать основную страницу приложения, где отражается список ранее внесенных им парковочных мест, а также кнопки для добавления и удаления парковочных мест.
Пользователю с ролью ADMIN помимо основной страницы приложения доступна панель админа, в которой он может просматривать список всех пользователей, а также добавлять, удалять и обновлять пользователй.

--------
### Стек технологий:
Java, PostgreSQL, Spring Boot, Spring Security, Hibernate, REST API, Thymeleaf, Apache Maven
--------

## Тестирование работоспособности основных операций программы:
1. Форма авторизации (Дефолтная реализация Spring Security):
   ![2024-12-16_01-11-48](https://github.com/user-attachments/assets/7fbd5493-1e15-4146-a687-53f2f92779d9)
2. Сообщение об ошибке, если авторизация не успешна (Дефолтная реализация Spring Security + сообщение NotAuthorizedException):
   ![2024-12-16_01-15-23](https://github.com/user-attachments/assets/5427cb28-c8a9-4a46-a6e0-f45fcf905ba0)
3. Если вход осуществлен пользователем с ролью "ADMIN", ему доступен переход с основной страницы приложения в панель админа:
   ![2024-12-16_02-19-02](https://github.com/user-attachments/assets/cccd4279-a5d6-42e1-b744-5a7203d5c60d)
4. Переход ко кнопке "В панель админа" ведет на страницу со списком пользователей и форме создания нового пользователя:
   ![2024-12-16_02-19-47](https://github.com/user-attachments/assets/701480dc-ca20-46a6-af65-81993a654d3b)
5. После заполнения всех полей формы и нажатия на кнопку "Создать" список пользователей в панели админа обновляется, также пользователь с хешированным паролем попадает в БД:
   ![2024-12-16_02-20-12](https://github.com/user-attachments/assets/aa875ffe-b035-433d-877c-ac151f161594)
   ![2024-12-16_02-20-35](https://github.com/user-attachments/assets/6480d10c-c885-4743-9773-e24f4fe36b0f)
6. При нажатии на пользователя из списка на панели админа открывается страница редактирования пользователей:
   ![2024-12-16_02-56-58](https://github.com/user-attachments/assets/6b4d0391-2e86-4cbf-b7ca-49ff7e44b9b3)
   После заполнения формы обновления пользователя и нажатия на кнопку "Обновить пользователя" пользователь обновляется в списке на панели админа и в БД.
   В случае нажатия на кнопу "Удалитб пользователя", соответственно, пользователь удаляется из списка пользователей на панели админа и из БД.
   Кнопка "Назад" возвращает админа к списку пользователей, кнопка "Выйти" ведет на страницу логина.
7. Вход для пользователя с ролью "User" (отсутствует переход в панель админа):
   ![2024-12-16_02-34-21](https://github.com/user-attachments/assets/e2819ef9-1aa0-4d86-aed2-0a0e07879735)
8. При нажатии на кнопку "Добавить парковку" открывается форма для добавления города и адреса паровки:
   ![2024-12-16_02-34-39](https://github.com/user-attachments/assets/16bb679a-ebbc-4acf-9012-aedae4493089)
9. При нажатии кнопки "Сохранить" новая парковка добавляется в БД и Lisbox со списком парковок обновляется:
   ![2024-12-16_03-06-41](https://github.com/user-attachments/assets/37e0691c-c057-4f43-9c61-4f0b7c0f9b9a)
   ![2024-12-16_02-34-54](https://github.com/user-attachments/assets/4734add9-811c-4370-95d2-9678639c1834)
10. При выборе парковочного места курсором и нажатии книпки "Удалить", парковочное место удаляется из БД, Listbox обновляется:
   ![395922573-d4c81ad9-caa3-4cb9-bdfe-56ede4ac85e5](https://github.com/user-attachments/assets/227be75c-516d-469d-8e77-834c1d62a9a2)
   ![2024-12-16_03-23-55](https://github.com/user-attachments/assets/0ac763f4-0e1a-435e-8cd8-139999280cec)
   ![2024-12-16_03-23-39](https://github.com/user-attachments/assets/6114a9dc-718e-4770-a819-921f143f2978)
11. Тест на выход и повторный вход пользователя с id=2. Данные в Listbox успешно подгружаются из БД:
   ![2024-12-16_03-25-52](https://github.com/user-attachments/assets/c1a99406-28ba-474d-977f-8b06f8bdb5c5)
   ![395922573-d4c81ad9-caa3-4cb9-bdfe-56ede4ac85e5](https://github.com/user-attachments/assets/79f07c23-829d-40f3-b760-4f58dfb24077)
12. Тест на добавление другого пользователя и добавление парковок из его аккаунта. В Listbox отражаются только парковки, внесенные пользователем с id =3.
   ![2024-12-16_03-29-01](https://github.com/user-attachments/assets/b5df0c0c-def0-478f-98f9-785e07885cfc)
   ![2024-12-16_03-29-26](https://github.com/user-attachments/assets/442326ed-66d3-4b12-ab27-b34061374f66)
   ![2024-12-16_03-29-55](https://github.com/user-attachments/assets/100d8a15-340a-4fd0-a037-ffe82cac8c15)
   ![2024-12-16_03-31-00](https://github.com/user-attachments/assets/0d58f62a-663e-486f-8f5b-8198782ed882)
13. Попытка добавить пользователя с существуюшим логином приводит к LoginAlreadyExistsException:
   ![2024-12-16_03-38-58](https://github.com/user-attachments/assets/5b47f5c5-96c2-4ed6-afeb-b72e9dedde81)





