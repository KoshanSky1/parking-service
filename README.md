# parking-service
1. Форма авторизации:
   ![2024-12-16_01-11-48](https://github.com/user-attachments/assets/7fbd5493-1e15-4146-a687-53f2f92779d9)
2. Сообщение об ошибке, если авторизация не успешна
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
    ![2024-12-16_03-10-03](https://github.com/user-attachments/assets/691462e7-15ce-4dd1-945a-84e5ce45badf)
    ![2024-12-16_03-10-23](https://github.com/user-attachments/assets/91831253-ed2d-4833-8442-8116ee93efe2) 
    ![2024-12-16_03-10-44](https://github.com/user-attachments/assets/9463ead7-0c9c-484d-876f-6f2aca26c2b0)
  12. Тест на выход и повторный вход, для проверки сохранения парковок пользователя в листбокс
      ![2024-12-16_03-13-14](https://github.com/user-attachments/assets/79ef9f96-e1cf-47cb-a190-1080f22dbddf)
13. Тест на добавление другого пользователя, добавление парковок из его личного кабинета, вход под пользователем Umnitsa78

