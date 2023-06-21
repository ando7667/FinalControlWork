# Итоговая контрольная работа по блоку специализация
## Информация о проекте
Необходимо организовать систему учета для питомника в котором живут
домашние и вьючные животные.
## Задание
1. Используя команду cat в терминале операционной системы Linux, создать два файла Домашние животные (заполнив файл
   собаками, кошками, хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их.
   Просмотреть содержимое созданного файла.
   Переименовать файл, дав ему новое имя (Друзья человека).
2. Создать директорию, переместить файл туда.
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
   из этого репозитория.
4. Установить и удалить deb-пакет с помощью dpkg.
5. Выложить историю команд в терминале ubuntu
6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние животные и вьючные животные, в составы
   которых в случае домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут:
   Лошади, верблюды и ослы).
7. В подключенном MySQL репозитории создать базу данных “Друзья человека”
8. Создать таблицы с иерархией из диаграммы в БД
9. Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку.
    Объединить таблицы лошади, и ослы в одну таблицу.
11. Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в
    отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
13. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.
14. Написать программу, имитирующую работу реестра домашних животных.
    В программе должен быть реализован следующий функционал:
    1. Завести новое животное
    2. определять животное в правильный класс
    3. увидеть список команд, которое выполняет животное
    4. обучить животное новым командам
    5. Реализовать навигацию по меню
15. Создайте класс Счетчик, у которого есть метод add(), увеличивающий̆
    значение внутренней̆int переменной̆на 1 при нажатие “Завести новое
    животное” Сделайте так, чтобы с объектом такого типа можно было работать в
    блоке try-with-resources. Нужно бросить исключение, если работа с объектом
    типа счетчик была не в ресурсном try и/или ресурс остался открыт. Значение
    считать в ресурсе try, если при заведения животного заполнены все поля.

## Выполнение задач
### Задача 1
+    создаем файлы и наполняем их данными

    cat > "Домашние животные.txt"
    Шарик,собака,2015
    Дуся,кошка,2016
    Вася,кошка,2022
    Мук,хомяк,2022
    Рич,собака,2018
    Люси,кошка,2021
    Фиона,кошка,2017
    Маврик,собака,2021
    Вега,собака,2019
    Снуп,хомяк,2020
    ^C
    cat > "Вьючные животные.txt"
    Жак,лошадь,2020
    Ерос,верблюд,2021
    Зулан,осел,2018
    Апполон,лошадь,2012
    Ворон,верблюд,2011
    Ежевика,осел,2011
    Гранит,лошадь,2018
    Дакар,верблюд,2019
    Зулан,осел,2014
    ^C
+    объединяем файлы
  
    cat "Домашние животные.txt" "Вьючные животные.txt" > "Все.txt"

скрин консоли

![alt-текст](./src/pictures/screenshot_1.png "Скрин создания и объединения файлов")

+    смотрим содержимое файла

    cat "Все.txt"

скрин 

![alt-текст](./src/pictures/screenshot_2.png "Скрин содержимого объединения файлов")

+    переименуем файл

    mv "Все.txt" "Друзья человека.txt"

+    проверим переименование

    ls

![alt-текст](./src/pictures/screenshot_3.png "Скрин переименования файла")

### Задача 2

Создадим директорию и переместим файл туда.

    mkdir pets
    mv "Друзья человека.txt" ./pets

![alt-текст](./src/pictures/screenshot_4.png "Скрин перемещения файла")

### Задача 3
Подключаем дополнительный репозиторий MySQL и установим пакет workbench-community
из этого репозитория.

    wget https://dev.mysql.com/get/mysql-apt-config_0.8.25-1_all.deb
    sudo dpkg -i mysql-apt-config_0.8.25-1_all.deb
    sudo apt-get update
    sudo apt-get install mysql-workbench-community

![alt-текст](./src/pictures/screenshot_3_1.png "Скрин закачки пакета репозитория")
![alt-текст](./src/pictures/screenshot_3_2.png "Скрин установки репозитория")
![alt-текст](./src/pictures/screenshot_3_3.png "Скрин обновления исходников apt")
![alt-текст](./src/pictures/screenshot_3_4.png "Скрин установки пакета workbench")
![alt-текст](./src/pictures/screenshot_3_5.png "Скрин установки пакета workbench")

### Задача 4
Установим и удалим deb-пакет SublimeText с помощью dpkg. 

скачаем пакет

    wget https://download.sublimetext.com/sublime-text_build-4143_amd64.deb

