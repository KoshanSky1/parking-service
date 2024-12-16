# parking-service
1. Форма авторизации (Дефолтная реализация):
   ![2024-12-16_01-11-48](https://github.com/user-attachments/assets/7fbd5493-1e15-4146-a687-53f2f92779d9)
2. Сообщение об ошибке, если авторизация не успешна:
   ![2024-12-16_01-15-23](https://github.com/user-attachments/assets/5427cb28-c8a9-4a46-a6e0-f45fcf905ba0)
3. Если вход осуществлен пользователем с ролью "ADMIN"
   ![2024-12-16_02-19-02](https://github.com/user-attachments/assets/cccd4279-a5d6-42e1-b744-5a7203d5c60d)
4. Переход ко кнопке "В панель админа"
   ![2024-12-16_02-19-47](https://github.com/user-attachments/assets/701480dc-ca20-46a6-af65-81993a654d3b)
5. После нажатия на кнопку "Создать" список пользователей обновляется и пользователь с хешированным паролем попадает в БД
   ![2024-12-16_02-20-12](https://github.com/user-attachments/assets/aa875ffe-b035-433d-877c-ac151f161594)
   ![2024-12-16_02-20-35](https://github.com/user-attachments/assets/6480d10c-c885-4743-9773-e24f4fe36b0f)
6. При нажатии на пользователя из списка открывается страница редактирования пользователей
   ![2024-12-16_02-56-58](https://github.com/user-attachments/assets/6b4d0391-2e86-4cbf-b7ca-49ff7e44b9b3)
7. Кнопка "Нвзад" возвращает админа к списку пользователей, кнопка "Выйти" ведет на страницу логина
8. Вход для пользователя с ролью "User"
   ![2024-12-16_02-34-21](https://github.com/user-attachments/assets/e2819ef9-1aa0-4d86-aed2-0a0e07879735)
9. При нажатии на кнопку "Добавить парковку" открывается форма для добавления
    ![2024-12-16_02-34-39](https://github.com/user-attachments/assets/16bb679a-ebbc-4acf-9012-aedae4493089)
10. При нажатии сохранить новая парковка добавляется в листбокс и БД
    ![2024-12-16_02-34-54](https://github.com/user-attachments/assets/4734add9-811c-4370-95d2-9678639c1834)
    ![2024-12-16_03-06-41](https://github.com/user-attachments/assets/37e0691c-c057-4f43-9c61-4f0b7c0f9b9a)
11. При выборе парковки курсором и нажатии книпки удалить, парковка удаляется из листбокса и БД
    ![2024-12-16_03-23-19](https://github.com/user-attachments/assets/d4c81ad9-caa3-4cb9-bdfe-56ede4ac85e5)
    ![2024-12-16_03-23-39](https://github.com/user-attachments/assets/6114a9dc-718e-4770-a819-921f143f2978)
    ![2024-12-16_03-23-55](https://github.com/user-attachments/assets/0ac763f4-0e1a-435e-8cd8-139999280cec)
12. Тест на выход и повторный вход, для проверки сохранения парковок пользователя в листбокс
    ![2024-12-16_03-25-52](https://github.com/user-attachments/assets/c1a99406-28ba-474d-977f-8b06f8bdb5c5)
14. Тест на добавление другого пользователя, добавление парковок из его личного кабинета, вход под пользователем id=2
    ![2024-12-16_03-29-01](https://github.com/user-attachments/assets/b5df0c0c-def0-478f-98f9-785e07885cfc)
    ![2024-12-16_03-29-26](https://github.com/user-attachments/assets/442326ed-66d3-4b12-ab27-b34061374f66)
    ![2024-12-16_03-29-55](https://github.com/user-attachments/assets/100d8a15-340a-4fd0-a037-ffe82cac8c15)
    ![2024-12-16_03-31-00](https://github.com/user-attachments/assets/0d58f62a-663e-486f-8f5b-8198782ed882)
15. Попытка добавить пользователя с существуюшим логином
    ![2024-12-16_03-38-58](https://github.com/user-attachments/assets/5b47f5c5-96c2-4ed6-afeb-b72e9dedde81)


