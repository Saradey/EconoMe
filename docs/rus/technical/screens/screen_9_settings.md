# 9. Экран настроек

## Краткое пояснение

Экран настроек, сюда входят настройки:

(без нижнего меню)

## Функционал

- вайп всех пользователей и кошельков
- отчисчтить базу данных данного пользователя
- поменять тему: (будет черная и белая)
- список категорий расходов: по нажатию переходить на экран списка категорий
- сменить пользователя (старый пользователь сохраняется)
- удалить текущего пользователя
- удалить текущий кошелек
- сменить кошелек
- возможность зайти в список категорий расходво и отредактировать их

## Реализация

## Навигация (куда)

- [0. Экран создания аккаунта](screen_0_create_account.md) - после удаления текущего аккаунта если
  нет других пользователей (при этом весь бекстек навигации отчищается)
- [15. Экран выбора пользователя](screen_15_select_user.md) - после удаления текущего аккаунта если
  есть другие пользователи, или если пользователь решил сменить аккаунт
- [4. Экран создания кошелька расходов](screen_4_create_wallet.md) - после удаление текущего
  кашелька пользователей если больше нет кошельков
- [16. Экран всех кошельков](screen_16_all_wallets.md) - после удаление текущего
  кашелька пользователей если есть еще кашельки, или если пользователь решит сменить кошелек
- [11. Экран всех категорий](screen_11_all_categories.md) - по нажатию кнопки "Все категории
  расходов"
- [21. Экран добавления категории товаров](screen_21_add_product_category.md) - по нажатию на кнопку
  "все категории товаров"
- [22. Экран добавления подкатегории товаров](screen_22_add_product_subcategory.md) - по нажатию на
  кнопку "все товары"

## TODO