установим пакет

    sudo dpkg -i sublime-text_build-4143_amd64.deb

![alt-текст](./src/pictures/screenshot_4_1.png "Скрин установки пакета")

Запускаем приложение. Все ОК.
![alt-текст](./src/pictures/screenshot_4_2.png "Скрин запуска SublimeText")

Удалим пакет

    sudo dpkg -r sublime-text

![alt-текст](./src/pictures/screenshot_4_3.png "Скрин удаления SublimeText")

### Задача 5

Выложить историю команд в терминале ubuntu

    history

![alt-текст](./src/pictures/screenshot_5.png "Скрин истории команд")

### Задача 6
Нарисуем диаграмму, в которой есть родительский класс, домашние животные и вьючные животные, в составы которых в случае
домашних животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные войдут: Лошади, верблюды и ослы.
![alt-текст](./src/pictures/screenshot_6.png "Скрин истории команд")

### Задача 7
В подключенном MySQL репозитории создать базу данных “Друзья человека”

    CREATE DATABASE human_friends;

### Задача 8
Создать таблицы с иерархией из диаграммы в БД

    USE human_friends;

    DROP TABLE IF EXISTS animals;
    CREATE TABLE animals
    (
    id INT AUTO_INCREMENT PRIMARY KEY,
    class_name tinytext
    );
    
    INSERT INTO animals (class_name) VALUES
    ('Домашние'),
    ('Вьючные');
    
    --
    
    DROP TABLE IF EXISTS home_animals;
    CREATE TABLE home_animals
    (
    id INT AUTO_INCREMENT PRIMARY KEY,
    genus_name tinytext,
    id_сlass INT,
    FOREIGN KEY (id_сlass) REFERENCES animals (id) ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    INSERT INTO home_animals (genus_name, id_сlass) VALUES
    ('Собаки', 1),
    ('Кошки', 1),  
    ('Хомяки', 1);
    
    DROP TABLE IF EXISTS pack_animals;
    CREATE TABLE pack_animals
    (
    id INT AUTO_INCREMENT PRIMARY KEY,
    genus_name tinytext,
    id_сlass INT,
    FOREIGN KEY (id_сlass) REFERENCES animals (id) ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    INSERT INTO pack_animals (genus_name, id_сlass) VALUES
    ('Лошади', 2),
    ('Верблюды', 2),  
    ('Ослы', 2);
    
    -- home_animals tables --
    
    DROP TABLE IF EXISTS dogs;
    CREATE TABLE dogs
    (       
    id INT AUTO_INCREMENT PRIMARY KEY,
    name tinytext,
    birthday DATE,
    commands tinytext,
    id_genus int,
    FOREIGN KEY (id_genus) REFERENCES home_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    
    DROP TABLE IF EXISTS cats;
    CREATE TABLE cats
    (       
    id INT AUTO_INCREMENT PRIMARY KEY,
    name tinytext,
    birthday DATE,
    commands tinytext,
    id_genus int,
    FOREIGN KEY (id_genus) REFERENCES home_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    
    DROP TABLE IF EXISTS hamsters ;
    CREATE TABLE hamsters  
    (       
    id INT AUTO_INCREMENT PRIMARY KEY,
    name tinytext,
    birthday DATE,
    commands tinytext,
    id_genus int,
    FOREIGN KEY (id_genus) REFERENCES home_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    -- pack_animals tables ---
    
    DROP TABLE IF EXISTS horses;
    CREATE TABLE horses  
    (       
    id INT AUTO_INCREMENT PRIMARY KEY,
    name tinytext,
    birthday DATE,
    commands tinytext,
    id_genus int,
    FOREIGN KEY (id_genus) REFERENCES home_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    DROP TABLE IF EXISTS camels;
    CREATE TABLE camels  
    (       
    id INT AUTO_INCREMENT PRIMARY KEY,
    name tinytext,
    birthday DATE,
    commands tinytext,
    id_genus int,
    FOREIGN KEY (id_genus) REFERENCES home_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
    );
    
    DROP TABLE IF EXISTS donkeys;
    CREATE TABLE donkeys  
    (       
    id INT AUTO_INCREMENT PRIMARY KEY,
    name tinytext,
    birthday DATE,
    commands tinytext,
    id_genus int,
    FOREIGN KEY (id_genus) REFERENCES home_animals (id) ON DELETE CASCADE ON UPDATE CASCADE
    );

### Задача 9
Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения

    